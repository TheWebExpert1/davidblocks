package newmod.common.config;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EnumHandler
  {
	public static final ToolMaterial copper_tool   = EnumHelper.addToolMaterial("copper",  3, 1200, 7.0F, 2.5F, 8);
	public static final ToolMaterial emerald_tool  = EnumHelper.addToolMaterial("emerald", 3, 1200, 7.0F, 2.5F, 8);
	public static final ToolMaterial silver_tool   = EnumHelper.addToolMaterial("silver",  3, 1200, 7.0F, 2.5F, 8);

	public static final ArmorMaterial copper_armor  = EnumHelper.addArmorMaterial("copper",  Reference.MOD_ID + ":copper",  25, new int[]{3, 5, 7, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F);
	public static final ArmorMaterial emerald_armor = EnumHelper.addArmorMaterial("emerald", Reference.MOD_ID + ":emerald", 25, new int[]{3, 5, 7, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F);
	public static final ArmorMaterial silver_armor  = EnumHelper.addArmorMaterial("silver",  Reference.MOD_ID + ":silver",  25, new int[]{3, 5, 7, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F);

    public static enum MyToolMaterial
      {
  	    copper_tool(3, 1200, 7.0F, 2.5F, 8),
  	    emerald_tool(3, 1200, 7.0F, 2.5F, 8),
  	    silver_tool(3, 1200, 7.0F, 2.5F, 8);

        /** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
        private final int harvestLevel;
        /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
        private final int maxUses;
        /** The strength of this tool material against blocks which it is effective against. */
        private final float efficiencyOnProperMaterial;
        /** Damage versus entities. */
        private final float damageVsEntity;
        /** Defines the natural enchantability factor of the material. */
        private final int enchantability;
        //Added by forge for custom Tool materials.
        private ItemStack repairMaterial = ItemStack.EMPTY;
  
        private MyToolMaterial(int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability)
          {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiencyOnProperMaterial = efficiency;
            this.damageVsEntity = damageVsEntity;
            this.enchantability = enchantability;
          }
        /**
         * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
         */
        public int getMaxUses()
          {
            return this.maxUses;
          }
        /**
         * The strength of this tool material against blocks which it is effective against.
         */
        public float getEfficiencyOnProperMaterial()
          {
            return this.efficiencyOnProperMaterial;
          }
        /**
         * Returns the damage against a given entity.
         */
        public float getDamageVsEntity()
          {
            return this.damageVsEntity;
          }
        /**
         * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
         */
        public int getHarvestLevel()
          {
            return this.harvestLevel;
          }
        /**
         * Return the natural enchantability factor of the material.
         */
        public int getEnchantability()
          {
            return this.enchantability;
          }
      }
  }