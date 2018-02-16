package com.olven.core.entities;

import com.olven.core.entities.attributes.Stats;
import com.olven.core.entities.effects.Effect;
import com.olven.core.event.Responder;
import com.olven.core.event.events.TakeDamageEvent;
import com.olven.core.instance.Check;
import com.olven.core.instance.Game;
import com.olven.core.items.CombatItem;
import com.olven.core.items.Item;
import com.olven.core.items.armor.lib.Armor;
import com.olven.core.items.armor.slots.Equipment;
import com.olven.core.items.armor.slots.ItemSlots;
import com.olven.core.items.weapons.Weapon;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Entity {
    private int currentHealth;
    private int baseHealth;
    private CopyOnWriteArrayList<Responder> effects = new CopyOnWriteArrayList<>();

    public Stats stats;
    public Equipment armor = new Equipment();
    public CombatItem weapon;

    public Entity(int baseHealth, Stats stats) {
        this.baseHealth = baseHealth;
        this.currentHealth = baseHealth;
        this.stats = stats;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void equipItem(CombatItem item) {
        if (Check.requirements(this, item)) {
            if (item instanceof Weapon) {
                this.weapon = item;
            }

            if (item instanceof Armor) {
                armor.equipSlot((Armor) item);
            }

        }
    }

    public void takeDamage(int amount) {
        Game.emit(new TakeDamageEvent(amount));
        this.currentHealth -= amount;

    }

    public void loseLife(int amount) {
        this.currentHealth -= amount;
    }

    public Item getEquiped(ItemSlots slot) {
        return armor.getEquiped(slot);
    }

    public Item getEquiped(String slot) {
        return armor.getEquiped(slot);
    }

    public CombatItem getWeapon() {
        return weapon;
    }

    public void addEffect(Effect effect) {
        this.effects.add(effect);
    }

    public void removeEffect(Effect effect) {
        effect.expire();
        this.effects.remove(effect);
    }

    public CopyOnWriteArrayList<Responder> getResponders() {
        return effects;
    }

//    public CopyOnWriteArrayList<Effect> getEffects() {
//        return effects;
//    }


    public boolean hasEffect(Effect effect) {
        return effects.contains(effect);
    }

}
