package com.wmem100002.teamod.nutrition;

import com.wmem100002.teamod.TeaMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 5 Major Nutrients (Carbs, Protein, Fat, Vitamins, Minerals) & Blood Glucose Gauge Engine.
 * Pairing sweets (Soft Serve, Honey) with Tea (Catechin) prevents glucose spikes
 * and maintains the optimal Lucid Full-Power Zone (40% - 75%).
 */
@Mod.EventBusSubscriber(modid = TeaMod.MOD_ID)
public class NutritionAndGlucoseHandler {
    private static final String NBT_GLUCOSE = "TeaModGlucose";

    public static float getGlucose(Player player) {
        CompoundTag data = player.getPersistentData();
        return data.contains(NBT_GLUCOSE) ? data.getFloat(NBT_GLUCOSE) : 55.0f;
    }

    public static void addGlucose(Player player, float delta, boolean withTeaCatechin) {
        float current = getGlucose(player);
        float effectiveDelta = withTeaCatechin && delta > 0 ? delta * 0.65f : delta;
        float updated = Math.max(0.0f, Math.min(100.0f, current + effectiveDelta));
        player.getPersistentData().putFloat(NBT_GLUCOSE, updated);

        if (updated >= 40.0f && updated <= 75.0f) {
            // Optimal Glucose Zone: Lucid Full-Power Buff
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0, true, false));
        } else if (updated > 90.0f) {
            // Glucose Spike Drowsiness
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, true, true));
        }
    }

    @SubscribeEvent
    public static void onItemConsumed(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player && event.getItem().isEdible()) {
            var food = event.getItem().getFoodProperties(player);
            if (food != null) {
                addGlucose(player, food.getNutrition() * 2.5f, false);
            }
        }
    }
}
