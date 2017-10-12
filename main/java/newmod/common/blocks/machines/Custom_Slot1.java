package newmod.common.blocks.machines;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Custom_Slot1 extends Slot
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
    public Custom_Slot1(IInventory inventoryIn, int index, int xPosition, int yPosition)
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
    	boolean valid = false;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.AIR)) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.COAL_BLOCK)) valid = true;
    	if (stack.getItem() == Items.GLASS_BOTTLE) valid = true;
    	//if (stack.getItem() == Init_Plants.grapesItem) valid = true;
    	//if (stack.areItemsEqual(stack, new ItemStack(Init_Blocks.ceramic_block, 1, 2))) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.GLASS)) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.GLASS_PANE)) valid = true;
        //if (stack.getItem() == ItemBlock.getItemFromBlock(Glass Doors)) valid = true;
    	//if (stack.getItem() == ItemBlock.getItemFromBlock(Init_Blocks.glass_stairs)) valid = true;
    	//if (stack.getItem() == ItemBlock.getItemFromBlock(Init_Blocks.glass_half_slab)) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.TNT)) valid = true;
    	//if (stack.getItem() == Init_Plants.tomatoItem) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.REDSTONE_BLOCK)) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.BONE_BLOCK)) valid = true;
    	//if (stack.areItemsEqual(stack, new ItemStack(Init_Blocks.honey_hex_block, 1, 5))) valid = true;
    	//if (stack.areItemsEqual(stack, new ItemStack(Init_Blocks.honeycomb_block, 1, 4))) valid = true;
    	if (stack.getItem() == ItemBlock.getItemFromBlock(Blocks.DIAMOND_BLOCK)) valid = true;
    	return valid;
      }
  }