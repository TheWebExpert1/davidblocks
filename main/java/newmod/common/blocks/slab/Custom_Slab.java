package newmod.common.blocks.slab;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Custom_Slab extends BlockSlab
  {
    public static final PropertyEnum<Custom_Slab.Variant> VARIANT = PropertyEnum.<Custom_Slab.Variant>create("variant", Custom_Slab.Variant.class);
    public Custom_Slab mySlab;

    public Custom_Slab(String name, Custom_Slab slabIn)
      {
        super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
	    setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        IBlockState iblockstate = this.blockState.getBaseState();
        mySlab = slabIn;
        if (!this.isDouble())
          {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
          }
        this.setDefaultState(iblockstate.withProperty(VARIANT, Custom_Slab.Variant.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      }
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
      {
        return Item.getItemFromBlock(mySlab);
      }
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
      {
        return new ItemStack(mySlab);
      }
    public IBlockState getStateFromMeta(int meta)
      {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Custom_Slab.Variant.DEFAULT);
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
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}) : new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
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
        return Custom_Slab.Variant.DEFAULT;
      }
    public static class Double extends Custom_Slab
      {
        public Double(String name, Custom_Slab slabIn)
          {
			super(name, slabIn);
		  }
		public boolean isDouble()
          {
            return true;
          }
      }
    public static class Half extends Custom_Slab
      {
        public Half(String name, Custom_Slab slabIn)
          {
			super(name, slabIn);
		  }
		public boolean isDouble()
          {
            return false;
          }
      }
    public static enum Variant implements IStringSerializable
      {
        DEFAULT;
        public String getName()
          {
            return "default";
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
  }