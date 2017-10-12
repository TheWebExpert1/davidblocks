package newmod.common.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import newmod.common.tileentities.Combiner_TileEntity;
import newmod.common.tileentities.Compressor_TileEntity;

public class TileEntityHandler 
  {
	public static void register()
	  {
		GameRegistry.registerTileEntity(Compressor_TileEntity.class, "compressor");
		GameRegistry.registerTileEntity(Combiner_TileEntity.class, "combiner");
	  }
  }