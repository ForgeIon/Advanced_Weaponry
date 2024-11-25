
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advancedweaponry.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.advancedweaponry.network.ExitExoskeletonMessage;
import net.mcreator.advancedweaponry.AdvancedWeaponryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AdvancedWeaponryModKeyMappings {
	public static final KeyMapping EXIT_EXOSKELETON = new KeyMapping("key.advanced_weaponry.exit_exoskeleton", GLFW.GLFW_KEY_BACKSLASH, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EXIT_EXOSKELETON_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - EXIT_EXOSKELETON_LASTPRESS);
				AdvancedWeaponryMod.PACKET_HANDLER.sendToServer(new ExitExoskeletonMessage(1, dt));
				ExitExoskeletonMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long EXIT_EXOSKELETON_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(EXIT_EXOSKELETON);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				EXIT_EXOSKELETON.consumeClick();
			}
		}
	}
}
