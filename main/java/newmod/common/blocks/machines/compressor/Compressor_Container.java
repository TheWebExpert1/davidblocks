package newmod.common.blocks.machines.compressor;

import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.blocks.machines.Custom_Slot1;
import newmod.common.tileentities.Compressor_TileEntity;

public class Compressor_Container extends Container
  {
	private final IInventory tileCompressor;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    
    public Compressor_Container(InventoryPlayer playerInventory, IInventory compressorInventory)
      {
    	this.tileCompressor = compressorInventory;
        this.addSlotToContainer(new Custom_Slot1(compressorInventory, 0, 79, 34));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, compressorInventory, 2, 78, 59));
        for (int i = 0; i < 3; ++i)
          {
            for (int j = 0; j < 9; ++j)
              {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
              }
          }
        for (int k = 0; k < 9; ++k)
          {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
          }
	  }    
	public void addListener(IContainerListener listener)
      {
        super.addListener(listener);
      }    
    public void detectAndSendChanges()
      {
        super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i)
          {
            IContainerListener icontainerlistener = this.listeners.get(i);
            if (this.cookTime != this.tileCompressor.getField(2))
              {
                icontainerlistener.sendWindowProperty(this, 2, this.tileCompressor.getField(2));
              }
            if (this.furnaceBurnTime != this.tileCompressor.getField(0))
              {
                icontainerlistener.sendWindowProperty(this, 0, this.tileCompressor.getField(0));
              }
            if (this.currentItemBurnTime != this.tileCompressor.getField(1))
              {
                icontainerlistener.sendWindowProperty(this, 1, this.tileCompressor.getField(1));
              }
            if (this.totalCookTime != this.tileCompressor.getField(3))
              {
                icontainerlistener.sendWindowProperty(this, 3, this.tileCompressor.getField(3));
              }
          }
        this.cookTime = this.tileCompressor.getField(2);
        this.furnaceBurnTime = this.tileCompressor.getField(0);
        this.currentItemBurnTime = this.tileCompressor.getField(1);
        this.totalCookTime = this.tileCompressor.getField(3);
      }    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
      {
        this.tileCompressor.setField(id, data);
      }   
    public boolean canInteractWith(EntityPlayer playerIn)
      {
        return this.tileCompressor.isUsableByPlayer(playerIn);
      }    
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
      {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack())
          {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2)
              {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                  {
                    return ItemStack.EMPTY;
                  }
                slot.onSlotChange(itemstack1, itemstack);
              }
            else if (index != 1 && index != 0)
              {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty())
                  {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                      {
                        return ItemStack.EMPTY;
                      }
                  }
                else if (index >= 3 && index < 30)
                  {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                      {
                        return ItemStack.EMPTY;
                      }
                  }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                  {
                    return ItemStack.EMPTY;
                  }
              }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
              {
                return ItemStack.EMPTY;
              }
            if (itemstack1.isEmpty())
              {
                slot.putStack(ItemStack.EMPTY);
              }
            else
              {
                slot.onSlotChanged();
              }
            if (itemstack1.getCount() == itemstack.getCount())
              {
                return ItemStack.EMPTY;
              }
            slot.onTake(playerIn, itemstack1);
          }
        return itemstack;
      }
  }