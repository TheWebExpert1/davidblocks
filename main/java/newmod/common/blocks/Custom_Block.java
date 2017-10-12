package newmod.common.blocks;

import newmod.common.config.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Custom_Block extends Block
  {
	public Custom_Block(String name, float hardness, float resistance, int harvestlevel) 
	  {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel("pickaxe", harvestlevel);
		setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	  }	
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
      {
		//This is to make the block sticky;
    	/*System.out.println("XXX: "+worldIn.getBlockState(pos).toString());
		if (worldIn.getBlockState(pos).toString() == "newmod:honey_block]")
		  {
			System.out.println("YYY: slow");
			entityIn.setInWeb();
		  }*/
      }
  }