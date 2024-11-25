package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.advancedweaponry.init.AdvancedWeaponryModMobEffects;
import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;

public class ExoChestplateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof ExoskeletonEntityEntity)) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(AdvancedWeaponryModMobEffects.EMP.get()) : false)) {
				if (itemstack.getOrCreateTag().getDouble("StoredPower") >= 1) {
					itemstack.getOrCreateTag().putDouble("StoredPower", (itemstack.getOrCreateTag().getDouble("StoredPower") - 1));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machinehum")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machinehum")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					itemstack.getOrCreateTag().putBoolean("ShutdownToPlay", true);
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0));
				} else {
					if (itemstack.getOrCreateTag().getBoolean("ShutdownToPlay")) {
						itemstack.getOrCreateTag().putBoolean("ShutdownToPlay", false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			} else {
				if (itemstack.getOrCreateTag().getBoolean("ShutdownToPlay")) {
					itemstack.getOrCreateTag().putBoolean("ShutdownToPlay", false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("advanced_weaponry:machineshutdown")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
