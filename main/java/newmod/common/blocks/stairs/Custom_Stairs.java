package newmod.common.blocks.stairs;

import java.util.Random;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Custom_Stairs extends BlockStairs
  {
    public Custom_Stairs(String name, IBlockState modelState)
      {
        super(modelState);
		setUnlocalizedName(name);
		setRegistryName(name);
	    setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
      {
    	return Item.getItemFromBlock(this);
      }
  }