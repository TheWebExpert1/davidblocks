package newmod.common.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;

public class CustomHoe extends ItemHoe
  {
	public CustomHoe(ToolMaterial material)
      {
		super(material);
	    setCreativeTab(CreativeTabs.TOOLS);
	  }    
  }