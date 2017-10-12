package newmod.client.guis;

import newmod.common.blocks.machines.compressor.Compressor_Container;
import newmod.common.config.Reference;
import newmod.common.tileentities.Compressor_TileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCompressor extends GuiContainer
  {
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID + ":textures/gui/compressor.png");
	private final InventoryPlayer playerInv;
	public Compressor_TileEntity tileCompressor;
	
	public GuiCompressor(InventoryPlayer playerInventory, Compressor_TileEntity furnaceInventory) 
	  {
		super(new Compressor_Container(playerInventory, furnaceInventory));
		playerInv = playerInventory;
		tileCompressor = furnaceInventory;
	  }
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	  {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	  }
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	  {
		String name = tileCompressor.getDisplayName().getUnformattedText();
		fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 117, this.ySize - 96 + 2, 4210752);
		fontRenderer.drawString("Input", 37, 37, 4210752);
		fontRenderer.drawString("Output", 37, 62, 4210752);
	  }
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	  {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        if(tileCompressor.isBurning())
          {
        	int k = this.getBurnLeftScaled(53);
        	int m = 0 + k;
        	drawTexturedModalRect(guiLeft + 111, guiTop + 17, 176, 0, 50, 53 - m);
          }
      }
    private int getCookProgressScaled(int pixels)
      {
        int i = this.tileCompressor.getField(2);
        int j = this.tileCompressor.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
      }
    private int getBurnLeftScaled(int pixels)
      {
        int i = this.tileCompressor.getField(1);
        if (i == 0)
          {
            i = 200;
          }
        return this.tileCompressor.getField(0) * pixels / i;
      }
  }