
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.advancedweaponry.item.ExoskeletonItem;
import net.mcreator.advancedweaponry.item.EMPGrenadeItem;
import net.mcreator.advancedweaponry.item.BeamRifleItem;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

public class AdvancedWeaponryModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<Item> EXOSKELETON_HELMET = REGISTRY.register("exoskeleton_helmet", () -> new ExoskeletonItem.Helmet());
	public static final RegistryObject<Item> EXOSKELETON_CHESTPLATE = REGISTRY.register("exoskeleton_chestplate", () -> new ExoskeletonItem.Chestplate());
	public static final RegistryObject<Item> EXOSKELETON_LEGGINGS = REGISTRY.register("exoskeleton_leggings", () -> new ExoskeletonItem.Leggings());
	public static final RegistryObject<Item> EXOSKELETON_BOOTS = REGISTRY.register("exoskeleton_boots", () -> new ExoskeletonItem.Boots());
	public static final RegistryObject<Item> BEAM_RIFLE = REGISTRY.register("beam_rifle", () -> new BeamRifleItem());
	public static final RegistryObject<Item> EXOSKELETON_ENTITY_SPAWN_EGG = REGISTRY.register("exoskeleton_entity_spawn_egg",
			() -> new ForgeSpawnEggItem(AdvancedWeaponryModEntities.EXOSKELETON_ENTITY, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> EMP_GRENADE = REGISTRY.register("emp_grenade", () -> new EMPGrenadeItem());
	public static final RegistryObject<Item> EXOSKELETON_CHARGER = block(AdvancedWeaponryModBlocks.EXOSKELETON_CHARGER, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
