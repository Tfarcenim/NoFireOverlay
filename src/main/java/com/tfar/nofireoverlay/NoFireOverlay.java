package com.tfar.nofireoverlay;

import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NoFireOverlay.MODID)
public class NoFireOverlay
{
    public static final String MODID = "nofireoverlay";

    public NoFireOverlay() {
        DistExecutor.runWhenOn(Dist.CLIENT,() -> () -> MinecraftForge.EVENT_BUS.addListener(this::no));
    }
    private void no(final RenderBlockOverlayEvent event) {
        if (event.getPlayer().isPotionActive(Effects.FIRE_RESISTANCE) && event.getPlayer().isBurning()){
            event.setCanceled(true);
        }
    }
}
