package newmod.common.items;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.config.Reference;

public class Custom_Item extends Item
  {
    public Custom_Item(String name, CreativeTabs myTab)
      {
		this.setHasSubtypes(true);
		setUnlocalizedName(name);
		setRegistryName(name);
        setCreativeTab(myTab);
      }
  }