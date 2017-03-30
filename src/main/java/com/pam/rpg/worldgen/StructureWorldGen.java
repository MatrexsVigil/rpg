package com.pam.rpg.worldgen;

import java.util.Random;

import com.pam.rpg.Reference;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureWorldGen implements IWorldGenerator
{

public static final ResourceLocation start = new ResourceLocation(Reference.MODID, "start");

@Override
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		
		WorldServer serverworld = (WorldServer)world;
		BlockPos playerspawn = serverworld.provider.getSpawnPoint();
		if (!playerspawn.equals(new BlockPos(0, 0, 0)))
			this.generateStart(serverworld, playerspawn);
		
}

public void generateStart(WorldServer world, BlockPos pos) {
	
	MinecraftServer server = world.getMinecraftServer();
	Template template = world.getStructureTemplateManager().getTemplate(server, start);
	PlacementSettings settings = new PlacementSettings();
	settings.setRotation(Rotation.NONE);
	
	BlockPos newPos = pos.add(0,0,0);
	RFCWorldInfo.getInstance().setStructureGenerated(true);
	template.addBlocksToWorld(world, newPos, settings);
	
	//LogRFC.debug("Structure generated at: " + newPos.toString() + " in world: " + world.getSaveHandler().getWorldDirectory().getName());
}
    
	
}