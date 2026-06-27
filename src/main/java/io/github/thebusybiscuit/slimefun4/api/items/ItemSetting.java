package io.github.thebusybiscuit.slimefun4.api.items;

import io.github.bakedlibs.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.lang.Validate;

/**
 * Třída reprezentující nastavení pro SlimefunItem, které lze měnit v Items.yml.
 */
public class ItemSetting<T> {

    private final SlimefunItem item;
    private final String key;
    private final T defaultValue;
    private T value;

    @ParametersAreNonnullByDefault
    public ItemSetting(SlimefunItem item, String key, T defaultValue) {
        Validate.notNull(item, "SlimefunItem nesmí být null!");
        Validate.notNull(key, "Klíč nesmí být null!");
        Validate.notNull(defaultValue, "Výchozí hodnota nesmí být null!");

        this.item = item;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public boolean validateInput(T input) {
        return input != null;
    }

    public void update(@Nonnull T newValue) {
        if (validateInput(newValue)) {
            this.value = newValue;
        } else {
            throw new IllegalArgumentException("Předaná hodnota není platná (možná null?).");
        }
    }

    public @Nonnull String getKey() {
        return key;
    }

    protected @Nonnull SlimefunItem getItem() {
        return item;
    }

    public @Nonnull T getValue() {
        if (value != null) {
            return value;
        } else if (Slimefun.instance().isUnitTest()) {
            throw new IllegalStateException("ItemSetting '" + key + "' byl zavolán, ale ještě nebyl inicializován.");
        } else {
            item.warn("ItemSetting '" + key + "' byl zavolán, ale ještě nebyl inicializován.");
            return defaultValue;
        }
    }

    public @Nonnull T getDefaultValue() {
        return defaultValue;
    }

    public boolean isType(@Nonnull Class<?> c) {
        return c.isInstance(defaultValue);
    }

    protected @Nonnull String getErrorMessage() {
        return "Použijte hodnotu v rozsahu typu '" + defaultValue.getClass().getSimpleName() + "'!";
    }

    @SuppressWarnings("unchecked")
    public void reload() {
        Validate.notNull(item, "Nelze načíst nastavení pro neexistující SlimefunItem");

        Slimefun.getItemCfg().setDefaultValue(item.getId() + '.' + getKey(), getDefaultValue());

        Object configuredValue = Slimefun.getItemCfg().getValue(item.getId() + '.' + getKey());

        if (defaultValue.getClass().isInstance(configuredValue)
                || (configuredValue instanceof List && defaultValue instanceof List)) {

            T newValue = (T) configuredValue;

            if (validateInput(newValue)) {
                this.value = newValue;
            } else {
                item.warn("Nalezena neplatná konfigurace v Items.yml!"
                        + "\n  V \"" + item.getId() + "." + getKey() + "\""
                        + "\n  " + configuredValue + " není platná hodnota!"
                        + "\n" + getErrorMessage());
            }
        } else {
            this.value = defaultValue;

            String found = configuredValue == null ? "null" : configuredValue.getClass().getSimpleName();

            item.warn("Nalezena neplatná konfigurace v Items.yml!"
                    + "\nPoužívejte pouze platné hodnoty."
                    + "\n  V \"" + item.getId() + "." + getKey() + "\""
                    + "\n  Očekáván typ \"" + defaultValue.getClass().getSimpleName()
                    + "\" ale bylo zadáno: \"" + found + "\"");
        }
    }

    @Override
    public String toString() {
        T currentValue = this.value != null ? this.value : defaultValue;
        return getClass().getSimpleName()
                + " {"
                + getKey()
                + " = "
                + currentValue
                + " (default: "
                + getDefaultValue()
                + ")}";
    }

    @Override
    public final int hashCode() {
        return Objects.hash(item, key);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof ItemSetting) {
            ItemSetting<?> setting = (ItemSetting<?>) obj;
            return Objects.equals(getKey(), setting.getKey()) && Objects.equals(getItem(), setting.getItem());
        } else {
            return false;
        }
    }
}
