package io.github.thebusybiscuit.slimefun4.core.attributes;

import javax.annotation.Nonnull;

public enum MachineTier {
    BASIC("&eZákladní"),
    AVERAGE("&6Obyčejný"),
    MEDIUM("&aStřední"),
    GOOD("&2Vynikající"),
    ADVANCED("&6Pokročilý"),
    END_GAME("&4Vrcholný");

    private final String prefix;

    MachineTier(@Nonnull String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix;
    }
}
