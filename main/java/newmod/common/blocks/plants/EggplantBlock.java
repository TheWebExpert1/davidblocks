package newmod.common.blocks.plants;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import newmod.common.initialization.Init_PlantItems;

public class EggplantBlock extends BlockCrops
  {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	public static final AxisAlignedBB[] PLANT_AABB = new AxisAlignedBB[]
	  {
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.250D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.500D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.750D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.000D, 1.0D)
	  };

	public EggplantBlock(String name) 
	  {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
	  }	
    protected PropertyInteger getAgeProperty()
      {
        return AGE;
      }
    public int getMaxAge()
      {
        return AGE.getAllowedValues().size() - 1;
      }
    protected Item getSeed()
      {
        return Init_PlantItems.eggplantSeeds;
      }
    protected Item getCrop()
      {
        return Init_PlantItems.eggplantItem;
      }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
      {
		super.updateTick(worldIn, pos, state, rand);
      }
    protected int getBonemealAgeIncrease(World worldIn)
      {
        return super.getBonemealAgeIncrease(worldIn) / 3;
      }
    protected BlockStateContainer createBlockState()
      {
        return new BlockStateContainer(this, new IProperty[] {AGE});
      }
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
      {
		int age = ((Integer) state.getValue(this.getAgeProperty())).intValue();
		return getCollisiongForAge(age);
      }
	public AxisAlignedBB getCollisiongForAge(int age)
      {
		return PLANT_AABB[age];
	  }
  }