package io.github.thebusybiscuit.slimefun4.utils.compatibility;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.lang.reflect.Method;
import javax.annotation.Nonnull;
import org.bukkit.block.Biome;

/**
 * Kompatibilita Biome napříč verzemi
 *
 * @author ybw0014
 */
public final class VersionedBiome {
    private VersionedBiome() {
        // pomocná třída
    }

    private static final Method VALUE_OF_METHOD;

    static {
        Method valueOfMethod = null;
        try {
            valueOfMethod = Biome.class.getMethod("valueOf", String.class);
        } catch (Exception e) {
            Slimefun.logger().severe("Inicializace kompatibility Biome napříč verzemi selhala: " + e.getMessage());
        }
        VALUE_OF_METHOD = valueOfMethod;
    }

    @Nonnull
    public static Biome valueOf(@Nonnull String biomeName) throws IllegalArgumentException {
        if (biomeName == null || biomeName.isEmpty()) {
            throw new IllegalArgumentException("Název biomu nesmí být prázdný");
        }
        try {
            if (VALUE_OF_METHOD != null) {
                return (Biome) VALUE_OF_METHOD.invoke(null, biomeName.toUpperCase());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Nelze zavolat Biome.valueOf: " + biomeName, e);
        }
        throw new IllegalArgumentException("Metoda Biome.valueOf není dostupná");
    }
}
