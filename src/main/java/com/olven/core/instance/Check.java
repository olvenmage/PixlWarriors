package com.olven.core.instance;

import com.olven.core.entities.Entity;
import com.olven.core.entities.attributes.Attributes;
import com.olven.core.items.CombatItem;
import com.olven.core.items.armor.lib.Armor;
import com.olven.core.items.armor.slots.ItemSlots;

import java.util.Map;

public class Check {

    public static boolean requirements(Entity entity, CombatItem item) {

        if (!item.hasRequirements()) {
            return true;
        }

        for (Map.Entry entry : item.getRequirements().entrySet()) {
            if (((int) entry.getValue() > entity.stats.getStat((Attributes) entry.getKey()).getBase())) {
                return false;
            }
        }

        return true;
    }

    public static boolean slotAvailable(Entity entity, Armor item) {
        ItemSlots slot = item.getSlot();

        return true;
    }
}
