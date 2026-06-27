package io.github.thebusybiscuit.slimefun4.api.player;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.xzavier0722.mc.plugin.slimefun4.storage.callback.IAsyncReadCallback;
import io.github.bakedlibs.dough.common.ChatColors;
import io.github.bakedlibs.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.api.events.AsyncProfileLoadEvent;
import io.github.thebusybiscuit.slimefun4.api.gps.Waypoint;
import io.github.thebusybiscuit.slimefun4.api.items.HashedArmorpiece;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectiveArmor;
import io.github.thebusybiscuit.slimefun4.core.guide.GuideHistory;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Třída, která ukládá pokrok hráče ve výzkumech pro účely cache.
 * Také obsahuje batohy hráče.
 */
public class PlayerProfile {

    private static final Map<UUID, Boolean> processProfiles = new ConcurrentHashMap<>();

    private final UUID owner;
    private int backpackNum;
    private final Config waypointsFile;

    private boolean dirty = false;
    private boolean markedForDeletion = false;

    private final Set<Research> researches;
    private final List<Waypoint> waypoints = new CopyOnWriteArrayList<>();
    private final GuideHistory guideHistory = new GuideHistory(this);

    private final HashedArmorpiece[] armor = {
        new HashedArmorpiece(), new HashedArmorpiece(), new HashedArmorpiece(), new HashedArmorpiece()
    };

    public PlayerProfile(@Nonnull OfflinePlayer p, int backpackNum) {
        this(p, backpackNum, new HashSet<>());
    }

    public PlayerProfile(@Nonnull OfflinePlayer p, int backpackNum, Set<Research> researches) {
        owner = p.getUniqueId();
        this.backpackNum = backpackNum;
        this.researches = researches;
        waypointsFile = new Config("data-storage/Slimefun/waypoints/" + p.getUniqueId() + ".yml");
        loadWaypoint();
    }

    private void loadWaypoint() {
        for (String key : waypointsFile.getKeys()) {
            try {
                if (waypointsFile.contains(key + ".world")
                        && Bukkit.getWorld(waypointsFile.getString(key + ".world")) != null) {
                    String waypointName = waypointsFile.getString(key + ".name");
                    Location loc = waypointsFile.getLocation(key);
                    waypoints.add(new Waypoint(this, key, loc, waypointName));
                }
            } catch (Exception x) {
                Slimefun.logger()
                        .log(
                                Level.WARNING,
                                x,
                                () -> "Nepodařilo se načíst waypoint \"" + key + "\" pro hráče \""
                                        + getOwner().getName() + '"');
            }
        }
    }

    public @Nonnull HashedArmorpiece[] getArmor() {
        return armor;
    }

    public @Nonnull UUID getUUID() {
        return owner;
    }

    public boolean isMarkedForDeletion() {
        return markedForDeletion;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void save() {
        if (processProfiles.containsKey(owner)) {
            return;
        }
        try {
            processProfiles.put(owner, true);
            waypointsFile.save();
            dirty = false;
        } finally {
            processProfiles.remove(owner);
        }
    }

    public void saveAsync() {
        Slimefun.getDatabaseManager().getProfileDataController().saveWaypoints(this);
    }

    public void setResearched(@Nonnull Research research, boolean unlock) {
        Validate.notNull(research, "Výzkum nesmí být null!");
        if (unlock) {
            researches.add(research);
        } else {
            researches.remove(research);
        }
        Slimefun.getDatabaseManager()
                .getProfileDataController()
                .setResearch(owner.toString(), research.getKey(), unlock);
    }

    public boolean hasUnlocked(@Nullable Research research) {
        if (research == null) {
            return true;
        }
        return !research.isEnabled() || researches.contains(research);
    }

    public boolean hasUnlockedEverything() {
        for (Research research : Slimefun.getRegistry().getResearches()) {
            if (!hasUnlocked(research)) {
                return false;
            }
        }
        return true;
    }

    public @Nonnull Set<Research> getResearches() {
        return ImmutableSet.copyOf(researches);
    }

    public @Nonnull List<Waypoint> getWaypoints() {
        return ImmutableList.copyOf(waypoints);
    }

    public void addWaypoint(@Nonnull Waypoint waypoint) {
        Validate.notNull(waypoint, "Nelze přidat null waypoint!");
        for (Waypoint wp : waypoints) {
            if (wp.getId().equals(waypoint.getId())) {
                throw new IllegalArgumentException("Waypoint s tímto ID již existuje pro tohoto hráče.");
            }
        }
        if (waypoints.size() < Slimefun.getGPSNetwork().getMaxWaypoints()) {
            waypoints.add(waypoint);
            waypointsFile.setValue(waypoint.getId(), waypoint.getLocation());
            waypointsFile.setValue(waypoint.getId() + ".name", waypoint.getName());
            markDirty();
            saveAsync();
        }
    }

    public void removeWaypoint(@Nonnull Waypoint waypoint) {
        Validate.notNull(waypoint, "Nelze odstranit null waypoint!");
        if (waypoints.remove(waypoint)) {
            waypointsFile.setValue(waypoint.getId(), null);
            markDirty();
            saveAsync();
        }
    }

    public final void markForDeletion() {
        markedForDeletion = true;
    }

    public final void markDirty() {
        dirty = true;
    }

    public int nextBackpackNum() {
        backpackNum++;
        Slimefun.getDatabaseManager().getProfileDataController().saveProfileBackpackCount(this);
        return backpackNum;
    }

    public int getBackpackCount() {
        return backpackNum;
    }

    public void setBackpackCount(int count) {
        backpackNum = Math.max(backpackNum, count);
        Slimefun.getDatabaseManager().getProfileDataController().saveProfileBackpackCount(this);
    }

    private int countNonEmptyResearches(@Nonnull Collection<Research> researches) {
        int count = 0;
        for (Research research : researches) {
            if (research.hasEnabledItems()) {
                count++;
            }
        }
        return count;
    }

    public @Nonnull String getTitle() {
        List<String> titles = Slimefun.getRegistry().getResearchRanks();
        int allResearches = countNonEmptyResearches(Slimefun.getRegistry().getResearches());
        float fraction = (float) countNonEmptyResearches(researches) / allResearches;
        int index = (int) (fraction * (titles.size() - 1));
        return titles.get(index);
    }

    public void sendStats(@Nonnull CommandSender sender) {
        int unlockedResearches = countNonEmptyResearches(getResearches());
        int levels = getResearches().stream().mapToInt(Research::getLevelCost).sum();
        int allResearches = countNonEmptyResearches(Slimefun.getRegistry().getResearches());
        float progress = Math.round(((unlockedResearches * 100.0F) / allResearches) * 100.0F) / 100.0F;

        sender.sendMessage("");
        sender.sendMessage(ChatColors.color("&7Statistiky výzkumů hráče: &b" + getPlayer()));
        sender.sendMessage("");
        sender.sendMessage(ChatColors.color("&7Úroveň výzkumu: " + ChatColor.AQUA + getTitle()));
        sender.sendMessage(ChatColors.color("&7Pokrok ve výzkumech: "
                + NumberUtils.getColorFromPercentage(progress)
                + progress
                + " &r% "
                + ChatColor.YELLOW
                + '('
                + unlockedResearches
                + " / "
                + allResearches
                + ')'));
        sender.sendMessage(ChatColors.color("&7Celkově utraceno zkušeností: " + ChatColor.AQUA + levels));
    }

    public @Nullable Player getPlayer() {
        if (getOwner() != null) {
            return getOwner().getPlayer();
        }
        return null;
    }

    public @Nonnull GuideHistory getGuideHistory() {
        return guideHistory;
    }

    public static boolean fromUUID(@Nonnull UUID uuid, @Nonnull Consumer<PlayerProfile> callback) {
        return get(Bukkit.getOfflinePlayer(uuid), callback);
    }

    public static boolean get(@Nonnull OfflinePlayer p, @Nonnull Consumer<PlayerProfile> callback) {
        Validate.notNull(p, "Nelze získat PlayerProfile pro: null!");
        UUID uuid = p.getUniqueId();
        PlayerProfile profile = Slimefun.getRegistry().getPlayerProfiles().get(uuid);

        if (profile != null && !profile.markedForDeletion) {
            callback.accept(profile);
            return true;
        }

        if (processProfiles.containsKey(uuid)) {
            return false;
        }

        processProfiles.put(uuid, true);
        getOrCreate(p, callback);
        return false;
    }

    public static boolean request(@Nonnull OfflinePlayer p) {
        Validate.notNull(p, "Nelze požádat o profil pro null");
        var profile = Slimefun.getRegistry().getPlayerProfiles().get(p.getUniqueId());
        if (profile == null || profile.markedForDeletion) {
            if (processProfiles.containsKey(p.getUniqueId())) {
                return false;
            }
            getOrCreate(p, null);
            return false;
        }
        return true;
    }

    public static @Nonnull Optional<PlayerProfile> find(@Nonnull OfflinePlayer p) {
        var re = Slimefun.getRegistry().getPlayerProfiles().get(p.getUniqueId());
        if (re == null || re.markedForDeletion) {
            return Optional.empty();
        }
        return Optional.of(re);
    }

    public static @Nonnull Iterator<PlayerProfile> iterator() {
        return Slimefun.getRegistry().getPlayerProfiles().values().iterator();
    }

    public boolean hasFullProtectionAgainst(@Nonnull ProtectionType type) {
        Validate.notNull(type, "ProtectionType nesmí být null.");
        int armorCount = 0;
        NamespacedKey setId = null;
        for (HashedArmorpiece armorpiece : armor) {
            Optional<SlimefunArmorPiece> armorPiece = armorpiece.getItem();
            if (armorPiece.isPresent() && armorPiece.get() instanceof ProtectiveArmor protectiveArmor) {
                for (ProtectionType protectionType : protectiveArmor.getProtectionTypes()) {
                    if (protectionType == type) {
                        if (!protectiveArmor.isFullSetRequired()) {
                            return true;
                        } else if (setId == null || setId.equals(protectiveArmor.getArmorSetId())) {
                            armorCount++;
                            setId = protectiveArmor.getArmorSetId();
                        }
                    }
                }
            }
        }
        return armorCount == 4;
    }

    @Override
    public int hashCode() {
        return owner.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PlayerProfile profile && owner.equals(profile.owner);
    }

    @Override
    public String toString() {
        return "PlayerProfile {" + owner + "}";
    }

    public OfflinePlayer getOwner() {
        return Bukkit.getOfflinePlayer(owner);
    }

    private static void getOrCreate(OfflinePlayer p, Consumer<PlayerProfile> cb) {
        var controller = Slimefun.getDatabaseManager().getProfileDataController();
        controller.getProfileAsync(p, new IAsyncReadCallback<>() {
            @Override
            public void onResult(PlayerProfile result) {
                invokeCb(result, false);
                processProfiles.remove(result.getUUID());
            }

            @Override
            public void onResultNotFound() {
                try {
                    var pf = controller.createProfile(p);
                    invokeCb(pf, true);
                } finally {
                    processProfiles.remove(p.getUniqueId());
                }
            }

            private void invokeCb(PlayerProfile pf, boolean newlyCreated) {
                if (newlyCreated) {
                    AsyncProfileLoadEvent event = new AsyncProfileLoadEvent(pf);
                    Bukkit.getPluginManager().callEvent(event);
                }
                if (cb != null) {
                    cb.accept(pf);
                }
            }
        });
    }
}
