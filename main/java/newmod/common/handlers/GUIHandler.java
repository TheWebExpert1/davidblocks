package newmod.common.handlers;

import newmod.client.guis.GuiCombiner;
import newmod.client.guis.GuiCompressor;
import newmod.common.blocks.machines.combiner.Combiner_Container;
import newmod.common.blocks.machines.compressor.Compressor_Container;
import newmod.common.config.Framework;
import newmod.common.config.Reference;
import newmod.common.tileentities.Combiner_TileEntity;
import newmod.common.tileentities.Compressor_TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler
  {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	  {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(entity != null)
		  {
			switch(ID)
			  {
			    case Reference.GUI_COMPRESSOR:
				  if(entity instanceof Compressor_TileEntity) 
				    {
				      return new Compressor_Container(player.inventory, (Compressor_TileEntity)entity);
				    }
			    case Reference.GUI_COMBINER:
				  if(entity instanceof Combiner_TileEntity) 
				    {
				      return new Combiner_Container(player.inventory, (Combiner_TileEntity)entity);
				    }
			  }
		  }
		return null;
	  }
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	  {
		TileEntity entity = world.getTileEntity(new BlockPos(x,y,z));
		if(entity != null)
		  {
			switch(ID)
			  {
			    case Reference.GUI_COMPRESSOR:
				  if(entity instanceof Compressor_TileEntity) 
				    {
					  return new GuiCompressor(player.inventory, (Compressor_TileEntity)entity);
				    }
			    case Reference.GUI_COMBINER:
				  if(entity instanceof Combiner_TileEntity) 
				    {
					  return new GuiCombiner(player.inventory, (Combiner_TileEntity)entity);
				    }
				  return null;
			  }
		  }
		return null;
	  }
	public static void register()
	  {
		NetworkRegistry.INSTANCE.registerGuiHandler(Framework.instance, new GUIHandler());
	  }
  }