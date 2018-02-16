package com.olven.core.instance;

import com.olven.core.items.armor.lib.Armor;
import com.olven.core.items.armor.slots.ItemSlots;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private Map<String, Object> collection = new HashMap<>();

    public void addItem(String key, Object armor, ItemSlots slot) {
        this.collection.put("item." + key, ((Armor) armor).setSlot(slot));
    }

    public void addGeneric(String key, Object table, String prefix) {
        this.collection.put(prefix + "." + key, table);
    }

    public Map<String, Object> getCollection() {
        return collection;
    }
}
