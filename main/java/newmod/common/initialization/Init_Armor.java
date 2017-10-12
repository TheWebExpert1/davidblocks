package newmod.common.initialization;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.armor.CustomArmor;
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;

public class Init_Armor
  {
	public static Item helmet_copper, shirt_copper, pants_copper, boots_copper;
	public static Item helmet_emerald, shirt_emerald, pants_emerald, boots_emerald;
	public static Item helmet_silver, shirt_silver, pants_silver, boots_silver;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	  {
		helmet_copper = new CustomArmor(EnumHandler.copper_armor,  1, EntityEquipmentSlot.HEAD).setRegistryName("helmet_copper").setUnlocalizedName("helmet_copper");
		//event.getRegistry().register(helmet_copper);
		shirt_copper  = new CustomArmor(EnumHandler.copper_armor,  1, EntityEquipmentSlot.CHEST).setRegistryName("shirt_copper").setUnlocalizedName("shirt_copper");
        //event.getRegistry().register(shirt_copper);
		pants_copper  = new CustomArmor(EnumHandler.copper_armor,  1, EntityEquipmentSlot.LEGS).setRegistryName("pants_copper").setUnlocalizedName("pants_copper");
		//event.getRegistry().register(pants_copper);
		boots_copper  = new CustomArmor(EnumHandler.copper_armor,  1, EntityEquipmentSlot.FEET).setRegistryName("boots_copper").setUnlocalizedName("boots_copper");
		//event.getRegistry().register(boots_copper);
		helmet_emerald = new CustomArmor(EnumHandler.emerald_armor, 1, EntityEquipmentSlot.HEAD).setRegistryName("helmet_emerald").setUnlocalizedName("helmet_emerald");
		//event.getRegistry().register(helmet_emerald);
		shirt_emerald  = new CustomArmor(EnumHandler.emerald_armor, 1, EntityEquipmentSlot.CHEST).setRegistryName("shirt_emerald").setUnlocalizedName("shirt_emerald");
		//event.getRegistry().register(shirt_emerald);
		pants_emerald  = new CustomArmor(EnumHandler.emerald_armor, 1, EntityEquipmentSlot.LEGS).setRegistryName("pants_emerald").setUnlocalizedName("pants_emerald");
		//event.getRegistry().register(pants_emerald);
		boots_emerald  = new CustomArmor(EnumHandler.emerald_armor, 1, EntityEquipmentSlot.FEET).setRegistryName("boots_emerald").setUnlocalizedName("boots_emerald");
		//event.getRegistry().register(boots_emerald);
		helmet_silver = new CustomArmor(EnumHandler.silver_armor,  1, EntityEquipmentSlot.HEAD).setRegistryName("helmet_silver").setUnlocalizedName("helmet_silver");
		//event.getRegistry().register(helmet_silver);
		shirt_silver  = new CustomArmor(EnumHandler.silver_armor,  1, EntityEquipmentSlot.CHEST).setRegistryName("shirt_silver").setUnlocalizedName("shirt_silver");
		//event.getRegistry().register(shirt_silver);
		pants_silver  = new CustomArmor(EnumHandler.silver_armor,  1, EntityEquipmentSlot.LEGS).setRegistryName("pants_silver").setUnlocalizedName("pants_silver");
		//event.getRegistry().register(pants_silver);
		boots_silver  = new CustomArmor(EnumHandler.silver_armor,  1, EntityEquipmentSlot.FEET).setRegistryName("boots_silver").setUnlocalizedName("boots_silver");
		//event.getRegistry().register(boots_silver);
		event.getRegistry().registerAll(helmet_copper, shirt_copper, pants_copper, boots_copper, helmet_emerald, shirt_emerald, pants_emerald, boots_emerald, helmet_silver, shirt_silver, pants_silver, boots_silver);
	  }
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event)
	  {
		registerArmor(helmet_copper); registerArmor(shirt_copper); registerArmor(pants_copper); registerArmor(boots_copper);
		registerArmor(helmet_emerald); registerArmor(shirt_emerald); registerArmor(pants_emerald); registerArmor(boots_emerald);
		registerArmor(helmet_silver); registerArmor(shirt_silver); registerArmor(pants_silver); registerArmor(boots_silver);
	  }
	public static void registerArmor(Item item)
	  {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
	  }
  }