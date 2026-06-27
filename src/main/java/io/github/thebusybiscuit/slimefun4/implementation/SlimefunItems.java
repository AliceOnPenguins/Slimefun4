package io.github.thebusybiscuit.slimefun4.implementation;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerBackpack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.items.magical.staves.StormStaff;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import io.github.thebusybiscuit.slimefun4.utils.compatibility.VersionedEnchantment;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ColoredFireworkStar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * This class holds a static references to every {@link SlimefunItemStack}
 * found in Slimefun.
 */
@SuppressWarnings("java:S1192") // Suppress "duplicate string literal" warnings
public final class SlimefunItems {

    private SlimefunItems() {}

    /*		 Items 		*/
    public static final SlimefunItemStack PORTABLE_CRAFTER = new SlimefunItemStack(
            "PORTABLE_CRAFTER",
            HeadTexture.PORTABLE_CRAFTER,
            "&6Přenosný pracovní stůl",
            "&a&oPřenosný pracovní stůl",
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack PORTABLE_DUSTBIN = new SlimefunItemStack(
            "PORTABLE_DUSTBIN",
            HeadTexture.TRASH_CAN,
            "&6Přenosný odpadkový koš",
            "&rSnadno likviduje nepotřebné věci",
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack ENDER_BACKPACK = new SlimefunItemStack(
            "ENDER_BACKPACK",
            HeadTexture.ENDER_BACKPACK,
            "&6Ender batoh",
            "&a&oPřenosný ender chest",
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack MAGIC_EYE_OF_ENDER = new SlimefunItemStack(
            "MAGIC_EYE_OF_ENDER",
            Material.ENDER_EYE,
            "&6&lMagické Ender oko",
            "&4&lVyžaduje kompletní Ender zbroj",
            "",
            "&7&ePravý klik&7 pro vystřelení ender perly");
    public static final SlimefunItemStack BROKEN_SPAWNER = new SlimefunItemStack(
            "BROKEN_SPAWNER",
            Material.SPAWNER,
            "&cPoškozený spawner",
            "&7Typ: &b<typ>",
            "",
            "&cPoškozený, opravit lze na starověkém oltáři");
    public static final SlimefunItemStack REPAIRED_SPAWNER =
            new SlimefunItemStack("REINFORCED_SPAWNER", Material.SPAWNER, "&bOpravený spawner", "&7Typ: &b<typ>");
    public static final SlimefunItemStack INFERNAL_BONEMEAL = new SlimefunItemStack(
            "INFERNAL_BONEMEAL",
            Material.BONE_MEAL,
            "&4Pekelný kostní prach",
            "",
            "&cZrychluje růst netherových výrůstků");
    public static final SlimefunItemStack TAPE_MEASURE = new SlimefunItemStack(
            "TAPE_MEASURE",
            "180d5c43a6cf5bb7769fd0c8240e1e70d2ae38ef9d78a1db401aca6a2cb36f65",
            "&6Měřicí pásmo",
            "",
            "&eShift + Pravý klik &7nastaví počáteční bod",
            "&ePravý klik &7změří vzdálenost");

    /*		 Gadgets 		*/
    public static final SlimefunItemStack GOLD_PAN = new SlimefunItemStack(
            "GOLD_PAN",
            Material.BOWL,
            "&6Zlatá pánev",
            "&a&oMůžeš získat různé rudy",
            "",
            "&7&ePravý klik&7 na štěrk pro získání zlata");
    public static final SlimefunItemStack NETHER_GOLD_PAN = new SlimefunItemStack(
            "NETHER_GOLD_PAN",
            Material.BOWL,
            "&4Netherová zlatá pánev",
            "",
            "&7&ePravý klik&7 na soul sand pro získání zlata");
    public static final SlimefunItemStack PARACHUTE = new SlimefunItemStack(
            "PARACHUTE", Material.LEATHER_CHESTPLATE, Color.WHITE, "&r&lPadák", "", LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack GRAPPLING_HOOK =
            new SlimefunItemStack("GRAPPLING_HOOK", Material.LEAD, "&6Háček", "", LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack SOLAR_HELMET = new SlimefunItemStack(
            "SOLAR_HELMET", Material.IRON_HELMET, "&bSolární helma", "", "&a&oDobíjí předměty a zbroj, které držíš");
    public static final SlimefunItemStack CLOTH = new SlimefunItemStack("CLOTH", Material.PAPER, "&bLátka");
    public static final SlimefunItemStack REINFORCED_CLOTH = new SlimefunItemStack(
            "REINFORCED_CLOTH",
            Material.PAPER,
            "&bVyztužená látka",
            "",
            "&fTato látka zesílená olovem",
            "&fchrání před negativními účinky radiace");
    public static final SlimefunItemStack TIN_CAN = new SlimefunItemStack("CAN", HeadTexture.TIN_CAN, "&rPlechovka");
    public static final SlimefunItemStack NIGHT_VISION_GOGGLES = new SlimefunItemStack(
            "NIGHT_VISION_GOGGLES",
            Material.LEATHER_HELMET,
            Color.BLACK,
            "&aBrýle nočního vidění",
            "",
            "&9+ Efekt nočního vidění");
    public static final SlimefunItemStack ELYTRA_CAP = new SlimefunItemStack(
            "ELYTRA_CAP",
            Material.LEATHER_HELMET,
            Color.PURPLE,
            "&5Čepice s elytrami",
            "",
            "&7Zabraňuje ti spadnout při létání s elytrami");
    public static final SlimefunItemStack FARMER_SHOES = new SlimefunItemStack(
            "FARMER_SHOES", Material.LEATHER_BOOTS, Color.YELLOW, "&eFarmářské boty", "", "&6&oZabraňuje ničení polí");
    public static final SlimefunItemStack INFUSED_MAGNET = new SlimefunItemStack(
            "INFUSED_MAGNET",
            HeadTexture.MAGNET,
            "&aMagický magnet",
            "",
            "&rMagnet naplněný magií",
            "&rsbírá předměty v okolí",
            "&rdo tvého inventáře",
            "",
            "&7Drž &eShift&7 pro sbírání okolních předmětů");
    public static final SlimefunItemStack RAG = new SlimefunItemStack(
            "RAG",
            Material.PAPER,
            "&cHadřík",
            "",
            "&aLékařský zásobník úrovně 1",
            "",
            "&rObnoví 2 HP",
            "&rUhasí oheň na tobě",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack BANDAGE = new SlimefunItemStack(
            "BANDAGE",
            Material.PAPER,
            "&cObvaz",
            "",
            "&aLékařský zásobník úrovně 2",
            "",
            "&rObnoví 4 HP",
            "&rUhasí oheň na tobě",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack SPLINT = new SlimefunItemStack(
            "SPLINT",
            Material.STICK,
            "&cDlaha",
            "",
            "&aLékařský zásobník úrovně 1",
            "",
            "&rObnoví 2 HP",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack VITAMINS = new SlimefunItemStack(
            "VITAMINS",
            Material.NETHER_WART,
            "&cVitamíny",
            "",
            "&aLékařský zásobník úrovně 3",
            "",
            "&rObnoví 4 HP",
            "&rUhasí oheň na tobě",
            "&rVyléčí otravu / wither / radiaci",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack MEDICINE = new SlimefunItemStack(
            "MEDICINE",
            Material.POTION,
            Color.RED,
            "&cLék",
            "",
            "&aLékařský zásobník úrovně 3",
            "",
            "&rObnoví 4 HP",
            "&rUhasí oheň na tobě",
            "&rVyléčí otravu / wither / radiaci",
            "",
            "&7&ePravý klik&7 pro vypití");
    public static final SlimefunItemStack MAGICAL_ZOMBIE_PILLS = new SlimefunItemStack(
            "MAGICAL_ZOMBIE_PILLS",
            Material.NETHER_WART,
            "&6Pilulky oživení",
            "",
            "&ePravý klik pro okamžité vyléčení &7zombie vesničana / piglina");

    public static final SlimefunItemStack FLASK_OF_KNOWLEDGE = new SlimefunItemStack(
            "FLASK_OF_KNOWLEDGE",
            Material.GLASS_BOTTLE,
            "&cLáhev vědění",
            "",
            "&rUmožňuje ukládat zkušenosti do láhve",
            "&7Spotřebuje &a1 level");
    public static final SlimefunItemStack FILLED_FLASK_OF_KNOWLEDGE =
            new SlimefunItemStack("FILLED_FLASK_OF_KNOWLEDGE", Material.EXPERIENCE_BOTTLE, "&aLáhev vědění");

    /*		Backpacks		*/
    public static final SlimefunItemStack BACKPACK_SMALL = new SlimefunItemStack(
            "SMALL_BACKPACK",
            HeadTexture.BACKPACK,
            "&eMalý batoh",
            "",
            "&7Velikost: &e9",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack BACKPACK_MEDIUM = new SlimefunItemStack(
            "MEDIUM_BACKPACK",
            HeadTexture.BACKPACK,
            "&eStřední batoh",
            "",
            "&7Velikost: &e18",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack BACKPACK_LARGE = new SlimefunItemStack(
            "LARGE_BACKPACK",
            HeadTexture.BACKPACK,
            "&eVelký batoh",
            "",
            "&7Velikost: &e27",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack WOVEN_BACKPACK = new SlimefunItemStack(
            "WOVEN_BACKPACK",
            HeadTexture.BACKPACK,
            "&eTkaný batoh",
            "",
            "&7Velikost: &e36",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack GILDED_BACKPACK = new SlimefunItemStack(
            "GILDED_BACKPACK",
            HeadTexture.BACKPACK,
            "&ePozlacený batoh",
            "",
            "&7Velikost: &e45",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack RADIANT_BACKPACK = new SlimefunItemStack(
            "RADIANT_BACKPACK",
            HeadTexture.BACKPACK,
            "&eZářivý batoh",
            "",
            "&7Velikost: &e54 (velká truhla)",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack BOUND_BACKPACK = new SlimefunItemStack(
            "BOUND_BACKPACK",
            HeadTexture.ENDER_BACKPACK,
            "&cDuší vázaný batoh",
            "",
            "&7Velikost: &e36",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack COOLER = new SlimefunItemStack(
            "COOLER",
            HeadTexture.COOLER,
            "&bMalá chladnička",
            "&rUkládá džusy a smoothie",
            "&rKdyž je v inventáři",
            "&rautomaticky konzumuje jídlo při hladu",
            "",
            "&7Velikost: &e27",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack RESTORED_BACKPACK = new SlimefunItemStack(
            "RESTORED_BACKPACK",
            HeadTexture.RESTORED_BACKPACK,
            "&eObnovovač batohů",
            "",
            "&7Získat zpět ztracené předměty z batohu",
            PlayerBackpack.LORE_OWNER,
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);

    /*		 Jetpacks		*/
    public static final SlimefunItemStack DURALUMIN_JETPACK = new SlimefunItemStack(
            "DURALUMIN_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eI",
            "",
            LoreBuilder.material("Duralumin"),
            LoreBuilder.powerCharged(0, 20),
            "&8\u21E8 &7Tah: &c0.35",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack SOLDER_JETPACK = new SlimefunItemStack(
            "SOLDER_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eII",
            "",
            LoreBuilder.material("Pájka"),
            LoreBuilder.powerCharged(0, 30),
            "&8\u21E8 &7Tah: &c0.4",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack BILLON_JETPACK = new SlimefunItemStack(
            "BILLON_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eIII",
            "",
            LoreBuilder.material("Billon"),
            LoreBuilder.powerCharged(0, 45),
            "&8\u21E8 &7Tah: &c0.45",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack STEEL_JETPACK = new SlimefunItemStack(
            "STEEL_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eIV",
            "",
            LoreBuilder.material("Ocel"),
            LoreBuilder.powerCharged(0, 60),
            "&8\u21E8 &7Tah: &c0.5",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack DAMASCUS_STEEL_JETPACK = new SlimefunItemStack(
            "DAMASCUS_STEEL_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eV",
            "",
            LoreBuilder.material("Damascénská ocel"),
            LoreBuilder.powerCharged(0, 75),
            "&8\u21E8 &7Tah: &c0.55",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack REINFORCED_ALLOY_JETPACK = new SlimefunItemStack(
            "REINFORCED_ALLOY_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.SILVER,
            "&9Proudový batoh &7- &eVI",
            "",
            LoreBuilder.material("Vyztužená slitina"),
            LoreBuilder.powerCharged(0, 100),
            "&8\u21E8 &7Tah: &c0.6",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack CARBONADO_JETPACK = new SlimefunItemStack(
            "CARBONADO_JETPACK",
            Material.LEATHER_CHESTPLATE,
            Color.BLACK,
            "&9Proudový batoh &7- &eVII",
            "",
            LoreBuilder.material("Carbonado"),
            LoreBuilder.powerCharged(0, 150),
            "&8\u21E8 &7Tah: &c0.7",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack ARMORED_JETPACK = new SlimefunItemStack(
            "ARMORED_JETPACK",
            Material.IRON_CHESTPLATE,
            "&9Obrněný proudový batoh",
            LoreBuilder.material("Ocel"),
            "",
            LoreBuilder.powerCharged(0, 50),
            "&8\u21E8 &7Tah: &c0.5",
            "",
            LoreBuilder.CROUCH_TO_USE);

    /*		 Jetboots		*/
    public static final SlimefunItemStack DURALUMIN_JETBOOTS = new SlimefunItemStack(
            "DURALUMIN_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eI",
            "",
            LoreBuilder.material("Duralumin"),
            LoreBuilder.powerCharged(0, 20),
            "&8\u21E8 &7Rychlost: &a0.35",
            "&8\u21E8 &7Přesnost: &c50%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack SOLDER_JETBOOTS = new SlimefunItemStack(
            "SOLDER_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eII",
            "",
            LoreBuilder.material("Pájka"),
            LoreBuilder.powerCharged(0, 30),
            "&8\u21E8 &7Rychlost: &a0.4",
            "&8\u21E8 &7Přesnost: &660%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack BILLON_JETBOOTS = new SlimefunItemStack(
            "BILLON_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eIII",
            "",
            LoreBuilder.material("Billon"),
            LoreBuilder.powerCharged(0, 40),
            "&8\u21E8 &7Rychlost: &a0.45",
            "&8\u21E8 &7Přesnost: &665%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack STEEL_JETBOOTS = new SlimefunItemStack(
            "STEEL_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eIV",
            "",
            LoreBuilder.material("Ocel"),
            LoreBuilder.powerCharged(0, 50),
            "&8\u21E8 &7Rychlost: &a0.5",
            "&8\u21E8 &7Přesnost: &e70%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack DAMASCUS_STEEL_JETBOOTS = new SlimefunItemStack(
            "DAMASCUS_STEEL_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eV",
            "",
            LoreBuilder.material("Damascénská ocel"),
            LoreBuilder.powerCharged(0, 75),
            "&8\u21E8 &7Rychlost: &a0.55",
            "&8\u21E8 &7Přesnost: &a75%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack REINFORCED_ALLOY_JETBOOTS = new SlimefunItemStack(
            "REINFORCED_ALLOY_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.SILVER,
            "&9Proudové boty &7- &eVI",
            "",
            LoreBuilder.material("Vyztužená slitina"),
            LoreBuilder.powerCharged(0, 100),
            "&8\u21E8 &7Rychlost: &a0.6",
            "&8\u21E8 &7Přesnost: &c80%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack CARBONADO_JETBOOTS = new SlimefunItemStack(
            "CARBONADO_JETBOOTS",
            Material.LEATHER_BOOTS,
            Color.BLACK,
            "&9Proudové boty &7- &eVII",
            "",
            LoreBuilder.material("Carbonado"),
            LoreBuilder.powerCharged(0, 125),
            "&8\u21E8 &7Rychlost: &a0.7",
            "&8\u21E8 &7Přesnost: &c99.9%",
            "",
            LoreBuilder.CROUCH_TO_USE);
    public static final SlimefunItemStack ARMORED_JETBOOTS = new SlimefunItemStack(
            "ARMORED_JETBOOTS",
            Material.IRON_BOOTS,
            "&9Obrněné proudové boty",
            "",
            LoreBuilder.material("Ocel"),
            LoreBuilder.powerCharged(0, 50),
            "&8\u21E8 &7Rychlost: &a0.45",
            "&8\u21E8 &7Přesnost: &e70%",
            "",
            LoreBuilder.CROUCH_TO_USE);

    /*		 Multi Tools		*/
    public static final SlimefunItemStack DURALUMIN_MULTI_TOOL = new SlimefunItemStack(
            "DURALUMIN_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eI",
            "",
            LoreBuilder.material("Duralumin"),
            LoreBuilder.powerCharged(0, 20),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack SOLDER_MULTI_TOOL = new SlimefunItemStack(
            "SOLDER_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eII",
            "",
            LoreBuilder.material("Pájka"),
            LoreBuilder.powerCharged(0, 30),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack BILLON_MULTI_TOOL = new SlimefunItemStack(
            "BILLON_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eIII",
            "",
            LoreBuilder.material("Billon"),
            LoreBuilder.powerCharged(0, 40),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack STEEL_MULTI_TOOL = new SlimefunItemStack(
            "STEEL_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eIV",
            "",
            LoreBuilder.material("Ocel"),
            LoreBuilder.powerCharged(0, 50),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack DAMASCUS_STEEL_MULTI_TOOL = new SlimefunItemStack(
            "DAMASCUS_STEEL_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eV",
            "",
            LoreBuilder.material("Damascénská ocel"),
            LoreBuilder.powerCharged(0, 60),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack REINFORCED_ALLOY_MULTI_TOOL = new SlimefunItemStack(
            "REINFORCED_ALLOY_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eVI",
            "",
            LoreBuilder.material("Vyztužená slitina"),
            LoreBuilder.powerCharged(0, 75),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");
    public static final SlimefunItemStack CARBONADO_MULTI_TOOL = new SlimefunItemStack(
            "CARBONADO_MULTI_TOOL",
            Material.SHEARS,
            "&9Multitool &7- &eVII",
            "",
            LoreBuilder.material("Carbonado"),
            LoreBuilder.powerCharged(0, 100),
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE,
            "&7Drž &eShift + Pravý klik&7 pro změnu režimu");

    static {
        ItemMeta duralumin = DURALUMIN_MULTI_TOOL.getItemMeta();
        duralumin.setUnbreakable(true);
        DURALUMIN_MULTI_TOOL.setItemMeta(duralumin);

        ItemMeta solder = SOLDER_MULTI_TOOL.getItemMeta();
        solder.setUnbreakable(true);
        SOLDER_MULTI_TOOL.setItemMeta(solder);

        ItemMeta billon = BILLON_MULTI_TOOL.getItemMeta();
        billon.setUnbreakable(true);
        BILLON_MULTI_TOOL.setItemMeta(billon);

        ItemMeta steel = STEEL_MULTI_TOOL.getItemMeta();
        steel.setUnbreakable(true);
        STEEL_MULTI_TOOL.setItemMeta(steel);

        ItemMeta damascus = DAMASCUS_STEEL_MULTI_TOOL.getItemMeta();
        damascus.setUnbreakable(true);
        DAMASCUS_STEEL_MULTI_TOOL.setItemMeta(damascus);

        ItemMeta reinforced = REINFORCED_ALLOY_MULTI_TOOL.getItemMeta();
        reinforced.setUnbreakable(true);
        REINFORCED_ALLOY_MULTI_TOOL.setItemMeta(reinforced);

        ItemMeta carbonado = CARBONADO_MULTI_TOOL.getItemMeta();
        carbonado.setUnbreakable(true);
        CARBONADO_MULTI_TOOL.setItemMeta(carbonado);
    }

    /*		 Food 		*/
    public static final SlimefunItemStack FORTUNE_COOKIE =
            new SlimefunItemStack("FORTUNE_COOKIE", Material.COOKIE, "&6Štěstíčko", "", "&a&oŘekne ti budoucnost :o");
    public static final SlimefunItemStack DIET_COOKIE = new SlimefunItemStack(
            "DIET_COOKIE", Material.COOKIE, "&6Dietní sušenka", "", "&aVelmi &olehká&r&a sušenka");
    public static final SlimefunItemStack MAGIC_SUGAR =
            new SlimefunItemStack("MAGIC_SUGAR", Material.SUGAR, "&6Magický cukr", "", "&a&oCítíš sílu Herma!");
    public static final SlimefunItemStack MONSTER_JERKY = new SlimefunItemStack(
            "MONSTER_JERKY", Material.ROTTEN_FLESH, "&6Sušené monstrum", "", "&a&oDodává energii a utišuje hlad");
    public static final SlimefunItemStack APPLE_JUICE = new SlimefunItemStack(
            "APPLE_JUICE",
            Color.RED,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&cJablečný džus",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack MELON_JUICE = new SlimefunItemStack(
            "MELON_JUICE",
            Color.RED,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&cMelounový džus",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack CARROT_JUICE = new SlimefunItemStack(
            "CARROT_JUICE",
            Color.ORANGE,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&6Mrkvový džus",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack PUMPKIN_JUICE = new SlimefunItemStack(
            "PUMPKIN_JUICE",
            Color.ORANGE,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&6Dýňový džus",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack SWEET_BERRY_JUICE = new SlimefunItemStack(
            "SWEET_BERRY_JUICE",
            Color.RED,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&cDžus z lesních plodů",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack GLOW_BERRY_JUICE = new SlimefunItemStack(
            "GLOW_BERRY_JUICE",
            Color.ORANGE,
            new PotionEffect(PotionEffectType.SATURATION, 5, 0),
            "&6Džus z svítících bobulí",
            "",
            LoreBuilder.hunger(3));
    public static final SlimefunItemStack GOLDEN_APPLE_JUICE = new SlimefunItemStack(
            "GOLDEN_APPLE_JUICE",
            Color.YELLOW,
            new PotionEffect(PotionEffectType.ABSORPTION, 20 * 20, 0),
            "&bDžus ze zlatého jablka");

    public static final SlimefunItemStack BEEF_JERKY =
            new SlimefunItemStack("BEEF_JERKY", Material.COOKED_BEEF, "&6Sušené hovězí", "", "&rUtíší hlad!");
    public static final SlimefunItemStack PORK_JERKY =
            new SlimefunItemStack("PORK_JERKY", Material.COOKED_PORKCHOP, "&6Sušené vepřové", "", "&rUtíší hlad!");
    public static final SlimefunItemStack CHICKEN_JERKY =
            new SlimefunItemStack("CHICKEN_JERKY", Material.COOKED_CHICKEN, "&6Sušené kuře", "", "&rUtíší hlad!");
    public static final SlimefunItemStack MUTTON_JERKY =
            new SlimefunItemStack("MUTTON_JERKY", Material.COOKED_MUTTON, "&6Sušené jehněčí", "", "&rUtíší hlad!");
    public static final SlimefunItemStack RABBIT_JERKY =
            new SlimefunItemStack("RABBIT_JERKY", Material.COOKED_RABBIT, "&6Sušený králík", "", "&rUtíší hlad!");
    public static final SlimefunItemStack FISH_JERKY =
            new SlimefunItemStack("FISH_JERKY", Material.COOKED_COD, "&6Sušená ryba", "", "&rUtíší hlad!");
    public static final SlimefunItemStack KELP_COOKIE =
            new SlimefunItemStack("KELP_COOKIE", Material.COOKIE, "&2Sušenka z chaluh");

    /*		Christmas		*/
    public static final SlimefunItemStack CHRISTMAS_MILK = new SlimefunItemStack(
            "CHRISTMAS_MILK",
            Color.WHITE,
            new PotionEffect(PotionEffectType.SATURATION, 4, 0),
            "&6Sklenice mléka",
            "",
            LoreBuilder.hunger(2.5));
    public static final SlimefunItemStack CHRISTMAS_CHOCOLATE_MILK = new SlimefunItemStack(
            "CHRISTMAS_CHOCOLATE_MILK",
            Color.MAROON,
            new PotionEffect(PotionEffectType.SATURATION, 11, 0),
            "&6Čokoládové mléko",
            "",
            LoreBuilder.hunger(3.5));
    public static final SlimefunItemStack CHRISTMAS_EGG_NOG = new SlimefunItemStack(
            "CHRISTMAS_EGG_NOG",
            Color.GRAY,
            new PotionEffect(PotionEffectType.SATURATION, 6, 0),
            "&aVaječný likér",
            "",
            LoreBuilder.hunger(7));
    public static final SlimefunItemStack CHRISTMAS_APPLE_CIDER = new SlimefunItemStack(
            "CHRISTMAS_APPLE_CIDER",
            Color.RED,
            new PotionEffect(PotionEffectType.SATURATION, 13, 0),
            "&cJablečný mošt",
            "",
            LoreBuilder.hunger(7));
    public static final SlimefunItemStack CHRISTMAS_COOKIE =
            new SlimefunItemStack("CHRISTMAS_COOKIE", Material.COOKIE, ChatUtils.christmas("Vánoční sušenka"));
    public static final SlimefunItemStack CHRISTMAS_FRUIT_CAKE =
            new SlimefunItemStack("CHRISTMAS_FRUIT_CAKE", Material.PUMPKIN_PIE, ChatUtils.christmas("Ovocný koláč"));
    public static final SlimefunItemStack CHRISTMAS_APPLE_PIE =
            new SlimefunItemStack("CHRISTMAS_APPLE_PIE", Material.PUMPKIN_PIE, "&rJablečný koláč");
    public static final SlimefunItemStack CHRISTMAS_HOT_CHOCOLATE = new SlimefunItemStack(
            "CHRISTMAS_HOT_CHOCOLATE",
            Color.MAROON,
            new PotionEffect(PotionEffectType.SATURATION, 13, 0),
            "&6Horká čokoláda",
            "",
            LoreBuilder.hunger(7));
    public static final SlimefunItemStack CHRISTMAS_CAKE =
            new SlimefunItemStack("CHRISTMAS_CAKE", Material.PUMPKIN_PIE, ChatUtils.christmas("Vánoční dort"));
    public static final SlimefunItemStack CHRISTMAS_CARAMEL =
            new SlimefunItemStack("CHRISTMAS_CARAMEL", Material.BRICK, "&6Karamel");
    public static final SlimefunItemStack CHRISTMAS_CARAMEL_APPLE =
            new SlimefunItemStack("CHRISTMAS_CARAMEL_APPLE", Material.APPLE, "&6Karamelové jablko");
    public static final SlimefunItemStack CHRISTMAS_CHOCOLATE_APPLE =
            new SlimefunItemStack("CHRISTMAS_CHOCOLATE_APPLE", Material.APPLE, "&6Čokoládové jablko");
    public static final SlimefunItemStack CHRISTMAS_PRESENT = new SlimefunItemStack(
            "CHRISTMAS_PRESENT",
            HeadTexture.CHRISTMAS_PRESENT,
            ChatUtils.christmas("Vánoční dárek"),
            "&7Dárek od &eTheBusyBiscuit",
            "&7Příjemce: &eTy",
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);

    /*		Easter			*/
    public static final SlimefunItemStack EASTER_EGG = new SlimefunItemStack(
            "EASTER_EGG",
            HeadTexture.EASTER_EGG,
            "&rVelikonoční vajíčko",
            "&dVeselé Velikonoce! Otevři ho.",
            "",
            LoreBuilder.RIGHT_CLICK_TO_OPEN);
    public static final SlimefunItemStack EASTER_CARROT_PIE =
            new SlimefunItemStack("CARROT_PIE", Material.PUMPKIN_PIE, "&6Mrkvový koláč");
    public static final SlimefunItemStack EASTER_APPLE_PIE =
            new SlimefunItemStack("EASTER_APPLE_PIE", Material.PUMPKIN_PIE, "&rJablečný koláč");

    /*		 Weapons 		*/
    public static final SlimefunItemStack GRANDMAS_WALKING_STICK =
            new SlimefunItemStack("GRANDMAS_WALKING_STICK", Material.STICK, "&7Babiččina hůl");
    public static final SlimefunItemStack GRANDPAS_WALKING_STICK =
            new SlimefunItemStack("GRANDPAS_WALKING_STICK", Material.STICK, "&7Dědečkova hůl");
    public static final SlimefunItemStack SWORD_OF_BEHEADING = new SlimefunItemStack(
            "SWORD_OF_BEHEADING",
            Material.IRON_SWORD,
            "&6Meč stětí",
            "&7Stětí II",
            "",
            "&rMá šanci useknout hlavu",
            "&r(zvyšuje šanci na wither skeleton skull)");
    public static final SlimefunItemStack BLADE_OF_VAMPIRES = new SlimefunItemStack(
            "BLADE_OF_VAMPIRES",
            Material.GOLDEN_SWORD,
            "&cUpíří čepel",
            "&7Životní krádež I",
            "",
            "&r45% šance při útoku",
            "obnovit 2 HP");
    public static final SlimefunItemStack SEISMIC_AXE = new SlimefunItemStack(
            "SEISMIC_AXE",
            Material.IRON_AXE,
            "&aSeizmická sekera",
            "",
            "&7&oZpůsobí zemětřesení...",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);

    static {
        GRANDMAS_WALKING_STICK.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        GRANDPAS_WALKING_STICK.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);

        BLADE_OF_VAMPIRES.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        BLADE_OF_VAMPIRES.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 4);
        BLADE_OF_VAMPIRES.addUnsafeEnchantment(VersionedEnchantment.SHARPNESS, 2);
    }

    /*		Bows		*/
    public static final SlimefunItemStack EXPLOSIVE_BOW = new SlimefunItemStack(
            "EXPLOSIVE_BOW", Material.BOW, "&cExplozivní luk", "&rŠípy z tohoto luku vyhodí cíl do vzduchu");
    public static final SlimefunItemStack ICY_BOW = new SlimefunItemStack(
            "ICY_BOW", Material.BOW, "&bLedový luk", "&rŠípy z tohoto luku", "&rzpůsobí zmrazení (2 sekundy)");

    /*		 Tools		*/
    public static final SlimefunItemStack SMELTERS_PICKAXE = new SlimefunItemStack(
            "SMELTERS_PICKAXE",
            Material.DIAMOND_PICKAXE,
            "&6Tavičský krumpáč",
            "&c&lAutomatické tavení",
            "",
            "&9Při těžbě má efekt štěstí");
    public static final SlimefunItemStack LUMBER_AXE = new SlimefunItemStack(
            "LUMBER_AXE", Material.DIAMOND_AXE, "&6Dřevorubecká sekera", "&a&oKácí celé stromy...");
    public static final SlimefunItemStack PICKAXE_OF_CONTAINMENT = new SlimefunItemStack(
            "PICKAXE_OF_CONTAINMENT", Material.IRON_PICKAXE, "&cKrumpáč na spawners", "", "&9Může získat spawner");
    public static final SlimefunItemStack EXPLOSIVE_PICKAXE = new SlimefunItemStack(
            "EXPLOSIVE_PICKAXE",
            Material.DIAMOND_PICKAXE,
            "&eExplozivní krumpáč",
            "",
            "&rRychlá těžba pomocí explozí",
            "",
            "&9Podporuje štěstí");
    public static final SlimefunItemStack EXPLOSIVE_SHOVEL = new SlimefunItemStack(
            "EXPLOSIVE_SHOVEL", Material.DIAMOND_SHOVEL, "&eExplozivní lopata", "", "&rNajednou vykope mnoho bloků");
    public static final SlimefunItemStack PICKAXE_OF_THE_SEEKER = new SlimefunItemStack(
            "PICKAXE_OF_THE_SEEKER",
            Material.DIAMOND_PICKAXE,
            "&aHledačský krumpáč",
            "&rPři použití ukáže blízké rudy",
            "&rMůže se poškodit",
            "",
            "&7&ePravý klik&7 pro hledání rud");
    public static final SlimefunItemStack COBALT_PICKAXE =
            new SlimefunItemStack("COBALT_PICKAXE", Material.IRON_PICKAXE, "&9Kobaltový krumpáč");
    public static final SlimefunItemStack PICKAXE_OF_VEIN_MINING = new SlimefunItemStack(
            "PICKAXE_OF_VEIN_MINING",
            Material.DIAMOND_PICKAXE,
            "&eŽilní krumpáč",
            "",
            "&rTento krumpáč vytěží",
            "&rcelou žílu...");
    public static final SlimefunItemStack CLIMBING_PICK = new SlimefunItemStack(
            "CLIMBING_PICK",
            Material.IRON_PICKAXE,
            "&bLezecký krumpáč",
            "",
            "&fUmožňuje ti lézt po stěnách",
            "&fpo pravém kliknutí.",
            "&fEfekt efektivity zvyšuje rychlost");

    static {
        COBALT_PICKAXE.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 10);
        COBALT_PICKAXE.addUnsafeEnchantment(VersionedEnchantment.EFFICIENCY, 6);
    }

    /*		 Armor 		*/
    public static final SlimefunItemStack GLOWSTONE_HELMET = new SlimefunItemStack(
            "GLOWSTONE_HELMET",
            Material.LEATHER_HELMET,
            Color.YELLOW,
            "&e&lHelma z glowstone",
            "",
            "&a&oSvítí jako slunce!",
            "",
            "&9+ Noční vidění");
    public static final SlimefunItemStack GLOWSTONE_CHESTPLATE = new SlimefunItemStack(
            "GLOWSTONE_CHESTPLATE",
            Material.LEATHER_CHESTPLATE,
            Color.YELLOW,
            "&e&lChestplate z glowstone",
            "",
            "&a&oSvítí jako slunce!",
            "",
            "&9+ Noční vidění");
    public static final SlimefunItemStack GLOWSTONE_LEGGINGS = new SlimefunItemStack(
            "GLOWSTONE_LEGGINGS",
            Material.LEATHER_LEGGINGS,
            Color.YELLOW,
            "&e&lLegíny z glowstone",
            "",
            "&a&oSvítí jako slunce!",
            "",
            "&9+ Noční vidění");
    public static final SlimefunItemStack GLOWSTONE_BOOTS = new SlimefunItemStack(
            "GLOWSTONE_BOOTS",
            Material.LEATHER_BOOTS,
            Color.YELLOW,
            "&e&lBoty z glowstone",
            "",
            "&a&oSvítí jako slunce!",
            "",
            "&9+ Noční vidění");
    public static final SlimefunItemStack RAINBOW_LEATHER = new SlimefunItemStack(
            "RAINBOW_LEATHER",
            Material.RABBIT_HIDE,
            Color.FUCHSIA,
            "&dDuhová kůže",
            "",
            "&fPoužívá se k výrobě duhové výbavy");
    public static final SlimefunItemStack RAINBOW_HELMET = new SlimefunItemStack(
            "RAINBOW_HELMET", Material.LEATHER_HELMET, Color.FUCHSIA, "&d&lDuhová helma", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_CHESTPLATE = new SlimefunItemStack(
            "RAINBOW_CHESTPLATE",
            Material.LEATHER_CHESTPLATE,
            Color.FUCHSIA,
            "&d&lDuhový hrudní plát",
            "",
            LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_LEGGINGS = new SlimefunItemStack(
            "RAINBOW_LEGGINGS",
            Material.LEATHER_LEGGINGS,
            Color.FUCHSIA,
            "&d&lDuhové kalhoty",
            "",
            LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_BOOTS = new SlimefunItemStack(
            "RAINBOW_BOOTS", Material.LEATHER_BOOTS, Color.FUCHSIA, "&d&lDuhové boty", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack ENDER_HELMET = new SlimefunItemStack(
            "ENDER_HELMET",
            Material.LEATHER_HELMET,
            Color.fromRGB(28, 25, 112),
            "&5&lEnder helma",
            "",
            "&a&oVolný pohyb");
    public static final SlimefunItemStack ENDER_CHESTPLATE = new SlimefunItemStack(
            "ENDER_CHESTPLATE",
            Material.LEATHER_CHESTPLATE,
            Color.fromRGB(28, 25, 112),
            "&5&lEnder hrudní plát",
            "",
            "&a&oVolný pohyb");
    public static final SlimefunItemStack ENDER_LEGGINGS = new SlimefunItemStack(
            "ENDER_LEGGINGS",
            Material.LEATHER_LEGGINGS,
            Color.fromRGB(28, 25, 112),
            "&5&lEnder kalhoty",
            "",
            "&a&oVolný pohyb");
    public static final SlimefunItemStack ENDER_BOOTS = new SlimefunItemStack(
            "ENDER_BOOTS",
            Material.LEATHER_BOOTS,
            Color.fromRGB(28, 25, 112),
            "&5&lEnder boty",
            "",
            "&a&oVolný pohyb",
            "",
            "&9+ Bez poškození při použití ender perly");

    public static final SlimefunItemStack SLIME_HELMET = new SlimefunItemStack(
            "SLIME_HELMET", Material.LEATHER_HELMET, Color.LIME, "&a&lSlizová helma", "", "&a&oPružný pocit");
    public static final SlimefunItemStack SLIME_CHESTPLATE = new SlimefunItemStack(
            "SLIME_CHESTPLATE",
            Material.LEATHER_CHESTPLATE,
            Color.LIME,
            "&a&lSlizový hrudní plát",
            "",
            "&a&oPružný pocit");
    public static final SlimefunItemStack SLIME_LEGGINGS = new SlimefunItemStack(
            "SLIME_LEGGINGS",
            Material.LEATHER_LEGGINGS,
            Color.LIME,
            "&a&lSlizové kalhoty",
            "",
            "&a&oPružný pocit",
            "",
            "&9+ Rychlost");
    public static final SlimefunItemStack SLIME_BOOTS = new SlimefunItemStack(
            "SLIME_BOOTS",
            Material.LEATHER_BOOTS,
            Color.LIME,
            "&a&lSlizové boty",
            "",
            "&a&oPružný pocit",
            "",
            "&9+ Skok",
            "&9+ Redukce pádového poškození");

    public static final SlimefunItemStack CACTUS_HELMET =
            new SlimefunItemStack("CACTUS_HELMET", Material.LEATHER_HELMET, Color.GREEN, "&2Kaktusová helma");
    public static final SlimefunItemStack CACTUS_CHESTPLATE = new SlimefunItemStack(
            "CACTUS_CHESTPLATE", Material.LEATHER_CHESTPLATE, Color.GREEN, "&2Kaktusový hrudní plát");
    public static final SlimefunItemStack CACTUS_LEGGINGS =
            new SlimefunItemStack("CACTUS_LEGGINGS", Material.LEATHER_LEGGINGS, Color.GREEN, "&2Kaktusové kalhoty");
    public static final SlimefunItemStack CACTUS_BOOTS =
            new SlimefunItemStack("CACTUS_BOOTS", Material.LEATHER_BOOTS, Color.GREEN, "&2Kaktusové boty");

    public static final SlimefunItemStack DAMASCUS_STEEL_HELMET =
            new SlimefunItemStack("DAMASCUS_STEEL_HELMET", Material.IRON_HELMET, "&7Damascénská ocelová helma");
    public static final SlimefunItemStack DAMASCUS_STEEL_CHESTPLATE = new SlimefunItemStack(
            "DAMASCUS_STEEL_CHESTPLATE", Material.IRON_CHESTPLATE, "&7Damascénský ocelový hrudní plát");
    public static final SlimefunItemStack DAMASCUS_STEEL_LEGGINGS =
            new SlimefunItemStack("DAMASCUS_STEEL_LEGGINGS", Material.IRON_LEGGINGS, "&7Damascénské ocelové kalhoty");
    public static final SlimefunItemStack DAMASCUS_STEEL_BOOTS =
            new SlimefunItemStack("DAMASCUS_STEEL_BOOTS", Material.IRON_BOOTS, "&7Damascénské ocelové boty");

    public static final SlimefunItemStack REINFORCED_ALLOY_HELMET =
            new SlimefunItemStack("REINFORCED_ALLOY_HELMET", Material.IRON_HELMET, "&bVyztužená slitinová helma");
    public static final SlimefunItemStack REINFORCED_ALLOY_CHESTPLATE = new SlimefunItemStack(
            "REINFORCED_ALLOY_CHESTPLATE", Material.IRON_CHESTPLATE, "&bVyztužený slitinový hrudní plát");
    public static final SlimefunItemStack REINFORCED_ALLOY_LEGGINGS =
            new SlimefunItemStack("REINFORCED_ALLOY_LEGGINGS", Material.IRON_LEGGINGS, "&bVyztužené slitinové kalhoty");
    public static final SlimefunItemStack REINFORCED_ALLOY_BOOTS =
            new SlimefunItemStack("REINFORCED_ALLOY_BOOTS", Material.IRON_BOOTS, "&bVyztužené slitinové boty");

    private static final List<String> hazmatLore = new ArrayList<>();

    static {
        hazmatLore.add("");
        hazmatLore.add(ChatColor.GOLD + "Efekt celé sady:");
        hazmatLore.add(ChatColor.YELLOW + "- Imunita vůči radiaci");
        hazmatLore.add(ChatColor.YELLOW + "- Imunita vůči včelám");
    }

    public static final SlimefunItemStack SCUBA_HELMET = new SlimefunItemStack(
            "SCUBA_HELMET",
            Material.LEATHER_HELMET,
            Color.ORANGE,
            "&cPotápěčská helma",
            "",
            "&7Umožňuje dýchat pod vodou");
    public static final SlimefunItemStack HAZMAT_CHESTPLATE = new SlimefunItemStack(
            "HAZMAT_CHESTPLATE",
            Material.LEATHER_CHESTPLATE,
            Color.ORANGE,
            "&cOchranný oblek",
            "",
            "&7Umožňuje chodit v ohni a lávě");
    public static final SlimefunItemStack HAZMAT_LEGGINGS = new SlimefunItemStack(
            "HAZMAT_LEGGINGS",
            Material.LEATHER_LEGGINGS,
            Color.ORANGE,
            "&cOchranné kalhoty",
            hazmatLore.toArray(new String[0]));
    public static final SlimefunItemStack HAZMAT_BOOTS = new SlimefunItemStack(
            "RUBBER_BOOTS", Material.LEATHER_BOOTS, Color.BLACK, "&cOchranné boty", hazmatLore.toArray(new String[0]));

    static {
        ItemMeta helmetMeta = SCUBA_HELMET.getItemMeta();
        List<String> helmetLore = helmetMeta.getLore();
        helmetLore.addAll(hazmatLore);
        helmetMeta.setLore(helmetLore);
        SCUBA_HELMET.setItemMeta(helmetMeta);

        ItemMeta chestplateMeta = HAZMAT_CHESTPLATE.getItemMeta();
        List<String> chestplateLore = chestplateMeta.getLore();
        chestplateLore.addAll(hazmatLore);
        chestplateMeta.setLore(chestplateLore);
        HAZMAT_CHESTPLATE.setItemMeta(chestplateMeta);
    }

    public static final SlimefunItemStack GILDED_IRON_HELMET =
            new SlimefunItemStack("GILDED_IRON_HELMET", Material.GOLDEN_HELMET, "&6Pozlacená železná helma");
    public static final SlimefunItemStack GILDED_IRON_CHESTPLATE = new SlimefunItemStack(
            "GILDED_IRON_CHESTPLATE", Material.GOLDEN_CHESTPLATE, "&6Pozlacený železný hrudní plát");
    public static final SlimefunItemStack GILDED_IRON_LEGGINGS =
            new SlimefunItemStack("GILDED_IRON_LEGGINGS", Material.GOLDEN_LEGGINGS, "&6Pozlacené železné kalhoty");
    public static final SlimefunItemStack GILDED_IRON_BOOTS =
            new SlimefunItemStack("GILDED_IRON_BOOTS", Material.GOLDEN_BOOTS, "&6Pozlacené železné boty");

    public static final SlimefunItemStack GOLDEN_HELMET_12K =
            new SlimefunItemStack("GOLD_12K_HELMET", Material.GOLDEN_HELMET, "&6Zlatá helma", "&912 karátů");
    public static final SlimefunItemStack GOLDEN_CHESTPLATE_12K = new SlimefunItemStack(
            "GOLD_12K_CHESTPLATE", Material.GOLDEN_CHESTPLATE, "&6Zlatý hrudní plát", "&912 karátů");
    public static final SlimefunItemStack GOLDEN_LEGGINGS_12K =
            new SlimefunItemStack("GOLD_12K_LEGGINGS", Material.GOLDEN_LEGGINGS, "&6Zlaté kalhoty", "&912 karátů");
    public static final SlimefunItemStack GOLDEN_BOOTS_12K =
            new SlimefunItemStack("GOLD_12K_BOOTS", Material.GOLDEN_BOOTS, "&6Zlaté boty", "&912 karátů");

    public static final SlimefunItemStack SLIME_HELMET_STEEL = new SlimefunItemStack(
            "SLIME_STEEL_HELMET", Material.IRON_HELMET, "&a&lSlizová helma", "&7&oVyztužená", "", "&a&oPružný pocit");
    public static final SlimefunItemStack SLIME_CHESTPLATE_STEEL = new SlimefunItemStack(
            "SLIME_STEEL_CHESTPLATE",
            Material.IRON_CHESTPLATE,
            "&a&lSlizový hrudní plát",
            "&7&oVyztužený",
            "",
            "&a&oPružný pocit");
    public static final SlimefunItemStack SLIME_LEGGINGS_STEEL = new SlimefunItemStack(
            "SLIME_STEEL_LEGGINGS",
            Material.IRON_LEGGINGS,
            "&a&lSlizové kalhoty",
            "&7&oVyztužené",
            "",
            "&a&oPružný pocit",
            "",
            "&9+ Rychlost");
    public static final SlimefunItemStack SLIME_BOOTS_STEEL = new SlimefunItemStack(
            "SLIME_STEEL_BOOTS",
            Material.IRON_BOOTS,
            "&a&lSlizové boty",
            "&7&oVyztužené",
            "",
            "&a&oPružný pocit",
            "",
            "&9+ Skok",
            "&9+ Redukce pádového poškození");

    public static final SlimefunItemStack BOOTS_OF_THE_STOMPER = new SlimefunItemStack(
            "BOOTS_OF_THE_STOMPER",
            Material.LEATHER_BOOTS,
            Color.AQUA,
            "&bBoty drtiče",
            "",
            "&9Veškeré pádové poškození",
            "&9se přenese na blízké entity/hráče",
            "",
            "&9+ Redukce pádového poškození");

    public static final SlimefunItemStack BEE_HELMET =
            new SlimefunItemStack("BEE_HELMET", Material.GOLDEN_HELMET, "&e&lVčelí helma", " ", "&fBzzz");
    public static final SlimefunItemStack BEE_WINGS = new SlimefunItemStack(
            "BEE_WINGS",
            Material.ELYTRA,
            "&e&lVčelí křídla",
            " ",
            "&fBzzz",
            " ",
            "&9Při přiblížení k zemi",
            "&9aktivuje pomalý pád",
            " ");
    public static final SlimefunItemStack BEE_LEGGINGS =
            new SlimefunItemStack("BEE_LEGGINGS", Material.GOLDEN_LEGGINGS, "&e&lVčelí kalhoty", " ", "&fBzzz");
    public static final SlimefunItemStack BEE_BOOTS = new SlimefunItemStack(
            "BEE_BOOTS",
            Material.GOLDEN_BOOTS,
            "&e&lVčelí boty",
            "&fBzzz",
            "",
            "&e&oOpětovný start je bez problémů",
            "",
            "&9+ Skok",
            "&9+ Redukce pádového poškození");

    static {
        Map<Enchantment, Integer> cactusEnchs = new HashMap<>();
        cactusEnchs.put(Enchantment.THORNS, 3);
        cactusEnchs.put(VersionedEnchantment.UNBREAKING, 6);

        CACTUS_HELMET.addUnsafeEnchantments(cactusEnchs);
        CACTUS_CHESTPLATE.addUnsafeEnchantments(cactusEnchs);
        CACTUS_LEGGINGS.addUnsafeEnchantments(cactusEnchs);
        CACTUS_BOOTS.addUnsafeEnchantments(cactusEnchs);

        Map<Enchantment, Integer> damascusEnchs = new HashMap<>();
        damascusEnchs.put(VersionedEnchantment.UNBREAKING, 5);
        damascusEnchs.put(VersionedEnchantment.PROTECTION, 5);

        DAMASCUS_STEEL_HELMET.addUnsafeEnchantments(damascusEnchs);
        DAMASCUS_STEEL_CHESTPLATE.addUnsafeEnchantments(damascusEnchs);
        DAMASCUS_STEEL_LEGGINGS.addUnsafeEnchantments(damascusEnchs);
        DAMASCUS_STEEL_BOOTS.addUnsafeEnchantments(damascusEnchs);

        Map<Enchantment, Integer> reinforcedEnchs = new HashMap<>();
        reinforcedEnchs.put(VersionedEnchantment.UNBREAKING, 9);
        reinforcedEnchs.put(VersionedEnchantment.PROTECTION, 9);

        REINFORCED_ALLOY_HELMET.addUnsafeEnchantments(reinforcedEnchs);
        REINFORCED_ALLOY_CHESTPLATE.addUnsafeEnchantments(reinforcedEnchs);
        REINFORCED_ALLOY_LEGGINGS.addUnsafeEnchantments(reinforcedEnchs);
        REINFORCED_ALLOY_BOOTS.addUnsafeEnchantments(reinforcedEnchs);

        Map<Enchantment, Integer> gildedEnchs = new HashMap<>();
        gildedEnchs.put(VersionedEnchantment.UNBREAKING, 6);
        gildedEnchs.put(VersionedEnchantment.PROTECTION, 8);

        GILDED_IRON_HELMET.addUnsafeEnchantments(gildedEnchs);
        GILDED_IRON_CHESTPLATE.addUnsafeEnchantments(gildedEnchs);
        GILDED_IRON_LEGGINGS.addUnsafeEnchantments(gildedEnchs);
        GILDED_IRON_BOOTS.addUnsafeEnchantments(gildedEnchs);

        GOLDEN_HELMET_12K.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 10);
        GOLDEN_CHESTPLATE_12K.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 10);
        GOLDEN_LEGGINGS_12K.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 10);
        GOLDEN_BOOTS_12K.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 10);

        Map<Enchantment, Integer> slimeEnchs = new HashMap<>();
        slimeEnchs.put(VersionedEnchantment.UNBREAKING, 4);
        slimeEnchs.put(VersionedEnchantment.PROTECTION, 2);

        SLIME_HELMET_STEEL.addUnsafeEnchantments(slimeEnchs);
        SLIME_CHESTPLATE_STEEL.addUnsafeEnchantments(slimeEnchs);
        SLIME_LEGGINGS_STEEL.addUnsafeEnchantments(slimeEnchs);
        SLIME_BOOTS_STEEL.addUnsafeEnchantments(slimeEnchs);

        Map<Enchantment, Integer> beeEnchs = new HashMap<>();
        beeEnchs.put(VersionedEnchantment.UNBREAKING, 4);
        beeEnchs.put(VersionedEnchantment.PROTECTION, 2);

        BEE_HELMET.addUnsafeEnchantments(beeEnchs);
        BEE_WINGS.addUnsafeEnchantments(beeEnchs);
        BEE_LEGGINGS.addUnsafeEnchantments(beeEnchs);
        BEE_BOOTS.addUnsafeEnchantments(beeEnchs);
    }

    /*		 Misc 		*/
    public static final SlimefunItemStack MAGIC_LUMP_1 = new SlimefunItemStack(
            "MAGIC_LUMP_1", Material.GOLD_NUGGET, "&6Magická hrudka &7- &eI", "", "&c&oÚroveň: I");
    public static final SlimefunItemStack MAGIC_LUMP_2 = new SlimefunItemStack(
            "MAGIC_LUMP_2", Material.GOLD_NUGGET, "&6Magická hrudka &7- &eII", "", "&c&oÚroveň: II");
    public static final SlimefunItemStack MAGIC_LUMP_3 = new SlimefunItemStack(
            "MAGIC_LUMP_3", Material.GOLD_NUGGET, "&6Magická hrudka &7- &eIII", "", "&c&oÚroveň: III");
    public static final SlimefunItemStack ENDER_LUMP_1 =
            new SlimefunItemStack("ENDER_LUMP_1", Material.GOLD_NUGGET, "&5Ender hrudka &7- &eI", "", "&c&oÚroveň: I");
    public static final SlimefunItemStack ENDER_LUMP_2 = new SlimefunItemStack(
            "ENDER_LUMP_2", Material.GOLD_NUGGET, "&5Ender hrudka &7- &eII", "", "&c&oÚroveň: II");
    public static final SlimefunItemStack ENDER_LUMP_3 = new SlimefunItemStack(
            "ENDER_LUMP_3", Material.GOLD_NUGGET, "&5Ender hrudka &7- &eIII", "", "&c&oÚroveň: III");
    public static final SlimefunItemStack MAGICAL_BOOK_COVER = new SlimefunItemStack(
            "MAGICAL_BOOK_COVER", Material.PAPER, "&6Magický obal na knihu", "", "&a&oPoužívá se pro magické knihy");
    public static final SlimefunItemStack MAGICAL_GLASS = new SlimefunItemStack(
            "MAGICAL_GLASS", Material.GLASS_PANE, "&6Magické sklo", "", "&a&oPoužíváno mnoha magickými předměty");
    public static final SlimefunItemStack SYNTHETIC_SHULKER_SHELL = new SlimefunItemStack(
            "SYNTHETIC_SHULKER_SHELL",
            Material.SHULKER_SHELL,
            "&dUmělá schránka shulkera",
            "",
            "&fLze použít v crafting table",
            "&fjako normální schránka");
    public static final SlimefunItemStack BASIC_CIRCUIT_BOARD =
            new SlimefunItemStack("BASIC_CIRCUIT_BOARD", Material.ACTIVATOR_RAIL, "&bZákladní obvodová deska");
    public static final SlimefunItemStack ADVANCED_CIRCUIT_BOARD =
            new SlimefunItemStack("ADVANCED_CIRCUIT_BOARD", Material.POWERED_RAIL, "&bPokročilá obvodová deska");
    public static final SlimefunItemStack WHEAT_FLOUR =
            new SlimefunItemStack("WHEAT_FLOUR", Material.SUGAR, "&rPšeničná mouka");
    public static final SlimefunItemStack STEEL_PLATE =
            new SlimefunItemStack("STEEL_PLATE", Material.PAPER, "&7&lOcelový plát");
    public static final SlimefunItemStack BATTERY = new SlimefunItemStack("BATTERY", HeadTexture.BATTERY, "&6Baterie");
    public static final SlimefunItemStack CARBON = new SlimefunItemStack("CARBON", HeadTexture.CARBON, "&eUhlík");
    public static final SlimefunItemStack COMPRESSED_CARBON =
            new SlimefunItemStack("COMPRESSED_CARBON", HeadTexture.COMPRESSED_CARBON, "&cStlačený uhlík");
    public static final SlimefunItemStack CARBON_CHUNK =
            new SlimefunItemStack("CARBON_CHUNK", HeadTexture.CARBON, "&4Uhelný blok");
    public static final SlimefunItemStack STEEL_THRUSTER =
            new SlimefunItemStack("STEEL_THRUSTER", Material.BUCKET, "&7&lOcelový trychtýř");
    public static final SlimefunItemStack POWER_CRYSTAL =
            new SlimefunItemStack("POWER_CRYSTAL", HeadTexture.POWER_CRYSTAL, "&c&lEnergetický krystal");
    public static final SlimefunItemStack CHAIN = new SlimefunItemStack("CHAIN", Material.STRING, "&bŘetěz");
    public static final SlimefunItemStack HOOK = new SlimefunItemStack("HOOK", Material.FLINT, "&bHák");
    public static final SlimefunItemStack SIFTED_ORE =
            new SlimefunItemStack("SIFTED_ORE", Material.GUNPOWDER, "&6Prosátá ruda");
    public static final SlimefunItemStack STONE_CHUNK =
            new SlimefunItemStack("STONE_CHUNK", HeadTexture.STONE_CHUNK, "&6Kamenný úlomek");
    public static final SlimefunItemStack LAVA_CRYSTAL =
            new SlimefunItemStack("LAVA_CRYSTAL", HeadTexture.LAVA_CRYSTAL, "&4Lávový krystal");
    public static final SlimefunItemStack SALT = new SlimefunItemStack("SALT", Material.SUGAR, "&rSůl");
    public static final SlimefunItemStack CHEESE = new SlimefunItemStack("CHEESE", HeadTexture.CHEESE, "&rSýr");
    public static final SlimefunItemStack BUTTER = new SlimefunItemStack("BUTTER", HeadTexture.BUTTER, "&rMáslo");
    public static final SlimefunItemStack DUCT_TAPE = new SlimefunItemStack(
            "DUCT_TAPE",
            HeadTexture.DUCT_TAPE,
            "&8Duct tape",
            "",
            "&rLze použít v auto anvilu",
            "&rpro opravu předmětů");
    public static final SlimefunItemStack HEAVY_CREAM =
            new SlimefunItemStack("HEAVY_CREAM", Material.SNOWBALL, "&rHustá smetana");
    public static final SlimefunItemStack CRUSHED_ORE =
            new SlimefunItemStack("CRUSHED_ORE", Material.GUNPOWDER, "&6Rozdrcená ruda");
    public static final SlimefunItemStack PULVERIZED_ORE =
            new SlimefunItemStack("PULVERIZED_ORE", Material.GUNPOWDER, "&6Rozemletá ruda");
    public static final SlimefunItemStack PURE_ORE_CLUSTER =
            new SlimefunItemStack("PURE_ORE_CLUSTER", Material.GUNPOWDER, "&6Čistý rudný shluk");
    public static final SlimefunItemStack SMALL_URANIUM = new SlimefunItemStack(
            "SMALL_URANIUM",
            HeadTexture.URANIUM,
            "&cMalý kus uranu",
            "",
            LoreBuilder.radioactive(Radioactivity.MODERATE),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack TINY_URANIUM = new SlimefunItemStack(
            "TINY_URANIUM",
            HeadTexture.URANIUM,
            "&cMalé množství uranu",
            "",
            LoreBuilder.radioactive(Radioactivity.LOW));

    public static final SlimefunItemStack MAGNET = new SlimefunItemStack("MAGNET", HeadTexture.MAGNET, "&cMagnet");
    public static final SlimefunItemStack NECROTIC_SKULL =
            new SlimefunItemStack("NECROTIC_SKULL", HeadTexture.NECROTIC_SKULL, "&cNekrotická lebka");
    public static final SlimefunItemStack ESSENCE_OF_AFTERLIFE =
            new SlimefunItemStack("ESSENCE_OF_AFTERLIFE", Material.GUNPOWDER, "&4Esence posmrtného života");
    public static final SlimefunItemStack STRANGE_NETHER_GOO = new SlimefunItemStack(
            "STRANGE_NETHER_GOO",
            Material.PURPLE_DYE,
            "&5Podivná netherová sliz",
            "",
            "&fPodivná hmota",
            "&fLze vyměnit s pigliny");
    public static final SlimefunItemStack ELECTRO_MAGNET =
            new SlimefunItemStack("ELECTRO_MAGNET", HeadTexture.MAGNET, "&cElektromagnet");
    public static final SlimefunItemStack HEATING_COIL =
            new SlimefunItemStack("HEATING_COIL", HeadTexture.HEATING_COIL, "&cTopná spirála");
    public static final SlimefunItemStack COOLING_UNIT =
            new SlimefunItemStack("COOLING_UNIT", HeadTexture.COOLING_UNIT, "&bChladící jednotka");
    public static final SlimefunItemStack ELECTRIC_MOTOR =
            new SlimefunItemStack("ELECTRIC_MOTOR", HeadTexture.MOTOR, "&cElektrický motor");
    public static final SlimefunItemStack CARGO_MOTOR = new SlimefunItemStack(
            "CARGO_MOTOR", HeadTexture.CARGO_MOTOR, "&3Cargo motor", "", "&7Důležitá součást cargo sítě");
    public static final SlimefunItemStack SCROLL_OF_DIMENSIONAL_TELEPOSITION = new SlimefunItemStack(
            "SCROLL_OF_DIMENSIONAL_TELEPOSITION",
            Material.PAPER,
            "&6Svitek dimenzionálního přesunu",
            "",
            "&cTento svitek může vytvořit",
            "&cdočasnou černou díru",
            "&cpřesouvající entity do jiné dimenze",
            "&cVše se otočí",
            "",
            "&rTo znamená: otočit entity o 180°");
    public static final SlimefunItemStack TOME_OF_KNOWLEDGE_SHARING = new SlimefunItemStack(
            "TOME_OF_KNOWLEDGE_SHARING",
            Material.ENCHANTED_BOOK,
            "&6Kniha sdílení vědění",
            "&7Vlastník: &bŽádný",
            "",
            "&ePravý klik&7 pro svázání všech výzkumů",
            "",
            "&ePravý klik&7 pro získání výzkumů předchozího vlastníka");
    public static final SlimefunItemStack HARDENED_GLASS = new SlimefunItemStack(
            "HARDENED_GLASS", Material.LIGHT_GRAY_STAINED_GLASS, "&7Tvrzené sklo", "", "&rOdolává explozím");
    public static final SlimefunItemStack WITHER_PROOF_OBSIDIAN = new SlimefunItemStack(
            "WITHER_PROOF_OBSIDIAN",
            Material.OBSIDIAN,
            "&5Wither-proof obsidián",
            "",
            "&rOdolává explozím a",
            "&rútokům withera");
    public static final SlimefunItemStack WITHER_PROOF_GLASS = new SlimefunItemStack(
            "WITHER_PROOF_GLASS",
            Material.PURPLE_STAINED_GLASS,
            "&5Wither-proof sklo",
            "",
            "&rOdolává explozím a",
            "&rútokům withera");
    public static final SlimefunItemStack REINFORCED_PLATE =
            new SlimefunItemStack("REINFORCED_PLATE", Material.PAPER, "&7Vyztužený plát");
    public static final SlimefunItemStack ANCIENT_PEDESTAL = new SlimefunItemStack(
            "ANCIENT_PEDESTAL", Material.DISPENSER, "&dStarověký podstavec", "", "&5Součást starověkého oltáře");
    public static final SlimefunItemStack ANCIENT_ALTAR = new SlimefunItemStack(
            "ANCIENT_ALTAR",
            Material.ENCHANTING_TABLE,
            "&dStarověký oltář",
            "",
            "&5Postav oltář ve světě",
            "&5a použij starověký rituál");
    public static final SlimefunItemStack COPPER_WIRE = new SlimefunItemStack(
            "COPPER_WIRE", Material.STRING, "&6Měděný drát", "", "&6Důležitá součást elektroniky");
    public static final SlimefunItemStack CRAFTING_MOTOR = new SlimefunItemStack(
            "CRAFTING_MOTOR",
            HeadTexture.CRAFTING_MOTOR,
            "&6Motor pro crafting",
            "",
            "&7Důležitá součást auto craftingu");

    public static final SlimefunItemStack RAINBOW_WOOL =
            new SlimefunItemStack("RAINBOW_WOOL", Material.WHITE_WOOL, "&5Duhová vlna", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_GLASS = new SlimefunItemStack(
            "RAINBOW_GLASS", Material.WHITE_STAINED_GLASS, "&5Duhové sklo", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_CLAY = new SlimefunItemStack(
            "RAINBOW_CLAY", Material.WHITE_TERRACOTTA, "&5Duhový terakotový blok", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_GLASS_PANE = new SlimefunItemStack(
            "RAINBOW_GLASS_PANE",
            Material.WHITE_STAINED_GLASS_PANE,
            "&5Duhová skleněná tabule",
            "",
            LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_CONCRETE = new SlimefunItemStack(
            "RAINBOW_CONCRETE", Material.WHITE_CONCRETE, "&5Duhový beton", "", LoreBuilder.RAINBOW);
    public static final SlimefunItemStack RAINBOW_GLAZED_TERRACOTTA = new SlimefunItemStack(
            "RAINBOW_GLAZED_TERRACOTTA",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&5Duhová glazovaná terakota",
            "",
            LoreBuilder.RAINBOW);

    private static final String CHRISTMAS = ChatUtils.christmas("< Vánoční edice >");

    public static final SlimefunItemStack RAINBOW_WOOL_XMAS =
            new SlimefunItemStack("RAINBOW_WOOL_XMAS", Material.WHITE_WOOL, "&5Duhová vlna &7(Vánoční)", "", CHRISTMAS);
    public static final SlimefunItemStack RAINBOW_GLASS_XMAS = new SlimefunItemStack(
            "RAINBOW_GLASS_XMAS", Material.WHITE_STAINED_GLASS, "&5Duhové sklo &7(Vánoční)", "", CHRISTMAS);
    public static final SlimefunItemStack RAINBOW_CLAY_XMAS = new SlimefunItemStack(
            "RAINBOW_CLAY_XMAS", Material.WHITE_TERRACOTTA, "&5Duhový terakotový blok &7(Vánoční)", "", CHRISTMAS);
    public static final SlimefunItemStack RAINBOW_GLASS_PANE_XMAS = new SlimefunItemStack(
            "RAINBOW_GLASS_PANE_XMAS",
            Material.WHITE_STAINED_GLASS_PANE,
            "&5Duhová skleněná tabule &7(Vánoční)",
            "",
            CHRISTMAS);
    public static final SlimefunItemStack RAINBOW_CONCRETE_XMAS = new SlimefunItemStack(
            "RAINBOW_CONCRETE_XMAS", Material.WHITE_CONCRETE, "&5Duhový beton &7(Vánoční)", "", CHRISTMAS);
    public static final SlimefunItemStack RAINBOW_GLAZED_TERRACOTTA_XMAS = new SlimefunItemStack(
            "RAINBOW_GLAZED_TERRACOTTA_XMAS",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&5Duhová glazovaná terakota &7(Vánoční)",
            "",
            CHRISTMAS);

    private static final String VALENTINES_DAY = "&d< Valentýnská edice >";

    public static final SlimefunItemStack RAINBOW_WOOL_VALENTINE = new SlimefunItemStack(
            "RAINBOW_WOOL_VALENTINE", Material.PINK_WOOL, "&5Duhová vlna &7(Valentýn)", "", VALENTINES_DAY);
    public static final SlimefunItemStack RAINBOW_GLASS_VALENTINE = new SlimefunItemStack(
            "RAINBOW_GLASS_VALENTINE", Material.PINK_STAINED_GLASS, "&5Duhové sklo &7(Valentýn)", "", VALENTINES_DAY);
    public static final SlimefunItemStack RAINBOW_CLAY_VALENTINE = new SlimefunItemStack(
            "RAINBOW_CLAY_VALENTINE",
            Material.PINK_TERRACOTTA,
            "&5Duhový terakotový blok &7(Valentýn)",
            "",
            VALENTINES_DAY);
    public static final SlimefunItemStack RAINBOW_GLASS_PANE_VALENTINE = new SlimefunItemStack(
            "RAINBOW_GLASS_PANE_VALENTINE",
            Material.PINK_STAINED_GLASS_PANE,
            "&5Duhová skleněná tabule &7(Valentýn)",
            "",
            VALENTINES_DAY);
    public static final SlimefunItemStack RAINBOW_CONCRETE_VALENTINE = new SlimefunItemStack(
            "RAINBOW_CONCRETE_VALENTINE", Material.PINK_CONCRETE, "&5Duhový beton &7(Valentýn)", "", VALENTINES_DAY);
    public static final SlimefunItemStack RAINBOW_GLAZED_TERRACOTTA_VALENTINE = new SlimefunItemStack(
            "RAINBOW_GLAZED_TERRACOTTA_VALENTINE",
            Material.PINK_GLAZED_TERRACOTTA,
            "&5Duhová glazovaná terakota &7(Valentýn)",
            "",
            VALENTINES_DAY);

    private static final String HALLOWEEN = "&6< Halloweenská edice >";

    public static final SlimefunItemStack RAINBOW_WOOL_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_WOOL_HALLOWEEN", Material.ORANGE_WOOL, "&5Duhová vlna &7(Halloween)", "", HALLOWEEN);
    public static final SlimefunItemStack RAINBOW_GLASS_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_GLASS_HALLOWEEN", Material.ORANGE_STAINED_GLASS, "&5Duhové sklo &7(Halloween)", "", HALLOWEEN);
    public static final SlimefunItemStack RAINBOW_CLAY_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_CLAY_HALLOWEEN",
            Material.ORANGE_TERRACOTTA,
            "&5Duhový terakotový blok &7(Halloween)",
            "",
            HALLOWEEN);
    public static final SlimefunItemStack RAINBOW_GLASS_PANE_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_GLASS_PANE_HALLOWEEN",
            Material.ORANGE_STAINED_GLASS_PANE,
            "&5Duhová skleněná tabule &7(Halloween)",
            "",
            HALLOWEEN);
    public static final SlimefunItemStack RAINBOW_CONCRETE_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_CONCRETE_HALLOWEEN", Material.ORANGE_CONCRETE, "&5Duhový beton &7(Halloween)", "", HALLOWEEN);
    public static final SlimefunItemStack RAINBOW_GLAZED_TERRACOTTA_HALLOWEEN = new SlimefunItemStack(
            "RAINBOW_GLAZED_TERRACOTTA_HALLOWEEN",
            Material.ORANGE_GLAZED_TERRACOTTA,
            "&5Duhová glazovaná terakota &7(Halloween)",
            "",
            HALLOWEEN);

    /*		Ingots 		*/
    public static final SlimefunItemStack COPPER_INGOT =
            new SlimefunItemStack("COPPER_INGOT", Material.BRICK, "&bMěděný ingot");
    public static final SlimefunItemStack TIN_INGOT =
            new SlimefunItemStack("TIN_INGOT", Material.IRON_INGOT, "&bCínový ingot");
    public static final SlimefunItemStack SILVER_INGOT =
            new SlimefunItemStack("SILVER_INGOT", Material.IRON_INGOT, "&bStříbrný ingot");
    public static final SlimefunItemStack ALUMINUM_INGOT =
            new SlimefunItemStack("ALUMINUM_INGOT", Material.IRON_INGOT, "&bHliníkový ingot");
    public static final SlimefunItemStack LEAD_INGOT =
            new SlimefunItemStack("LEAD_INGOT", Material.IRON_INGOT, "&bOlovo ingot");
    public static final SlimefunItemStack ZINC_INGOT =
            new SlimefunItemStack("ZINC_INGOT", Material.IRON_INGOT, "&bZinkový ingot");
    public static final SlimefunItemStack MAGNESIUM_INGOT =
            new SlimefunItemStack("MAGNESIUM_INGOT", Material.IRON_INGOT, "&bHořčíkový ingot");

    /*		Alloy (Carbon + Iron)	*/
    public static final SlimefunItemStack STEEL_INGOT =
            new SlimefunItemStack("STEEL_INGOT", Material.IRON_INGOT, "&bOcelový ingot");
    /*		Alloy (Copper + Tin)	*/
    public static final SlimefunItemStack BRONZE_INGOT =
            new SlimefunItemStack("BRONZE_INGOT", Material.BRICK, "&bBronzový ingot");
    /*		Alloy (Copper + Aluminum)	*/
    public static final SlimefunItemStack DURALUMIN_INGOT =
            new SlimefunItemStack("DURALUMIN_INGOT", Material.IRON_INGOT, "&bDuraluminový ingot");
    /*		Alloy (Copper + Silver)	*/
    public static final SlimefunItemStack BILLON_INGOT =
            new SlimefunItemStack("BILLON_INGOT", Material.IRON_INGOT, "&bBillon ingot");
    /*		Alloy (Copper + Zinc)	*/
    public static final SlimefunItemStack BRASS_INGOT =
            new SlimefunItemStack("BRASS_INGOT", Material.GOLD_INGOT, "&bMosazný ingot");
    /*		Alloy (Aluminum + Brass)	*/
    public static final SlimefunItemStack ALUMINUM_BRASS_INGOT =
            new SlimefunItemStack("ALUMINUM_BRASS_INGOT", Material.GOLD_INGOT, "&bHliníko-mosazný ingot");
    /*		Alloy (Aluminum + Bronze)	*/
    public static final SlimefunItemStack ALUMINUM_BRONZE_INGOT =
            new SlimefunItemStack("ALUMINUM_BRONZE_INGOT", Material.GOLD_INGOT, "&bHliníko-bronzový ingot");
    /*		Alloy (Gold + Silver + Copper)	*/
    public static final SlimefunItemStack CORINTHIAN_BRONZE_INGOT =
            new SlimefunItemStack("CORINTHIAN_BRONZE_INGOT", Material.GOLD_INGOT, "&bKorintský bronzový ingot");
    /*		Alloy (Lead + Tin)	*/
    public static final SlimefunItemStack SOLDER_INGOT =
            new SlimefunItemStack("SOLDER_INGOT", Material.IRON_INGOT, "&bPájkový ingot");
    /*		Alloy (Steel + Iron + Carbon)	*/
    public static final SlimefunItemStack DAMASCUS_STEEL_INGOT =
            new SlimefunItemStack("DAMASCUS_STEEL_INGOT", Material.IRON_INGOT, "&bDamascénský ocelový ingot");
    /*		Alloy (Damascus Steel + Duralumin + Compressed Carbon + Aluminium Bronze)	*/
    public static final SlimefunItemStack HARDENED_METAL_INGOT =
            new SlimefunItemStack("HARDENED_METAL_INGOT", Material.IRON_INGOT, "&b&lTvrdý kov");
    /*		Alloy (Hardened Metal + Corinthian Bronze + Solder + Billon + Damascus Steel)	*/
    public static final SlimefunItemStack REINFORCED_ALLOY_INGOT =
            new SlimefunItemStack("REINFORCED_ALLOY_INGOT", Material.IRON_INGOT, "&b&lVyztužený slitinový ingot");
    /*		Alloy (Iron + Silicon)		*/
    public static final SlimefunItemStack FERROSILICON =
            new SlimefunItemStack("FERROSILICON", Material.IRON_INGOT, "&bFerrosilikon");
    /*		Alloy (Iron + Gold)			*/
    public static final SlimefunItemStack GILDED_IRON =
            new SlimefunItemStack("GILDED_IRON", Material.GOLD_INGOT, "&6&lPozlacený železný ingot");
    /*		Alloy (Redstone + Ferrosilicon)	*/
    public static final SlimefunItemStack REDSTONE_ALLOY =
            new SlimefunItemStack("REDSTONE_ALLOY", Material.BRICK, "&cRedstone slitina");
    /*		Alloy (Iron + Copper)		*/
    public static final SlimefunItemStack NICKEL_INGOT =
            new SlimefunItemStack("NICKEL_INGOT", Material.IRON_INGOT, "&bNiklový ingot");
    /*		Alloy (Nickel + Iron + Copper)		*/
    public static final SlimefunItemStack COBALT_INGOT =
            new SlimefunItemStack("COBALT_INGOT", Material.IRON_INGOT, "&9Kobaltový ingot");

    /*		Gold		*/
    public static final SlimefunItemStack GOLD_4K =
            new SlimefunItemStack("GOLD_4K", Material.GOLD_INGOT, "&rZlatý ingot &7(4 karátů)");
    public static final SlimefunItemStack GOLD_6K =
            new SlimefunItemStack("GOLD_6K", Material.GOLD_INGOT, "&rZlatý ingot &7(6 karátů)");
    public static final SlimefunItemStack GOLD_8K =
            new SlimefunItemStack("GOLD_8K", Material.GOLD_INGOT, "&rZlatý ingot &7(8 karátů)");
    public static final SlimefunItemStack GOLD_10K =
            new SlimefunItemStack("GOLD_10K", Material.GOLD_INGOT, "&rZlatý ingot &7(10 karátů)");
    public static final SlimefunItemStack GOLD_12K =
            new SlimefunItemStack("GOLD_12K", Material.GOLD_INGOT, "&rZlatý ingot &7(12 karátů)");
    public static final SlimefunItemStack GOLD_14K =
            new SlimefunItemStack("GOLD_14K", Material.GOLD_INGOT, "&rZlatý ingot &7(14 karátů)");
    public static final SlimefunItemStack GOLD_16K =
            new SlimefunItemStack("GOLD_16K", Material.GOLD_INGOT, "&rZlatý ingot &7(16 karátů)");
    public static final SlimefunItemStack GOLD_18K =
            new SlimefunItemStack("GOLD_18K", Material.GOLD_INGOT, "&rZlatý ingot &7(18 karátů)");
    public static final SlimefunItemStack GOLD_20K =
            new SlimefunItemStack("GOLD_20K", Material.GOLD_INGOT, "&rZlatý ingot &7(20 karátů)");
    public static final SlimefunItemStack GOLD_22K =
            new SlimefunItemStack("GOLD_22K", Material.GOLD_INGOT, "&rZlatý ingot &7(22 karátů)");
    public static final SlimefunItemStack GOLD_24K =
            new SlimefunItemStack("GOLD_24K", Material.GOLD_INGOT, "&rZlatý ingot &7(24 karátů)");

    /*		 Dusts 		*/
    public static final SlimefunItemStack IRON_DUST =
            new SlimefunItemStack("IRON_DUST", Material.GUNPOWDER, "&6Železný prach");
    public static final SlimefunItemStack GOLD_DUST =
            new SlimefunItemStack("GOLD_DUST", Material.GLOWSTONE_DUST, "&6Zlatý prach");
    public static final SlimefunItemStack TIN_DUST =
            new SlimefunItemStack("TIN_DUST", Material.SUGAR, "&6Cínový prach");
    public static final SlimefunItemStack COPPER_DUST =
            new SlimefunItemStack("COPPER_DUST", Material.GLOWSTONE_DUST, "&6Měděný prach");
    public static final SlimefunItemStack SILVER_DUST =
            new SlimefunItemStack("SILVER_DUST", Material.SUGAR, "&6Stříbrný prach");
    public static final SlimefunItemStack ALUMINUM_DUST =
            new SlimefunItemStack("ALUMINUM_DUST", Material.SUGAR, "&6Hliníkový prach");
    public static final SlimefunItemStack LEAD_DUST =
            new SlimefunItemStack("LEAD_DUST", Material.GUNPOWDER, "&6Olověný prach");
    public static final SlimefunItemStack SULFATE =
            new SlimefunItemStack("SULFATE", Material.GLOWSTONE_DUST, "&6Síran");
    public static final SlimefunItemStack ZINC_DUST =
            new SlimefunItemStack("ZINC_DUST", Material.SUGAR, "&6Zinkový prach");
    public static final SlimefunItemStack MAGNESIUM_DUST =
            new SlimefunItemStack("MAGNESIUM_DUST", Material.SUGAR, "&6Hořčíkový prach");
    public static final SlimefunItemStack SILICON =
            new SlimefunItemStack("SILICON", Material.FIREWORK_STAR, "&6Křemík");
    public static final SlimefunItemStack GOLD_24K_BLOCK =
            new SlimefunItemStack("GOLD_24K_BLOCK", Material.GOLD_BLOCK, "&r&rZlatý blok &7(24 karátů)");

    /*		 Gems 		*/
    public static final SlimefunItemStack SYNTHETIC_DIAMOND = new SlimefunItemStack(
            "SYNTHETIC_DIAMOND", Material.DIAMOND, "&bUmělý diamant", "", "&rLze použít jako diamant v crafting table");
    public static final SlimefunItemStack SYNTHETIC_EMERALD = new SlimefunItemStack(
            "SYNTHETIC_EMERALD", Material.EMERALD, "&bUmělý smaragd", "", "&rLze použít k obchodování s vesničany");
    public static final SlimefunItemStack SYNTHETIC_SAPPHIRE = new SlimefunItemStack(
            "SYNTHETIC_SAPPHIRE", HeadTexture.SAPPHIRE, "&bUmělý safír", "", "&rLze použít jako lapis lazuli");
    public static final SlimefunItemStack CARBONADO =
            new SlimefunItemStack("CARBONADO", HeadTexture.CARBONADO, "&b&lCarbonado", "", "&7&o\"Černý diamant\"");
    public static final SlimefunItemStack RAW_CARBONADO =
            new SlimefunItemStack("RAW_CARBONADO", HeadTexture.RAW_CARBONADO, "&bSurový carbonado");

    public static final SlimefunItemStack URANIUM = new SlimefunItemStack(
            "URANIUM",
            HeadTexture.URANIUM,
            "&4Uran",
            "",
            LoreBuilder.radioactive(Radioactivity.HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack NEPTUNIUM = new SlimefunItemStack(
            "NEPTUNIUM",
            HeadTexture.NEPTUNIUM,
            "&aNeptunium",
            "",
            LoreBuilder.radioactive(Radioactivity.HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack PLUTONIUM = new SlimefunItemStack(
            "PLUTONIUM",
            HeadTexture.PLUTONIUM,
            "&7Plutonium",
            "",
            LoreBuilder.radioactive(Radioactivity.VERY_HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack BOOSTED_URANIUM = new SlimefunItemStack(
            "BOOSTED_URANIUM",
            HeadTexture.BOOSTED_URANIUM,
            "&2Smíšené oxidové jaderné palivo",
            "",
            LoreBuilder.radioactive(Radioactivity.VERY_HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);

    /*		Talisman		*/
    public static final SlimefunItemStack COMMON_TALISMAN =
            new SlimefunItemStack("COMMON_TALISMAN", Material.EMERALD, "&6Obyčejný talisman");
    public static final SlimefunItemStack ENDER_TALISMAN =
            new SlimefunItemStack("ENDER_TALISMAN", Material.EMERALD, "&5Ender talisman");

    public static final SlimefunItemStack TALISMAN_ANVIL = new SlimefunItemStack(
            "ANVIL_TALISMAN",
            Material.EMERALD,
            "&aTalisman kovadliny",
            "",
            "&fKaždý talisman zabrání",
            "&fjednomu nástroji zničení kvůli nízké trvanlivosti",
            "&fa pak se spotřebuje",
            "",
            "&4&lVarování:",
            "&4Kvůli složitosti velmi silných nástrojů",
            "&4tento talisman nemůže opravit příliš silné nástroje");
    public static final SlimefunItemStack TALISMAN_MINER = new SlimefunItemStack(
            "MINER_TALISMAN",
            Material.EMERALD,
            "&aHorníkův talisman",
            "",
            "&fKdyž je v inventáři",
            "&f20% šance na dvojnásobný drop",
            "&frud");
    public static final SlimefunItemStack TALISMAN_FARMER = new SlimefunItemStack(
            "FARMER_TALISMAN",
            Material.EMERALD,
            "&aFarmářův talisman",
            "",
            "&fKdyž je v inventáři",
            "&f20% šance na dvojnásobný drop",
            "&fplodin");
    public static final SlimefunItemStack TALISMAN_HUNTER = new SlimefunItemStack(
            "HUNTER_TALISMAN",
            Material.EMERALD,
            "&aLovcův talisman",
            "",
            "&fKdyž je v inventáři",
            "&f20% šance na dvojnásobný drop",
            "&fzvířat");
    public static final SlimefunItemStack TALISMAN_LAVA = new SlimefunItemStack(
            "LAVA_TALISMAN",
            Material.EMERALD,
            "&aTalisman chůze po lávě",
            "",
            "&fKdyž je v inventáři",
            "&fposkytne ochranu proti ohni",
            "&fpouze při chůzi po lávě",
            "&fa pak se spotřebuje");
    public static final SlimefunItemStack TALISMAN_WATER = new SlimefunItemStack(
            "WATER_TALISMAN",
            Material.EMERALD,
            "&aTalisman potápěče",
            "",
            "&fKdyž je v inventáři",
            "&fpři blížícím se utonutí",
            "&fposkytne dýchání pod vodou",
            "&fa pak se spotřebuje");
    public static final SlimefunItemStack TALISMAN_ANGEL = new SlimefunItemStack(
            "ANGEL_TALISMAN",
            Material.EMERALD,
            "&aAndělský talisman",
            "",
            "&fKdyž je v inventáři",
            "&f75% šance snížit pádové poškození");
    public static final SlimefunItemStack TALISMAN_FIRE = new SlimefunItemStack(
            "FIRE_TALISMAN",
            Material.EMERALD,
            "&aPožární talisman",
            "",
            "&fKdyž je v inventáři",
            "&fpři hoření",
            "&fposkytne ochranu proti ohni",
            "&fa pak se spotřebuje");
    public static final SlimefunItemStack TALISMAN_MAGICIAN = new SlimefunItemStack(
            "MAGICIAN_TALISMAN",
            Material.EMERALD,
            "&aKouzelníkův talisman",
            "",
            "&fKdyž je v inventáři",
            "&f80% šance při enchantování",
            "&fna extra enchant");
    public static final SlimefunItemStack TALISMAN_TRAVELLER = new SlimefunItemStack(
            "TRAVELLER_TALISMAN",
            Material.EMERALD,
            "&aCestovatelův talisman",
            "",
            "&fKdyž je v inventáři",
            "&f60% šance při sprintu",
            "&fposkytne efekt rychlosti");
    public static final SlimefunItemStack TALISMAN_WARRIOR = new SlimefunItemStack(
            "WARRIOR_TALISMAN",
            Material.EMERALD,
            "&aVálečníkův talisman",
            "",
            "&fKdyž je v inventáři",
            "&fpo zásahu získáš sílu 3",
            "&fa pak se spotřebuje");
    public static final SlimefunItemStack TALISMAN_KNIGHT = new SlimefunItemStack(
            "KNIGHT_TALISMAN",
            Material.EMERALD,
            "&aRytířský talisman",
            "",
            "&fKdyž je v inventáři",
            "&f30% šance na 5 sekund regenerace",
            "&fpo zásahu",
            "&fa pak se spotřebuje");
    public static final SlimefunItemStack TALISMAN_WHIRLWIND = new SlimefunItemStack(
            "WHIRLWIND_TALISMAN",
            Material.EMERALD,
            "&aVířivý talisman",
            "",
            "&fKdyž je v inventáři",
            "&f60% šance",
            "&fodrazit všechny střely");
    public static final SlimefunItemStack TALISMAN_WIZARD = new SlimefunItemStack(
            "WIZARD_TALISMAN",
            Material.EMERALD,
            "&aČarodějův talisman",
            "",
            "&fKdyž je v inventáři",
            "&fposkytne štěstí 4/5 při enchantování",
            "&fale může snížit úroveň",
            "&jiných enchantů");
    public static final SlimefunItemStack TALISMAN_CAVEMAN = new SlimefunItemStack(
            "CAVEMAN_TALISMAN",
            Material.EMERALD,
            "&aJeskynní talisman",
            "",
            "&fKdyž je v inventáři",
            "&f50% šance při těžbě",
            "&fna efekt urychlení");
    public static final SlimefunItemStack TALISMAN_WISE = new SlimefunItemStack(
            "WISE_TALISMAN",
            Material.EMERALD,
            "&aMoudrý talisman",
            "",
            "&fKdyž je v inventáři",
            "&f20% šance zdvojnásobit získané zkušenosti");

    /*		Staves		*/
    public static final SlimefunItemStack STAFF_ELEMENTAL =
            new SlimefunItemStack("STAFF_ELEMENTAL", Material.STICK, "&6Elementální hůl");
    public static final SlimefunItemStack STAFF_WIND = new SlimefunItemStack(
            "STAFF_ELEMENTAL_WIND",
            Material.STICK,
            "&6Elementální hůl &7- &b&oVítr",
            "",
            "&7Element: &b&oVítr",
            "",
            "&7&ePravý klik&7 pro odhození sebe");
    public static final SlimefunItemStack STAFF_FIRE = new SlimefunItemStack(
            "STAFF_ELEMENTAL_FIRE",
            Material.STICK,
            "&6Elementální hůl &7- &c&oOheň",
            "",
            "&7Element: &c&oOheň",
            "",
            "&cNechť oheň očistí vše!");
    public static final SlimefunItemStack STAFF_WATER = new SlimefunItemStack(
            "STAFF_ELEMENTAL_WATER",
            Material.STICK,
            "&6Elementální hůl &7- &1&oVoda",
            "",
            "&7Element: &1&oVoda",
            "",
            "&7&ePravý klik&7 pro uhašení ohně");
    public static final SlimefunItemStack STAFF_STORM = new SlimefunItemStack(
            "STAFF_ELEMENTAL_STORM",
            Material.STICK,
            "&6Elementální hůl &7- &8&oBouře",
            "",
            "&7Element: &8&oBouře",
            "",
            "&ePravý klik&7 pro vyvolání blesku",
            LoreBuilder.usesLeft(StormStaff.MAX_USES));

    static {
        STAFF_WIND.addUnsafeEnchantment(VersionedEnchantment.LUCK_OF_THE_SEA, 1);
        STAFF_FIRE.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
        STAFF_WATER.addUnsafeEnchantment(VersionedEnchantment.AQUA_AFFINITY, 1);
        STAFF_STORM.addUnsafeEnchantment(VersionedEnchantment.UNBREAKING, 1);
    }

    /*		 Machines 		*/
    public static final SlimefunItemStack GRIND_STONE =
            new SlimefunItemStack("GRIND_STONE", Material.DISPENSER, "&bBrusný kámen", "", "&a&oEfektivnější broušení");
    public static final SlimefunItemStack ARMOR_FORGE = new SlimefunItemStack(
            "ARMOR_FORGE", Material.ANVIL, "&6Kovárna zbroje", "", "&a&oDává sílu k vytváření silné zbroje");
    public static final SlimefunItemStack MAKESHIFT_SMELTERY = new SlimefunItemStack(
            "MAKESHIFT_SMELTERY",
            Material.BLAST_FURNACE,
            "&eProvizorní tavicí pec",
            "",
            "&rZjednodušená tavicí pec",
            "&rPouze taví rudný prach na ingoty");
    public static final SlimefunItemStack SMELTERY = new SlimefunItemStack(
            "SMELTERY", Material.FURNACE, "&6Tavicí pec", "", "&aVysokoteplotní pec pro tavení kovů");
    public static final SlimefunItemStack IGNITION_CHAMBER = new SlimefunItemStack(
            "IGNITION_CHAMBER",
            Material.DROPPER,
            "&4Automatický zapalovač",
            "&rPro případ zhasnutí tavicí pece",
            "&rVlož flint and steel",
            "&rdo dropperu vedle pece");
    public static final SlimefunItemStack ORE_CRUSHER = new SlimefunItemStack(
            "ORE_CRUSHER", Material.DISPENSER, "&bDrtič rud", "", "&a&oDrti rudy a dává dvojnásobek prachu");
    public static final SlimefunItemStack COMPRESSOR =
            new SlimefunItemStack("COMPRESSOR", Material.PISTON, "&bKompresor", "", "&aKomprimuje předměty");
    public static final SlimefunItemStack PRESSURE_CHAMBER = new SlimefunItemStack(
            "PRESSURE_CHAMBER", Material.GLASS, "&bTlakový kompresor", "", "&aKomprimuje více předmětů");
    public static final SlimefunItemStack MAGIC_WORKBENCH = new SlimefunItemStack(
            "MAGIC_WORKBENCH",
            Material.CRAFTING_TABLE,
            "&6Magický pracovní stůl",
            "",
            "&dVkládá magickou energii do předmětů");
    public static final SlimefunItemStack ORE_WASHER = new SlimefunItemStack(
            "ORE_WASHER", Material.CAULDRON, "&6Pračka rud", "", "&a&oČistí prosátou rudu", "&a&odává malé kamínky");
    public static final SlimefunItemStack TABLE_SAW = new SlimefunItemStack(
            "TABLE_SAW",
            Material.STONECUTTER,
            "&6Stolní pila",
            "",
            "&a&oZ 1 dřeva získáš 8 prken",
            "&a&o(podporuje všechny kmeny)");
    public static final SlimefunItemStack COMPOSTER = new SlimefunItemStack(
            "COMPOSTER", Material.CAULDRON, "&aKompostér", "", "&a&oPostupně přeměňuje materiály...");
    public static final SlimefunItemStack ENHANCED_CRAFTING_TABLE = new SlimefunItemStack(
            "ENHANCED_CRAFTING_TABLE",
            Material.CRAFTING_TABLE,
            "&eVylepšený pracovní stůl",
            "",
            "&a&oZákladní pracovní stůl",
            "&a&onevydrží silné síly...");
    public static final SlimefunItemStack CRUCIBLE = new SlimefunItemStack(
            "CRUCIBLE", Material.CAULDRON, "&cTygel", "", "&a&oSlouží k přeměně předmětů na tekutinu");
    public static final SlimefunItemStack JUICER =
            new SlimefunItemStack("JUICER", Material.GLASS_BOTTLE, "&aOdšťavňovač", "", "&aVytváří lahodné džusy");

    public static final SlimefunItemStack INDUSTRIAL_MINER = new SlimefunItemStack(
            "INDUSTRIAL_MINER",
            Material.GOLDEN_PICKAXE,
            "&bPrůmyslový těžař",
            "",
            "&rTěží všechny rudy v 7x7 oblasti pod sebou.",
            "&rVlož uhlí nebo palivo do truhly.");
    public static final SlimefunItemStack ADVANCED_INDUSTRIAL_MINER = new SlimefunItemStack(
            "ADVANCED_INDUSTRIAL_MINER",
            Material.DIAMOND_PICKAXE,
            "&cPokročilý průmyslový těžař",
            "",
            "&rTěží všechny rudy v 11x11 oblasti pod sebou.",
            "&rVlož palivo nebo lávu do truhly.",
            "",
            "&a+ Silk Touch");

    static {
        ItemMeta meta = INDUSTRIAL_MINER.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        INDUSTRIAL_MINER.setItemMeta(meta);

        ItemMeta meta2 = ADVANCED_INDUSTRIAL_MINER.getItemMeta();
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ADVANCED_INDUSTRIAL_MINER.setItemMeta(meta2);
    }

    public static final SlimefunItemStack SOLAR_PANEL = new SlimefunItemStack(
            "SOLAR_PANEL",
            Material.DAYLIGHT_DETECTOR,
            "&bSolární panel",
            "",
            "&7Důležitá součást &bSolárního generátoru");

    public static final SlimefunItemStack AUTOMATED_PANNING_MACHINE = new SlimefunItemStack(
            "AUTOMATED_PANNING_MACHINE", Material.BOWL, "&aAutomatická zlatá pánev", "", "&a&oVylepšená zlatá pánev");
    public static final SlimefunItemStack OUTPUT_CHEST = new SlimefunItemStack(
            "OUTPUT_CHEST",
            Material.CHEST,
            "&4Výstupní truhla",
            "",
            "&c&oUmísti vedle výstupu stroje",
            "&c&ovýstup půjde do truhly");
    public static final SlimefunItemStack HOLOGRAM_PROJECTOR = new SlimefunItemStack(
            "HOLOGRAM_PROJECTOR",
            Material.QUARTZ_SLAB,
            "&bHolografický projektor",
            "",
            "&rProjektuje upravitelný holografický text");

    /*		 Enhanced Furnaces 		*/
    public static final SlimefunItemStack ENHANCED_FURNACE = new SlimefunItemStack(
            "ENHANCED_FURNACE",
            Material.FURNACE,
            "&7Vylepšená pec - &eI",
            "",
            "&7Rychlost spalování: &e1x",
            "&7Účinnost paliva: &e1x",
            "&7Násobič výstupu: &e1x");
    public static final SlimefunItemStack ENHANCED_FURNACE_2 = new SlimefunItemStack(
            "ENHANCED_FURNACE_2",
            Material.FURNACE,
            "&7Vylepšená pec - &eII",
            "",
            "&7Rychlost spalování: &e2x",
            "&7Účinnost paliva: &e1x",
            "&7Násobič výstupu: &e1x");
    public static final SlimefunItemStack ENHANCED_FURNACE_3 = new SlimefunItemStack(
            "ENHANCED_FURNACE_3",
            Material.FURNACE,
            "&7Vylepšená pec - &eIII",
            "",
            "&7Rychlost spalování: &e2x",
            "&7Účinnost paliva: &e2x",
            "&7Násobič výstupu: &e1x");
    public static final SlimefunItemStack ENHANCED_FURNACE_4 = new SlimefunItemStack(
            "ENHANCED_FURNACE_4",
            Material.FURNACE,
            "&7Vylepšená pec - &eIV",
            "",
            "&7Rychlost spalování: &e3x",
            "&7Účinnost paliva: &e2x",
            "&7Násobič výstupu: &e1x");
    public static final SlimefunItemStack ENHANCED_FURNACE_5 = new SlimefunItemStack(
            "ENHANCED_FURNACE_5",
            Material.FURNACE,
            "&7Vylepšená pec - &eV",
            "",
            "&7Rychlost spalování: &e3x",
            "&7Účinnost paliva: &e2x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_6 = new SlimefunItemStack(
            "ENHANCED_FURNACE_6",
            Material.FURNACE,
            "&7Vylepšená pec - &eVI",
            "",
            "&7Rychlost spalování: &e3x",
            "&7Účinnost paliva: &e3x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_7 = new SlimefunItemStack(
            "ENHANCED_FURNACE_7",
            Material.FURNACE,
            "&7Vylepšená pec - &eVII",
            "",
            "&7Rychlost spalování: &e4x",
            "&7Účinnost paliva: &e3x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_8 = new SlimefunItemStack(
            "ENHANCED_FURNACE_8",
            Material.FURNACE,
            "&7Vylepšená pec - &eVIII",
            "",
            "&7Rychlost spalování: &e4x",
            "&7Účinnost paliva: &e4x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_9 = new SlimefunItemStack(
            "ENHANCED_FURNACE_9",
            Material.FURNACE,
            "&7Vylepšená pec - &eIX",
            "",
            "&7Rychlost spalování: &e5x",
            "&7Účinnost paliva: &e4x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_10 = new SlimefunItemStack(
            "ENHANCED_FURNACE_10",
            Material.FURNACE,
            "&7Vylepšená pec - &eX",
            "",
            "&7Rychlost spalování: &e5x",
            "&7Účinnost paliva: &e5x",
            "&7Násobič výstupu: &e2x");
    public static final SlimefunItemStack ENHANCED_FURNACE_11 = new SlimefunItemStack(
            "ENHANCED_FURNACE_11",
            Material.FURNACE,
            "&7Vylepšená pec - &eXI",
            "",
            "&7Rychlost spalování: &e5x",
            "&7Účinnost paliva: &e5x",
            "&7Násobič výstupu: &e3x");
    public static final SlimefunItemStack REINFORCED_FURNACE = new SlimefunItemStack(
            "REINFORCED_FURNACE",
            Material.FURNACE,
            "&7Vyztužená slitinová pec",
            "",
            "&7Rychlost spalování: &e10x",
            "&7Účinnost paliva: &e10x",
            "&7Násobič výstupu: &e3x");
    public static final SlimefunItemStack CARBONADO_EDGED_FURNACE = new SlimefunItemStack(
            "CARBONADO_EDGED_FURNACE",
            Material.FURNACE,
            "&7Pec s carbonado hranami",
            "",
            "&7Rychlost spalování: &e20x",
            "&7Účinnost paliva: &e10x",
            "&7Násobič výstupu: &e3x");

    public static final SlimefunItemStack BLOCK_PLACER = new SlimefunItemStack(
            "BLOCK_PLACER",
            Material.DISPENSER,
            "&aUmísťovač bloků",
            "",
            "&rVšechny bloky v tomto dropperu",
            "&rbudou automaticky umisťovány");

    /*		Soulbound Items		*/
    public static final SlimefunItemStack SOULBOUND_SWORD =
            new SlimefunItemStack("SOULBOUND_SWORD", Material.DIAMOND_SWORD, "&cDuší vázaný meč");
    public static final SlimefunItemStack SOULBOUND_BOW =
            new SlimefunItemStack("SOULBOUND_BOW", Material.BOW, "&cDuší vázaný luk");
    public static final SlimefunItemStack SOULBOUND_PICKAXE =
            new SlimefunItemStack("SOULBOUND_PICKAXE", Material.DIAMOND_PICKAXE, "&cDuší vázaný krumpáč");
    public static final SlimefunItemStack SOULBOUND_AXE =
            new SlimefunItemStack("SOULBOUND_AXE", Material.DIAMOND_AXE, "&cDuší vázaná sekera");
    public static final SlimefunItemStack SOULBOUND_SHOVEL =
            new SlimefunItemStack("SOULBOUND_SHOVEL", Material.DIAMOND_SHOVEL, "&cDuší vázaná lopata");
    public static final SlimefunItemStack SOULBOUND_HOE =
            new SlimefunItemStack("SOULBOUND_HOE", Material.DIAMOND_HOE, "&cDuší vázaná motyka");

    public static final SlimefunItemStack SOULBOUND_HELMET =
            new SlimefunItemStack("SOULBOUND_HELMET", Material.DIAMOND_HELMET, "&cDuší vázaná helma");
    public static final SlimefunItemStack SOULBOUND_CHESTPLATE =
            new SlimefunItemStack("SOULBOUND_CHESTPLATE", Material.DIAMOND_CHESTPLATE, "&cDuší vázaný hrudní plát");
    public static final SlimefunItemStack SOULBOUND_LEGGINGS =
            new SlimefunItemStack("SOULBOUND_LEGGINGS", Material.DIAMOND_LEGGINGS, "&cDuší vázané kalhoty");
    public static final SlimefunItemStack SOULBOUND_BOOTS =
            new SlimefunItemStack("SOULBOUND_BOOTS", Material.DIAMOND_BOOTS, "&cDuší vázané boty");
    public static final SlimefunItemStack SOULBOUND_TRIDENT =
            new SlimefunItemStack("SOULBOUND_TRIDENT", Material.TRIDENT, "&cDuší vázaný trojzubec");

    /* Runes */
    public static final SlimefunItemStack BLANK_RUNE =
            new SlimefunItemStack("BLANK_RUNE", new ColoredFireworkStar(Color.BLACK, "&8Prázdná runa"));

    public static final SlimefunItemStack AIR_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_AIR", new ColoredFireworkStar(Color.AQUA, "&7Starověká runa &8&l[&b&lVzduch&8&l]"));
    public static final SlimefunItemStack WATER_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_WATER", new ColoredFireworkStar(Color.BLUE, "&7Starověká runa &8&l[&1&lVoda&8&l]"));
    public static final SlimefunItemStack FIRE_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_FIRE", new ColoredFireworkStar(Color.RED, "&7Starověká runa &8&l[&4&lOheň&8&l]"));
    public static final SlimefunItemStack EARTH_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_EARTH",
            new ColoredFireworkStar(Color.fromRGB(112, 47, 7), "&7Starověká runa &8&l[&c&lZemě&8&l]"));
    public static final SlimefunItemStack ENDER_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_ENDER", new ColoredFireworkStar(Color.PURPLE, "&7Starověká runa &8&l[&5&lEnder&8&l]"));

    public static final SlimefunItemStack RAINBOW_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_RAINBOW", new ColoredFireworkStar(Color.FUCHSIA, "&7Starověká runa &8&l[&d&lDuhová&8&l]"));
    public static final SlimefunItemStack LIGHTNING_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_LIGHTNING",
            new ColoredFireworkStar(Color.fromRGB(255, 255, 95), "&7Starověká runa &8&l[&e&lBlesk&8&l]"));
    public static final SlimefunItemStack SOULBOUND_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_SOULBOUND",
            new ColoredFireworkStar(
                    Color.fromRGB(47, 0, 117),
                    "&7Starověká runa &8&l[&5&lDuše&8&l]",
                    "&eNejprve hoď předmět na zem",
                    "&ePak hoď runu na předmět",
                    "&5a předmět bude duší vázaný.",
                    " ",
                    "&eDoporučeno pro &6důležité &epředměty.",
                    " ",
                    "&ePo smrti se nevypadne."));
    public static final SlimefunItemStack ENCHANTMENT_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_ENCHANTMENT",
            new ColoredFireworkStar(
                    Color.fromRGB(255, 217, 25),
                    "&7Starověká runa &8&l[&6&lEnchant&8&l]",
                    "&eHoď runu na předmět,",
                    "&ekterý jsi hodil na zem",
                    "&epředmět získá náhodný enchant."));
    public static final SlimefunItemStack VILLAGER_RUNE = new SlimefunItemStack(
            "ANCIENT_RUNE_VILLAGERS",
            new ColoredFireworkStar(
                    Color.fromRGB(160, 20, 5),
                    "&7Starověká runa &8&l[&4&lVesničan&8&l]",
                    "&ePravý klik na vesničana",
                    "&esmaže jeho profesi a obchody.",
                    "&eVesničan si po chvíli",
                    "&enajde novou práci."));

    /*		Electricity			*/
    public static final SlimefunItemStack SOLAR_GENERATOR = new SlimefunItemStack(
            "SOLAR_GENERATOR",
            Material.DAYLIGHT_DETECTOR,
            "&bSolární generátor",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(0),
            LoreBuilder.powerPerSecond(4));
    public static final SlimefunItemStack SOLAR_GENERATOR_2 = new SlimefunItemStack(
            "SOLAR_GENERATOR_2",
            Material.DAYLIGHT_DETECTOR,
            "&cPokročilý solární generátor",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(0),
            LoreBuilder.powerPerSecond(16));
    public static final SlimefunItemStack SOLAR_GENERATOR_3 = new SlimefunItemStack(
            "SOLAR_GENERATOR_3",
            Material.DAYLIGHT_DETECTOR,
            "&4Carbonado solární generátor",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(0),
            LoreBuilder.powerPerSecond(64));
    public static final SlimefunItemStack SOLAR_GENERATOR_4 = new SlimefunItemStack(
            "SOLAR_GENERATOR_4",
            Material.DAYLIGHT_DETECTOR,
            "&eNabíjený solární generátor",
            "",
            "&9Funguje i v noci",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(0),
            LoreBuilder.powerPerSecond(256),
            " (den)",
            LoreBuilder.powerPerSecond(128),
            " (noc)");

    public static final SlimefunItemStack COAL_GENERATOR = new SlimefunItemStack(
            "COAL_GENERATOR",
            HeadTexture.GENERATOR,
            "&cUhelný generátor",
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(64),
            LoreBuilder.powerPerSecond(16));
    public static final SlimefunItemStack COAL_GENERATOR_2 = new SlimefunItemStack(
            "COAL_GENERATOR_2",
            HeadTexture.GENERATOR,
            "&cUhelný generátor &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(30));

    public static final SlimefunItemStack LAVA_GENERATOR = new SlimefunItemStack(
            "LAVA_GENERATOR",
            HeadTexture.GENERATOR,
            "&4Lávový generátor",
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(20));
    public static final SlimefunItemStack LAVA_GENERATOR_2 = new SlimefunItemStack(
            "LAVA_GENERATOR_2",
            HeadTexture.GENERATOR,
            "&4Lávový generátor &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(40));

    public static final SlimefunItemStack ELECTRIC_FURNACE = new SlimefunItemStack(
            "ELECTRIC_FURNACE",
            Material.FURNACE,
            "&cElektrická pec",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(4));
    public static final SlimefunItemStack ELECTRIC_FURNACE_2 = new SlimefunItemStack(
            "ELECTRIC_FURNACE_2",
            Material.FURNACE,
            "&cElektrická pec &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 2x",
            LoreBuilder.powerPerSecond(6));
    public static final SlimefunItemStack ELECTRIC_FURNACE_3 = new SlimefunItemStack(
            "ELECTRIC_FURNACE_3",
            Material.FURNACE,
            "&cElektrická pec &7- &eIII",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 4x",
            LoreBuilder.powerPerSecond(10));

    public static final SlimefunItemStack ELECTRIC_ORE_GRINDER = new SlimefunItemStack(
            "ELECTRIC_ORE_GRINDER",
            Material.FURNACE,
            "&cElektrický drtič rud",
            "",
            "&rKombinace drtiče a brusného kamene",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(12));
    public static final SlimefunItemStack ELECTRIC_ORE_GRINDER_2 = new SlimefunItemStack(
            "ELECTRIC_ORE_GRINDER_2",
            Material.FURNACE,
            "&cElektrický drtič rud &7(&eII&7)",
            "",
            "&rKombinace drtiče a brusného kamene",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 4x",
            LoreBuilder.powerPerSecond(30));
    public static final SlimefunItemStack ELECTRIC_ORE_GRINDER_3 = new SlimefunItemStack(
            "ELECTRIC_ORE_GRINDER_3",
            Material.FURNACE,
            "&cElektrický drtič rud &7(&eIII&7)",
            "",
            "&fKombinace drtiče a brusného kamene",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(10),
            LoreBuilder.powerPerSecond(90));
    public static final SlimefunItemStack ELECTRIC_INGOT_PULVERIZER = new SlimefunItemStack(
            "ELECTRIC_INGOT_PULVERIZER",
            Material.FURNACE,
            "&cElektrický drtič ingotů",
            "",
            "&rMění ingoty na prach",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(14));
    public static final SlimefunItemStack AUTO_DRIER = new SlimefunItemStack(
            "AUTO_DRIER",
            Material.SMOKER,
            "&eAutomatická sušička",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(10));
    public static final SlimefunItemStack AUTO_ENCHANTER = new SlimefunItemStack(
            "AUTO_ENCHANTER",
            Material.ENCHANTING_TABLE,
            "&5Automatický enchantér",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(18));
    public static final SlimefunItemStack AUTO_ENCHANTER_2 = new SlimefunItemStack(
            "AUTO_ENCHANTER_2",
            Material.ENCHANTING_TABLE,
            "&5Automatický enchantér &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(3),
            LoreBuilder.powerPerSecond(48));
    public static final SlimefunItemStack AUTO_DISENCHANTER = new SlimefunItemStack(
            "AUTO_DISENCHANTER",
            Material.ENCHANTING_TABLE,
            "&5Automatický odčarovač",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(18));
    public static final SlimefunItemStack AUTO_DISENCHANTER_2 = new SlimefunItemStack(
            "AUTO_DISENCHANTER_2",
            Material.ENCHANTING_TABLE,
            "&5Automatický odčarovač &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(3),
            LoreBuilder.powerPerSecond(48));
    public static final SlimefunItemStack AUTO_ANVIL = new SlimefunItemStack(
            "AUTO_ANVIL",
            Material.IRON_BLOCK,
            "&7Automatická kovadlina",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Oprava: 10%",
            LoreBuilder.powerPerSecond(24));
    public static final SlimefunItemStack AUTO_ANVIL_2 = new SlimefunItemStack(
            "AUTO_ANVIL_2",
            Material.IRON_BLOCK,
            "&7Automatická kovadlina Mk.II",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Oprava: 25%",
            LoreBuilder.powerPerSecond(32));
    public static final SlimefunItemStack AUTO_BREWER = new SlimefunItemStack(
            "AUTO_BREWER",
            Material.SMOKER,
            "&eAutomatický vařič lektvarů",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(12));

    public static final SlimefunItemStack BOOK_BINDER = new SlimefunItemStack(
            "BOOK_BINDER",
            Material.BOOKSHELF,
            "&6Spojovač enchantovaných knih",
            "",
            "&fSpojuje více enchantovaných knih do jedné.",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(16));

    public static final SlimefunItemStack BIO_REACTOR = new SlimefunItemStack(
            "BIO_REACTOR",
            Material.LIME_TERRACOTTA,
            "&2Bioreaktor",
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.GENERATOR),
            "&8\u21E8 &e\u26A1 &7128 J úložiště",
            LoreBuilder.powerPerSecond(8));
    public static final SlimefunItemStack MULTIMETER =
            new SlimefunItemStack("MULTIMETER", Material.CLOCK, "&eMultimetr", "", "&rZobrazí uloženou energii");

    public static final SlimefunItemStack SMALL_CAPACITOR = new SlimefunItemStack(
            "SMALL_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aMalý kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.CAPACITOR),
            "&8\u21E8 &e\u26A1 &7128 J úložiště");
    public static final SlimefunItemStack MEDIUM_CAPACITOR = new SlimefunItemStack(
            "MEDIUM_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aStřední kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.CAPACITOR),
            LoreBuilder.powerBuffer(512));
    public static final SlimefunItemStack BIG_CAPACITOR = new SlimefunItemStack(
            "BIG_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aVelký kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.CAPACITOR),
            LoreBuilder.powerBuffer(1024));
    public static final SlimefunItemStack LARGE_CAPACITOR = new SlimefunItemStack(
            "LARGE_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aObří kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.GOOD, MachineType.CAPACITOR),
            LoreBuilder.powerBuffer(8192));
    public static final SlimefunItemStack CARBONADO_EDGED_CAPACITOR = new SlimefunItemStack(
            "CARBONADO_EDGED_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aCarbonado kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR),
            LoreBuilder.powerBuffer(65536));
    public static final SlimefunItemStack ENERGIZED_CAPACITOR = new SlimefunItemStack(
            "ENERGIZED_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&aUltimátní kondenzátor",
            LoreBuilder.range(6),
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR),
            LoreBuilder.powerBuffer(524288));

    /*		Robots				*/
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID",
            HeadTexture.PROGRAMMABLE_ANDROID,
            "&cProgramovatelný android &7(Obyčejný)",
            "",
            "&8\u21E8 &7Funkce: Žádná",
            "&8\u21E8 &7Účinnost paliva: 1.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_FARMER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_FARMER",
            HeadTexture.PROGRAMMABLE_ANDROID_FARMER,
            "&cProgramovatelný android &7(Farmář)",
            "",
            "&8\u21E8 &7Funkce: Farmářství",
            "&8\u21E8 &7Účinnost paliva: 1.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_MINER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_MINER",
            HeadTexture.PROGRAMMABLE_ANDROID_MINER,
            "&cProgramovatelný android &7(Těžař)",
            "",
            "&8\u21E8 &7Funkce: Těžba",
            "&8\u21E8 &7Účinnost paliva: 1.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_WOODCUTTER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_WOODCUTTER",
            HeadTexture.PROGRAMMABLE_ANDROID_WOODCUTTER,
            "&cProgramovatelný android &7(Dřevorubec)",
            "",
            "&8\u21E8 &7Funkce: Kácení",
            "&8\u21E8 &7Účinnost paliva: 1.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_BUTCHER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_BUTCHER",
            HeadTexture.PROGRAMMABLE_ANDROID_BUTCHER,
            "&cProgramovatelný android &7(Řezník)",
            "",
            "&8\u21E8 &7Funkce: Porážení",
            "&8\u21E8 &7Poškození: 4",
            "&8\u21E8 &7Účinnost paliva: 1.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_FISHERMAN = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_FISHERMAN",
            HeadTexture.PROGRAMMABLE_ANDROID_FISHERMAN,
            "&cProgramovatelný android &7(Rybář)",
            "",
            "&8\u21E8 &7Funkce: Rybaření",
            "&8\u21E8 &7Úspěšnost: 10%",
            "&8\u21E8 &7Účinnost paliva: 1.0x");

    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_2 = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_2",
            HeadTexture.PROGRAMMABLE_ANDROID,
            "&cPokročilý programovatelný android &7(Obyčejný)",
            "",
            "&8\u21E8 &7Funkce: Žádná",
            "&8\u21E8 &7Účinnost paliva: 1.5x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_2_FISHERMAN = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_2_FISHERMAN",
            HeadTexture.PROGRAMMABLE_ANDROID_FISHERMAN,
            "&cPokročilý programovatelný android &7(Rybář)",
            "",
            "&8\u21E8 &7Funkce: Rybaření",
            "&8\u21E8 &7Úspěšnost: 20%",
            "&8\u21E8 &7Účinnost paliva: 1.5x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_2_FARMER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_2_FARMER",
            HeadTexture.PROGRAMMABLE_ANDROID_FARMER,
            "&cPokročilý programovatelný android &7(Farmář)",
            "",
            "&8\u21E8 &7Funkce: Farmářství",
            "&8\u21E8 &7Účinnost paliva: 1.5x",
            "&8\u21E8 &7Může sklízet exotické rostliny");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_2_BUTCHER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_2_BUTCHER",
            HeadTexture.PROGRAMMABLE_ANDROID_BUTCHER,
            "&cPokročilý programovatelný android &7(Řezník)",
            "",
            "&8\u21E8 &7Funkce: Porážení",
            "&8\u21E8 &7Poškození: 8",
            "&8\u21E8 &7Účinnost paliva: 1.5x");

    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_3 = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_3",
            HeadTexture.PROGRAMMABLE_ANDROID,
            "&eAutorizovatelný programovatelný android &7(Obyčejný)",
            "",
            "&8\u21E8 &7Funkce: Žádná",
            "&8\u21E8 &7Účinnost paliva: 3.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_3_FISHERMAN = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_3_FISHERMAN",
            HeadTexture.PROGRAMMABLE_ANDROID_FISHERMAN,
            "&eAutorizovatelný programovatelný android &7(Rybář)",
            "",
            "&8\u21E8 &7Funkce: Rybaření",
            "&8\u21E8 &7Úspěšnost: 30%",
            "&8\u21E8 &7Účinnost paliva: 8.0x");
    public static final SlimefunItemStack PROGRAMMABLE_ANDROID_3_BUTCHER = new SlimefunItemStack(
            "PROGRAMMABLE_ANDROID_3_BUTCHER",
            HeadTexture.PROGRAMMABLE_ANDROID_BUTCHER,
            "&eAutorizovatelný programovatelný android &7(Řezník)",
            "",
            "&8\u21E8 &7Funkce: Porážení",
            "&8\u21E8 &7Poškození: 20",
            "&8\u21E8 &7Účinnost paliva: 8.0x");

    /*		       GPS		       */
    public static final SlimefunItemStack GPS_TRANSMITTER = new SlimefunItemStack(
            "GPS_TRANSMITTER",
            HeadTexture.GPS_TRANSMITTER,
            "&bGPS vysílač",
            "",
            LoreBuilder.powerBuffer(16),
            LoreBuilder.powerPerSecond(2));
    public static final SlimefunItemStack GPS_TRANSMITTER_2 = new SlimefunItemStack(
            "GPS_TRANSMITTER_2",
            HeadTexture.GPS_TRANSMITTER,
            "&cPokročilý GPS vysílač",
            "",
            LoreBuilder.powerBuffer(64),
            LoreBuilder.powerPerSecond(6));
    public static final SlimefunItemStack GPS_TRANSMITTER_3 = new SlimefunItemStack(
            "GPS_TRANSMITTER_3",
            HeadTexture.GPS_TRANSMITTER,
            "&4Carbonado GPS vysílač",
            "",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(22));
    public static final SlimefunItemStack GPS_TRANSMITTER_4 = new SlimefunItemStack(
            "GPS_TRANSMITTER_4",
            HeadTexture.GPS_TRANSMITTER,
            "&eNabíjený GPS vysílač",
            "",
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(92));

    public static final SlimefunItemStack GPS_MARKER_TOOL = new SlimefunItemStack(
            "GPS_MARKER_TOOL",
            Material.REDSTONE_TORCH,
            "&bGPS nástroj pro waypointy",
            "",
            "&rUmožňuje nastavit waypoint");
    public static final SlimefunItemStack GPS_CONTROL_PANEL = new SlimefunItemStack(
            "GPS_CONTROL_PANEL",
            HeadTexture.GPS_CONTROL_PANEL,
            "&bGPS ovládací panel",
            "",
            "&rSleduje GPS satelity",
            "&ra spravuje waypointy");
    public static final SlimefunItemStack GPS_EMERGENCY_TRANSMITTER = new SlimefunItemStack(
            "GPS_EMERGENCY_TRANSMITTER",
            HeadTexture.GPS_TRANSMITTER,
            "&cGPS nouzový vysílač",
            "",
            "&rPři smrti automaticky",
            "&rnastaví waypoint na místo smrti");

    public static final SlimefunItemStack ANDROID_INTERFACE_FUEL = new SlimefunItemStack(
            "ANDROID_INTERFACE_FUEL",
            Material.DISPENSER,
            "&7Android rozhraní &c(Palivo)",
            "",
            "&rVkládá palivo do androida");
    public static final SlimefunItemStack ANDROID_INTERFACE_ITEMS = new SlimefunItemStack(
            "ANDROID_INTERFACE_ITEMS",
            Material.DISPENSER,
            "&7Android rozhraní &9(Předměty)",
            "",
            "&rVkládá/vybírá předměty z androida");

    public static final SlimefunItemStack GPS_GEO_SCANNER = new SlimefunItemStack(
            "GPS_GEO_SCANNER",
            HeadTexture.GEO_SCANNER,
            "&bGPS geologický skener",
            "",
            "&rZjistí množství přírodních zdrojů",
            "&rv chunku (např. &8ropa)");
    public static final SlimefunItemStack PORTABLE_GEO_SCANNER = new SlimefunItemStack(
            "PORTABLE_GEO_SCANNER",
            Material.CLOCK,
            "&bPřenosný geologický skener",
            "",
            "&rSkenuje zdroje v chunku",
            "",
            "&ePravý klik&7 pro sken");
    public static final SlimefunItemStack GEO_MINER = new SlimefunItemStack(
            "GEO_MINER",
            HeadTexture.GEO_MINER,
            "&6Těžař přírodních zdrojů",
            "",
            "&eTěží zdroje z chunku",
            "&ekteré nelze normálně vytěžit",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(48),
            "",
            "&c&l! &cNejprve proveď GEO sken");
    public static final SlimefunItemStack OIL_PUMP = new SlimefunItemStack(
            "OIL_PUMP",
            HeadTexture.OIL_PUMP,
            "&rRopná pumpa",
            "",
            "&7Pumpuje ropu do kbelíků",
            "",
            "&c&l! &cNejprve proveď GEO sken");
    public static final SlimefunItemStack OIL_BUCKET =
            new SlimefunItemStack("BUCKET_OF_OIL", HeadTexture.OIL_BUCKET, "&rKbelík ropy");
    public static final SlimefunItemStack FUEL_BUCKET =
            new SlimefunItemStack("BUCKET_OF_FUEL", HeadTexture.FUEL_BUCKET, "&rKbelík paliva");

    public static final SlimefunItemStack REFINERY =
            new SlimefunItemStack("REFINERY", Material.PISTON, "&cRafinérie", "", "&rRafinuje ropu na palivo");
    public static final SlimefunItemStack COMBUSTION_REACTOR = new SlimefunItemStack(
            "COMBUSTION_REACTOR",
            HeadTexture.GENERATOR,
            "&cSpalovací reaktor",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(24));
    public static final SlimefunItemStack ANDROID_MEMORY_CORE =
            new SlimefunItemStack("ANDROID_MEMORY_CORE", HeadTexture.ENERGY_REGULATOR, "&bPaměťové jádro androida");

    public static final SlimefunItemStack GPS_TELEPORTER_PYLON = new SlimefunItemStack(
            "GPS_TELEPORTER_PYLON", Material.PURPLE_STAINED_GLASS, "&5GPS pylon", "", "&7Součást teleporteru");
    public static final SlimefunItemStack GPS_TELEPORTATION_MATRIX = new SlimefunItemStack(
            "GPS_TELEPORTATION_MATRIX",
            Material.IRON_BLOCK,
            "&bGPS teleportační matice",
            "",
            "&rHlavní část GPS teleportu",
            "&rUmožňuje teleportaci na waypointy");
    public static final SlimefunItemStack GPS_ACTIVATION_DEVICE_SHARED = new SlimefunItemStack(
            "GPS_ACTIVATION_DEVICE_SHARED",
            Material.STONE_PRESSURE_PLATE,
            "&rGPS aktivátor &3(Veřejný)",
            "",
            "&rUmísti na matici a šlápni");
    public static final SlimefunItemStack GPS_ACTIVATION_DEVICE_PERSONAL = new SlimefunItemStack(
            "GPS_ACTIVATION_DEVICE_PERSONAL",
            Material.STONE_PRESSURE_PLATE,
            "&rGPS aktivátor &a(Osobní)",
            "",
            "&rUmísti na matici a šlápni",
            "",
            "&rPouze majitel může používat");
    public static final SlimefunItemStack PORTABLE_TELEPORTER = new SlimefunItemStack(
            "PORTABLE_TELEPORTER",
            Material.COMPASS,
            "&bPřenosný teleporter",
            "",
            "&fTeleportuje tě kdykoliv",
            "",
            LoreBuilder.powerCharged(0, 50),
            "",
            "&ePravý klik&7 pro použití");

    public static final SlimefunItemStack ELEVATOR_PLATE = new SlimefunItemStack(
            "ELEVATOR_PLATE",
            Material.STONE_PRESSURE_PLATE,
            "&bVýtahová deska",
            "",
            "&rUmísti na každé patro",
            "&rpro teleportaci mezi patry.",
            "",
            "&ePravý klik&7 pro pojmenování patra");

    public static final SlimefunItemStack INFUSED_HOPPER = new SlimefunItemStack(
            "INFUSED_HOPPER",
            Material.HOPPER,
            "&5Magický hopper",
            "",
            "&rAutomaticky sbírá předměty",
            "&rv 7x7x7 oblasti");

    public static final SlimefunItemStack PLASTIC_SHEET =
            new SlimefunItemStack("PLASTIC_SHEET", Material.PAPER, "&rPlastová fólie");

    public static final SlimefunItemStack HEATED_PRESSURE_CHAMBER = new SlimefunItemStack(
            "HEATED_PRESSURE_CHAMBER",
            Material.LIGHT_GRAY_STAINED_GLASS,
            "&cOhřívaná tlakový komora",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(10));
    public static final SlimefunItemStack HEATED_PRESSURE_CHAMBER_2 = new SlimefunItemStack(
            "HEATED_PRESSURE_CHAMBER_2",
            Material.LIGHT_GRAY_STAINED_GLASS,
            "&cOhřívaná tlakový komora &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 5x",
            LoreBuilder.powerPerSecond(44));

    public static final SlimefunItemStack ELECTRIC_SMELTERY = new SlimefunItemStack(
            "ELECTRIC_SMELTERY",
            Material.FURNACE,
            "&cElektrická tavicí pec",
            "",
            "&4Pouze slitiny, ne taví prach",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(20));
    public static final SlimefunItemStack ELECTRIC_SMELTERY_2 = new SlimefunItemStack(
            "ELECTRIC_SMELTERY_2",
            Material.FURNACE,
            "&cElektrická tavicí pec &7- &eII",
            "",
            "&4Pouze slitiny, ne taví prach",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 3x",
            LoreBuilder.powerPerSecond(40));

    public static final SlimefunItemStack ELECTRIC_PRESS = new SlimefunItemStack(
            "ELECTRIC_PRESS",
            HeadTexture.ELECTRIC_PRESS,
            "&eKompresor",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(16));
    public static final SlimefunItemStack ELECTRIC_PRESS_2 = new SlimefunItemStack(
            "ELECTRIC_PRESS_2",
            HeadTexture.ELECTRIC_PRESS,
            "&eKompresor &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 3x",
            LoreBuilder.powerPerSecond(40));

    public static final SlimefunItemStack ELECTRIFIED_CRUCIBLE = new SlimefunItemStack(
            "ELECTRIFIED_CRUCIBLE",
            Material.RED_TERRACOTTA,
            "&cElektrický tygel",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(48));
    public static final SlimefunItemStack ELECTRIFIED_CRUCIBLE_2 = new SlimefunItemStack(
            "ELECTRIFIED_CRUCIBLE_2",
            Material.RED_TERRACOTTA,
            "&cElektrický tygel &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 2x",
            "&8\u21E8 &e\u26A1 &780 J/s");
    public static final SlimefunItemStack ELECTRIFIED_CRUCIBLE_3 = new SlimefunItemStack(
            "ELECTRIFIED_CRUCIBLE_3",
            Material.RED_TERRACOTTA,
            "&cElektrický tygel &7- &eIII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 4x",
            "&8\u21E8 &e\u26A1 &7120 J/s");

    public static final SlimefunItemStack CARBON_PRESS = new SlimefunItemStack(
            "CARBON_PRESS",
            Material.BLACK_STAINED_GLASS,
            "&cUhlíkový lis",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(20));
    public static final SlimefunItemStack CARBON_PRESS_2 = new SlimefunItemStack(
            "CARBON_PRESS_2",
            Material.BLACK_STAINED_GLASS,
            "&cUhlíkový lis &7- &eII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 3x",
            "&8\u21E8 &e\u26A1 &750 J/s");
    public static final SlimefunItemStack CARBON_PRESS_3 = new SlimefunItemStack(
            "CARBON_PRESS_3",
            Material.BLACK_STAINED_GLASS,
            "&cUhlíkový lis &7- &eIII",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 15x",
            "&8\u21E8 &e\u26A1 &7180 J/s");

    public static final SlimefunItemStack BLISTERING_INGOT = new SlimefunItemStack(
            "BLISTERING_INGOT",
            Material.GOLD_INGOT,
            "&6Puchýřnatý ingot &7(33%)",
            "",
            LoreBuilder.radioactive(Radioactivity.HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack BLISTERING_INGOT_2 = new SlimefunItemStack(
            "BLISTERING_INGOT_2",
            Material.GOLD_INGOT,
            "&6Puchýřnatý ingot &7(66%)",
            "",
            LoreBuilder.radioactive(Radioactivity.HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack BLISTERING_INGOT_3 = new SlimefunItemStack(
            "BLISTERING_INGOT_3",
            Material.GOLD_INGOT,
            "&6Puchýřnatý ingot",
            "",
            LoreBuilder.radioactive(Radioactivity.HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);

    public static final SlimefunItemStack ENERGY_REGULATOR = new SlimefunItemStack(
            "ENERGY_REGULATOR",
            HeadTexture.ENERGY_REGULATOR,
            "&6Energetický regulátor",
            "",
            "&rJádro energetické sítě");
    public static final SlimefunItemStack ENERGY_CONNECTOR = new SlimefunItemStack(
            "ENERGY_CONNECTOR",
            HeadTexture.ENERGY_CONNECTOR,
            "&cEnergetický konektor",
            LoreBuilder.range(6),
            "",
            "&fPřipojuje stroje a generátory",
            "&fdo energetické sítě");
    public static final SlimefunItemStack DEBUG_FISH = new SlimefunItemStack(
            "DEBUG_FISH",
            Material.SALMON,
            "&3Kolik stojí tahle ryba?",
            "",
            "&ePravý klik &rna blok pro zobrazení dat",
            "&eLevý klik &rpro zničení",
            "&eShift + Levý klik &rpro smazání dat",
            "&eShift + Pravý klik &rpro placeholder");

    public static final SlimefunItemStack NETHER_ICE = new SlimefunItemStack(
            "NETHER_ICE",
            HeadTexture.NETHER_ICE,
            "&eNetherový led",
            "",
            LoreBuilder.radioactive(Radioactivity.MODERATE),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack ENRICHED_NETHER_ICE = new SlimefunItemStack(
            "ENRICHED_NETHER_ICE",
            HeadTexture.ENRICHED_NETHER_ICE,
            "&eObohacený netherový led",
            "",
            LoreBuilder.radioactive(Radioactivity.VERY_HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack NETHER_ICE_COOLANT_CELL = new SlimefunItemStack(
            "NETHER_ICE_COOLANT_CELL", HeadTexture.NETHER_ICE_COOLANT_CELL, "&6Chladicí článek z nether ledu");

    // Cargo
    public static final SlimefunItemStack CARGO_MANAGER = new SlimefunItemStack(
            "CARGO_MANAGER", HeadTexture.CARGO_MANAGER, "&6Cargo manažer", "", "&rJádro cargo sítě");
    public static final SlimefunItemStack CARGO_CONNECTOR_NODE = new SlimefunItemStack(
            "CARGO_NODE", HeadTexture.CARGO_CONNECTOR_NODE, "&7Cargo node &c(Konektor)", "", "&rPřipojovací potrubí");
    public static final SlimefunItemStack CARGO_INPUT_NODE = new SlimefunItemStack(
            "CARGO_NODE_INPUT", HeadTexture.CARGO_INPUT_NODE, "&7Cargo node &c(Vstup)", "", "&rVstupní potrubí");
    public static final SlimefunItemStack CARGO_OUTPUT_NODE = new SlimefunItemStack(
            "CARGO_NODE_OUTPUT", HeadTexture.CARGO_OUTPUT_NODE, "&7Cargo node &c(Výstup)", "", "&rVýstupní potrubí");
    public static final SlimefunItemStack CARGO_OUTPUT_NODE_2 = new SlimefunItemStack(
            "CARGO_NODE_OUTPUT_ADVANCED",
            HeadTexture.CARGO_OUTPUT_NODE,
            "&6Pokročilý cargo node &c(Výstup)",
            "",
            "&rVýstupní potrubí");

    // Animal farm
    public static final SlimefunItemStack AUTO_BREEDER = new SlimefunItemStack(
            "AUTO_BREEDER",
            Material.HAY_BLOCK,
            "&eAutomatický chovatel",
            "",
            "&rVyžaduje &aorganickou potravu",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            "&8\u21E8 &e\u26A1 &760 J/živočich");
    public static final SlimefunItemStack PRODUCE_COLLECTOR = new SlimefunItemStack(
            "PRODUCE_COLLECTOR",
            Material.HAY_BLOCK,
            "&bAutomatický sběrač produktů",
            "",
            "&fAutomaticky sbírá produkty",
            "&fz blízkých zvířat.",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(32));

    public static final SlimefunItemStack ORGANIC_FOOD =
            new SlimefunItemStack("ORGANIC_FOOD", HeadTexture.FILLED_CAN, "&aOrganická potrava", "&7Obsahuje &9???");
    public static final SlimefunItemStack WHEAT_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_WHEAT", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9pšenici");
    public static final SlimefunItemStack CARROT_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_CARROT", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9mrkev");
    public static final SlimefunItemStack POTATO_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_POTATO", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9bramboru");
    public static final SlimefunItemStack SEEDS_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_SEEDS", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9semínka");
    public static final SlimefunItemStack BEETROOT_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_BEETROOT",
            HeadTexture.FILLED_CAN,
            ORGANIC_FOOD.getDisplayName(),
            "&7Obsahuje &9červenou řepu");
    public static final SlimefunItemStack MELON_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_MELON", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9meloun");
    public static final SlimefunItemStack APPLE_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_APPLE", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9jablko");
    public static final SlimefunItemStack SWEET_BERRIES_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_SWEET_BERRIES",
            HeadTexture.FILLED_CAN,
            ORGANIC_FOOD.getDisplayName(),
            "&7Obsahuje &9lesní plody");
    public static final SlimefunItemStack KELP_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_KELP", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9sušené chaluhy");
    public static final SlimefunItemStack COCOA_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_COCOA", HeadTexture.FILLED_CAN, ORGANIC_FOOD.getDisplayName(), "&7Obsahuje &9kakaové boby");
    public static final SlimefunItemStack SEAGRASS_ORGANIC_FOOD = new SlimefunItemStack(
            "ORGANIC_FOOD_SEAGRASS",
            HeadTexture.FILLED_CAN,
            ORGANIC_FOOD.getDisplayName(),
            "&7Obsahuje: &9mořskou trávu");

    public static final SlimefunItemStack FERTILIZER =
            new SlimefunItemStack("FERTILIZER", HeadTexture.FILLED_CAN, "&aOrganické hnojivo", "&7Obsahuje &9???");
    public static final SlimefunItemStack WHEAT_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_WHEAT", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9pšenici");
    public static final SlimefunItemStack CARROT_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_CARROT", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9mrkev");
    public static final SlimefunItemStack POTATO_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_POTATO", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9bramboru");
    public static final SlimefunItemStack SEEDS_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_SEEDS", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9semínka");
    public static final SlimefunItemStack BEETROOT_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_BEETROOT", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9červenou řepu");
    public static final SlimefunItemStack MELON_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_MELON", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9meloun");
    public static final SlimefunItemStack APPLE_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_APPLE", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9jablko");
    public static final SlimefunItemStack SWEET_BERRIES_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_SWEET_BERRIES",
            HeadTexture.FILLED_CAN,
            FERTILIZER.getDisplayName(),
            "&7Obsahuje &9lesní plody");
    public static final SlimefunItemStack KELP_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_KELP", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9sušené chaluhy");
    public static final SlimefunItemStack COCOA_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_COCOA", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje &9kakaové boby");
    public static final SlimefunItemStack SEAGRASS_FERTILIZER = new SlimefunItemStack(
            "FERTILIZER_SEAGRASS", HeadTexture.FILLED_CAN, FERTILIZER.getDisplayName(), "&7Obsahuje: &9mořskou trávu");

    public static final SlimefunItemStack ANIMAL_GROWTH_ACCELERATOR = new SlimefunItemStack(
            "ANIMAL_GROWTH_ACCELERATOR",
            Material.HAY_BLOCK,
            "&bZrychlovač růstu zvířat",
            "",
            "&rVyžaduje &aorganickou potravu",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(28));
    public static final SlimefunItemStack CROP_GROWTH_ACCELERATOR = new SlimefunItemStack(
            "CROP_GROWTH_ACCELERATOR",
            Material.LIME_TERRACOTTA,
            "&aZrychlovač růstu plodin",
            "",
            "&rVyžaduje &aorganické hnojivo",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Poloměr: 7x7",
            "&8\u21E8 &7Rychlost: &a3/tik",
            LoreBuilder.powerBuffer(1024),
            "&8\u21E8 &e\u26A1 &750 J/s");
    public static final SlimefunItemStack CROP_GROWTH_ACCELERATOR_2 = new SlimefunItemStack(
            "CROP_GROWTH_ACCELERATOR_2",
            Material.LIME_TERRACOTTA,
            "&aZrychlovač růstu plodin &7(&eII&7)",
            "",
            "&rVyžaduje &aorganické hnojivo",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Poloměr: 9x9",
            "&8\u21E8 &7Rychlost: &a4/tik",
            LoreBuilder.powerBuffer(1024),
            "&8\u21E8 &e\u26A1 &760 J/s");
    public static final SlimefunItemStack TREE_GROWTH_ACCELERATOR = new SlimefunItemStack(
            "TREE_GROWTH_ACCELERATOR",
            Material.BROWN_TERRACOTTA,
            "&aZrychlovač růstu stromů",
            "",
            "&rVyžaduje &aorganické hnojivo",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Poloměr: 9x9",
            "&8\u21E8 &7Rychlost: &a4/tik",
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(48));

    public static final SlimefunItemStack FOOD_FABRICATOR = new SlimefunItemStack(
            "FOOD_FABRICATOR",
            Material.GREEN_STAINED_GLASS,
            "&cVýrobník potravy",
            "",
            "&rVyrábí &aorganickou potravu",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(14));
    public static final SlimefunItemStack FOOD_FABRICATOR_2 = new SlimefunItemStack(
            "FOOD_FABRICATOR_2",
            Material.GREEN_STAINED_GLASS,
            "&cVýrobník potravy &7(&eII&7)",
            "",
            "&rVyrábí &aorganickou potravu",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 6x",
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(48));

    public static final SlimefunItemStack FOOD_COMPOSTER = new SlimefunItemStack(
            "FOOD_COMPOSTER",
            Material.GREEN_TERRACOTTA,
            "&cKompostér potravy",
            "",
            "&rVyrábí &aorganické hnojivo",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(16));
    public static final SlimefunItemStack FOOD_COMPOSTER_2 = new SlimefunItemStack(
            "FOOD_COMPOSTER_2",
            Material.GREEN_TERRACOTTA,
            "&cKompostér potravy &7(&eII&7)",
            "",
            "&rVyrábí &aorganické hnojivo",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 10x",
            LoreBuilder.powerBuffer(512),
            "&8\u21E8 &e\u26A1 &752 J/s");

    public static final SlimefunItemStack EXP_COLLECTOR = new SlimefunItemStack(
            "XP_COLLECTOR",
            HeadTexture.EXP_COLLECTOR,
            "&aSběrač zkušeností",
            "",
            "&rSbírá a ukládá okolní XP",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(20));
    public static final SlimefunItemStack REACTOR_COOLANT_CELL =
            new SlimefunItemStack("REACTOR_COLLANT_CELL", HeadTexture.COOLANT_CELL, "&bChladicí článek reaktoru");

    public static final SlimefunItemStack NUCLEAR_REACTOR = new SlimefunItemStack(
            "NUCLEAR_REACTOR",
            HeadTexture.NUCLEAR_REACTOR,
            "&2Jaderný reaktor",
            "",
            "&rVyžaduje chlazení!",
            "&8\u21E8 &bMusí být obklopen vodou",
            "&8\u21E8 &bMusí používat chladicí článek",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
            "&8\u21E8 &e\u26A1 &716384 J úložiště",
            "&8\u21E8 &e\u26A1 &7500 J/s");
    public static final SlimefunItemStack NETHER_STAR_REACTOR = new SlimefunItemStack(
            "NETHERSTAR_REACTOR",
            HeadTexture.NETHER_STAR_REACTOR,
            "&rReaktor z nether hvězdy",
            "",
            "&rVyžaduje nether hvězdu",
            "&8\u21E8 &bMusí být obklopen vodou",
            "&8\u21E8 &bMusí používat nether led",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
            "&8\u21E8 &e\u26A1 &732768 J úložiště",
            "&8\u21E8 &e\u26A1 &71024 J/s",
            "&8\u21E8 &4Způsobuje wither efekt okolním entitám");
    public static final SlimefunItemStack REACTOR_ACCESS_PORT = new SlimefunItemStack(
            "REACTOR_ACCESS_PORT",
            Material.CYAN_TERRACOTTA,
            "&2Přístupový port reaktoru",
            "",
            "&rUmožňuje cargo přístup k reaktoru",
            "",
            "&8\u21E8 &cMusí být umístěn 3 bloky nad reaktorem");

    public static final SlimefunItemStack FREEZER = new SlimefunItemStack(
            "FREEZER",
            Material.LIGHT_BLUE_STAINED_GLASS,
            "&bMrazák",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(18));
    public static final SlimefunItemStack FREEZER_2 = new SlimefunItemStack(
            "FREEZER_2",
            Material.LIGHT_BLUE_STAINED_GLASS,
            "&bMrazák &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 2x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(30));
    public static final SlimefunItemStack FREEZER_3 = new SlimefunItemStack(
            "FREEZER_3",
            Material.LIGHT_BLUE_STAINED_GLASS,
            "&bMrazák &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(3),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(42));

    public static final SlimefunItemStack ELECTRIC_GOLD_PAN = new SlimefunItemStack(
            "ELECTRIC_GOLD_PAN",
            Material.BROWN_TERRACOTTA,
            "&6Elektrická zlatá pánev",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(2));
    public static final SlimefunItemStack ELECTRIC_GOLD_PAN_2 = new SlimefunItemStack(
            "ELECTRIC_GOLD_PAN_2",
            Material.BROWN_TERRACOTTA,
            "&6Elektrická zlatá pánev &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 3x",
            LoreBuilder.powerPerSecond(4));
    public static final SlimefunItemStack ELECTRIC_GOLD_PAN_3 = new SlimefunItemStack(
            "ELECTRIC_GOLD_PAN_3",
            Material.BROWN_TERRACOTTA,
            "&6Elektrická zlatá pánev &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 10x",
            LoreBuilder.powerPerSecond(14));

    public static final SlimefunItemStack ELECTRIC_DUST_WASHER = new SlimefunItemStack(
            "ELECTRIC_DUST_WASHER",
            Material.BLUE_STAINED_GLASS,
            "&3Elektrická pračka prachu",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(6));
    public static final SlimefunItemStack ELECTRIC_DUST_WASHER_2 = new SlimefunItemStack(
            "ELECTRIC_DUST_WASHER_2",
            Material.BLUE_STAINED_GLASS,
            "&3Elektrická pračka prachu &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 2x",
            LoreBuilder.powerPerSecond(10));
    public static final SlimefunItemStack ELECTRIC_DUST_WASHER_3 = new SlimefunItemStack(
            "ELECTRIC_DUST_WASHER_3",
            Material.BLUE_STAINED_GLASS,
            "&3Elektrická pračka prachu &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 10x",
            LoreBuilder.powerPerSecond(30));

    public static final SlimefunItemStack ELECTRIC_INGOT_FACTORY = new SlimefunItemStack(
            "ELECTRIC_INGOT_FACTORY",
            Material.RED_TERRACOTTA,
            "&cElektrická továrna na ingoty",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 1x",
            LoreBuilder.powerPerSecond(8));
    public static final SlimefunItemStack ELECTRIC_INGOT_FACTORY_2 = new SlimefunItemStack(
            "ELECTRIC_INGOT_FACTORY_2",
            Material.RED_TERRACOTTA,
            "&cElektrická továrna na ingoty &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 2x",
            LoreBuilder.powerPerSecond(14));
    public static final SlimefunItemStack ELECTRIC_INGOT_FACTORY_3 = new SlimefunItemStack(
            "ELECTRIC_INGOT_FACTORY_3",
            Material.RED_TERRACOTTA,
            "&cElektrická továrna na ingoty &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Rychlost: 8x",
            LoreBuilder.powerPerSecond(40));

    public static final SlimefunItemStack FLUID_PUMP = new SlimefunItemStack(
            "FLUID_PUMP",
            Material.BLUE_TERRACOTTA,
            "&9Čerpadlo kapalin",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &e\u26A1 &732 J/blok");
    public static final SlimefunItemStack CHARGING_BENCH = new SlimefunItemStack(
            "CHARGING_BENCH",
            Material.CRAFTING_TABLE,
            "&6Nabíjecí stůl",
            "",
            "&rNabíjí předměty jako jetpacky",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &e\u26A1 &7128 J úložiště",
            "&8\u21E8 &e\u26A1 &7Ztráta energie: &c50%");

    public static final SlimefunItemStack VANILLA_AUTO_CRAFTER = new SlimefunItemStack(
            "VANILLA_AUTO_CRAFTER",
            HeadTexture.VANILLA_AUTO_CRAFTER,
            "&2Automatický craftěr &8(Vanilla)",
            "",
            "&fUmísti na jakýkoliv inventářový blok",
            "&fpro automatické craftění!",
            "&fCraftí vše co zvládne normální stůl",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &e\u26A1 &716 J za craft");
    public static final SlimefunItemStack ENHANCED_AUTO_CRAFTER = new SlimefunItemStack(
            "ENHANCED_AUTO_CRAFTER",
            HeadTexture.ENHANCED_AUTO_CRAFTER,
            "&2Automatický craftěr &8(Pokročilý)",
            "",
            "&fUmísti na jakýkoliv inventářový blok",
            "&fpro automatické craftění!",
            "&fCraftí vše co zvládne vylepšený stůl",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &e\u26A1 &716 J za craft");
    public static final SlimefunItemStack ARMOR_AUTO_CRAFTER = new SlimefunItemStack(
            "ARMOR_AUTO_CRAFTER",
            HeadTexture.ARMOR_AUTO_CRAFTER,
            "&2Automatický craftěr &8(Kovárna zbroje)",
            "",
            "&fUmísti na jakýkoliv inventářový blok",
            "&fpro automatické craftění zbroje",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &e\u26A1 &732 J za craft");

    public static final SlimefunItemStack IRON_GOLEM_ASSEMBLER = new SlimefunItemStack(
            "IRON_GOLEM_ASSEMBLER",
            Material.IRON_BLOCK,
            "&6Montážní linka železného golema",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Cooldown: &b30 sekund",
            LoreBuilder.powerBuffer(4096),
            "&8\u21E8 &e\u26A1 &72048 J/golem");
    public static final SlimefunItemStack WITHER_ASSEMBLER = new SlimefunItemStack(
            "WITHER_ASSEMBLER",
            Material.OBSIDIAN,
            "&5Montážní linka withera",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Cooldown: &b30 sekund",
            "&8\u21E8 &e\u26A1 &74096 J úložiště",
            "&8\u21E8 &e\u26A1 &74096 J/wither");

    public static final SlimefunItemStack TRASH_CAN = new SlimefunItemStack(
            "TRASH_CAN_BLOCK", HeadTexture.TRASH_CAN, "&3Odpadkový koš", "", "&rSem můžeš házet nepotřebné věci");

    public static final SlimefunItemStack ELYTRA_SCALE =
            new SlimefunItemStack("ELYTRA_SCALE", Material.FEATHER, "&bŠupina elytry");
    public static final SlimefunItemStack INFUSED_ELYTRA =
            new SlimefunItemStack("INFUSED_ELYTRA", Material.ELYTRA, "&5Elytra (Mending)");
    public static final SlimefunItemStack SOULBOUND_ELYTRA =
            new SlimefunItemStack("SOULBOUND_ELYTRA", Material.ELYTRA, "&cElytra (Duše)");

    public static final SlimefunItemStack MAGNESIUM_SALT = new SlimefunItemStack(
            "MAGNESIUM_SALT", Material.SUGAR, "&cHořčíková sůl", "", "&7Speciální palivo pro hořčíkový generátor");
    public static final SlimefunItemStack MAGNESIUM_GENERATOR = new SlimefunItemStack(
            "MAGNESIUM_GENERATOR",
            HeadTexture.GENERATOR,
            "&cHořčíkový generátor",
            "",
            LoreBuilder.machine(MachineTier.MEDIUM, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(128),
            LoreBuilder.powerPerSecond(36));

    public static final SlimefunItemStack CRAFTER_SMART_PORT = new SlimefunItemStack(
            "CRAFTER_SMART_PORT",
            Material.LIME_STAINED_GLASS,
            "&aChytré rozhraní craftěru",
            "",
            "&5Rozděluje vstupy podle receptu",
            "&5a má určený výstupní slot");

    static {
        INFUSED_ELYTRA.addUnsafeEnchantment(Enchantment.MENDING, 1);
    }
}
