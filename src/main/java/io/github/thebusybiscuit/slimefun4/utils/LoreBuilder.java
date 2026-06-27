package io.github.thebusybiscuit.slimefun4.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.annotation.Nonnull;

/**
 * Tato pomocná třída poskytuje několik užitečných metod a konstant pro vytváření popisu (lore)
 * u {@link SlimefunItemStack}. Nejčastěji se používá přímo ve třídě {@link SlimefunItems}.
 */
public final class LoreBuilder {

    public static final String HAZMAT_SUIT_REQUIRED = "&8\u21E8 &4Vyžaduje ochranný oblek proti radiaci!";
    public static final String RAINBOW = "&dStřídavě zobrazuje duhové barvy!";
    public static final String RIGHT_CLICK_TO_USE = "&ePravý klik&7 pro použití";
    public static final String RIGHT_CLICK_TO_OPEN = "&ePravý klik&7 pro otevření";
    public static final String CROUCH_TO_USE = "&eDrž &eCrouch &7pro použití";

    private static final DecimalFormat hungerFormat =
            new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.ROOT));

    private LoreBuilder() {}

    public static @Nonnull String radioactive(@Nonnull Radioactivity radioactivity) {
        return radioactivity.getLore();
    }

    public static @Nonnull String machine(@Nonnull MachineTier tier, @Nonnull MachineType type) {
        return tier + " " + type;
    }

    public static @Nonnull String speed(float speed) {
        return "&8\u21E8 &b\u26A1 &7Rychlost: &b" + speed + 'x';
    }

    public static @Nonnull String powerBuffer(int power) {
        return power(power, " uloženo");
    }

    public static @Nonnull String powerPerSecond(int power) {
        return power(power, "/s");
    }

    public static @Nonnull String power(int power, @Nonnull String suffix) {
        return "&8\u21E8 &e\u26A1 &7" + power + " J" + suffix;
    }

    public static @Nonnull String powerCharged(int charge, int capacity) {
        return "&8\u21E8 &e\u26A1 &7" + charge + " / " + capacity + " J";
    }

    public static @Nonnull String material(String material) {
        return "&8\u21E8 &7Materiál: &b" + material;
    }

    public static @Nonnull String hunger(double value) {
        return "&7&oObnoví &b&o" + hungerFormat.format(value) + " &7&obodu hladu";
    }

    public static @Nonnull String range(int blocks) {
        return "&7Dosah: &c" + blocks + " bloků";
    }

    public static @Nonnull String usesLeft(int usesLeft) {
        return "&7Zbývá použití: &e" + usesLeft + "×";
    }
}
