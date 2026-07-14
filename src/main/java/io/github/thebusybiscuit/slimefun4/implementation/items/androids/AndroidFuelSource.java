package io.github.thebusybiscuit.slimefun4.implementation.items.androids;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import javax.annotation.Nonnull;
import org.bukkit.inventory.ItemStack;

/**
 * This enum covers all different fuel sources a {@link ProgrammableAndroid} can have.
 *
 * @author TheBusyBiscuit
 *
 */
public enum AndroidFuelSource {

    /**
     * This {@link ProgrammableAndroid} runs on solid fuel, e.g. Wood or coal
     */
    SOLID("", "&fTento typ androida potřebuje pevné palivo", "&fnapř. uhlí, dřevo atd..."),

    /**
     * This {@link ProgrammableAndroid} runs on liquid fuel, e.g. Fuel, Oil or Lava
     */
    LIQUID("", "&fTento typ androida potřebuje kapalné palivo", "&fnapř. lávu, ropu, palivový olej atd..."),

    /**
     * This {@link ProgrammableAndroid} runs on nuclear fuel, e.g. Uranium
     */
    NUCLEAR("", "&fTento typ androida potřebuje radioaktivní palivo", "&fnapř. uran, neptunium nebo MOX palivo");

    private final String[] lore;

    AndroidFuelSource(@Nonnull String... lore) {
        this.lore = lore;
    }

    /**
     * This returns a display {@link ItemStack} for this {@link AndroidFuelSource}.
     *
     * @return An {@link ItemStack} to display
     */
    @Nonnull
    public ItemStack getItem() {
        return new CustomItemStack(
                HeadTexture.GENERATOR.getAsItemStack(), "&8\u21E9 &cVstupní slot na palivo &8\u21E9", lore);
    }
}
