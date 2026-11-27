package com.wmem100002.teamod.registry;

import com.wmem100002.teamod.TeaMod;
import com.wmem100002.teamod.agriculture.RiceVariety;
import com.wmem100002.teamod.client.PestWildlifeGuideItem;
import com.wmem100002.teamod.client.TeaDevBlogItem;
import com.wmem100002.teamod.equipment.CrowFeatherBowItem;
import com.wmem100002.teamod.equipment.CrowQuillPenItem;
import com.wmem100002.teamod.equipment.TeaEquipmentMaterials;
import com.wmem100002.teamod.ritual.SeasonalInstrumentItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TeaMod.MOD_ID);

    // Three-Tier Ingot System
    // 1. Tea Dregs Ingot: EXCLUSIVELY for Tea Dregs Hoe (茶殻インゴットは鍬専用)
    public static final RegistryObject<Item> TEA_DREGS_INGOT = ITEMS.register("tea_dregs_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_DREGS_HOE = ITEMS.register("tea_dregs_hoe",
            () -> new HoeItem(TeaEquipmentMaterials.TEA_DREGS_TIER, -1, -1.0F, new Item.Properties()));

    // 2. Tea Ingot: Weapons, Armor, Tools & Tea Apparatus
    public static final RegistryObject<Item> TEA_INGOT = ITEMS.register("tea_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_SWORD = ITEMS.register("tea_sword",
            () -> new SwordItem(TeaEquipmentMaterials.TEA_TIER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TEA_PICKAXE = ITEMS.register("tea_pickaxe",
            () -> new PickaxeItem(TeaEquipmentMaterials.TEA_TIER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> TEA_AXE = ITEMS.register("tea_axe",
            () -> new AxeItem(TeaEquipmentMaterials.TEA_TIER, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> TEA_SHOVEL = ITEMS.register("tea_shovel",
            () -> new ShovelItem(TeaEquipmentMaterials.TEA_TIER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TEA_HOE = ITEMS.register("tea_hoe",
            () -> new HoeItem(TeaEquipmentMaterials.TEA_TIER, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> TEA_HELMET = ITEMS.register("tea_helmet",
            () -> new ArmorItem(TeaEquipmentMaterials.TEA_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TEA_CHESTPLATE = ITEMS.register("tea_chestplate",
            () -> new ArmorItem(TeaEquipmentMaterials.TEA_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TEA_LEGGINGS = ITEMS.register("tea_leggings",
            () -> new ArmorItem(TeaEquipmentMaterials.TEA_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TEA_BOOTS = ITEMS.register("tea_boots",
            () -> new ArmorItem(TeaEquipmentMaterials.TEA_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

    // 3. Tea Steel Ingot: High-tier Bio-Alloy (Tea + Blood + Liquid Spider Silk)
    public static final RegistryObject<Item> TEA_STEEL_INGOT = ITEMS.register("tea_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_STEEL_SWORD = ITEMS.register("tea_steel_sword",
            () -> new SwordItem(TeaEquipmentMaterials.TEA_STEEL_TIER, 4, -2.3F, new Item.Properties()));

    // Rice Varieties (Strictly named 農林〇〇号)
    public static final RegistryObject<Item> RICE_SEED_NORIN_1 = ITEMS.register("rice_seed_norin_1",
            () -> new ItemNameBlockItem(ModBlocks.RICE_CROP_NORIN_1.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_SEED_NORIN_8 = ITEMS.register("rice_seed_norin_8",
            () -> new ItemNameBlockItem(ModBlocks.RICE_CROP_NORIN_8.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_SEED_NORIN_22 = ITEMS.register("rice_seed_norin_22",
            () -> new ItemNameBlockItem(ModBlocks.RICE_CROP_NORIN_22.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_SEED_NORIN_100 = ITEMS.register("rice_seed_norin_100",
            () -> new ItemNameBlockItem(ModBlocks.RICE_CROP_NORIN_100.get(), new Item.Properties()));

    // Dairy, Cream & Soft Serve
    public static final RegistryObject<Item> FRESH_CREAM = ITEMS.register("fresh_cream",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHIPPED_CREAM = ITEMS.register("whipped_cream",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> WAFFLE_CONE = ITEMS.register("waffle_cone",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> SOFT_SERVE_ICE_CREAM = ITEMS.register("soft_serve_ice_cream",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.8f).alwaysEat().build())));

    // Hornet Larva, Pupa & Bird Hunting Drops
    public static final RegistryObject<Item> HORNET_LARVA = ITEMS.register("hornet_larva",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORNET_PUPA = ITEMS.register("hornet_pupa",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORNET_KANRONI = ITEMS.register("hornet_kanroni",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.9f).build())));
    public static final RegistryObject<Item> RAW_SPARROW_MEAT = ITEMS.register("raw_sparrow_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).meat().build())));
    public static final RegistryObject<Item> COOKED_SPARROW_MEAT = ITEMS.register("cooked_sparrow_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.7f).meat().build())));
    public static final RegistryObject<Item> RAW_CROW_MEAT = ITEMS.register("raw_crow_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).meat().build())));
    public static final RegistryObject<Item> TEA_SMOKED_CROW = ITEMS.register("tea_smoked_crow",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.8f).meat().build())));

    // Crow Feather, Special Bow, Quill Pen & Custom Ink
    public static final RegistryObject<Item> CROW_FEATHER = ITEMS.register("crow_feather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CROW_FEATHER_BOW = ITEMS.register("crow_feather_bow",
            () -> new CrowFeatherBowItem(new Item.Properties().durability(650)));
    public static final RegistryObject<Item> CROW_QUILL_PEN = ITEMS.register("crow_quill_pen",
            () -> new CrowQuillPenItem(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CUSTOM_INK_BOTTLE = ITEMS.register("custom_ink_bottle",
            () -> new Item(new Item.Properties().stacksTo(16)));

    // Seasonal Instruments
    public static final RegistryObject<Item> SPRING_SHINOBUE = ITEMS.register("spring_shinobue",
            () -> new SeasonalInstrumentItem(SeasonalInstrumentItem.SeasonType.SPRING, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SUMMER_SHIME_DAIKO = ITEMS.register("summer_shime_daiko",
            () -> new SeasonalInstrumentItem(SeasonalInstrumentItem.SeasonType.SUMMER, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AUTUMN_BIWA = ITEMS.register("autumn_biwa",
            () -> new SeasonalInstrumentItem(SeasonalInstrumentItem.SeasonType.AUTUMN, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WINTER_KOTO = ITEMS.register("winter_koto",
            () -> new SeasonalInstrumentItem(SeasonalInstrumentItem.SeasonType.WINTER, new Item.Properties().stacksTo(1)));

    // Books & Guides
    public static final RegistryObject<Item> PEST_WILDLIFE_GUIDE = ITEMS.register("pest_wildlife_guide",
            () -> new PestWildlifeGuideItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TEA_DEV_BLOG = ITEMS.register("tea_dev_blog",
            () -> new TeaDevBlogItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CATECHIN_SPRAY = ITEMS.register("catechin_spray",
            () -> new Item(new Item.Properties().durability(128)));
}
