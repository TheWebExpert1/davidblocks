package newmod.common.blocks.doors;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import newmod.common.initialization.Init_Blocks;
import newmod.common.initialization.Init_Items;

public class Glass_Door extends BlockDoor
  {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<BlockDoor.EnumHingePosition> HINGE = PropertyEnum.<BlockDoor.EnumHingePosition>create("hinge", BlockDoor.EnumHingePosition.class);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyEnum<BlockDoor.EnumDoorHalf> HALF = PropertyEnum.<BlockDoor.EnumDoorHalf>create("half", BlockDoor.EnumDoorHalf.class);
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);

    public Glass_Door(String name)
	  {
		super(Material.GLASS);
		setUnlocalizedName(name);
		setRegistryName(name);
	    setSoundType(SoundType.GLASS);
	    this.useNeighborBrightness = true;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	  }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
      {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
        boolean flag1 = state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT;
        switch (enumfacing)
          {
            case EAST:
            default:
              return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
              return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            case WEST:
              return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
              return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
          }
      }
    @Override
    public boolean isOpaqueCube(IBlockState state)
      {
        return false;
      }
    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
      {
        return isOpen(combineMetadata(worldIn, pos));
      }
    @Override
    public boolean isFullCube(IBlockState state)
      {
        return false;
      }
    private int getCloseSound()
      {
        return this.blockMaterial == Material.IRON ? 1011 : 1012;
      }
    private int getOpenSound()
      {
        return this.blockMaterial == Material.IRON ? 1005 : 1006;
      }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
      {
        if (this.blockMaterial == Material.IRON)
          {
            return false;
          }
        else
          {
            BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
            IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);
            if (iblockstate.getBlock() != this)
              {
                return false;
              }
            else
              {
                state = iblockstate.cycleProperty(OPEN);
                worldIn.setBlockState(blockpos, state, 10);
                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
                worldIn.playEvent(playerIn, ((Boolean)state.getValue(OPEN)).booleanValue() ? this.getOpenSound() : this.getCloseSound(), pos, 0);
                return true;
              }
          }
      }
    @Override
    public void toggleDoor(World worldIn, BlockPos pos, boolean open)
      {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        if (iblockstate.getBlock() == this)
          {
            BlockPos blockpos = iblockstate.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
            IBlockState iblockstate1 = pos == blockpos ? iblockstate : worldIn.getBlockState(blockpos);
            if (iblockstate1.getBlock() == this && ((Boolean)iblockstate1.getValue(OPEN)).booleanValue() != open)
              {
                worldIn.setBlockState(blockpos, iblockstate1.withProperty(OPEN, Boolean.valueOf(open)), 10);
                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
                worldIn.playEvent((EntityPlayer)null, open ? this.getOpenSound() : this.getCloseSound(), pos, 0);
              }
          }
      }
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
      {
        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
          {
            BlockPos blockpos = pos.down();
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
            if (iblockstate.getBlock() != this)
              {
                worldIn.setBlockToAir(pos);
              }
            else if (blockIn != this)
              {
                iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
              }
          }
        else
          {
            boolean flag1 = false;
            BlockPos blockpos1 = pos.up();
            IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);
            if (iblockstate1.getBlock() != this)
              {
                worldIn.setBlockToAir(pos);
                flag1 = true;
              }
            if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn,  pos.down(), EnumFacing.UP))
              {
                worldIn.setBlockToAir(pos);
                flag1 = true;
                if (iblockstate1.getBlock() == this)
                  {
                    worldIn.setBlockToAir(blockpos1);
                  }
              }
            if (flag1)
              {
                if (!worldIn.isRemote)
                  {
                    this.dropBlockAsItem(worldIn, pos, state, 0);
                  }
              }
            else
              {
                boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);
                if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean)iblockstate1.getValue(POWERED)).booleanValue())
                  {
                    worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);
                    if (flag != ((Boolean)state.getValue(OPEN)).booleanValue())
                      {
                        worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
                        worldIn.markBlockRangeForRenderUpdate(pos, pos);
                        worldIn.playEvent((EntityPlayer)null, flag ? this.getOpenSound() : this.getCloseSound(), pos, 0);
                      }
                  }
              }
          }
      }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
      {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : this.getItem();
      }
    private Item getItem()
      {
    	return Init_Blocks.glassdoor_clear.getItem();
      }
    @Override
    public BlockRenderLayer getBlockLayer()
      {
        return BlockRenderLayer.CUTOUT;
      }
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
      {
        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER)
          {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());
            if (iblockstate.getBlock() == this)
              {
                state = state.withProperty(HINGE, iblockstate.getValue(HINGE)).withProperty(POWERED, iblockstate.getValue(POWERED));
              }
           }
        else
          {
            IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
            if (iblockstate1.getBlock() == this)
              {
                state = state.withProperty(FACING, iblockstate1.getValue(FACING)).withProperty(OPEN, iblockstate1.getValue(OPEN));
              }
          }
        return state;
      }
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
      {
        return state.getValue(HALF) != BlockDoor.EnumDoorHalf.LOWER ? state : state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
      }
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
      {
        return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING))).cycleProperty(HINGE);
      }
    @Override
    public IBlockState getStateFromMeta(int meta)
      {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(HINGE, (meta & 1) > 0 ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER).withProperty(FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW()).withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
      }
    @Override
    public int getMetaFromState(IBlockState state)
      {
        int i = 0;
        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
          {
            i = i | 8;
            if (state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT)
              {
                i |= 1;
              }
            if (((Boolean)state.getValue(POWERED)).booleanValue())
              {
                i |= 2;
              }
          }
        else
          {
            i = i | ((EnumFacing)state.getValue(FACING)).rotateY().getHorizontalIndex();
            if (((Boolean)state.getValue(OPEN)).booleanValue())
              {
                i |= 4;
              }
          }
        return i;
      }
    public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos)
      {
        return getFacing(combineMetadata(worldIn, pos));
      }
    public static EnumFacing getFacing(int combinedMeta)
      {
        return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
      }
    @Override
    protected BlockStateContainer createBlockState()
      {
        return new BlockStateContainer(this, new IProperty[] {HALF, FACING, OPEN, HINGE, POWERED});
      }
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
      {
        return BlockFaceShape.UNDEFINED;
      }
    public static enum EnumDoorHalf implements IStringSerializable
      {
        UPPER,
        LOWER;
        public String toString()
          {
            return this.getName();
          }
        public String getName()
          {
            return this == UPPER ? "upper" : "lower";
          }
      }
    public static enum EnumHingePosition implements IStringSerializable
      {
        LEFT,
        RIGHT;
        public String toString()
          {
            return this.getName();
          }
        public String getName()
          {
            return this == LEFT ? "left" : "right";
          }
      }
  }