package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.advancedweaponry.entity.BeamEntityEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class BeamMovementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Vec3 TestVector = Vec3.ZERO;
		Vec3 Vector2 = Vec3.ZERO;
		if (true) {
			Vector2 = (new Vec3(x, y, z)).lerp((new Vec3((entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_X) : 0),
					(entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_Y) : 0), (entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_Z) : 0))),
					0.2);
			{
				Entity _ent = entity;
				_ent.teleportTo((Vector2.x()), (Vector2.y()), (Vector2.z()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((Vector2.x()), (Vector2.y()), (Vector2.z()), _ent.getYRot(), _ent.getXRot());
			}
			if ((new Vec3(x, y, z)).distanceTo((new Vec3((entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_X) : 0),
					(entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_Y) : 0),
					(entity instanceof BeamEntityEntity _datEntI ? _datEntI.getEntityData().get(BeamEntityEntity.DATA_Target_Z) : 0)))) <= 3) {
				if (!entity.level.isClientSide())
					entity.discard();
			}
		}
		if (true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
						entityiterator.hurt(new EntityDamageSource("on_fire", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 3);
					}
				}
			}
		}
	}
}
