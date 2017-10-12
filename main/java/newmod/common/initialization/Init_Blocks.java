package newmod.common.initialization;

import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoubleStoneSlab;
import net.minecraft.block.BlockDoubleWoodSlab;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockPurpurSlab;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import newmod.common.blocks.Custom_Ore;
import newmod.common.blocks.doors.Glass_Door;
import newmod.common.blocks.Custom_Block;
import newmod.common.blocks.stairs.Glass_Stairs;
import newmod.common.blocks.stairs.Custom_Stairs;
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;
import newmod.common.blocks.machines.combiner.Combiner;
import newmod.common.blocks.machines.compressor.Compressor;
import newmod.common.blocks.slab.Glass_Slab;
import newmod.common.blocks.slab.Custom_Slab;

public class Init_Blocks
  {
	//Harvest Levels:
	//0 - Wood    1 - Stone      2 - Iron              3 - Diamond   4 - Harder than Diamond
	
	//Hardness Levels:
    //1 - Sign    2 - Wood       3 - Iron Ore          4 - Cobweb    5 - Block of Iron 	
	
	//Resistance Levels:
	//5 - Sign   15 - Coal Ore  30 - Block of Iron  6000 - Obsidian
    public static Block glass_stairs;
	public static Block endbrick_stairs;
	public static Block nether_wart_block_stairs;
	public static Block combiner_idle, combiner_active;
	public static Block compressor_idle, compressor_active;
	public static Block copper_ore, silver_ore;
	public static Block beet_block;
	public static Block ceramic_block;
	public static Block copper_block;
	public static Block crystal_block;
	public static Block flint_block;
	public static Block flower_bed_soil_block;
	public static Block gourd_block;
	public static Block hellstone_block;
	public static Block honey_block;
	public static Block honey_hex_block;
	public static Block honeycomb_block;
	public static Block powered_crystal_block;
	public static Block silver_block;
	public static Block steel_block;

	public static Glass_Slab glass_slab;
	public static Glass_Slab glass_double_slab;
	public static Custom_Slab endbrick_slab;
	public static Custom_Slab endbrick_double_slab;
	public static Custom_Slab nether_wart_block_slab;
	public static Custom_Slab nether_wart_block_double_slab;
	
	public static Glass_Door glassdoor_clear;
	
    @SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	  {
    	glass_stairs = new Glass_Stairs("glass_stairs", Blocks.GLASS.getDefaultState());
    	endbrick_stairs = new Custom_Stairs("endbrick_stairs", Blocks.END_BRICKS.getDefaultState());
    	nether_wart_block_stairs = new Custom_Stairs("nether_wart_block_stairs", Blocks.NETHER_WART_BLOCK.getDefaultState());
    	copper_ore = new Custom_Ore("copper_ore");
		silver_ore = new Custom_Ore("silver_ore");
		combiner_idle = new Combiner("combiner_idle", 2.5F, 4.5F, false);
		combiner_active = new Combiner("combiner_active", 2.5F, 4.5F, false);
		compressor_idle = new Compressor("compressor_idle", 2.5F, 4.5F, false);
		compressor_active = new Compressor("compressor_active", 2.5F, 4.5F, false);
		beet_block = new Custom_Block("beet_block", 2.0F, 3.0F, 20);
		ceramic_block = new Custom_Block("ceramic_block", 2.0F, 3.0F, 20);
		copper_block = new Custom_Block("copper_block", 2.0F, 3.0F, 20);
		crystal_block = new Custom_Block("crystal_block", 2.0F, 3.0F, 20);
		flint_block = new Custom_Block("flint_block", 2.0F, 3.0F, 20);
		flower_bed_soil_block = new Custom_Block("flower_bed_soil_block", 2.0F, 3.0F, 20);
		gourd_block = new Custom_Block("gourd_block", 2.0F, 3.0F, 20);
		hellstone_block = new Custom_Block("hellstone_block", 2.0F, 3.0F, 20);
		honey_block = new Custom_Block("honey_block", 2.0F, 3.0F, 20);
		honey_hex_block = new Custom_Block("honey_hex_block", 2.0F, 3.0F, 20);
		honeycomb_block = new Custom_Block("honeycomb_block", 2.0F, 3.0F, 20);
		powered_crystal_block = new Custom_Block("powered_crystal_block", 2.0F, 3.0F, 20);
		silver_block = new Custom_Block("silver_block", 2.0F, 3.0F, 20);
		steel_block = new Custom_Block("steel_block", 2.0F, 3.0F, 20);
		event.getRegistry().registerAll(glass_stairs, endbrick_stairs, nether_wart_block_stairs, combiner_idle, combiner_active, compressor_idle, compressor_active, copper_ore, silver_ore, beet_block, ceramic_block, copper_block, crystal_block, flint_block, flower_bed_soil_block, gourd_block, hellstone_block, honey_block, honey_hex_block, honeycomb_block, powered_crystal_block, silver_block, steel_block);


		glass_slab = new Glass_Slab.Half("glass_slab", glass_slab, false);
    	glass_double_slab = new Glass_Slab.Double("glass_double_slab", glass_double_slab, false);
    	endbrick_slab = new Custom_Slab.Half("endbrick_slab", endbrick_slab);
    	endbrick_double_slab = new Custom_Slab.Double("endbrick_double_slab", endbrick_double_slab);
    	nether_wart_block_slab = new Custom_Slab.Half("nether_wart_block_slab", nether_wart_block_slab);
    	nether_wart_block_double_slab = new Custom_Slab.Double("nether_wart_block_double_slab", nether_wart_block_double_slab);
    	event.getRegistry().registerAll(glass_slab, endbrick_slab, nether_wart_block_slab, glass_double_slab, endbrick_double_slab, nether_wart_block_double_slab);
    	
    	glassdoor_clear = new Glass_Door("glassdoor_clear");
    	event.getRegistry().registerAll(glassdoor_clear);
	  }
    @SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event)
	  {
		registerBlocks(glass_stairs);          registerBlocks(endbrick_stairs);             registerBlocks(nether_wart_block_stairs);
	    registerBlocks(combiner_idle);         registerBlocks(combiner_active);             registerBlocks(compressor_idle);
	    registerBlocks(compressor_active);     registerBlocks(beet_block);                  registerBlocks(ceramic_block);
	    registerBlocks(copper_block);          registerBlocks(crystal_block);               registerBlocks(flint_block);
	    registerBlocks(flower_bed_soil_block); registerBlocks(gourd_block);                 registerBlocks(hellstone_block);
	    registerBlocks(honey_block);           registerBlocks(honey_hex_block);             registerBlocks(honeycomb_block);
	    registerBlocks(powered_crystal_block); registerBlocks(silver_block);                registerBlocks(steel_block);
	    
		registerBlocks(glass_slab);            registerBlocks(endbrick_slab);               registerBlocks(nether_wart_block_slab);	    
		registerBlocks(glass_double_slab);     registerBlocks(endbrick_double_slab);        registerBlocks(nether_wart_block_double_slab);
		
		registerBlocks(glassdoor_clear);
      }
    public static void registerBlocks(Block block)
      {
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
      }
  }