package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.advancedweaponry.init.AdvancedWeaponryModEntities;
import net.mcreator.advancedweaponry.entity.BeamEntityEntity;

public class BeamRifleShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Vec3 targetPosition = Vec3.ZERO;
		Vec3 TestVector = Vec3.ZERO;
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(2, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		Vec3 startPosition = entity.getEyePosition(1f); // Get the entity's eye position.
		Vec3 direction = entity.getViewVector(1f).scale(25); // Get the view vector and scale it by 25.
		targetPosition = startPosition.add(direction); // Add the scaled vector to the start position.
		if (world instanceof ServerLevel _serverLevel) {
			Entity entityinstance = new BeamEntityEntity(AdvancedWeaponryModEntities.BEAM_ENTITY.get(), _serverLevel);
			entityinstance.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360.0F, 0.0F);
			if (entityinstance instanceof Mob)
				((Mob) entityinstance).finalizeSpawn(_serverLevel, _serverLevel.getCurrentDifficultyAt(entityinstance.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			if (entityinstance instanceof BeamEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BeamEntityEntity.DATA_Target_X, (int) targetPosition.x());
			if (entityinstance instanceof BeamEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BeamEntityEntity.DATA_Target_Y, (int) targetPosition.y());
			if (entityinstance instanceof BeamEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BeamEntityEntity.DATA_Target_Z, (int) targetPosition.z());
			if (entityinstance instanceof TamableAnimal _toTame && entity instanceof Player _owner)
				_toTame.tame(_owner);
			entityinstance.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((targetPosition.x()), (targetPosition.y()), (targetPosition.z())));
			_serverLevel.addFreshEntity(entityinstance);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:laserdelta")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:laserdelta")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
		TestVector = new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - x),
				(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - y),
				(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - z));
		TestVector = TestVector.normalize();
		TestVector = TestVector.scale(0.2);
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - TestVector.x()), (entity.getDeltaMovement().y() - TestVector.y()), (entity.getDeltaMovement().z() - TestVector.z())));
	}
}
