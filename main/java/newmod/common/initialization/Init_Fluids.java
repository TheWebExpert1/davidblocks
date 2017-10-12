package newmod.common.initialization;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import newmod.common.config.Reference;
import newmod.common.fluids.Fluid_Base;
import newmod.common.fluids.Fluid_Oil;

public class Init_Fluids
  {
	public static void register()
	  {
		FluidRegistry.registerFluid(Fluid_Oil.instance);
		ForgeRegistries.BLOCKS.register(Fluid_Base.instance);
		Item oil = Item.getItemFromBlock(Fluid_Base.instance);
		ModelLoader.setCustomMeshDefinition(oil, new ItemMeshDefinition()
		  {			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack)
			  {
				return Fluid_Base.oil_location;
			  }
		  });
		ModelLoader.setCustomStateMapper(Fluid_Base.instance, new StateMapperBase()
		  {			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			  {
				return Fluid_Base.oil_location;
			  }
		  });
		FluidRegistry.addBucketForFluid(Fluid_Oil.instance);
	  }	
  }