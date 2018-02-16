package com.olven.core.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemEntity {
    private Item item;
    private int amount;

    @JsonCreator
    public ItemEntity(@JsonProperty("item") Item item, @JsonProperty("amount") int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
