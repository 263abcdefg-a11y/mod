package com.wmem100002.teamod.equipment;

import com.wmem100002.teamod.registry.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Equipment Tiers & Armor Materials:
 * - TEA_DREGS_TIER: Exclusively for Tea Dregs Hoe (茶殻インゴットは鍬専用)
 * - TEA_TIER / TEA_ARMOR: Weapons, Tools, and Armor crafted from Tea Ingots
 * - TEA_STEEL_TIER: High-end Bio-Alloy (Tea + Blood + Liquid Spider Silk)
 */
public class TeaEquipmentMaterials {

    public static final Tier TEA_DREGS_TIER = new Tier() {
        @Override public int getUses() { return 220; }
        @Override public float getSpeed() { return 5.5F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 1; }
        @Override public int getEnchantmentValue() { return 14; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.TEA_DREGS_INGOT.get()); }
    };

    public static final Tier TEA_TIER = new Tier() {
        @Override public int getUses() { return 480; }
        @Override public float getSpeed() { return 7.0F; }
        @Override public float getAttackDamageBonus() { return 2.5F; }
        @Override public int getLevel() { return 2; }
        @Override public int getEnchantmentValue() { return 20; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.TEA_INGOT.get()); }
    };

    public static final Tier TEA_STEEL_TIER = new Tier() {
        @Override public int getUses() { return 1850; }
        @Override public float getSpeed() { return 9.0F; }
        @Override public float getAttackDamageBonus() { return 4.0F; }
        @Override public int getLevel() { return 3; }
        @Override public int getEnchantmentValue() { return 22; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.TEA_STEEL_INGOT.get()); }
    };

    public static final ArmorMaterial TEA_ARMOR = new ArmorMaterial() {
        private final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
        private final int[] PROTECTION = new int[]{2, 5, 6, 2};

        @Override public int getDurabilityForType(ArmorItem.Type type) { return HEALTH_PER_SLOT[type.getSlot().getIndex()] * 18; }
        @Override public int getDefenseForType(ArmorItem.Type type) { return PROTECTION[type.getSlot().getIndex()]; }
        @Override public int getEnchantmentValue() { return 20; }
        @Override public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_LEATHER; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.TEA_INGOT.get()); }
        @Override public String getName() { return "teamod:tea"; }
        @Override public float getToughness() { return 1.0F; }
        @Override public float getKnockbackResistance() { return 0.0F; }
    };
}
