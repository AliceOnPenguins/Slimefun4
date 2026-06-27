package io.github.thebusybiscuit.slimefun4.utils.compatibility;

import com.google.common.base.Preconditions;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.annotation.Nonnull;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;

/**
 * Kompatibilita Sound napříč verzemi
 *
 * @author ybw0014
 */
public final class VersionedSound {
    private VersionedSound() {
        // pomocná třída
    }

    private static final boolean IS_ENUM;
    private static final Method GET_KEY_METHOD;
    private static final Method VALUE_OF_METHOD;

    static {
        boolean isEnum = false;
        Method getKeyMethod = null;
        Method valueOfMethod = null;
        try {
            if (Sound.class.isEnum()) {
                isEnum = true;
            } else {
                getKeyMethod = Sound.class.getMethod("getKey");
            }
            valueOfMethod = Sound.class.getMethod("valueOf", String.class);
        } catch (Exception e) {
            Slimefun.logger().severe("Nelze určit typ Sound: " + e.getMessage());
        }
        IS_ENUM = isEnum;
        GET_KEY_METHOD = getKeyMethod;
        VALUE_OF_METHOD = valueOfMethod;
    }

    public static boolean isEnum() {
        return IS_ENUM;
    }
    /**
     * Získá název Sound
     *
     * @param sound objekt Sound
     * @return název Sound
     */
    @Nonnull
    public static String getSoundName(@Nonnull Sound sound) {
        try {
            if (isEnum()) {
                return ((Enum<?>) sound).name();
            } else if (GET_KEY_METHOD != null) {
                Object key = GET_KEY_METHOD.invoke(sound);
                if (!(key instanceof NamespacedKey nsKey)) {
                    throw new IllegalStateException("Sound.getKey() nevrátilo NamespacedKey");
                }
                return nsKey.getKey();
            }
        } catch (Exception e) {
            Slimefun.logger().severe("Získání názvu Sound selhalo: " + e.getMessage());
        }
        // záložní řešení
        return sound.toString();
    }
    /**
     * Kompatibilita metody valueOf()
     *
     * @param name název Sound
     * @return objekt Sound
     * @throws IllegalArgumentException neplatný název
     */
    @Nonnull
    public static Sound valueOf(@Nonnull String name) throws IllegalArgumentException {
        Preconditions.checkArgument(name != null, "Název Sound nesmí být prázdný");
        String enumName = name.toUpperCase(Locale.ROOT).replace('.', '_').replace('-', '_');
        try {
            if (VALUE_OF_METHOD != null) {
                return (Sound) VALUE_OF_METHOD.invoke(null, enumName);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Nelze zavolat Sound.valueOf: " + name, e);
        }
        throw new IllegalArgumentException("Metoda Sound.valueOf není dostupná");
    }
}
