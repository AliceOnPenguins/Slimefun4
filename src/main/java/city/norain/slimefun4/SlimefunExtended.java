package city.norain.slimefun4;

import city.norain.slimefun4.compatibillty.VersionedEvent;
import city.norain.slimefun4.listener.SlimefunMigrateListener;
import city.norain.slimefun4.utils.EnvUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import io.github.bakedlibs.dough.versions.MinecraftVersion;
import io.github.bakedlibs.dough.versions.UnknownServerVersionException;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.util.logging.Level;
import javax.annotation.Nonnull;
import lombok.Getter;
import net.guizhanss.guizhanlib.minecraft.utils.MinecraftVersionUtil;
import org.apache.logging.log4j.core.config.Configurator;
import org.bukkit.Server;

public final class SlimefunExtended {

    private static SlimefunMigrateListener migrateListener = new SlimefunMigrateListener();

    @Getter
    private static boolean databaseDebugMode = false;

    @Deprecated(since = "2026.1.1", forRemoval = true)
    private static MinecraftVersion minecraftVersion;

    @Deprecated(since = "2026.1.1", forRemoval = true)
    public static MinecraftVersion getMinecraftVersion() {
        return minecraftVersion;
    }

    /**
     * Vrátí podrobnosti o verzi Minecraft aktuálního serveru (hlavní verze, vedlejší verze a patch).
     * Například: 26.1.2 vrátí (26, 1, 2), 26.1 vrátí (26, 1, 0).
     *
     * Pokud se nepodaří verzi rozpoznat, vrátí null.
     *
     * @since 2026.1
     * @param server Server
     * @return ServerVersion nebo null
     */
    public static ServerVersion getServerVerDetail(Server server) {
        String mcVersion = server.getMinecraftVersion();
        if (mcVersion.isBlank()) {
            return null;
        }

        // Extrahuje číselné části verze
        String[] versionPart = mcVersion.split("\\.");

        // Může to být snapshot nebo pre-release?
        if (versionPart.length < 2) {
            return null;
        }

        try {
            int majorVersion = Integer.parseInt(versionPart[0]);

            // Od 26.1 je formát verzí Minecraftu založený na roce
            if (majorVersion != 1 && majorVersion < 26) {
                return null;
            }

            int minorVersion = Integer.parseInt(versionPart[1]);
            int patchVersion = versionPart.length > 2 ? Integer.parseInt(versionPart[2]) : 0;

            return new ServerVersion(majorVersion, minorVersion, patchVersion);
        } catch (NumberFormatException e) {
            server.getLogger().log(Level.WARNING, "Nepodařilo se rozpoznat verzi serveru: " + mcVersion, e);
            return null;
        }
    }

    /**
     * @since 2026.1
     */
    public static boolean isAtLeast(int major, int minor) {
        return MinecraftVersionUtil.isAtLeast(major, minor);
    }

    /**
     * @since 2026.1
     */
    public static boolean isAtLeast(int major, int minor, int patch) {
        return MinecraftVersionUtil.isAtLeast(major, minor, patch);
    }

    private static void checkDebug() {
        if ("true".equals(System.getProperty("slimefun.database.debug"))) {
            databaseDebugMode = true;
            Slimefun.getSQLProfiler().start();
            Slimefun.logger().log(Level.INFO, "Byl aktivován režim ladění databáze");
        } else {
            Configurator.setLevel(HikariConfig.class.getName(), org.apache.logging.log4j.Level.OFF);
            Configurator.setLevel(HikariDataSource.class.getName(), org.apache.logging.log4j.Level.OFF);
            Configurator.setLevel(HikariPool.class.getName(), org.apache.logging.log4j.Level.OFF);
        }
    }

    public static boolean checkEnvironment(@Nonnull Slimefun sf) {
        try {
            minecraftVersion = MinecraftVersion.of(sf.getServer());
        } catch (UnknownServerVersionException ignored) {
            // sf.getLogger().log(Level.WARNING, "Nepodařilo se rozpoznat verzi serveru :(");
            // return false;
        }

        if (EnvironmentChecker.checkHybridServer()) {
            sf.getLogger().log(Level.WARNING, "#######################################################");
            sf.getLogger().log(Level.WARNING, "");
            sf.getLogger().log(Level.WARNING, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            sf.getLogger().log(Level.WARNING, "Byl detekován hybridní server, Slimefun bude vypnut!");
            sf.getLogger().log(Level.WARNING, "Hybridní servery byly mnoha uživateli nahlášeny jako problematické.");
            sf.getLogger().log(Level.WARNING, "Vynucené obejití kontroly nebude podporováno.");
            sf.getLogger().log(Level.WARNING, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            sf.getLogger().log(Level.WARNING, "");
            sf.getLogger().log(Level.WARNING, "#######################################################");
            return false;
        }

        if (Slimefun.getConfigManager().isBypassEnvironmentCheck()) {
            sf.getLogger().log(Level.WARNING, "#######################################################");
            sf.getLogger().log(Level.WARNING, "");
            sf.getLogger().log(Level.WARNING, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            sf.getLogger().log(Level.WARNING, "Byla vypnuta kontrola kompatibility prostředí!");
            sf.getLogger().log(Level.WARNING, "Problémy způsobené nekompatibilitou nebudou podporovány.");
            sf.getLogger().log(Level.WARNING, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            sf.getLogger().log(Level.WARNING, "");
            sf.getLogger().log(Level.WARNING, "#######################################################");
            return true;
        } else {
            return !EnvironmentChecker.checkIncompatiblePlugins(sf.getLogger());
        }
    }

    public static void init(@Nonnull Slimefun sf) {
        EnvironmentChecker.scheduleSlimeGlueCheck(sf);
        EnvUtil.init();
        checkDebug();
        VaultIntegration.register(sf);
        migrateListener.register(sf);
        VersionedEvent.init();
    }

    public static void shutdown() {
        migrateListener = null;
        VaultIntegration.cleanup();
        databaseDebugMode = false;
    }
}
