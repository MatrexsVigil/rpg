package com.pam.rpg.item;

import java.util.HashMap;
import java.util.HashSet;

import com.pam.rpg.rpg;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ItemRegistry {
	public static final HashMap<String, Item> items = new HashMap<String, Item>();

	// Items
	

	public static boolean initialized = false;

	public static void registerItems() {
		registerFoodItems();
		initialized = true;
	}



	private static void registerFoodItems() {
	}


	

	private static Item registerGenericItem(String registryName) {
		final Item item = new Item();

		return registerItem(item, registryName);
	}


	public static Item registerItem(Item item, String registryName) {
		item.setCreativeTab(rpg.modTab);
		item.setRegistryName(registryName);
		item.setUnlocalizedName(registryName);

		items.put(registryName, item);

		return GameRegistry.register(item);
	}
}
