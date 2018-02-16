package com.olven.core.inventory;

import com.olven.core.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventorySlot> slotCollection = new ArrayList<>();
    private int length;

    public Inventory(int num) {
        this.length = num;
        for (int i = 0; i < num; i++) {
            slotCollection.add(new InventorySlot(i, null));
        }
    }

    public void addSlots(int num) {
        for (int i = 0; i < num; i++) {
            length++;
            slotCollection.add(new InventorySlot(length, null));
        }
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int amount) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem() == null) {
                slot.setItem(item, amount);
                break;
            }
        }
    }



    public boolean useItem(Item item, int amount) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem() == item) {
                if (amount - slot.getAmount() <= 0) {
                    slot.removeAmount(amount);
                    return true;
                }

            }
        }

        return false;

    }

    public boolean hasItem(Item item, int amount) {
        int req = amount;
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem() == item) {
                if (req - slot.getAmount() <= 0) {
                    return true;
                }

            }
        }

        return false;
    }

    public void removeItem(Item item) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem() == item) {
                slot.setItem(null, 0);
                break;
            }
        }
    }

    public void moveItem(InventorySlot from, InventorySlot to) {
        Item toItem = to.getItem();
        int toAmount = to.getAmount();

        Item fromItem = from.getItem();
        int fromAmount = from.getAmount();

        to.setItem(fromItem, fromAmount);
        from.setItem(toItem, toAmount);
    }

    private void sort() {

        List<InventorySlot> sorted = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (InventorySlot slot : slotCollection) {
                if (slot.getIndex() == i) {
                    sorted.add(slot);
                    break;
                }
            }
        }

        slotCollection = sorted;
    }

    public InventorySlot getSlotByItem(Item item) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem() == item) {
                return slot;
            }
        }

        return null;
    }

    public InventorySlot getSlotByName(String name) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getItem().getName().equals(name)) {
                return slot;
            }
        }

        return null;
    }

    public List<InventorySlot> getSlotCollection() {
        return slotCollection;
    }

    public InventorySlot getSlotByIndex(int index) {
        for (InventorySlot slot : slotCollection) {
            if (slot.getIndex() == index) {
                return slot;
            }
        }

        return null;
    }
}
