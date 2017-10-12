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
import newmod.common.blocks.plants.EggplantBlock;
import newmod.common.blocks.plants.GourdBlock;
import newmod.common.blocks.plants.GrapesBlock;
import newmod.common.blocks.plants.KiwiBlock;
import newmod.common.blocks.plants.LettuceBlock;
import newmod.common.blocks.plants.TomatoBlock;
import newmod.common.blocks.plants.WildberryBlock;
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;
import newmod.common.items.Custom_Item;
import newmod.common.plants.EggplantItem;
import newmod.common.plants.EggplantSeeds;
import newmod.common.plants.GourdItem;
import newmod.common.plants.GourdSeeds;
import newmod.common.plants.GrapesItem;
import newmod.common.plants.GrapesSeeds;
import newmod.common.plants.KiwiItem;
import newmod.common.plants.KiwiSeeds;
import newmod.common.plants.LettuceItem;
import newmod.common.plants.LettuceSeeds;
import newmod.common.plants.TomatoItem;
import newmod.common.plants.TomatoSeeds;
import newmod.common.plants.WildberryItem;
import newmod.common.plants.WildberrySeeds;

public class Init_PlantItems
  {
	public static Item  eggplantItem;  public static Item  eggplantSeeds;
	public static Item  gourdItem;     public static Item  gourdSeeds;
	public static Item  grapesItem;    public static Item  grapesSeeds;
	public static Item  kiwiItem;      public static Item  kiwiSeeds;
	public static Item  lettuceItem;   public static Item  lettuceSeeds;
	public static Item  tomatoItem;    public static Item  tomatoSeeds;
	public static Item  wildberryItem; public static Item  wildberrySeeds;
	
	@SubscribeEvent
	public static void registerPlantItems(RegistryEvent.Register<Item> event)
	  {
		//Here we're registering the Plant Items we've created
		eggplantItem       = new EggplantItem("eggplant");
		eggplantSeeds      = new EggplantSeeds(Init_PlantBlocks.eggplantBlock, "eggplantSeeds");
		gourdItem          = new GourdItem("gourd");
		gourdSeeds         = new GourdSeeds(Init_PlantBlocks.gourdBlock, "gourdSeeds");
		grapesItem         = new GrapesItem("grapes");
		grapesSeeds        = new GrapesSeeds(Init_PlantBlocks.grapesBlock, "grapesSeeds");
		kiwiItem           = new KiwiItem("kiwi");
		kiwiSeeds          = new KiwiSeeds(Init_PlantBlocks.kiwiBlock, "kiwiSeeds");
		lettuceItem        = new LettuceItem("lettuce");
		lettuceSeeds       = new LettuceSeeds(Init_PlantBlocks.lettuceBlock, "lettuceSeeds");
		tomatoItem         = new TomatoItem("tomato");
		tomatoSeeds        = new TomatoSeeds(Init_PlantBlocks.tomatoBlock, "tomatoSeeds");
		wildberryItem      = new WildberryItem("wildberry");
		wildberrySeeds     = new WildberrySeeds(Init_PlantBlocks.wildberryBlock, "wildberrySeeds");
	    event.getRegistry().registerAll(eggplantItem, eggplantSeeds, gourdItem, gourdSeeds, grapesItem, grapesSeeds, kiwiItem, kiwiSeeds, lettuceItem, lettuceSeeds, tomatoItem, tomatoSeeds, wildberryItem, wildberrySeeds);
	  }
    @SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerPlantModels(ModelRegistryEvent event)
	  {
		registerItem(eggplantItem);
		registerItem(eggplantSeeds);
		registerItem(gourdItem);
		registerItem(gourdSeeds);
		registerItem(grapesItem);
		registerItem(grapesSeeds);
		registerItem(kiwiItem);
		registerItem(kiwiSeeds);
		registerItem(lettuceItem);
		registerItem(lettuceSeeds);
		registerItem(tomatoItem);
		registerItem(tomatoSeeds);
		registerItem(wildberryItem);
		registerItem(wildberrySeeds);
  	  }
    public static void registerItem(Item item)
      {
  	    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
      }
  }