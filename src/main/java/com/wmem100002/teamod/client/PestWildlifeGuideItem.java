package com.wmem100002.teamod.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Illustrated Field Guide to Crop Diseases, Pests, Harmful Birds & Wildlife (病害虫獣図鑑).
 */
public class PestWildlifeGuideItem extends Item {
    public PestWildlifeGuideItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            player.displayClientMessage(Component.literal(
                "§2【病害虫獣図鑑】§r いもち病(農林22号で耐性) / ウンカ・イネミズゾウムシ・ニカメイガ(カテキン防除・天敵カエル) / スズメバチ(煙で鎮静化) / カラス・スズメ(かかし・防鳥ネット・烏羽の弓)"
            ), false);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
