package com.olven.core.inventory;

import com.olven.core.entities.player.Player;
import com.olven.core.instance.Check;
import com.olven.core.instance.Game;
import com.olven.core.items.CombatItem;
import com.olven.core.items.Item;
import com.olven.core.items.armor.lib.Armor;
import com.olven.core.items.weapons.Weapon;

public class InventorySlot {
    private int index;
    private Item item;
    private int amount;

    public InventorySlot(int index, Item item) {
        this.index = index;
        this.item = item;
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public void equip() {
        if (this.getItem() instanceof CombatItem) {
            Player player = Game.player;

            if (Check.requirements(player, (CombatItem) this.getItem())) {
                if (item instanceof Weapon) {
                    if (player.getWeapon() != null) {
                        player.inventory.addItem(player.getWeapon(), 1);
                    }

                    player.weapon = (CombatItem) this.getItem();
                }

                if (item instanceof Armor) {
                    player.armor.equipSlot((Armor) this.getItem());
                }

            }
        }
    }

    public void unequip() {
        if (this.getItem() instanceof CombatItem) {
            Player player = Game.player;

            player.inventory.addItem(this.getItem(), this.getAmount());
            this.setItem(null, 0);
        }
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void removeAmount(int amount) {
        this.amount -= amount;

        if (this.amount == 0) {
            this.setItem(null, 0);
        }
    }
}
