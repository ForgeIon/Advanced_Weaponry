
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.advancedweaponry.client.renderer.ExoskeletonEntityRenderer;
import net.mcreator.advancedweaponry.client.renderer.BeamEntityRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AdvancedWeaponryModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AdvancedWeaponryModEntities.BEAM_ENTITY.get(), BeamEntityRenderer::new);
		event.registerEntityRenderer(AdvancedWeaponryModEntities.EXOSKELETON_ENTITY.get(), ExoskeletonEntityRenderer::new);
	}
}
