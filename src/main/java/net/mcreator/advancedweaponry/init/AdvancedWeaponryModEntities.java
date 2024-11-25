
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.entity.ExoskeletonEntityEntity;
import net.mcreator.advancedweaponry.entity.BeamEntityEntity;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvancedWeaponryModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AdvancedWeaponryMod.MODID);
	public static final RegistryObject<EntityType<BeamEntityEntity>> BEAM_ENTITY = register("beam_entity", EntityType.Builder.<BeamEntityEntity>of(BeamEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(BeamEntityEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ExoskeletonEntityEntity>> EXOSKELETON_ENTITY = register("exoskeleton_entity", EntityType.Builder.<ExoskeletonEntityEntity>of(ExoskeletonEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ExoskeletonEntityEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BeamEntityEntity.init();
			ExoskeletonEntityEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BEAM_ENTITY.get(), BeamEntityEntity.createAttributes().build());
		event.put(EXOSKELETON_ENTITY.get(), ExoskeletonEntityEntity.createAttributes().build());
	}
}
