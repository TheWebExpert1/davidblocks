package newmod.common.config;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class Reference
  {
    public static final String MOD_ID="newmod";
    public static final String NAME="MegaMod";
    public static final String VERSION="1.0";
    public static final String ACCEPTED_VERSIONS="[1.12]";
    
    public static final String CLIENT_PROXY_CLASS="newmod.client.proxy.Client_Proxy";
    public static final String COMMON_PROXY_CLASS="newmod.common.proxy.Common_Proxy";

	public static ToolMaterial coppert  = EnumHelper.addToolMaterial("copper",  2, 300, 5.0F, 2.0F, 12);
	public static ToolMaterial emeraldt = EnumHelper.addToolMaterial("emerald", 2, 300, 5.0F, 2.0F, 12);
	public static ToolMaterial silvert  = EnumHelper.addToolMaterial("silver",  2, 300, 5.0F, 2.0F, 12);

	public static ArmorMaterial coppera  = EnumHelper.addArmorMaterial("copper",  Reference.MOD_ID + ":copper",  33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
	public static ArmorMaterial emeralda = EnumHelper.addArmorMaterial("emerald", Reference.MOD_ID + ":emerald", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
	public static ArmorMaterial silvera  = EnumHelper.addArmorMaterial("silver",  Reference.MOD_ID + ":silver",  33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);

	public static final int GUI_COMPRESSOR = 0;
	public static final int GUI_COMBINER = 1;
  }