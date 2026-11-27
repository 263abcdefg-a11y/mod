package com.wmem100002.teamod.client;

import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Read-Only Developer Blog Book (wmem100002).
 * Only editable via ブログ的な本の内容.json (updates.json) by the mod developer.
 */
public class TeaDevBlogItem extends Item {
    public TeaDevBlogItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            player.sendSystemMessage(Component.literal("§6=== TeaMod 開発者ブログ (Author: wmem100002 / 編集不可) ==="));
            player.sendSystemMessage(Component.literal("§aYouTube: https://www.youtube.com/@wmem100002")
                    .setStyle(Style.EMPTY.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.youtube.com/@wmem100002"))));
            player.sendSystemMessage(Component.literal("§bX (Twitter): https://x.com/wmem100002")
                    .setStyle(Style.EMPTY.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://x.com/wmem100002"))));
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
