
package net.mcreator.advancedweaponry.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.advancedweaponry.entity.BeamEntityEntity;
import net.mcreator.advancedweaponry.client.model.Modelshittybeam;

public class BeamEntityRenderer extends MobRenderer<BeamEntityEntity, Modelshittybeam<BeamEntityEntity>> {
	public BeamEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelshittybeam(context.bakeLayer(Modelshittybeam.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(BeamEntityEntity entity) {
		return new ResourceLocation("advanced_weaponry:textures/entities/red.png");
	}
}
