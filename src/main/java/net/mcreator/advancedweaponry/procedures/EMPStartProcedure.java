package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;

public class EMPStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.getXRot();
			entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HeadlockPitch = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getYRot();
			entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HeadlockYaw = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
