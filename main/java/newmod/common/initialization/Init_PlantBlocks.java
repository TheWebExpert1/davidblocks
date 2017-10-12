package newmod.common.initialization;

import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoubleStoneSlab;
import net.minecraft.block.BlockHalfStoneSlab;
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
import newmod.common.blocks.Custom_Block;
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;
import newmod.common.blocks.plants.EggplantBlock;
import newmod.common.blocks.plants.GourdBlock;
import newmod.common.blocks.plants.GrapesBlock;
import newmod.common.blocks.plants.KiwiBlock;
import newmod.common.blocks.plants.LettuceBlock;
import newmod.common.blocks.plants.TomatoBlock;
import newmod.common.blocks.plants.WildberryBlock;

public class Init_PlantBlocks
  {
	public static Block eggplantBlock;
	public static Block gourdBlock;
	public static Block grapesBlock;
	public static Block kiwiBlock;
	public static Block lettuceBlock;
	public static Block tomatoBlock;
	public static Block wildberryBlock;
	
    @SubscribeEvent
	public static void registerPlantBlocks(RegistryEvent.Register<Block> event)
	  {
		eggplantBlock      = new EggplantBlock("eggplant");
		gourdBlock         = new GourdBlock("gourd");
		grapesBlock        = new GrapesBlock("grapes");
		kiwiBlock          = new KiwiBlock("kiwi");
		lettuceBlock       = new LettuceBlock("lettuce");
		tomatoBlock        = new TomatoBlock("tomato");
		wildberryBlock     = new WildberryBlock("wildberry");
		event.getRegistry().registerAll(eggplantBlock, gourdBlock, grapesBlock, kiwiBlock, lettuceBlock, tomatoBlock, wildberryBlock);
	  }
    @SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerPlantModels(ModelRegistryEvent event)
	  {
		registerBlocks(eggplantBlock);
		registerBlocks(gourdBlock);
		registerBlocks(grapesBlock);
		registerBlocks(kiwiBlock);
		registerBlocks(lettuceBlock);
		registerBlocks(tomatoBlock);
		registerBlocks(wildberryBlock);
      }
    public static void registerBlocks(Block block)
      {
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
      }
  }