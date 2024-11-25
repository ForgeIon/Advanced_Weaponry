package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;

public class ExoskeletonEquipCooldownProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ExoskeletonEntityEntity _datEntI ? _datEntI.getEntityData().get(ExoskeletonEntityEntity.DATA_EquipCooldown) : 0) >= 1) {
			if (entity instanceof ExoskeletonEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ExoskeletonEntityEntity.DATA_EquipCooldown, (int) ((entity instanceof ExoskeletonEntityEntity _datEntI ? _datEntI.getEntityData().get(ExoskeletonEntityEntity.DATA_EquipCooldown) : 0) - 1));
		}
		entity.setDeltaMovement(new Vec3(0, (-0.1), 0));
	}
}
