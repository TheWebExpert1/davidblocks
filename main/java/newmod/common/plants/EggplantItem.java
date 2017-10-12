package newmod.common.plants;

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

public class EggplantItem extends ItemFood
  {
    public EggplantItem(String name)
      {
		super(4, 0.8F, false);
		setUnlocalizedName(name);
		setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);
      }
  }