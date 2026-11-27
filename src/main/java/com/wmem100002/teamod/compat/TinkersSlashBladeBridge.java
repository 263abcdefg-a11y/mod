package com.wmem100002.teamod.compat;

import com.wmem100002.teamod.TeaMod;
import net.minecraftforge.fml.ModList;

/**
 * Cross-Mod Integration Bridge for:
 * - Create (Mechanical Mixer, Blaze Burner, Jetpack & non-Jetpack alternatives)
 * - Tinkers' Construct (Tea Ingot & Tea Steel 3-part Bio-Alloy Smeltery recipes)
 * - SlashBlade & Tinkers-SlashBlade Addons (Chasen-maru, Awadate-maru, custom enchantments)
 */
public class TinkersSlashBladeBridge {
    public static boolean isCreateLoaded() { return ModList.get().isLoaded("create"); }
    public static boolean isTinkersLoaded() { return ModList.get().isLoaded("tconstruct"); }
    public static boolean isSlashBladeLoaded() { return ModList.get().isLoaded("slashblade"); }

    public static void logActiveIntegrations() {
        TeaMod.LOGGER.info("Compat Status -> Create: {}, Tinkers: {}, SlashBlade: {}",
                isCreateLoaded(), isTinkersLoaded(), isSlashBladeLoaded());
    }
}
