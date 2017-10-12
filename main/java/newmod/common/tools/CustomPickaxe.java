package newmod.common.tools;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomPickaxe extends ItemPickaxe
  {
	public CustomPickaxe(ToolMaterial material)
      {
		super(material);
	    setCreativeTab(CreativeTabs.TOOLS);
	  }    
  }