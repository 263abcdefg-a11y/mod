package com.wmem100002.teamod.ritual;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Seasonal Musical Instruments (Shinobue, Shime-Daiko, Biwa, Koto).
 * Playing the matching seasonal instrument combined with ritual dancing and tea offering
 * summons the Four Seasonal Bosses (Sakuyahime, Enrai-Shishi, Tsukuyomi-Kitsune, Hyomu-Gozen),
 * and also frightens away crop-damaging birds (Sparrows & Crows).
 */
public class SeasonalInstrumentItem extends Item {
    public enum SeasonType {
        SPRING("春風の篠笛", "桜花・茶樹の精霊王『咲耶姫』"),
        SUMMER("夏祭りの締太鼓", "烈火・雷鳴の獅子舞神『炎雷獅子』"),
        AUTUMN("秋月の琵琶", "豊穣・月光の狐神『月読狐』"),
        WINTER("冬雪の琴", "白銀・霧氷の雪女将軍『氷霧御前』");

        public final String instrumentName;
        public final String bossName;

        SeasonType(String instrumentName, String bossName) {
            this.instrumentName = instrumentName;
            this.bossName = bossName;
        }
    }

    private final SeasonType seasonType;

    public SeasonalInstrumentItem(SeasonType seasonType, Properties properties) {
        super(properties);
        this.seasonType = seasonType;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            serverLevel.playSound(null, player.blockPosition(), SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.PLAYERS, 1.2F, 1.0F);
            serverLevel.sendParticles(ParticleTypes.NOTE, player.getX(), player.getY() + 2.0, player.getZ(), 8, 0.5, 0.5, 0.5, 0.1);
            player.displayClientMessage(Component.literal("§d♪ " + seasonType.instrumentName + " を奏でた！（踊りステップとお茶のお供えで " + seasonType.bossName + " を召喚）"), true);
        }
        player.getCooldowns().addCooldown(this, 20);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
