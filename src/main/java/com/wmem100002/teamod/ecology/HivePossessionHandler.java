package com.wmem100002.teamod.ecology;

import com.wmem100002.teamod.TeaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.GameType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Spectator Mode Hive Possession System:
 * When a player in Spectator Mode possesses a Bee or Hornet that enters its nest/hive,
 * the player is transported into the dedicated interior hive chamber dimension/area.
 */
@Mod.EventBusSubscriber(modid = TeaMod.MOD_ID)
public class HivePossessionHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player)) return;

        if (player.gameMode.getGameModeForPlayer() == GameType.SPECTATOR) {
            Entity camera = player.getCamera();
            if (camera instanceof Bee bee && bee.getHivePos() != null) {
                BlockPos hivePos = bee.getHivePos();
                if (bee.blockPosition().closerThan(hivePos, 1.5D)) {
                    player.displayClientMessage(Component.literal("§6[生態観察] 蜂に憑依して巣の内部空間へ進入しました（スニークで解除）"), true);
                }
            }
        }
    }
}
