package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.advancedweaponry.init.AdvancedWeaponryModMobEffects;

public class Self_EMPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(AdvancedWeaponryModMobEffects.EMP.get(), (int) (60 * 20), 0));
	}
}
