package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ExoBootPowerReductionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).EBPower - 1;
			entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EBPower = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
