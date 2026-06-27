package io.github.thebusybiscuit.slimefun4.api.player;

import city.norain.slimefun4.holder.SlimefunInventoryHolder;
import city.norain.slimefun4.utils.InventoryUtil;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.InvSnapshot;
import io.github.bakedlibs.dough.common.ChatColors;
import io.github.bakedlibs.dough.common.CommonPatterns;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import io.github.thebusybiscuit.slimefun4.implementation.listeners.BackpackListener;
import io.github.thebusybiscuit.slimefun4.utils.ThreadUtils;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/**
 * Tato třída reprezentuje instanci {@link SlimefunBackpack}, která je připravená k otevření.
 *
 * Obsahuje skutečný {@link Inventory} a reprezentuje batoh na úrovni jednotlivého {@link ItemStack},
 * na rozdíl od třídy {@link SlimefunBackpack}.
 */
public class PlayerBackpack extends SlimefunInventoryHolder {

    public static final String LORE_OWNER = "&7Vlastník: ";
    private static final String COLORED_LORE_OWNER = ChatColors.color(LORE_OWNER);

    private static final NamespacedKey KEY_BACKPACK_UUID = new NamespacedKey(Slimefun.instance(), "B_UUID");
    private static final NamespacedKey KEY_OWNER_UUID = new NamespacedKey(Slimefun.instance(), "OWNER_UUID");

    private final OfflinePlayer owner;
    private final UUID uuid;
    private final int id;
    private String name;
    private int size;
    private boolean isInvalid = false;

    @Nonnull
    @Getter
    private InvSnapshot snapshot;

    public static void getAsync(ItemStack item, Consumer<PlayerBackpack> callback, boolean runCbOnMainThread) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore()) {
            return;
        }

        Executor executor = runCbOnMainThread
                ? ThreadUtils.getMainDelayedExecutor()
                : Slimefun.getDatabaseManager().getProfileDataController().getCallbackExecutor();

        var bUuid = getBackpackUUID(item.getItemMeta());
        if (bUuid.isPresent()) {
            Slimefun.getDatabaseManager()
                    .getProfileDataController()
                    .getBackpackAsync(bUuid.get())
                    .thenAcceptAsync(
                            (result) -> {
                                if (result != null) {
                                    callback.accept(result);
                                }
                            },
                            executor);
            return;
        }

        // Starý formát batohu
        OptionalInt id = OptionalInt.empty();
        String uuid = "";
        for (String line : item.getItemMeta().getLore()) {
            if (line.startsWith(ChatColors.color("&7ID: ")) && line.indexOf('#') != -1) {
                String[] splitLine = CommonPatterns.HASH.split(line);
                if (CommonPatterns.NUMERIC.matcher(splitLine[1]).matches()) {
                    uuid = splitLine[0].replace(ChatColors.color("&7ID: "), "");
                    id = OptionalInt.of(Integer.parseInt(splitLine[1]));
                }
            }
        }

        if (id.isPresent()) {
            int number = id.getAsInt();
            Slimefun.getDatabaseManager()
                    .getProfileDataController()
                    .getBackpackAsync(Bukkit.getOfflinePlayer(UUID.fromString(uuid)), number)
                    .thenAcceptAsync(
                            (result) -> {
                                if (result != null) {
                                    var meta = item.getItemMeta();
                                    meta.getPersistentDataContainer()
                                            .set(KEY_BACKPACK_UUID, PersistentDataType.STRING, result.uuid.toString());
                                    item.setItemMeta(meta);
                                    callback.accept(result);
                                }
                            },
                            executor);
        }
    }

    public static CompletableFuture<PlayerBackpack> getAsync(ItemStack item) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore()) {
            return CompletableFuture.completedFuture(null);
        }

        var bUuid = getBackpackUUID(item.getItemMeta());
        if (bUuid.isPresent()) {
            return Slimefun.getDatabaseManager().getProfileDataController().getBackpackAsync(bUuid.get());
        }

        // Starý formát batohu
        OptionalInt id = OptionalInt.empty();
        String uuid = "";
        for (String line : item.getItemMeta().getLore()) {
            if (line.startsWith(ChatColors.color("&7ID: ")) && line.contains("#")) {
                String[] splitLine = CommonPatterns.HASH.split(line);
                if (CommonPatterns.NUMERIC.matcher(splitLine[1]).matches()) {
                    uuid = splitLine[0].replace(ChatColors.color("&7ID: "), "");
                    id = OptionalInt.of(Integer.parseInt(splitLine[1]));
                }
            }
        }

        if (id.isPresent()) {
            int number = id.getAsInt();
            return Slimefun.getDatabaseManager()
                    .getProfileDataController()
                    .getBackpackAsync(Bukkit.getOfflinePlayer(UUID.fromString(uuid)), number);
        }

        return CompletableFuture.completedFuture(null);
    }

    public static Optional<String> getBackpackUUID(ItemMeta meta) {
        if (meta == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(meta.getPersistentDataContainer().get(KEY_BACKPACK_UUID, PersistentDataType.STRING));
    }

    public static Optional<String> getOwnerUUID(ItemMeta meta) {
        if (meta == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(meta.getPersistentDataContainer().get(KEY_OWNER_UUID, PersistentDataType.STRING));
    }

    public static OptionalInt getBackpackID(ItemMeta meta) {
        if (meta == null) {
            return OptionalInt.empty();
        }
        for (String line : meta.getLore()) {
            if (line.startsWith(ChatColors.color("&7ID: ")) && line.contains("#")) {
                try {
                    return OptionalInt.of(Integer.parseInt(
                            CommonPatterns.HASH.split(line.replace(ChatColors.color("&7ID: "), ""))[1]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return OptionalInt.empty();
    }

    public static void setItemPdc(ItemStack item, String bpUuid, String ownerUuid) {
        ItemMeta meta = item.getItemMeta();
        setPdc(meta, bpUuid, ownerUuid);
        item.setItemMeta(meta);
    }

    public static void bindItem(ItemStack item, PlayerBackpack bp) {
        var meta = item.getItemMeta();
        setPdc(meta, bp.uuid.toString(), bp.owner.getUniqueId().toString());
        setItem(meta, bp);
        item.setItemMeta(meta);
    }

    public static void setItemDisplayInfo(ItemStack item, PlayerBackpack bp) {
        var meta = item.getItemMeta();
        setItem(meta, bp);
        item.setItemMeta(meta);
    }

    public static boolean isOwnerOnline(ItemMeta meta) {
        if (Slimefun.getCfg().getBoolean("backpack.allow-open-when-owner-offline")) {
            return true;
        }
        var ownerUuid = PlayerBackpack.getOwnerUUID(meta);
        return ownerUuid.isEmpty() || Bukkit.getPlayer(UUID.fromString(ownerUuid.get())) != null;
    }

    private static void setPdc(ItemMeta meta, String bpUuid, String ownerUuid) {
        var pdc = meta.getPersistentDataContainer();
        pdc.set(PlayerBackpack.KEY_BACKPACK_UUID, PersistentDataType.STRING, bpUuid);
        pdc.set(PlayerBackpack.KEY_OWNER_UUID, PersistentDataType.STRING, ownerUuid);
    }

    private static void setItem(ItemMeta meta, PlayerBackpack bp) {
        var lore = meta.getLore();
        for (var i = 0; i < lore.size(); i++) {
            var line = lore.get(i);
            if (COLORED_LORE_OWNER.equals(line)) {
                lore.set(i, COLORED_LORE_OWNER + bp.getOwner().getName());
                break;
            }
        }
        meta.setLore(lore);

        if (bp.name.isEmpty() || bp.name.isBlank()) {
            return;
        }
        meta.setDisplayName(ChatColors.color(bp.name));
    }

    @ParametersAreNonnullByDefault
    public PlayerBackpack(
            OfflinePlayer owner, UUID uuid, String name, int id, int size, @Nullable ItemStack[] contents) {
        if (size < 9 || size > 54 || size % 9 != 0) {
            throw new IllegalArgumentException("Neplatná velikost! Velikost musí být jedna z: [9, 18, 27, 36, 45, 54]");
        }

        this.owner = owner;
        this.uuid = uuid;
        this.name = name;
        this.id = id;
        this.size = size;

        inventory = newInv();

        if (contents != null) {
            if (size != contents.length) {
                throw new IllegalArgumentException("Neplatný obsah: nesouhlasí velikost!");
            }
            inventory.setContents(contents);
        }

        this.snapshot = new InvSnapshot(inventory);
    }

    public void refreshSnapshot() {
        this.snapshot = new InvSnapshot(inventory);
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public OfflinePlayer getOwner() {
        return owner;
    }

    public int getSize() {
        return size;
    }

    @Nonnull
    public Inventory getInventory() {
        return inventory;
    }

    public void open(Player p) {
        if (isInvalid) {
            return;
        }
        InventoryUtil.openInventory(p, inventory);
    }

    public void setSize(int size) {
        if (size < 9 || size > 54 || size % 9 != 0) {
            throw new IllegalArgumentException("Neplatná velikost! Velikost musí být jedna z: [9, 18, 27, 36, 45, 54]");
        }
        this.size = size;
        updateInv();
        Slimefun.getDatabaseManager().getProfileDataController().saveBackpackInfo(this);
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public void setName(String name) {
        this.name = name;
        updateInv();
        Slimefun.getDatabaseManager().getProfileDataController().saveBackpackInfo(this);
    }

    public String getName() {
        return name;
    }

    public void markInvalid() {
        isInvalid = true;
        InventoryUtil.closeInventory(this.inventory);
        Slimefun.getDatabaseManager().getProfileDataController().saveBackpackInventory(this);
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    private Inventory newInv() {
        return Bukkit.createInventory(
                this, size, (name.isEmpty() ? "Batoh" : ChatColors.color(name + "&r")) + " [Velikost " + size + "]");
    }

    private void updateInv() {
        InventoryUtil.closeInventory(this.inventory);
        var inv = newInv();
        inv.setContents(this.inventory.getContents());
        this.inventory.clear();
        this.inventory = inv;
        setInventory(inv);
    }
}
