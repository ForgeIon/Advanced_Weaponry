package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ExoBootsFallDamageProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).EBPower >= 1) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
