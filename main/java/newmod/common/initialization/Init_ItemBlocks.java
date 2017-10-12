package newmod.common.initialization;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import newmod.common.blocks.Custom_ItemBlock;
import newmod.common.blocks.slab.Glass_Slab;
import newmod.common.blocks.stairs.Glass_Stairs;

public class Init_ItemBlocks
  {
    public static ItemBlock glass_stairs;
	public static ItemBlock endbrick_stairs;
	public static ItemBlock nether_wart_block_stairs;
	public static ItemBlock combiner_idle, combiner_active;
	public static ItemBlock compressor_idle, compressor_active;
	public static ItemBlock copper_ore, silver_ore;
	public static ItemBlock beet_block;
	public static ItemBlock ceramic_block;
	public static ItemBlock copper_block;
	public static ItemBlock crystal_block;
	public static ItemBlock flint_block;
	public static ItemBlock flower_bed_soil_block;
	public static ItemBlock gourd_block;
	public static ItemBlock hellstone_block;
	public static ItemBlock honey_block;
	public static ItemBlock honey_hex_block;
	public static ItemBlock honeycomb_block;
	public static ItemBlock powered_crystal_block;
	public static ItemBlock silver_block;
	public static ItemBlock steel_block;

    public static Item glass_slab;
	public static Item endbrick_slab;
	public static Item nether_wart_block_slab;
	
	public static Item glassdoor_clear;

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	  {
		//Here we're registering ItemBlocks for each of the Blocks we've created 
    	glass_stairs = new Custom_ItemBlock("glass_stairs", Init_Blocks.glass_stairs);
    	endbrick_stairs = new Custom_ItemBlock("endbrick_stairs", Init_Blocks.endbrick_stairs);
    	nether_wart_block_stairs = new Custom_ItemBlock("nether_wart_block_stairs", Init_Blocks.nether_wart_block_stairs);
    	combiner_idle = new Custom_ItemBlock("combiner_idle", Init_Blocks.combiner_idle);
    	combiner_active = new Custom_ItemBlock("combiner_active", Init_Blocks.combiner_active);
    	compressor_idle = new Custom_ItemBlock("compressor_idle", Init_Blocks.compressor_idle);
    	compressor_active = new Custom_ItemBlock("compressor_active", Init_Blocks.compressor_active);
    	copper_ore = new Custom_ItemBlock("copper_ore", Init_Blocks.copper_ore);
    	silver_ore = new Custom_ItemBlock("silver_ore", Init_Blocks.silver_ore);
    	beet_block = new Custom_ItemBlock("beet_block", Init_Blocks.beet_block);
    	ceramic_block = new Custom_ItemBlock("ceramic_block", Init_Blocks.ceramic_block);
    	copper_block = new Custom_ItemBlock("copper_block", Init_Blocks.copper_block);
    	crystal_block = new Custom_ItemBlock("crystal_block", Init_Blocks.crystal_block);
    	flint_block = new Custom_ItemBlock("flint_block", Init_Blocks.flint_block);
    	flower_bed_soil_block = new Custom_ItemBlock("flower_bed_soil_block", Init_Blocks.flower_bed_soil_block);
    	gourd_block = new Custom_ItemBlock("gourd_block", Init_Blocks.gourd_block);
    	hellstone_block = new Custom_ItemBlock("hellstone_block", Init_Blocks.hellstone_block);
    	honey_block = new Custom_ItemBlock("honey_block", Init_Blocks.honey_block);
    	honey_hex_block = new Custom_ItemBlock("honey_hex_block", Init_Blocks.honey_hex_block);
    	honeycomb_block = new Custom_ItemBlock("honeycomb_block", Init_Blocks.honeycomb_block);
    	powered_crystal_block = new Custom_ItemBlock("powered_crystal_block", Init_Blocks.powered_crystal_block);
    	silver_block = new Custom_ItemBlock("silver_block", Init_Blocks.silver_block);
    	steel_block = new Custom_ItemBlock("steel_block", Init_Blocks.steel_block);
    	event.getRegistry().registerAll(glass_stairs, endbrick_stairs, nether_wart_block_stairs, combiner_idle, compressor_idle, beet_block, ceramic_block, copper_block, crystal_block, flint_block, flower_bed_soil_block, gourd_block, hellstone_block, honey_block, honey_hex_block, honeycomb_block, powered_crystal_block, silver_block, steel_block);

		glass_slab = new ItemSlab(Init_Blocks.glass_slab, Init_Blocks.glass_slab, Init_Blocks.glass_double_slab).setUnlocalizedName("glass_slab").setRegistryName("glass_slab");
 		endbrick_slab = new ItemSlab(Init_Blocks.endbrick_slab, Init_Blocks.endbrick_slab, Init_Blocks.endbrick_double_slab).setUnlocalizedName("endbrick_slab").setRegistryName("endbrick_slab");
		nether_wart_block_slab = new ItemSlab(Init_Blocks.nether_wart_block_slab, Init_Blocks.nether_wart_block_slab, Init_Blocks.nether_wart_block_double_slab).setUnlocalizedName("nether_wart_block_slab").setRegistryName("nether_wart_block_slab");
    	event.getRegistry().registerAll(glass_slab, endbrick_slab, nether_wart_block_slab);
    	
    	glassdoor_clear = new Custom_ItemBlock("glassdoor_clear", Init_Blocks.glassdoor_clear);
    	event.getRegistry().registerAll(glassdoor_clear);
	  }
  }