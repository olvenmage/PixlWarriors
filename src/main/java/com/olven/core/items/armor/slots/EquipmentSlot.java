package com.olven.core.items.armor.slots;

import com.olven.core.items.Item;

public class EquipmentSlot {
    private boolean empty;

    private Item item;

    EquipmentSlot() {
        this.empty = true;
    }

    public void empty() {
        this.item = null;
        this.empty = true;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        this.empty = false;
    }


}
