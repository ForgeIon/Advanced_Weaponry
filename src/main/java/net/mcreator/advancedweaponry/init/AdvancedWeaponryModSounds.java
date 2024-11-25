
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

public class AdvancedWeaponryModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<SoundEvent> LASERDELTA = REGISTRY.register("laserdelta", () -> new SoundEvent(new ResourceLocation("advanced_weaponry", "laserdelta")));
	public static final RegistryObject<SoundEvent> METALCLICK = REGISTRY.register("metalclick", () -> new SoundEvent(new ResourceLocation("advanced_weaponry", "metalclick")));
	public static final RegistryObject<SoundEvent> MACHINEHUM = REGISTRY.register("machinehum", () -> new SoundEvent(new ResourceLocation("advanced_weaponry", "machinehum")));
	public static final RegistryObject<SoundEvent> MACHINESHUTDOWN = REGISTRY.register("machineshutdown", () -> new SoundEvent(new ResourceLocation("advanced_weaponry", "machineshutdown")));
}
