package newmod.common.blocks.machines.combiner;

import java.util.List;
import com.google.common.collect.Lists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.blocks.machines.Custom_Slot1;
import newmod.common.blocks.machines.Custom_Slot2;
import newmod.common.blocks.machines.Custom_Slot3;
import newmod.common.tileentities.Combiner_TileEntity;

public class Combiner_Container extends Container
  {
	private final IInventory tileCombiner;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private Slot slot;
    
    public Combiner_Container(InventoryPlayer playerInventory, IInventory combinerInventory)
      {
    	this.tileCombiner = combinerInventory;
        this.addSlotToContainer(new Slot(combinerInventory, 0, 49, 27));
        this.addSlotToContainer(new Slot(combinerInventory, 1, 49, 57));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, combinerInventory, 2, 109, 42));
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
            if (this.cookTime != this.tileCombiner.getField(2))
              {
                icontainerlistener.sendWindowProperty(this, 2, this.tileCombiner.getField(2));
              }
            if (this.furnaceBurnTime != this.tileCombiner.getField(0))
              {
                icontainerlistener.sendWindowProperty(this, 0, this.tileCombiner.getField(0));
              }
            if (this.currentItemBurnTime != this.tileCombiner.getField(1))
              {
                icontainerlistener.sendWindowProperty(this, 1, this.tileCombiner.getField(1));
              }
            if (this.totalCookTime != this.tileCombiner.getField(3))
              {
                icontainerlistener.sendWindowProperty(this, 3, this.tileCombiner.getField(3));
              }
          }
        this.cookTime = this.tileCombiner.getField(2);
        this.furnaceBurnTime = this.tileCombiner.getField(0);
        this.currentItemBurnTime = this.tileCombiner.getField(1);
        this.totalCookTime = this.tileCombiner.getField(3);
      }    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
      {
        this.tileCombiner.setField(id, data);
      }   
    public boolean canInteractWith(EntityPlayer playerIn)
      {
        return this.tileCombiner.isUsableByPlayer(playerIn);
      }    
    /*public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
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
      }*/
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                //if (FurnaceRecipes.getSmeltingResult(itemstack1) != null)
                //{
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                //}
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }
            if (itemstack1.isEmpty() == true)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
            //slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }	
  }