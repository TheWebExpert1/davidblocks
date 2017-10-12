package newmod.common.config;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.entities.Sound_List;
import newmod.common.handlers.GUIHandler;
import newmod.common.handlers.RecipeHandler;
import newmod.common.handlers.TileEntityHandler;
import newmod.common.proxy.Common_Proxy;
import newmod.common.tabs.Custom_Tabs;
import newmod.common.worldgen.World_Generator;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION)
public class Framework
  {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static Common_Proxy proxy;
	public static CreativeTabs newTab = new Custom_Tabs(CreativeTabs.getNextID(), "Special Blocks");
	public static Block Special_01 = Blocks.COMMAND_BLOCK.setCreativeTab(Framework.newTab);
	public static Block Special_02 = Blocks.CHAIN_COMMAND_BLOCK.setCreativeTab(Framework.newTab);
	public static Block Special_03 = Blocks.REPEATING_COMMAND_BLOCK.setCreativeTab(Framework.newTab);
	public static Block Special_04 = Blocks.BARRIER.setCreativeTab(Framework.newTab);
	public static Block Special_05 = Blocks.STRUCTURE_BLOCK.setCreativeTab(Framework.newTab);
	public static Block Special_06 = Blocks.STRUCTURE_VOID.setCreativeTab(Framework.newTab);
	public static Block Special_07 = Blocks.END_GATEWAY.setCreativeTab(Framework.newTab);
	public static Block Special_09 = Blocks.END_PORTAL_FRAME.setCreativeTab(Framework.newTab);
	public static Block Special_11 = Blocks.MOB_SPAWNER.setCreativeTab(Framework.newTab);
		
	public static Block Mushroom_01 = Blocks.BROWN_MUSHROOM_BLOCK.setCreativeTab(CreativeTabs.DECORATIONS);
	public static Block Mushroom_02 = Blocks.RED_MUSHROOM_BLOCK.setCreativeTab(CreativeTabs.DECORATIONS);
		
	public static Block Dirt_01 = Blocks.FARMLAND.setCreativeTab(CreativeTabs.DECORATIONS);
	public static Block Dirt_02 = Blocks.GRASS_PATH.setCreativeTab(CreativeTabs.DECORATIONS);

	@SideOnly(Side.CLIENT)
	@Instance
	public static Framework instance;
    
	static
	  {
		FluidRegistry.enableUniversalBucket();
	  }	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
      {
		TileEntityHandler.register();
		GUIHandler.register();
      }
    @EventHandler
    public void Init(FMLInitializationEvent event)
      {	
		GameRegistry.registerWorldGenerator(new World_Generator(), 0);
    	RecipeHandler.registerSmelting();
      }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
      {
      }
	/*
	public static void Common()
	  {
		TileEntityHandler.register();
		GUIHandler.register();
	  }
	@SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
      {
        Sound_List.register(event);
      }
    */
  }