package newmod.common.fluids;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.config.Reference;

public final class Fluid_Base extends BlockFluidClassic
  {
	public static final String name = "oil";
	public static ModelResourceLocation oil_location = new ModelResourceLocation(Reference.MOD_ID + ":" + Fluid_Base.name, "fluid");
	public static final Fluid_Base instance = new Fluid_Base();
	
	public Fluid_Base()
	  {
		super(Fluid_Oil.instance, Material.LAVA);
		setUnlocalizedName("blockoil");
		setRegistryName(oil_location);
      }
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	  {
		if(entityIn instanceof EntityLivingBase)
		  {
			/*((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(19), 100, 10, false, false));
			((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(20), 1, 10, false, false));*/
		  }
	  }	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	  {
		return EnumBlockRenderType.MODEL;
	  }
  }