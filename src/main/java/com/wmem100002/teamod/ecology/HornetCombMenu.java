package com.wmem100002.teamod.ecology;

import com.wmem100002.teamod.registry.ModItems;
import com.wmem100002.teamod.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/**
 * Tweezer Extraction Mini-Game Menu for Hornet Nests:
 * Extract Hornet Larvae and Pupae with precise timing without crushing them.
 */
public class HornetCombMenu extends AbstractContainerMenu {
    private int extractedCount = 0;

    public HornetCombMenu(int containerId, Inventory playerInv, FriendlyByteBuf extraData) {
        this(containerId, playerInv);
    }

    public HornetCombMenu(int containerId, Inventory playerInv) {
        super(ModMenuTypes.HORNET_COMB_MENU.get(), containerId);
    }

    public void performTweezerExtraction(Player player, boolean sweetSpotHit, boolean isPupa) {
        if (sweetSpotHit && extractedCount < 6) {
            extractedCount++;
            ItemStack reward = new ItemStack(isPupa ? ModItems.HORNET_PUPA.get() : ModItems.HORNET_LARVA.get());
            if (!player.getInventory().add(reward)) {
                player.drop(reward, false);
            }
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
