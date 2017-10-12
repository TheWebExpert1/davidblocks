package newmod.common.blocks.slab;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Glass_Slab extends BlockSlab
  {
    public static final PropertyEnum<Glass_Slab.Variant> VARIANT = PropertyEnum.<Glass_Slab.Variant>create("variant", Glass_Slab.Variant.class);
    private Block block;
    public Glass_Slab mySlab;
    private final boolean ignoreSimilarity;

    public Glass_Slab(String name, Glass_Slab slabIn, boolean ignoreSimilarityIn)
      {
        super(Material.GLASS);
        this.block = Blocks.GLASS;
		setUnlocalizedName(name);
		setRegistryName(name);
        ignoreSimilarity = ignoreSimilarityIn;
	    setSoundType(SoundType.GLASS);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        IBlockState iblockstate = this.blockState.getBaseState();
        mySlab = slabIn;
        if (!this.isDouble())
          {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
          }
        this.setDefaultState(iblockstate.withProperty(VARIANT, Glass_Slab.Variant.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      }
    public static class Double extends Glass_Slab
      {
        public Double(String name, Glass_Slab slabIn, boolean ignoreSimilarityIn)
          {
			super(name, slabIn, ignoreSimilarityIn);
		  }
		public boolean isDouble()
          {
            return true;
          }
      }
    public static class Half extends Glass_Slab
      {
        public Half(String name, Glass_Slab slabIn, boolean ignoreSimilarityIn)
          {
			super(name, slabIn, ignoreSimilarityIn);
		  }
		public boolean isDouble()
          {
            return false;
          }
      }
	@Override
	public boolean isDouble()
	  {
        IBlockState iblockstate = this.blockState.getBaseState();
        if (this.isDouble())
          {
      	    return true;
          }
        else
          {
       	    return false;
          }
	  }
    public boolean isFullCube(IBlockState state)
      {
        return false;
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
        return !this.isDouble();
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
    public IBlockState getStateFromMeta(int meta)
      {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Glass_Slab.Variant.DEFAULT);
        if (!this.isDouble())
          {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
          }
        return iblockstate;        
      }
    public int getMetaFromState(IBlockState state)
      {
        int i = 0;
        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
          {
            i |= 8;
          }
        return i;
      }
    protected BlockStateContainer createBlockState()
      {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}): new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
      }
    public String getUnlocalizedName(int meta)
      {
        return super.getUnlocalizedName();
      }
    public IProperty<?> getVariantProperty()
      {
        return VARIANT;
      }
    public Comparable<?> getTypeForItem(ItemStack stack)
      {
        return Glass_Slab.Variant.DEFAULT;
      }
    public static enum Variant implements IStringSerializable
      {
        DEFAULT;
        public String getName()
          {
            return "default";
          }
      }
  }