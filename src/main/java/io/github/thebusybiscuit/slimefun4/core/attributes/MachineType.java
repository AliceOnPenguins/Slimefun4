package io.github.thebusybiscuit.slimefun4.core.attributes;

import javax.annotation.Nonnull;

public enum MachineType {
    CAPACITOR("Kondenzátor"),
    GENERATOR("Generátor"),
    MACHINE("Stroj");

    private final String suffix;

    MachineType(@Nonnull String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return suffix;
    }
}
