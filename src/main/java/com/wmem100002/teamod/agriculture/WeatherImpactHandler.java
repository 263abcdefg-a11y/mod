package com.wmem100002.teamod.agriculture;

import com.wmem100002.teamod.TeaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;

/**
 * Realistic Weather (Rain & Thunderstorm) Environmental Impact Engine:
 * - Waterlogging / root rot check when rain persists without drainage blocks
 * - Wet tea leaves quality penalty if harvested in rain without roof/greenhouse
 * - Post-rain growth burst
 * - Teacup cooling & dilution when exposed to rain
 */
@Mod.EventBusSubscriber(modid = TeaMod.MOD_ID)
public class WeatherImpactHandler {

    public static boolean isExposedToRain(Level level, BlockPos pos) {
        return level.isRainingAt(pos.above());
    }

    public static boolean hasProperDrainage(Level level, BlockPos farmlandPos) {
        for (BlockPos offset : new BlockPos[]{farmlandPos.north(), farmlandPos.south(), farmlandPos.east(), farmlandPos.west()}) {
            if (level.getBlockState(offset).is(Blocks.GRAVEL) || level.getBlockState(offset).is(Blocks.COBBLESTONE)) {
                return true;
            }
        }
        return false;
    }
}
