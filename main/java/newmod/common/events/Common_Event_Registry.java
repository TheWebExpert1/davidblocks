package newmod.common.events;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import newmod.common.initialization.Init_Armor;
import newmod.common.initialization.Init_Blocks;
import newmod.common.initialization.Init_Entities;
import newmod.common.initialization.Init_Fluids;
import newmod.common.initialization.Init_Food;
import newmod.common.initialization.Init_ItemBlocks;
import newmod.common.initialization.Init_Items;
import newmod.common.initialization.Init_PlantBlocks;
import newmod.common.initialization.Init_PlantItems;
import newmod.common.initialization.Init_Tools;

@Mod.EventBusSubscriber
public class Common_Event_Registry
  {
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	  {
		Init_Armor.registerItems(event);
		Init_Entities.init();
		Init_Food.registerItems(event);
		Init_Items.registerItems(event);
		Init_ItemBlocks.registerItemBlocks(event);
		Init_Fluids.register();
		Init_PlantItems.registerPlantItems(event);
		Init_Tools.registerItems(event);
	  }
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	  {
		Init_Blocks.registerBlocks(event);
		Init_PlantBlocks.registerPlantBlocks(event);
	  }
  }