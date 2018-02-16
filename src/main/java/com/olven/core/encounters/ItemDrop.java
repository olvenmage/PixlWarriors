package com.olven.core.encounters;

import com.olven.core.items.Item;

public class ItemDrop {
    private Item item;
    private int dropChance;
    private int minQuantity;
    private int maxQuantity;

    public ItemDrop(Item item, int dropChance, int minQuantity, int maxQuantity) {
        this.item = item;
        this.dropChance = dropChance;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    public Item getItem() {
        return item;
    }

    public int getDropChance() {
        return dropChance;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }
}
