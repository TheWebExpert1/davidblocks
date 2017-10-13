package newmod.common.initialization;

import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.blocks.doors.Glass_Door;
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;
import newmod.common.items.Custom_Item;

public class Init_Items
  {
	public static Item copper_nugget;
	public static Item emerald_nugget;
	public static Item silver_nugget;
	public static Item copper_ingot;
	public static Item emerald_ingot;
	public static Item silver_ingot;
	public static Item magic_dust;
	public static Item marrow;
	public static Item nitroglycerin;
	public static Item pollen;
	public static Item crystal_shard;
	
	public static Item itemGlassdoor_clear;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	  {
		//Here we're registering the Items we've created
		copper_ingot = new Custom_Item("copper_ingot", CreativeTabs.MATERIALS);
		emerald_ingot = new Custom_Item("emerald_ingot", CreativeTabs.MATERIALS);
		silver_ingot = new Custom_Item("silver_ingot", CreativeTabs.MATERIALS);
		copper_nugget = new Custom_Item("copper_nugget", CreativeTabs.MATERIALS);
		emerald_nugget = new Custom_Item("emerald_nugget", CreativeTabs.MATERIALS);
		silver_nugget = new Custom_Item("silver_nugget", CreativeTabs.MATERIALS);
		magic_dust = new Custom_Item("magic_dust", CreativeTabs.MISC);
		marrow = new Custom_Item("marrow", CreativeTabs.MISC);
		nitroglycerin = new Custom_Item("nitroglycerin", CreativeTabs.MISC);
		pollen = new Custom_Item("pollen", CreativeTabs.MISC);
		crystal_shard = new Custom_Item("crystal_shard", CreativeTabs.MISC);
		event.getRegistry().registerAll(copper_nugget, emerald_nugget, silver_nugget, copper_ingot, emerald_ingot, silver_ingot, magic_dust, marrow, nitroglycerin, pollen, crystal_shard);
		
		itemGlassdoor_clear = new ItemDoor(Init_Blocks.glassdoor_clear).setRegistryName("itemGlassdoor_clear").setUnlocalizedName("itemGlassdoor_clear");
		event.getRegistry().registerAll(itemGlassdoor_clear);
	  }
    @SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event)
	  {
		registerItem(copper_nugget);
		registerItem(emerald_nugget);
		registerItem(silver_nugget);
		registerItem(copper_ingot);
		registerItem(emerald_ingot);
		registerItem(silver_ingot);
		registerItem(magic_dust);
		registerItem(marrow);
		registerItem(nitroglycerin);
		registerItem(pollen);
		registerItem(crystal_shard);
		registerItem(itemGlassdoor_clear);
  	  }
    public static void registerItem(Item item)
      {
  	    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
      }
  }