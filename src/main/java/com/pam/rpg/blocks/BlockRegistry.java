package com.pam.rpg.blocks;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class BlockRegistry {

	// Market block
	//public static final String marketItemName = "market";
	//public static Block pamMarket;
	//public static ItemBlock marketItemBlock;

	// Mining Nodes
	public static final HashMap<String, BlockBaseMiningNode> miningnodes = new HashMap<String, BlockBaseMiningNode>();
	public static final String copperMiningNode = "copperMiningNode";
	public static final String tinMiningNode = "tinMiningNode";
	public static final String nickelMiningNode = "nickelMiningNode";
	public static final String ironMiningNode = "ironMiningNode";
	public static final String silverMiningNode = "silverMiningNode";
	public static final String titaniumMiningNode = "titaniumMiningNode";
	public static final String goldMiningNode = "goldMiningNode";
	public static final String platinumMiningNode = "platinumMiningNode";
	
	public static final HashMap<Integer, BlockBaseMiningNode> mininglevels = new HashMap<Integer, BlockBaseMiningNode>();
	public static final int copperMiningLevel = 1;
	public static final int tinMiningLevel = 1;
	public static final int nickelMiningLevel = 1;
	public static final int ironMiningLevel = 2;
	public static final int silverMiningLevel = 2;
	public static final int titaniumMiningLevel = 3;
	public static final int goldMiningLevel = 3;
	public static final int platinumMiningLevel = 4;

	private static boolean initialized = false;

	public static void initBlockRegistry() {
		registerOre();
		initialized = true;
	}

	public static BlockBaseMiningNode getMiningNode(String miningnodeName) {
		if(!initialized) {
			FMLLog.bigWarning("BlockRegistry has not been initialized yet.");
			return null;
		}

		if(!miningnodes.containsKey(miningnodeName)) {
			FMLLog.bigWarning("Mining Node %s is not registered.", miningnodeName);
			return null;
		}

		return miningnodes.get(miningnodeName);
	}


	private static void registerOre() {
		addMiningNode(copperMiningNode, copperMiningLevel);
		addMiningNode(tinMiningNode, tinMiningLevel);
		addMiningNode(nickelMiningNode, nickelMiningLevel);
		addMiningNode(ironMiningNode, ironMiningLevel);
		addMiningNode(silverMiningNode, silverMiningLevel);
		addMiningNode(goldMiningNode, goldMiningLevel);
		addMiningNode(titaniumMiningNode, titaniumMiningLevel);
		addMiningNode(platinumMiningNode, platinumMiningLevel);
	}



	private static void addMiningNode(String miningnodeName, int miningnodeLevel) {
		final BlockBaseMiningNode miningnode = new BlockBaseMiningNode(miningnodeName, miningnodeLevel);
		miningnodes.put(miningnodeName, miningnode);
	}

	public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
		block.setRegistryName(registerName);
		block.setUnlocalizedName(registerName);
		GameRegistry.register(block);

		if(itemBlock != null) {
			itemBlock.setRegistryName(registerName);
			itemBlock.setUnlocalizedName(registerName);
			GameRegistry.register(itemBlock);
		}
	}

	public static void registerBlock(String registerName, Block block) {
		registerBlock(registerName, new ItemBlock(block), block);
	}
}
