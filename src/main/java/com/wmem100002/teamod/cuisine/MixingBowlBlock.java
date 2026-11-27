package com.wmem100002.teamod.cuisine;

import com.wmem100002.teamod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Mixing Bowl for Soft Serve Ice Cream & Whipped Cream:
 * Put Sugar + Honey + Fresh Cream into the bowl, whisk to aerate/chill,
 * then scoop with a Waffle Cone to create Soft Serve Ice Cream!
 */
public class MixingBowlBlock extends Block {
    public MixingBowlBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        ItemStack held = player.getItemInHand(hand);
        if (held.is(Items.SUGAR) || held.is(Items.HONEY_BOTTLE) || held.is(ModItems.FRESH_CREAM.get())) {
            player.displayClientMessage(Component.literal("§eボウルに材料を投入しました（砂糖＋はちみつ＋生クリームを混ぜて泡立てます）"), true);
            return InteractionResult.CONSUME;
        }
        if (held.is(ModItems.WAFFLE_CONE.get())) {
            held.shrink(1);
            ItemStack softServe = new ItemStack(ModItems.SOFT_SERVE_ICE_CREAM.get());
            if (!player.getInventory().add(softServe)) {
                player.drop(softServe, false);
            }
            player.displayClientMessage(Component.literal("§b極上のソフトクリームを盛り付けました！"), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
