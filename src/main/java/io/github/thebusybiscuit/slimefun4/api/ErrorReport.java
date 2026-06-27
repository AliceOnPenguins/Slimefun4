package io.github.thebusybiscuit.slimefun4.api;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.papermc.lib.PaperLib;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

/**
 * Tato třída reprezentuje {@link ErrorReport}.
 * Chybové reporty se vytvářejí, když {@link BlockTicker} způsobuje problémy.
 * Aby se konzole příliš nezanášela, blok se zničí a místo toho se vygeneruje {@link ErrorReport}.
 * Chybové reporty se ukládají do složky pluginu.
 *
 * @param <T> Typ {@link Throwable}, který tento {@link ErrorReport} vytvořil
 */
public class ErrorReport<T extends Throwable> {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm", Locale.ROOT);
    private static final AtomicInteger count = new AtomicInteger(0);

    private final SlimefunAddon addon;
    private final T throwable;
    private File file;

    @ParametersAreNonnullByDefault
    public ErrorReport(T throwable, SlimefunAddon addon, Consumer<PrintStream> printer) {
        this.throwable = throwable;
        this.addon = addon;
        Slimefun.runSync(() -> print(printer));
    }

    @ParametersAreNonnullByDefault
    public ErrorReport(T throwable, Location l, SlimefunItem item) {
        this(throwable, item.getAddon(), stream -> {
            stream.println("Informace o bloku:");
            stream.println("  Svět: " + l.getWorld().getName());
            stream.println("  X: " + l.getBlockX());
            stream.println("  Y: " + l.getBlockY());
            stream.println("  Z: " + l.getBlockZ());
            stream.println("  Typ bloku: " + l.getBlock().getType());
            stream.println(
                    "  BlockData: " + l.getBlock().getBlockData().getClass().getName());
            stream.println("  Stav: " + l.getBlock().getState().getClass().getName());
            stream.println();

            if (item.getBlockTicker() != null) {
                stream.println("Informace o Tickeru:");
                stream.println("  Typ: " + (item.getBlockTicker().isSynchronized() ? "Synchronní" : "Asynchronní"));
                stream.println();
            }

            if (item instanceof EnergyNetProvider) {
                stream.println("Informace o Tickeru:");
                stream.println("  Typ: Nepřímý (spravováno energetickou sítí)");
                stream.println();
            }

            stream.println("Slimefun data:");
            stream.println("  ID: " + item.getId());

            var blockData =
                    Slimefun.getDatabaseManager().getBlockDataController().getBlockData(l);
            if (blockData == null) {
                Slimefun.runSync(() -> Slimefun.getBlockDataService()
                        .getUniversalDataUUID(l.getBlock())
                        .ifPresentOrElse(
                                uuid -> {
                                    var universalData = Slimefun.getDatabaseManager()
                                            .getBlockDataController()
                                            .getUniversalBlockDataFromCache(uuid);
                                    if (universalData != null) {
                                        stream.println("  Stav načtení dat: " + universalData.isDataLoaded());
                                        stream.println("  Inventář: " + (universalData.getMenu() != null));
                                        stream.println("  Data: ");
                                        universalData
                                                .getAllData()
                                                .forEach((k, v) -> stream.println("   " + k + ": " + v));
                                    } else {
                                        stream.println("Tento blok nemá žádná data.");
                                    }
                                },
                                () -> stream.println("Tento blok nemá žádná data.")));
            } else {
                stream.println("  Stav načtení dat: " + blockData.isDataLoaded());
                stream.println("  Inventář: " + (blockData.getBlockMenu() != null));
                stream.println("  Data: ");
                blockData.getAllData().forEach((k, v) -> stream.println("   " + k + ": " + v));
            }
            stream.println();
        });
    }

    @ParametersAreNonnullByDefault
    public ErrorReport(T throwable, SlimefunItem item) {
        this(throwable, item.getAddon(), stream -> {
            stream.println("SlimefunItem:");
            stream.println("  ID: " + item.getId());
            stream.println("  Plugin: "
                    + (item.getAddon() == null ? "Neznámý" : item.getAddon().getName()));
            stream.println();
        });
    }

    public @Nonnull File getFile() {
        return file;
    }

    public @Nonnull T getThrown() {
        return throwable;
    }

    public static int count() {
        return count.get();
    }

    private void print(@Nonnull Consumer<PrintStream> printer) {
        this.file = getNewFile();
        count.incrementAndGet();

        try (PrintStream stream = new PrintStream(file, StandardCharsets.UTF_8.name())) {
            stream.println();
            stream.println("Chyba vygenerována: " + dateFormat.format(LocalDateTime.now()));
            stream.println();

            stream.println("Java prostředí:");
            stream.println("  Operační systém: " + System.getProperty("os.name"));
            stream.println("  Verze Javy: " + System.getProperty("java.version"));
            stream.println();

            String serverSoftware = PaperLib.isSpigot() && !PaperLib.isPaper() ? "Spigot" : Bukkit.getName();
            stream.println("Server software: " + serverSoftware);
            stream.println("  Build: " + Bukkit.getVersion());
            stream.println("  Minecraft v" + Bukkit.getBukkitVersion());
            stream.println();

            stream.println("Slimefun prostředí:");
            stream.println("  Slimefun v" + Slimefun.getVersion());
            stream.println("  Způsobeno: " + addon.getName() + " v" + addon.getPluginVersion());
            stream.println();

            List<String> plugins = new ArrayList<>();
            List<String> addons = new ArrayList<>();
            scanPlugins(plugins, addons);

            stream.println("Nainstalované addony (" + addons.size() + ")");
            addons.forEach(stream::println);
            stream.println();

            stream.println("Nainstalované pluginy (" + plugins.size() + "):");
            plugins.forEach(stream::println);
            stream.println();

            printer.accept(stream);

            stream.println("Stacktrace:");
            stream.println();
            throwable.printStackTrace(stream);

            addon.getLogger().log(Level.WARNING, "");
            addon.getLogger().log(Level.WARNING, "Došlo k chybě! Byla uložena jako:");
            addon.getLogger().log(Level.WARNING, "/plugins/Slimefun/error-reports/{0}", file.getName());
            addon.getLogger().log(Level.WARNING, "Nahraj tento soubor na https://pastebin.com/ a nahlás to vývojáři.");
            if (addon.getBugTrackerURL() != null) {
                addon.getLogger().log(Level.WARNING, "Bug Tracker: {0}", addon.getBugTrackerURL());
            }
            addon.getLogger().log(Level.WARNING, "Prosím NEPOSÍLEJ vývojářům screenshoty těchto logů.");
            addon.getLogger().log(Level.WARNING, "");
        } catch (Exception x) {
            addon.getLogger()
                    .log(
                            Level.SEVERE,
                            x,
                            () -> "Došlo k chybě při ukládání chybového reportu pro Slimefun " + Slimefun.getVersion());
        }
    }

    private static void scanPlugins(@Nonnull List<String> plugins, @Nonnull List<String> addons) {
        String dependency = "Slimefun";
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (Bukkit.getPluginManager().isPluginEnabled(plugin)) {
                plugins.add(
                        " + " + plugin.getName() + ' ' + plugin.getDescription().getVersion());
                if (plugin.getDescription().getDepend().contains(dependency)
                        || plugin.getDescription().getSoftDepend().contains(dependency)) {
                    addons.add(" + " + plugin.getName() + ' '
                            + plugin.getDescription().getVersion());
                }
            } else {
                plugins.add(
                        " - " + plugin.getName() + ' ' + plugin.getDescription().getVersion());
                if (plugin.getDescription().getDepend().contains(dependency)
                        || plugin.getDescription().getSoftDepend().contains(dependency)) {
                    addons.add(" - " + plugin.getName() + ' '
                            + plugin.getDescription().getVersion());
                }
            }
        }
    }

    private static @Nonnull File getNewFile() {
        String path = "plugins/Slimefun/error-reports/" + dateFormat.format(LocalDateTime.now());
        File newFile = new File(path + ".err");

        if (newFile.exists()) {
            IntStream stream =
                    IntStream.iterate(1, i -> i + 1).filter(i -> !new File(path + " (" + i + ").err").exists());
            int id = stream.findFirst().getAsInt();
            newFile = new File(path + " (" + id + ").err");
        }
        return newFile;
    }

    /**
     * Pomocná metoda, která zabalí {@link Runnable} do try-catch bloku.
     * Pokud dojde k výjimce, vygeneruje se {@link ErrorReport}.
     */
    public static void tryCatch(
            @Nonnull Function<Exception, ErrorReport<Exception>> function, @Nonnull Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception x) {
            function.apply(x);
        }
    }
}
