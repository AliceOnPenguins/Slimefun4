package io.github.thebusybiscuit.slimefun4.implementation;

import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class stores some startup warnings we occasionally need to print.
 * If you setup your server the recommended way, you are never going to see
 * any of these messages.
 *
 * @author TheBusyBiscuit
 *
 */
final class StartupWarnings {

    private static final String BORDER = "****************************************************";
    private static final String PREFIX = "* ";

    private StartupWarnings() {}

    @ParametersAreNonnullByDefault
    static void discourageCSCoreLib(Logger logger) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "Zdá se, že máš nainstalovaný CS-CoreLib.");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "Od 30. 1. 2021 už Slimefun CS-CoreLib nevyžaduje.");
        logger.log(Level.SEVERE, PREFIX + "Pro správnou funkci Slimefunu musíš CS-CoreLib odinstalovat.");
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void invalidMinecraftVersion(Logger logger, String detectedVer, String slimefunVersion) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "Slimefun se nepodařilo načíst!");
        logger.log(Level.SEVERE, PREFIX + "Používáš nepodporovanou verzi Minecraftu!");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "Používáš Minecraft {0}", detectedVer);
        logger.log(Level.SEVERE, PREFIX + "Ale Slimefun {0} podporuje pouze tyto verze:", slimefunVersion);
        logger.log(Level.SEVERE, PREFIX + "Minecraft {0}", String.join(" / ", Slimefun.getSupportedVersions()));
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void invalidServerSoftware(Logger logger) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "Slimefun se nepodařilo načíst!");
        logger.log(Level.SEVERE, PREFIX + "CraftBukkit server už nepodporujeme!");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "Musíš používat Paper nebo jeho fork (doporučujeme Paper).");
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void oldJavaVersion(Logger logger, int recommendedJavaVersion) {
        int javaVersion = NumberUtils.getJavaVersion();
        logger.log(Level.WARNING, BORDER);
        logger.log(Level.WARNING, PREFIX + "Používáš zastaralou verzi Javy (Java {0}).", javaVersion);
        logger.log(Level.WARNING, PREFIX);
        logger.log(Level.WARNING, PREFIX + "Novější verze Minecraftu vyžadují Java {0},", recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "doporučujeme ti co nejdříve přejít na Java {0}.", recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "Slimefun bude brzy také vyžadovat Java {0}.", recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "Aby ses vyhnul problémům v budoucnu, aktualizuj prosím co nejdříve!");
        logger.log(Level.WARNING, BORDER);
    }
}
