
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.advancedweaponry.potion.EMPMobEffect;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

public class AdvancedWeaponryModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<MobEffect> EMP = REGISTRY.register("emp", () -> new EMPMobEffect());
}
