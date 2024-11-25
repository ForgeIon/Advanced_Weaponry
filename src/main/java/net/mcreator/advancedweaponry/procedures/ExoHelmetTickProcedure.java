package net.mcreator.advancedweaponry.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;
import net.mcreator.advancedweaponry.init.AdvancedWeaponryModMobEffects;
import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;

public class ExoHelmetTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack NewChestplate = ItemStack.EMPTY;
		if (!(entity instanceof ExoskeletonEntityEntity)) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(AdvancedWeaponryModMobEffects.EMP.get()) : false) {
				{
					Entity _ent = entity;
					_ent.setYRot((float) (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).HeadlockYaw);
					_ent.setXRot((float) (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).HeadlockPitch);
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			} else {
				NewChestplate = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
				if (NewChestplate.getOrCreateTag().getDouble("StoredPower") >= 1) {
					NewChestplate.getOrCreateTag().putDouble("StoredPower", (NewChestplate.getOrCreateTag().getDouble("StoredPower") - 1));
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, NewChestplate);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, NewChestplate);
						}
					}
					{
						double _setval = -1;
						entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ScreenshakeTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
