
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.advancedweaponry.client.model.Modelshittybeam;
import net.mcreator.advancedweaponry.client.model.Modelexoskeleton;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AdvancedWeaponryModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelexoskeleton.LAYER_LOCATION, Modelexoskeleton::createBodyLayer);
		event.registerLayerDefinition(Modelshittybeam.LAYER_LOCATION, Modelshittybeam::createBodyLayer);
	}
}
