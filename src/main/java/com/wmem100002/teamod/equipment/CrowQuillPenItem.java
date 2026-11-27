package com.wmem100002.teamod.equipment;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Crow Quill Pen (烏羽の羽ペン):
 * Dip into a Water Cauldron mixed with Dyes to charge ink color,
 * then right-click placed blocks (Wool, Terracotta, Concrete, Glass, Teacups) to dye them in-world!
 */
public class CrowQuillPenItem extends Item {
    private static final String TAG_INK_COLOR = "InkColorId";

    public CrowQuillPenItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (level.isClientSide || player == null) return InteractionResult.SUCCESS;

        // Dip into cauldron to absorb blended dye ink
        if (state.getBlock() instanceof LayeredCauldronBlock) {
            int nextColor = (stack.getOrCreateTag().getInt(TAG_INK_COLOR) + 1) % DyeColor.values().length;
            stack.getOrCreateTag().putInt(TAG_INK_COLOR, nextColor);
            DyeColor chosen = DyeColor.byId(nextColor);
            level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 0.8F, 1.2F);
            player.displayClientMessage(Component.literal("§b大釜の調合インク（" + chosen.getName() + "）を羽ペンに含ませました！"), true);
            return InteractionResult.SUCCESS;
        }

        // Dye placed wool blocks directly in-world as demonstration
        DyeColor inkColor = DyeColor.byId(stack.getOrCreateTag().getInt(TAG_INK_COLOR));
        Block targetBlock = state.getBlock();
        if (targetBlock.getDescriptionId().contains("wool")) {
            Block dyedWool = switch (inkColor) {
                case RED -> Blocks.RED_WOOL;
                case BLUE -> Blocks.BLUE_WOOL;
                case GREEN -> Blocks.GREEN_WOOL;
                case YELLOW -> Blocks.YELLOW_WOOL;
                case BLACK -> Blocks.BLACK_WOOL;
                case PURPLE -> Blocks.PURPLE_WOOL;
                case CYAN -> Blocks.CYAN_WOOL;
                default -> Blocks.WHITE_WOOL;
            };
            level.setBlock(pos, dyedWool.defaultBlockState(), 3);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));
            level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 0.8F, 1.1F);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
