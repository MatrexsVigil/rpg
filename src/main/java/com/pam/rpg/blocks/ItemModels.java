package com.pam.rpg.blocks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.pam.rpg.blocks.harvestables.BlockBaseMiningNode;
import com.pam.rpg.blocks.harvestables.BlockBaseTree;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemModels {
    private static final HashMap<Item, ItemModelList> models = new HashMap<Item, ItemModelList>();

    public static void preInit() {
        defineItemModels();
        prepareModels();
    }

    public static void init() {
        registerModels();
    }

    private static void defineItemModels() {

        for (BlockBaseMiningNode miningnode : BlockRegistry.miningnodes.values()) {
            registerItemModels(getItem(miningnode), new ItemModelList("miningnodes/")
                    .add(0, miningnode.getName()));
        }
        for (BlockBaseTree tree : BlockRegistry.trees.values()) {
            registerItemModels(getItem(tree), new ItemModelList("trees/")
                    .add(0, tree.getName()));
        }
    }

    private static void registerItemModels(Item item, ItemModelList list) {
        models.put(item, list);
    }

    private static void prepareModels() {
        for (Map.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            Collection<String> registrations = entry.getValue().getRegistrations().values();

            for (String registration : registrations) {
                if (item == null || registration == null) continue;

                ModelBakery.registerItemVariants(item, new ResourceLocation(registration));
            }
        }
    }

    private static void registerModels() {
        for (HashMap.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            HashMap<Integer, String> registrations = entry.getValue().getRegistrations();

            for (Map.Entry<Integer, String> registration : registrations.entrySet()) {
                int meta = registration.getKey();
                String path = registration.getValue();

                ModelResourceLocation resource = new ModelResourceLocation(path, "inventory");

                Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resource);
            }
        }
    }

    private static Item getItem(Block block) {
        return Item.getItemFromBlock(block);
    }
}
