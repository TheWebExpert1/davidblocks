package newmod.common.initialization;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.food.Custom_Food;
import newmod.common.config.Reference;

public class Init_Food
  {
	public static Item american_cheese;
	public static Item cheddar_cheese;
	public static Item swiss_cheese;
	public static Item american_soup;
	public static Item cheddar_soup;
	public static Item swiss_soup;
	public static Item coppery_beet;
	public static Item irony_beet;
	public static Item silvery_beet;
	public static Item corn;
	public static Item wine;
	public static Item french_fries;
	public static Item ketchup;
	public static Item popcorn;
	public static Item fried_fish;
	public static Item fried_salmon;
	public static Item boiling_oil;
	public static Item bottle_oil;	
	public static Item honey_pile;
	public static Item honey_bottle;		
	public static Item grilled_sandwich;
	public static Item plain_sandwich;
	public static Item royal_jelly_pile;
	public static Item royal_jelly_bottle;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	  {
		american_cheese= new Custom_Food("american_cheese");
		cheddar_cheese= new Custom_Food("cheddar_cheese");
		swiss_cheese= new Custom_Food("swiss_cheese");
		american_soup= new Custom_Food("american_soup");
		cheddar_soup= new Custom_Food("cheddar_soup");
		swiss_soup= new Custom_Food("swiss_soup");
		coppery_beet= new Custom_Food("coppery_beet");
		irony_beet= new Custom_Food("irony_beet");
		silvery_beet= new Custom_Food("silvery_beet");
		corn= new Custom_Food("corn");
		french_fries= new Custom_Food("french_fries");
		ketchup= new Custom_Food("ketchup");
		popcorn= new Custom_Food("popcorn");
		wine= new Custom_Food("wine");
		fried_fish= new Custom_Food("fried_fish");
		fried_salmon= new Custom_Food("fried_salmon");
		boiling_oil= new Custom_Food("boiling_oil");
		bottle_oil= new Custom_Food("bottle_oil");
		honey_pile= new Custom_Food("honey_pile");
		honey_bottle= new Custom_Food("honey_bottle");
		grilled_sandwich= new Custom_Food("grilled_sandwich");
		plain_sandwich= new Custom_Food("plain_sandwich");
		royal_jelly_pile= new Custom_Food("royal_jelly_pile");
		royal_jelly_bottle= new Custom_Food("royal_jelly_bottle");
		event.getRegistry().registerAll(american_cheese, cheddar_cheese, swiss_cheese, american_soup, cheddar_soup, swiss_soup, coppery_beet, irony_beet, silvery_beet, corn, wine, french_fries, ketchup, popcorn, fried_fish, fried_salmon, boiling_oil, bottle_oil, honey_pile, honey_bottle, grilled_sandwich, plain_sandwich, royal_jelly_pile, royal_jelly_bottle);
	  }
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event)
	  {
		registerFood(american_cheese); registerFood(cheddar_cheese);   registerFood(swiss_cheese);
		registerFood(american_soup);   registerFood(cheddar_soup);     registerFood(swiss_soup);
		registerFood(coppery_beet);    registerFood(irony_beet);       registerFood(silvery_beet);
		registerFood(corn);            registerFood(french_fries);     registerFood(ketchup);
		registerFood(popcorn);         registerFood(wine);             registerFood(fried_fish);
		registerFood(fried_salmon);    registerFood(boiling_oil);      registerFood(bottle_oil);	
		registerFood(honey_pile);      registerFood(honey_bottle); 	   registerFood(grilled_sandwich);
		registerFood(plain_sandwich);  registerFood(royal_jelly_pile); registerFood(royal_jelly_bottle);
  	  }
    public static void registerFood(Item item)
      {
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
      }
  }