package com.xzavier0722.mc.plugin.slimefun4.storage.migrator;

import io.github.bakedlibs.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;
import java.util.logging.Level;
import javax.annotation.Nonnull;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class PlayerProfileMigrator implements IMigrator {
    private static final PlayerProfileMigrator instance = new PlayerProfileMigrator();

    private static final File playerFolder = new File("data-storage/Slimefun/Players/");
    private static volatile boolean migrateLock = false;

    private PlayerProfileMigrator() {}

    public static PlayerProfileMigrator getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "PlayerProfile";
    }

    @Override
    public boolean hasOldData() {
        return !MigratorUtil.checkMigrateMark()
                && (playerFolder.exists() && playerFolder.listFiles() != null && playerFolder.listFiles().length > 0);
    }

    @Override
    public MigrateStatus migrateData() {
        if (migrateLock) {
            return MigrateStatus.MIGRATING;
        }

        migrateLock = true;
        var result = MigrateStatus.SUCCESS;

        var listFiles = playerFolder.listFiles();

        if (!hasOldData() || listFiles == null) {
            migrateLock = false;
            return MigrateStatus.MIGRATED;
        }

        var migratedCount = 0;
        var total = listFiles.length;

        for (File file : listFiles) {
            if (!file.getName().endsWith(".yml")) {
                continue;
            }

            try {
                var uuid = UUID.fromString(file.getName().replace(".yml", ""));
                var p = Bukkit.getOfflinePlayer(uuid);

                if (!p.hasPlayedBefore()) {
                    Slimefun.logger()
                            .log(Level.INFO, "Nalezena data hráče, který se nikdy nepřipojil, přeskakuji: " + uuid);
                    total--;
                    continue;
                }

                migratePlayerProfile(p);

                migratedCount++;
                Slimefun.logger()
                        .log(
                                Level.INFO,
                                "Úspěšně migrována data hráče: " + p.getName() + "(" + migratedCount + "/" + total
                                        + ")");
            } catch (IllegalArgumentException ignored) {
                result = MigrateStatus.FAILED;
                Slimefun.logger().log(Level.WARNING, "Nalezen soubor s neplatným názvem: '" + file.getName() + "'");
            }
        }

        if (MigratorUtil.createDirBackup(playerFolder)) {
            Slimefun.logger()
                    .log(
                            Level.INFO,
                            "Úspěšně migrována data {0} hráčů! Stará data jsou uložena v ./data-storage/Slimefun/old_data",
                            migratedCount);
            try {
                Files.deleteIfExists(playerFolder.toPath());
            } catch (IOException e) {
                result = MigrateStatus.FAILED;
                Slimefun.logger()
                        .log(Level.WARNING, "Nepodařilo se smazat složku starých dat hráčů, smaž ji prosím ručně", e);
            }
        }

        migrateLock = false;

        return result;
    }

    private void migratePlayerProfile(@Nonnull OfflinePlayer p) {
        var uuid = p.getUniqueId();
        var configFile = new Config("data-storage/Slimefun/Players/" + uuid + ".yml");

        if (!configFile.getFile().exists()) {
            return;
        }

        var controller = Slimefun.getDatabaseManager().getProfileDataController();
        var profile = controller.getProfile(p);
        if (null == profile) {
            profile = controller.createProfile(p);
        }

        for (String researchID : configFile.getKeys("researches")) {
            var research = Research.getResearchByID(Integer.parseInt(researchID));

            if (research.isEmpty()) {
                continue;
            }

            profile.setResearched(research.get(), true);
        }

        var max = 0;
        for (String backpackID : configFile.getKeys("backpacks")) {
            var bpID = Integer.parseInt(backpackID);
            if (max < bpID) {
                max = bpID;
            }
            var size = configFile.getInt("backpacks." + bpID + ".size");

            var bp = controller.createBackpack(p, "", bpID, size);

            for (String key : configFile.getKeys("backpacks." + bpID + ".contents")) {
                var bpKey = Integer.parseInt(key);
                var item = configFile.getItem("backpacks." + bpID + ".contents." + bpKey);
                bp.getInventory().setItem(bpKey, item);
            }

            controller.saveBackpackInventory(bp);
        }
        profile.setBackpackCount(max);
    }
}
