package com.olven.core.items.armor.slots;

import com.olven.core.instance.Game;
import com.olven.core.items.Item;
import com.olven.core.items.armor.lib.Armor;

import java.util.EnumMap;
import java.util.Map;

public class Equipment {
    private Map<ItemSlots, EquipmentSlot> equipment = new EnumMap<>(ItemSlots.class);

    public Equipment() {
        equipment.put(ItemSlots.Helmet, new EquipmentSlot());
        equipment.put(ItemSlots.Shoulders, new EquipmentSlot());
        equipment.put(ItemSlots.Chestplate, new EquipmentSlot());
        equipment.put(ItemSlots.Leggings, new EquipmentSlot());
        equipment.put(ItemSlots.Gloves, new EquipmentSlot());
        equipment.put(ItemSlots.Boots, new EquipmentSlot());
        equipment.put(ItemSlots.Cloak, new EquipmentSlot());
        equipment.put(ItemSlots.Belt, new EquipmentSlot());
    }

    public void equipSlot(Armor armor) {
        Item currentItem = equipment.get(armor.getSlot()).getItem();
        if (currentItem != null) {
            Game.player.inventory.addItem(currentItem);
        }

        equipment.get(armor.getSlot()).setItem(armor);
        Game.player.inventory.getSlotByItem(armor).setItem(null, 0);
    }

    public Item getEquiped(ItemSlots slot) {

        return equipment.get(slot).getItem();
    }

    public Item getEquiped(String slot) {

        for (Map.Entry entry : equipment.entrySet()) {
            ItemSlots itemSlot = (ItemSlots) entry.getKey();
            EquipmentSlot equipmentSlot = (EquipmentSlot) entry.getValue();

            if (itemSlot.getName().equals(slot)) {
                return equipmentSlot.getItem();
            }
        }

        return null;


    }

}
