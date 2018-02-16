package com.olven.core.entities.attack;

import com.olven.core.items.armor.ArmorClass;

public class DamageClass {

    private ArmorClass advantage;
    private ArmorClass disadvantage;

    DamageClass(ArmorClass advantage, ArmorClass disadvantage) {

        this.advantage = advantage;
        this.disadvantage = disadvantage;
    }


    public ArmorClass getAdvantage() {
        return advantage;
    }

    public ArmorClass getDisadvantage() {
        return disadvantage;
    }
}
