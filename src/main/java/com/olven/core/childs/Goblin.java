package com.olven.core.childs;

import com.olven.core.items.armor.ArmorClass;
import com.olven.core.items.armor.ArmorTypes;
import com.olven.core.entities.attributes.Stats;
import com.olven.core.entities.enemies.Enemy;
import com.olven.core.entities.attack.DamageClass;
import com.olven.core.entities.attack.DamageTypes;

public class Goblin extends Enemy {

    private String image;
    private DamageClass damageClass;
    private ArmorClass armorClass;

    public Goblin(int baseHealth, int level, Stats stats) {
        super(baseHealth, level, stats);

        this.image = "";
        this.damageClass = DamageTypes.slashing;
        this.armorClass = ArmorTypes.light;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DamageClass getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(DamageClass damageClass) {
        this.damageClass = damageClass;
    }

    public ArmorClass getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(ArmorClass armorClass) {
        this.armorClass = armorClass;
    }
}
