package com.wmem100002.teamod.equipment;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;

/**
 * Crow Feather Hunting Bow:
 * Crafted with Crow Feathers & Tea Ingots. Fires high-velocity low-drop arrows
 * ideal for hunting crop-damaging Crows and Sparrows.
 */
public class CrowFeatherBowItem extends BowItem {
    public CrowFeatherBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        arrow.setBaseDamage(arrow.getBaseDamage() * 1.25D);
        return arrow;
    }
}
