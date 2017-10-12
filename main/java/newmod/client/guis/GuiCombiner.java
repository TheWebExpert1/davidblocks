package newmod.client.guis;

import newmod.common.blocks.machines.combiner.Combiner_Container;
import newmod.common.config.Reference;
import newmod.common.tileentities.Combiner_TileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCombiner extends GuiContainer
  {
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID + ":textures/gui/combiner.png");
	private final InventoryPlayer playerInv;
	public Combiner_TileEntity tileCombiner;
	
	public GuiCombiner(InventoryPlayer playerInventory, Combiner_TileEntity furnaceInventory) 
	  {
		super(new Combiner_Container(playerInventory, furnaceInventory));
		playerInv = playerInventory;
		tileCombiner = furnaceInventory;
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
		String name = tileCombiner.getDisplayName().getUnformattedText();
		fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 117, this.ySize - 96 + 2, 4210752);
		fontRenderer.drawString("Input #1", 34, 16, 4210752);
		fontRenderer.drawString("Input #2", 34, 47, 4210752);
		fontRenderer.drawString("Output", 102, 28, 4210752);
	  }
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	  {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        if(tileCombiner.isBurning())
          {
        	int k = this.getBurnLeftScaled(43);
        	drawTexturedModalRect(guiLeft + 72, guiTop + 29, 176, 0, 43 - k, 43);
          }
      }
    private int getCookProgressScaled(int pixels)
      {
        int i = this.tileCombiner.getField(2);
        int j = this.tileCombiner.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
      }
    private int getBurnLeftScaled(int pixels)
      {
        int i = this.tileCombiner.getField(1);
        if (i == 0)
          {
            i = 200;
          }
        return this.tileCombiner.getField(0) * pixels / i;
      }
  }