package com.olven.core.sets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.olven.core.instance.Game;
import com.olven.core.items.Item;
import com.olven.core.items.armor.slots.ItemSlots;

import java.util.HashMap;
import java.util.Map;

public class ItemSet {
    private String name;
    private HashMap<String, String> collection;
    //effect

    @JsonCreator
    public ItemSet(String name, HashMap<String, String> collection) {
        this.name = name;
        this.collection = collection;
    }

    public Item get(String string) {
        return Game.item(collection.get(string));
    }

    public boolean check() {
        for (Map.Entry entry : collection.entrySet()) {
            String slot = (String) entry.getKey();
            String item = (String) entry.getValue();

            if (Game.player.getEquiped(slot) != Game.item(item)) {
                return false;
            }
        }

        return true;
    }
}
