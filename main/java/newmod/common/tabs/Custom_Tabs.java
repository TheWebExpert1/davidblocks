package newmod.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.initialization.Init_Blocks;

public class Custom_Tabs extends CreativeTabs
  {
    public Custom_Tabs(int tabID, String tabName)
      {
    	super(tabID, tabName);
      }
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack()
      {
    	//return new ItemStack(Init_Blocks.compressor_idle, 1, 0);
    	return new ItemStack(Items.DIAMOND, 1, 0);
      }
    public String getTranslatedTabLabel()
      {
    	return "Special Blocks";
      }
	@Override
	public ItemStack getTabIconItem()
	  {
    	//return new ItemStack(Init_Blocks.compressor_idle, 1, 0);
    	return new ItemStack(Items.DIAMOND, 1, 0);
	  }
  }
