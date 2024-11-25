package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;

public class EMP_TickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Vec3 Vector2 = Vec3.ZERO;
		Vector2 = (Vec3.directionFromRotation((float) (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).HeadlockPitch,
				(float) (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).HeadlockYaw))
				.lerp((Vec3.directionFromRotation(entity.getXRot(), entity.getYRot())), 0.35);
		{
			double _setval = (new Object() {
				public double yaw(Vec3 _vec3) {
					double _yaw = 0.0D;
					double _d0 = _vec3.horizontalDistance();
					double _sgn = _vec3.x() >= 0.0D ? -1.0D : 1.0D;
					if (_d0 > 0.0D) {
						_yaw = Math.toDegrees(_sgn * Math.acos(_vec3.z() / _d0));
					}
					return _yaw;
				}
			}).yaw(Vector2);
			entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HeadlockYaw = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (new Object() {
				public double pitch(Vec3 _vec3) {
					double _pitch = 0.0D;
					double _d0 = _vec3.length();
					if (_d0 > 0.0D) {
						_pitch = Math.toDegrees(Math.acos(_vec3.y() / _d0)) - 90.0D;
					}
					return _pitch;
				}
			}).pitch(Vector2);
			entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HeadlockPitch = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
