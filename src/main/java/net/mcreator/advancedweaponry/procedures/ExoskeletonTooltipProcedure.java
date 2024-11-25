package net.mcreator.advancedweaponry.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.advancedweaponry.init.AdvancedWeaponryModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ExoskeletonTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		double MaxPower = 0;
		if (itemstack.getItem() == AdvancedWeaponryModItems.EXOSKELETON_HELMET.get()) {
			tooltip.add(Component.literal("Helmet"));
		} else if (itemstack.getItem() == AdvancedWeaponryModItems.EXOSKELETON_CHESTPLATE.get()) {
			tooltip.add(Component.literal("Stores Power And Provides Extra Strength."));
			MaxPower = (itemstack.getOrCreateTag().getDouble("MaxPower") != 0) ? (itemstack.getOrCreateTag().getDouble("MaxPower")) : 24000;
			tooltip.add(Component.literal(("Contained Power: " + itemstack.getOrCreateTag().getDouble("StoredPower") + "/" + MaxPower)));
		} else if (itemstack.getItem() == AdvancedWeaponryModItems.EXOSKELETON_LEGGINGS.get()) {
			tooltip.add(Component.literal("Pants"));
		} else if (itemstack.getItem() == AdvancedWeaponryModItems.EXOSKELETON_BOOTS.get()) {
			tooltip.add(Component.literal("Boots"));
		}
	}
}
