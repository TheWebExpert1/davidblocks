package newmod.common.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade
  {
	public CustomShovel(ToolMaterial material)
      {
		super(material);
        setCreativeTab(CreativeTabs.TOOLS);
	  }    
  }