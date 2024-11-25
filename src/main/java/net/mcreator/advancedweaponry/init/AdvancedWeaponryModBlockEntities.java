
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.advancedweaponry.block.entity.ExoskeletonChargerBlockEntity;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

public class AdvancedWeaponryModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> EXOSKELETON_CHARGER = register("exoskeleton_charger", AdvancedWeaponryModBlocks.EXOSKELETON_CHARGER, ExoskeletonChargerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
