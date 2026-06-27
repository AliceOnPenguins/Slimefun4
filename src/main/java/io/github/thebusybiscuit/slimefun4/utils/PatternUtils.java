package io.github.thebusybiscuit.slimefun4.utils;

import io.github.bakedlibs.dough.common.ChatColors;
import java.util.regex.Pattern;

/**
 * Tato třída je vytvořena pro vzory pro opakované použití, například v metodách jako {@link String#split(String)}. <br>
 * Pokaždé, když je zavolána metoda jako {@link String#split(String)}, dojde ke kompilaci {@link Pattern}.
 * U kódu, který je volán často, může být tato kompilace výraznou ztrátou výkonu.
 * Tato třída to řeší: zkompiluje vzor jednou, ale používá ho mnohokrát!
 *
 * @author Walshy
 * @author TheBusyBiscuit
 *
 */
public final class PatternUtils {
    private PatternUtils() {}

    public static final Pattern SLASH_SEPARATOR = Pattern.compile(" / ");
    public static final Pattern YAML_ENTRY = Pattern.compile("[a-z0-9_-]+:.*");
    public static final Pattern MINECRAFT_NAMESPACEDKEY = Pattern.compile("minecraft:[a-z0-9/._-]+");
    public static final Pattern MINECRAFT_TAG = Pattern.compile("#minecraft:[a-z_]+");
    public static final Pattern SLIMEFUN_TAG = Pattern.compile("#slimefun:[a-z_]+");
    public static final Pattern USES_LEFT_LORE = Pattern.compile(ChatColors.color("&7Zbývá &e[0-9]+ použití"));
}
