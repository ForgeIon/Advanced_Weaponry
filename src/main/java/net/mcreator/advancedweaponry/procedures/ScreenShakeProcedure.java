package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.advancedweaponry.network.AdvancedWeaponryModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ScreenShakeProcedure {
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
		if ((entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).ScreenshakeTicks >= 1) {
			{
				double _setval = (entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdvancedWeaponryModVariables.PlayerVariables())).ScreenshakeTicks - 1;
				entity.getCapability(AdvancedWeaponryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ScreenshakeTicks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
				_ent.setXRot((float) (entity.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
	}
}
