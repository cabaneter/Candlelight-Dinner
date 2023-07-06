package satisfyu.candlelight.client.gui.handler;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import satisfyu.candlelight.registry.ObjectRegistry;
import satisfyu.candlelight.registry.ScreenHandlerTypeRegistry;
/*

public class LetterGuiHandler extends AbstractContainerMenu {
    private final Container inventory;
    public static String name = "";

    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public LetterGuiHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, new SimpleContainer(3));
    }


    //This constructor gets called from the BlockEntity on the server without calling the other constructor first, the server knows the inventory of the container
    //and can therefore directly provide it as an argument. This inventory will then be synced to the client.
    public LetterGuiHandler(int syncId, Inventory playerInventory, Container inventory) {
        super(ScreenHandlerTypeRegistry.LETTER_SCREEN_HANDLER.get(), syncId);
        checkContainerSize(inventory, 3);
        this.inventory = inventory;
        //some inventories do custom logic when a player opens it.
        inventory.startOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job
        int m;
        int l;
        //Our inventory

        this.addSlot(new Slot(inventory, 0, 80 + 18 - 100 + 30 + 5, 15 - 2));
        this.addSlot(new Slot(inventory, 1, 80 + 18 - 100 + 30 + 5, 15 + 18 + 25 - 8));

        this.addSlot(new OutputSlot(inventory, 2, 64 + 18 + 50 - 30 + 8, 18 + 2 * 18 - 10 + 4, this));
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }


    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        Item inputItem = this.inventory.getItem(0).getItem();
        if ((inputItem == ObjectRegistry.LETTER_OPEN.get() || inputItem == ObjectRegistry.LOVE_LETTER_OPEN.get()) && this.inventory.getItem(1).getItem() == ObjectRegistry.NOTE_PAPER_WRITTEN.get()) {
            ItemStack stack = inputItem == ObjectRegistry.LETTER_OPEN.get() ? new ItemStack(ObjectRegistry.LETTER_CLOSED.get()) : new ItemStack(ObjectRegistry.LOVE_LETTER_CLOSED.get());

            CompoundTag nbtCompound = this.inventory.getItem(1).getTag();
            if (nbtCompound != null) {
                stack.setTag(nbtCompound.copy());
            }

            stack.addTagElement("letter_title", StringTag.valueOf(name));

            this.inventory.setItem(2, stack);
        } else if ((this.inventory.getItem(1).getItem() == ObjectRegistry.LETTER_OPEN.get() && this.inventory.getItem(0).getItem() == ObjectRegistry.NOTE_PAPER_WRITTEN.get())) {
            ItemStack stack = new ItemStack(ObjectRegistry.LETTER_CLOSED.get());

            CompoundTag nbtCompound = this.inventory.getItem(0).getTag();
            if (nbtCompound != null) {
                stack.setTag(nbtCompound.copy());
            }

            stack.addTagElement("letter_title", StringTag.valueOf(name));

            this.inventory.setItem(2, stack);
        } else {
            this.inventory.setItem(2, ItemStack.EMPTY);
        }
    }

    @Override
    public void slotsChanged(Container inventory) {
        super.slotsChanged(inventory);

    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (player instanceof ServerPlayer) {
            for (int i = 0; i < this.inventory.getContainerSize(); i++) {
                ItemStack itemStack = this.inventory.getItem(i);
                if (!itemStack.isEmpty()) {
                    if (player.isAlive() && !((ServerPlayer) player).hasDisconnected()) {
                        player.getInventory().placeItemBackInInventory(itemStack);
                    } else {
                        player.drop(itemStack, false);
                    }
                }
            }
        }

    }

    @Override
    public boolean stillValid(Player player) {
        return this.inventory.stillValid(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.inventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }

    public static class OutputSlot extends Slot {
        LetterGuiHandler container;

        public OutputSlot(Container itemHandler, int index, int xPosition, int yPosition, LetterGuiHandler container) {
            super(itemHandler, index, xPosition, yPosition);
            this.container = container;
        }

        @Override
        public void onTake(Player p_190901_1_, ItemStack p_190901_2_) {
            this.container.inventory.setItem(0, ItemStack.EMPTY);
            this.container.inventory.setItem(1, ItemStack.EMPTY);
        }

        @Override
        public boolean mayPlace(ItemStack p_75214_1_) {
            return false;
        }

    }
}

 */