package newmod.common.blocks.machines;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Custom_Slot3 extends Slot
  {
    /** The index of the slot in the inventory. */
    private final int slotIndex;
    /** The inventory we want to extract a slot from. */
    public final IInventory inventory;
    /** the id of the slot(also the index in the inventory arraylist) */
    public int slotNumber;
    /** display position of the inventory slot on the screen x axis */
    public int xPos;
    /** display position of the inventory slot on the screen y axis */
    public int yPos;
    public Custom_Slot3(IInventory inventoryIn, int index, int xPosition, int yPosition)
      {
		super(inventoryIn, index, xPosition, yPosition);
        this.inventory = inventoryIn;
        this.slotIndex = index;
        this.xPos = xPosition;
        this.yPos = yPosition;
	  }
    @Override
    public boolean isItemValid(ItemStack stack)
      {
    	boolean valid = true;
    	return valid;
      }
  }