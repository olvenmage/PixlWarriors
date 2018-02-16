package com.olven.core.items.armor.lib;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.olven.core.items.CombatItem;
import com.olven.core.items.armor.slots.ItemSlots;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Armor extends CombatItem {

    private ItemSlots slot;

    public Armor setSlot(ItemSlots slot) {
        this.slot = slot;
        return this;
    }

    @JsonCreator
    public Armor(
            @JsonProperty("name") String name,
            @JsonProperty("price") int price,
            @JsonProperty("requirements") HashMap<String, Integer> requirements,
            @JsonProperty("recipe") HashMap<String, Object> recipe
    ) {
        super(name, price, recipe, requirements);

        this.slot = ItemSlots.Belt;
    }

    public ItemSlots getSlot() {
        return slot;
    }
}
