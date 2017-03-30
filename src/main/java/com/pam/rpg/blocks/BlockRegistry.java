package com.pam.rpg.blocks;

import java.util.HashMap;

import com.pam.rpg.blocks.harvestables.BlockBaseMiningNode;
import com.pam.rpg.blocks.harvestables.BlockBaseTree;

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

	public static final int copperMiningLevel = 1;
	public static final int tinMiningLevel = 1;
	public static final int nickelMiningLevel = 1;
	public static final int ironMiningLevel = 2;
	public static final int silverMiningLevel = 2;
	public static final int titaniumMiningLevel = 3;
	public static final int goldMiningLevel = 3;
	public static final int platinumMiningLevel = 4;
	
	// Trees
	public static final HashMap<String, BlockBaseTree> trees = new HashMap<String, BlockBaseTree>();
	public static final String chestnutTree = "chestnutTree";

	public static final int chestnutMiningLevel = 1;

	private static boolean initialized = false;

	public static void initBlockRegistry() {
		registerOre();
		registerWood();
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
	
	public static BlockBaseTree getTree(String treeName) {
		if(!initialized) {
			FMLLog.bigWarning("BlockRegistry has not been initialized yet.");
			return null;
		}

		if(!trees.containsKey(treeName)) {
			FMLLog.bigWarning("Tree %s is not registered.", treeName);
			return null;
		}

		return trees.get(treeName);
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

	private static void registerWood() {
		addTree(chestnutTree, chestnutMiningLevel);

	}

	private static void addMiningNode(String miningnodeName, int miningnodeLevel) {
		final BlockBaseMiningNode miningnode = new BlockBaseMiningNode(miningnodeName, miningnodeLevel);
		miningnodes.put(miningnodeName, miningnode);
		registerBlock(miningnodeName, miningnode);
	}
	
	private static void addTree(String treeName, int treeLevel) {
		final BlockBaseTree tree = new BlockBaseTree(treeName, treeLevel);
		trees.put(treeName, tree);
		registerBlock(treeName, tree);
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
