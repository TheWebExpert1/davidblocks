package newmod.common.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import newmod.common.initialization.Init_Blocks;
import newmod.common.initialization.Init_Food;
import newmod.common.initialization.Init_Items;
import newmod.common.initialization.Init_PlantItems;

public class RecipeHandler 
  {
	public static void registerSmelting()
	  {
		//Furnace Recipes
		//Sandwich -> Grilled Cheese
		GameRegistry.addSmelting(new ItemStack(Init_Food.plain_sandwich), new ItemStack(Init_Food.grilled_sandwich), 1.0F);
		//Corn -> Popcorn
    	GameRegistry.addSmelting(new ItemStack(Init_Food.corn), new ItemStack(Init_Food.popcorn), 1.0F);
    	//Copper Ore -> Copper Ingot
		GameRegistry.addSmelting(new ItemStack(Init_Blocks.copper_ore), new ItemStack(Init_Items.copper_ingot), 1.0F);
        //Silver Ore -> Silver Ingot
		GameRegistry.addSmelting(new ItemStack(Init_Blocks.silver_ore), new ItemStack(Init_Items.silver_ingot), 1.0F);
		//Emerald -> Emerald Ingot
		GameRegistry.addSmelting(Items.EMERALD, new ItemStack(Init_Items.emerald_ingot), 1.0F);
		//Oil -> Boiling Oil
		GameRegistry.addSmelting(new ItemStack(Init_Food.bottle_oil), new ItemStack(Init_Food.boiling_oil), 1.0F);
		
		//Compressor Recipes
		//Flint Block -> Ceramic Block
		GameRegistry.addSmelting(new ItemStack(Init_Blocks.flint_block), new ItemStack(Init_Blocks.ceramic_block), 1);
		//Coal Block -> Diamond
		GameRegistry.addSmelting(Blocks.COAL_BLOCK, new ItemStack(Items.DIAMOND), 1);                         
		//Glass Block -> Sand
		GameRegistry.addSmelting(Blocks.GLASS, new ItemStack(Blocks.SAND), 1);                                
		//Glass Pane -> Sand
		GameRegistry.addSmelting(Blocks.GLASS_PANE, new ItemStack(Blocks.SAND), 1);                           
		//Glass Bottle -> Sand
		GameRegistry.addSmelting(new ItemStack(Items.GLASS_BOTTLE), new ItemStack(Blocks.SAND), 1);           
		//Glass Doors - Sand
		//Glass Stairs - Sand
		GameRegistry.addSmelting(Init_Blocks.glass_stairs, new ItemStack(Blocks.SAND), 1);           
		//TNT -> Nitroglycerin
		GameRegistry.addSmelting(Blocks.TNT, new ItemStack(Init_Items.nitroglycerin), 1);                           
		//Grapes -> Wine
		GameRegistry.addSmelting(new ItemStack(Init_PlantItems.grapesItem), new ItemStack(Init_Food.wine), 1);     
		//Tomato -> Ketchup
		GameRegistry.addSmelting(new ItemStack(Init_PlantItems.tomatoItem), new ItemStack(Init_Food.ketchup), 1);      
		//Redstone Block -> Magic Dust
		GameRegistry.addSmelting(Blocks.REDSTONE_BLOCK, new ItemStack(Init_Items.magic_dust), 1);                
		//Bone Block -> Marrow
		GameRegistry.addSmelting(Blocks.BONE_BLOCK, new ItemStack(Init_Items.marrow), 1);   
		//Honey Hex -> Honey
		GameRegistry.addSmelting(new ItemStack(Init_Blocks.honey_hex_block), new ItemStack(Init_Food.honey_pile), 4);   
		//Honeycomb -> Honey
		GameRegistry.addSmelting(new ItemStack(Init_Blocks.honeycomb_block), new ItemStack(Init_Food.honey_pile), 1);   
        //Diamond Block - EXPLODE
		
		//Combiner Recipes
		//Glass Block/Diamond = Crystal Shard
		//Crystal Block/Redstone Block = Powered Crystal Block
		//Dirt/Bucket of Water = Podsol
		//Clay Pot/Clay Pot = Clay Wall Block
		//Magma Block/Netherrack  Block = Hellstone Block
		//String/Slimeball = Spider Web
		//Bucket of Water/Glowstone Block = Glowing Water Bucket*/
	  }	
  }