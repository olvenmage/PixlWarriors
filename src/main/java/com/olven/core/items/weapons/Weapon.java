package com.olven.core.items.weapons;

import com.olven.core.entities.attack.DamageClass;
import com.olven.core.items.CombatItem;

import java.util.HashMap;

public class Weapon extends CombatItem {

    private DamageClass damageType;

//    public Weapon(String name, int sellPrice, DamageClass damageType, int intellectRequired, int strengthRequired, int vitalityRequired, int dexterityRequired) {
//        this(name, sellPrice, damageType, intellectRequired, strengthRequired, vitalityRequired, dexterityRequired, null);
//    }


    public Weapon(String name, int price, HashMap<String, Object> recipe, HashMap<String, Integer> requirements, DamageClass damageType) {
        super(name, price, recipe, requirements);
        this.damageType = damageType;
    }
}
