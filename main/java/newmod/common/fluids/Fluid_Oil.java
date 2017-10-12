package newmod.common.fluids;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.config.Reference;

public final class Fluid_Oil extends Fluid 
  {
	public static final Fluid_Oil instance = new Fluid_Oil();

	public Fluid_Oil()
	  {
		super(Fluid_Base.name, new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + Fluid_Base.name  + "_still"), new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + Fluid_Base.name  + "_flow"));
		this.setViscosity(50000);
	  }
	public boolean isFireSource(World world, int x, int y, int z, int metadata, int face)
	  {
	    return true;
	  }
  }