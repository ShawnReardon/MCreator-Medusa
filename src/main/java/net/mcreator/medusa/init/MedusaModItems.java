
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.medusa.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.medusa.item.AppleArmorItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MedusaModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item APPLE_ARMOR_HELMET = register(new AppleArmorItem.Helmet());
	public static final Item APPLE_ARMOR_CHESTPLATE = register(new AppleArmorItem.Chestplate());
	public static final Item APPLE_ARMOR_LEGGINGS = register(new AppleArmorItem.Leggings());
	public static final Item APPLE_ARMOR_BOOTS = register(new AppleArmorItem.Boots());
	public static final Item STONE_COW = register(MedusaModBlocks.STONE_COW, null);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
