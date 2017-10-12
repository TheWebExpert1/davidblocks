package newmod.common.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import newmod.common.fluids.Fluid_Base;
import newmod.common.initialization.Init_Blocks;

public class World_Generator implements IWorldGenerator
  {
	//World Generators
	private WorldGenerator copper;
	private WorldGenerator silver;
	private WorldGenerator oil;

	public World_Generator()
	  {
		copper = new WorldGenMinable(Init_Blocks.copper_ore.getDefaultState(), 8);
		silver = new WorldGenMinable(Init_Blocks.silver_ore.getDefaultState(), 8);
		oil = new WorldGenMinable(Fluid_Base.instance.getDefaultState(), 8);
	  }
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
	  {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++)
		  {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		  }
	  }
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
      {
		switch(world.provider.getDimension())
		 {
		   case 0: //Overworld  ..  chances to spawn .. minHeight .. maxHeight
		     this.runGenerator(copper, world, random, chunkX, chunkZ, 90, 0, 64);
		     this.runGenerator(silver, world, random, chunkX, chunkZ, 90, 0, 64);
		     this.runGenerator(oil, world, random, chunkX, chunkZ, 20, 0, 64);
		   case 1: //End
		   case -1: //Nether
		 }
	  }
  }