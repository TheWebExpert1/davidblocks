package newmod.common.initialization;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
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
import newmod.common.config.EnumHandler;
import newmod.common.config.Reference;
import newmod.common.tools.CustomAxe;
import newmod.common.tools.CustomHoe;
import newmod.common.tools.CustomPickaxe;
import newmod.common.tools.CustomShovel;
import newmod.common.tools.CustomSword;

public class Init_Tools
  {
	public static Item pickaxe_copper,  axe_copper,  hoe_copper,  shovel_copper,  sword_copper;
	public static Item pickaxe_emerald, axe_emerald, hoe_emerald, shovel_emerald, sword_emerald;
	public static Item pickaxe_silver,  axe_silver,  hoe_silver,  shovel_silver,  sword_silver;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	  {
		pickaxe_copper = new CustomPickaxe(EnumHandler.copper_tool).setRegistryName("pickaxe_copper").setUnlocalizedName("pickaxe_copper");
		//event.getRegistry().register(pickaxe_copper);
		axe_copper     = new CustomAxe(EnumHandler.copper_tool).setRegistryName("axe_copper").setUnlocalizedName("axe_copper");
		//event.getRegistry().register(axe_copper);
		hoe_copper     = new CustomHoe(EnumHandler.copper_tool).setRegistryName("hoe_copper").setUnlocalizedName("hoe_copper");
		//event.getRegistry().register(hoe_copper);
		shovel_copper  = new CustomShovel(EnumHandler.copper_tool).setRegistryName("shovel_copper").setUnlocalizedName("shovel_copper");
		//event.getRegistry().register(shovel_copper);
		sword_copper   = new CustomSword(EnumHandler.copper_tool).setRegistryName("sword_copper").setUnlocalizedName("sword_copper");
		//event.getRegistry().register(sword_copper);
		pickaxe_emerald = new CustomPickaxe(EnumHandler.emerald_tool).setRegistryName("pickaxe_emerald").setUnlocalizedName("pickaxe_emerald");
		//event.getRegistry().register(pickaxe_emerald);
		axe_emerald     = new CustomAxe(EnumHandler.emerald_tool).setRegistryName("axe_emerald").setUnlocalizedName("axe_emerald");
		//event.getRegistry().register(axe_emerald);
		hoe_emerald     = new CustomHoe(EnumHandler.emerald_tool).setRegistryName("hoe_emerald").setUnlocalizedName("hoe_emerald");
		//event.getRegistry().register(hoe_emerald);
		shovel_emerald  = new CustomShovel(EnumHandler.emerald_tool).setRegistryName("shovel_emerald").setUnlocalizedName("shovel_emerald");
		//event.getRegistry().register(shovel_emerald);
		sword_emerald   = new CustomSword(EnumHandler.emerald_tool).setRegistryName("sword_emerald").setUnlocalizedName("sword_emerald");
		//event.getRegistry().register(sword_emerald);
		pickaxe_silver = new CustomPickaxe(EnumHandler.silver_tool).setRegistryName("pickaxe_silver").setUnlocalizedName("pickaxe_silver");
		//event.getRegistry().register(pickaxe_silver);
		axe_silver     = new CustomAxe(EnumHandler.silver_tool).setRegistryName("axe_silver").setUnlocalizedName("axe_silver");
		//event.getRegistry().register(axe_silver);
		hoe_silver     = new CustomHoe(EnumHandler.silver_tool).setRegistryName("hoe_silver").setUnlocalizedName("hoe_silver");
		//event.getRegistry().register(hoe_silver);
		shovel_silver  = new CustomShovel(EnumHandler.silver_tool).setRegistryName("shovel_silver").setUnlocalizedName("shovel_silver");
		//event.getRegistry().register(shovel_silver);
		sword_silver   = new CustomSword(EnumHandler.silver_tool).setRegistryName("sword_silver").setUnlocalizedName("sword_silver");
		//event.getRegistry().register(sword_silver);
		event.getRegistry().registerAll(pickaxe_copper,  axe_copper,  hoe_copper,  shovel_copper,  sword_copper, pickaxe_emerald, axe_emerald, hoe_emerald, shovel_emerald, sword_emerald, pickaxe_silver,  axe_silver,  hoe_silver,  shovel_silver,  sword_silver);
		
	  }
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event)
	  {
		registerTools(pickaxe_copper); registerTools(axe_copper); registerTools(hoe_copper); registerTools(shovel_copper); registerTools(sword_copper);
		registerTools(pickaxe_emerald); registerTools(axe_emerald); registerTools(hoe_emerald); registerTools(shovel_emerald); registerTools(sword_emerald);
		registerTools(pickaxe_silver); registerTools(axe_silver); registerTools(hoe_silver); registerTools(shovel_silver); registerTools(sword_silver);
	  }
	public static void registerTools(Item item)
	  {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
	  }
  }