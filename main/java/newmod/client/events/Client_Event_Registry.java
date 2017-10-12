package newmod.client.events;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import newmod.common.initialization.Init_Armor;
import newmod.common.initialization.Init_Blocks;
import newmod.common.initialization.Init_Entities;
import newmod.common.initialization.Init_Food;
import newmod.common.initialization.Init_Items;
import newmod.common.initialization.Init_PlantBlocks;
import newmod.common.initialization.Init_PlantItems;
import newmod.common.initialization.Init_Tools;

@Mod.EventBusSubscriber(Side.CLIENT)
public class Client_Event_Registry
  {
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	  {
		Init_Armor.registerModels(event);
		Init_Blocks.registerModels(event);
		Init_Entities.initModels();
		Init_Food.registerModels(event);
		Init_Items.registerModels(event);
		Init_PlantItems.registerPlantModels(event);
		Init_PlantBlocks.registerPlantModels(event);
		Init_Tools.registerModels(event);
	  }
  }