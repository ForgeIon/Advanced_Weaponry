package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.advancedweaponry.init.AdvancedWeaponryModMobEffects;
import net.mcreator.advancedweaponry.init.AdvancedWeaponryModItems;
import net.mcreator.advancedweaponry.init.AdvancedWeaponryModEntities;
import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;

public class ExitExoskeletonProcedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == AdvancedWeaponryModItems.EXOSKELETON_BOOTS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == AdvancedWeaponryModItems.EXOSKELETON_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == AdvancedWeaponryModItems.EXOSKELETON_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == AdvancedWeaponryModItems.EXOSKELETON_HELMET.get()) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entityinstance = new ExoskeletonEntityEntity(AdvancedWeaponryModEntities.EXOSKELETON_ENTITY.get(), _serverLevel);
				entityinstance.moveTo(x, y, z, world.getRandom().nextFloat() * 360.0F, 0.0F);
				if (entityinstance instanceof Mob)
					((Mob) entityinstance).finalizeSpawn(_serverLevel, _serverLevel.getCurrentDifficultyAt(entityinstance.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(AdvancedWeaponryModMobEffects.EMP.get()) : false) {
					if (entityinstance instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(AdvancedWeaponryModMobEffects.EMP.get(),
								entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AdvancedWeaponryModMobEffects.EMP.get()) ? _livEnt.getEffect(AdvancedWeaponryModMobEffects.EMP.get()).getDuration() : 0, 0, true, false));
				}
				{
					Entity _entity = entityinstance;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entityinstance;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entityinstance;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entityinstance;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
					}
				}
				{
					Entity _ent = entityinstance;
					_ent.setYRot(entity.getYRot());
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				_serverLevel.addFreshEntity(entityinstance);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(AdvancedWeaponryModMobEffects.EMP.get());
		}
	}
}
