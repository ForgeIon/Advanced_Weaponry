
package net.mcreator.advancedweaponry.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;
import net.mcreator.advancedweaponry.client.model.Modelexoskeleton;

public class ExoskeletonEntityRenderer extends MobRenderer<ExoskeletonEntityEntity, Modelexoskeleton<ExoskeletonEntityEntity>> {
	public ExoskeletonEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelexoskeleton(context.bakeLayer(Modelexoskeleton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ExoskeletonEntityEntity entity) {
		return new ResourceLocation("advanced_weaponry:textures/entities/exotexture.png");
	}
}
