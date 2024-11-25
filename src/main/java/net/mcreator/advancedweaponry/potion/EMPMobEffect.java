
package net.mcreator.advancedweaponry.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.advancedweaponry.procedures.EMP_TickProcedure;
import net.mcreator.advancedweaponry.procedures.EMPStartProcedure;

public class EMPMobEffect extends MobEffect {
	public EMPMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13369345);
	}

	@Override
	public String getDescriptionId() {
		return "effect.advanced_weaponry.emp";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		EMPStartProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EMP_TickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
