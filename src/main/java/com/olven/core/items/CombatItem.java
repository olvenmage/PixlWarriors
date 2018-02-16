package com.olven.core.items;

import com.olven.core.entities.attributes.Attributes;

import java.util.HashMap;

public abstract class CombatItem extends Item {
    //    private EnumMap<Attributes, Integer> requirements = new EnumMap<>(Attributes.class);
    public HashMap<String, Integer> requirements;
    private boolean hasRequirements;

    public CombatItem(String name, int price, HashMap<String, Object> recipe, HashMap<String, Integer> requirements) {
        super(name, price, recipe);
        if (requirements != null) {
            this.requirements = requirements;
            this.hasRequirements = true;
        } else {
            this.requirements = new HashMap<>();
            this.hasRequirements = false;
        }

    }


    public boolean hasRequirements() {
        return hasRequirements;
    }

    public int getRequirement(Attributes attributes) {
        return requirements.get(attributes);
    }

    public HashMap<String, Integer> getRequirements() {
        return requirements;
    }
}

