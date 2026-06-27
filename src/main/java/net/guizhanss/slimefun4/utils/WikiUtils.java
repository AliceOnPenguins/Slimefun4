package net.guizhanss.slimefun4.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.JsonUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.bukkit.plugin.Plugin;

/**
 * Poskytuje pomocné metody pro Wiki
 *
 * @author ybw0014
 */
public final class WikiUtils {
    private WikiUtils() {
        throw new IllegalStateException("Pomocná třída");
    }
    /**
     * Načte wiki.json doplňku a nastaví Wiki tlačítka předmětů
     *
     * @param addon instance {@link SlimefunAddon} doplňku
     */
    public static void setupJson(Plugin addon) {
        setupJson(addon, page -> page);
    }
    /**
     * Načte wiki.json doplňku a nastaví Wiki tlačítka předmětů.
     * Umožňuje upravit adresu stránky.
     *
     * @param plugin instance {@link SlimefunAddon} doplňku
     * @param formatter úprava adresy stránky
     */
    public static void setupJson(Plugin plugin, Function<String, String> formatter) {
        if (!(plugin instanceof SlimefunAddon)) {
            throw new IllegalArgumentException("Tento plugin není Slimefun doplněk");
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(plugin.getClass().getResourceAsStream("/wiki.json"), StandardCharsets.UTF_8))) {
            JsonElement element = JsonUtils.parseString(reader.lines().collect(Collectors.joining("")));
            JsonObject json = element.getAsJsonObject();
            int count = 0;
            for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
                SlimefunItem item = SlimefunItem.getById(entry.getKey());
                if (item != null) {
                    String page = entry.getValue().getAsString();
                    page = formatter.apply(page);
                    item.addWikiPage(page);
                    count++;
                }
            }
            plugin.getLogger()
                    .log(
                            Level.INFO,
                            MessageFormat.format("Načteno {1} Wiki stránek předmětů z {0}", plugin.getName(), count));
        } catch (Exception e) {
            plugin.getLogger()
                    .log(Level.SEVERE, MessageFormat.format("Nelze načíst wiki.json pro {0}", plugin.getName()), e);
        }
    }
}
