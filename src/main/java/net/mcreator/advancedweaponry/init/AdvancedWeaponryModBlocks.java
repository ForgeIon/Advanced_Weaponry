
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.advancedweaponry.block.ExoskeletonChargerBlock;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

public class AdvancedWeaponryModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<Block> EXOSKELETON_CHARGER = REGISTRY.register("exoskeleton_charger", () -> new ExoskeletonChargerBlock());
}
