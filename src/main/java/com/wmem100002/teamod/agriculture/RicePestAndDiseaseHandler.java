package com.wmem100002.teamod.agriculture;

import com.wmem100002.teamod.TeaMod;
import com.wmem100002.teamod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

/**
 * Handles Rice Blast, Sheath Blight, Planthoppers, Rice Water Weevils, and Stem Borers.
 * Features stylized field-guide pest representation, natural predators (Frogs/Spiders),
 * and Tea Catechin Spray organic control.
 */
@Mod.EventBusSubscriber(modid = TeaMod.MOD_ID)
public class RicePestAndDiseaseHandler {

    public enum PestOrDisease {
        NONE("健全", "健康な生育状態です"),
        RICE_BLAST("いもち病", "長雨・多湿で発生。農林22号は強い抵抗性を持ちます。カテキンスプレーで防除可能。"),
        SHEATH_BLIGHT("紋枯病", "高温多湿・密植で発生。中干し（水抜き）で予防・軽減できます。"),
        PLANTHOPPER("ウンカ類", "夏に飛来する吸汁害虫（図鑑アイコン表示）。カエルやクモが捕食、またはカテキン防除が有効。"),
        WATER_WEEVIL("イネミズゾウムシ", "田植え初期に発生。中干しとカテキンスプレーで防除可能。"),
        STEM_BORER("ニカメイガ", "茎に潜む害虫（白い綿毛サイン表示）。カテキン防除スプレーで撃退可能。");

        public final String name;
        public final String guideNote;

        PestOrDisease(String name, String guideNote) {
            this.name = name;
            this.guideNote = guideNote;
        }
    }

    /**
     * Checks whether natural predators (Frogs or Spiders) are patrolling nearby paddy fields.
     */
    public static boolean hasNaturalPredatorNearby(ServerLevel level, BlockPos pos) {
        AABB searchBox = new AABB(pos).inflate(8.0D);
        List<Frog> frogs = level.getEntitiesOfClass(Frog.class, searchBox);
        List<Spider> spiders = level.getEntitiesOfClass(Spider.class, searchBox);
        return !frogs.isEmpty() || !spiders.isEmpty();
    }

    /**
     * Applies Tea Catechin Spray to cure diseases and repel stylized pests.
     */
    @SubscribeEvent
    public static void onUseCatechinSpray(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        if (stack.is(ModItems.CATECHIN_SPRAY.get()) && !event.getLevel().isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) event.getLevel();
            BlockPos pos = event.getPos();
            serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                    pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5,
                    12, 0.4, 0.3, 0.4, 0.05);
            serverLevel.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.PLAYERS, 0.6F, 1.4F);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(event.getHand()));
            player.displayClientMessage(Component.literal("§aカテキン防除液を散布し、病害虫を予防・撃退しました！"), true);
        }
    }
}
