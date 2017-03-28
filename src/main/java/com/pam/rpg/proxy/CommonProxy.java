package com.pam.rpg.proxy;

import com.pam.rpg.blocks.BlockRegistry;
import com.pam.rpg.events.MiningEventHandler;
import com.pam.rpg.item.ItemRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	BlockRegistry.initBlockRegistry();
        ItemRegistry.registerItems();
        onBlocksAndItemsLoaded();
    }

    public void init(FMLInitializationEvent e) {
    	//GameRegistry.registerWorldGenerator(new BushWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void onBlocksAndItemsLoaded() {
    	//HarvestCraft.config.configureGardenDrops();

        //GeneralOreRegistry.initOreRegistry();

        //RecipeRegistry.registerRecipes();
        //SeedDropRegistry.getSeedDrops();

        //MarketItems.registerItems();
        //ShippingBinItems.registerItems();
        PacketHandler.init();

        //GameRegistry.registerTileEntity(TileEntityApiary.class, "PamApiary");
        //MinecraftForge.EVENT_BUS.register(new MiningEventHandler());

    }
}
