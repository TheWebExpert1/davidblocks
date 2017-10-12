package newmod.common.plants;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EggplantSeeds extends ItemSeeds
  {
	public EggplantSeeds(Block crops, String name)
	  {
	    super(crops, Blocks.FARMLAND);
	    this.setUnlocalizedName(name);
	    this.setRegistryName(name);
	    this.setCreativeTab(CreativeTabs.MISC);
	  }
  }