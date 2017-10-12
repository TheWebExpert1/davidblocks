package newmod.common.blocks.stairs;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.blocks.slab.Glass_Slab;

public class Glass_Stairs extends BlockStairs
  {
    private Block block;

    public Glass_Stairs(String name, IBlockState modelState)
      {
        super(modelState);
        this.block = Blocks.GLASS;
		setUnlocalizedName(name);
		setRegistryName(name);
	    setSoundType(SoundType.GLASS);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(HALF, Glass_Stairs.EnumHalf.BOTTOM).withProperty(SHAPE, Glass_Stairs.EnumShape.STRAIGHT));
        this.setHardness(2.5F);
        this.setResistance(4.5F);
        this.setLightOpacity(255);
      }
  @Override
  public boolean isOpaqueCube(IBlockState state)
    {
  	  return false;
    }    
  @Override
  public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
      if(this.block.getDefaultState().getMaterial().equals(Material.GLASS))
        return Blocks.GLASS.doesSideBlockRendering(state, world, pos, face);
      else
        return super.doesSideBlockRendering(state, world, pos, face);      
      /*if (net.minecraftforge.common.ForgeModContainer.disableStairSlabCulling)
          return super.doesSideBlockRendering(state, world, pos, face);
        if (state.isOpaqueCube()) return false;
        state = this.getActualState(state, world, pos);
        EnumHalf half = state.getValue(HALF);
        EnumFacing side = state.getValue(FACING);
        EnumShape shape = state.getValue(SHAPE);
        if (face == EnumFacing.UP) return half == EnumHalf.TOP;
        if (face == EnumFacing.DOWN) return half == EnumHalf.BOTTOM;
        if (shape == EnumShape.OUTER_LEFT || shape == EnumShape.OUTER_RIGHT) return false;
        if (face == side) return true;
        if (shape == EnumShape.INNER_LEFT && face.rotateY() == side) return true;
        if (shape == EnumShape.INNER_RIGHT && face.rotateYCCW() == side) return true;
        return false;*/      
    }    
  @Override
  public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
  	if(this.block.getDefaultState().getMaterial().equals(Material.GLASS))
  	  {
  		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
          Block block = iblockstate.getBlock();
          if (blockState != iblockstate)
            {
              return true;
            }
          if (block == this)
            {
              return false;
            }            
          return block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
  	  }
  	return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }    
  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getBlockLayer()
    {
      return this.block.getDefaultState().getMaterial().equals(Material.GLASS) ? BlockRenderLayer.CUTOUT : BlockRenderLayer.SOLID;
    }            
  protected boolean canSilkHarvest()
    {
      return true;
    }
  @Override
  public boolean canProvidePower(IBlockState state)
    {
	    return this.block.equals(Blocks.REDSTONE_BLOCK);
    }
  @Override
  public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
	    return this.block.equals(Blocks.REDSTONE_BLOCK) ? 15 : 0;
    }
  public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
      return this.block.getDefaultState().getMaterial().equals(Material.GLASS) ? null : Item.getItemFromBlock(this);
    }
  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
      return new ItemStack(Item.getItemFromBlock(this));
    }
  public String getUnlocalizedName(int meta)
    {
      return super.getUnlocalizedName();
    }
  }