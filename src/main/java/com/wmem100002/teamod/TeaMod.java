package com.wmem100002.teamod;

import com.mojang.logging.LogUtils;
import com.wmem100002.teamod.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * TeaMod Main Entry Point (Minecraft 1.20.1 Forge)
 * Author: wmem100002
 */
@Mod(TeaMod.MOD_ID)
public class TeaMod {
    public static final String MOD_ID = "teamod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TeaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFluids.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("TeaMod initialized successfully for Minecraft 1.20.1!");
    }
}
