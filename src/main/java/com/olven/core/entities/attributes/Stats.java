package com.olven.core.entities.attributes;

import java.util.*;

public class Stats {

    private EnumMap<Attributes, Attribute> stats = new EnumMap<>(Attributes.class);

    public Stats(int str, int dex, int vit, int intl) {
        this.stats.put(Attributes.Strength, new Attribute("Strength", str));
        this.stats.put(Attributes.Dexterity, new Attribute("Dexterity", dex));
        this.stats.put(Attributes.Vitality, new Attribute("Vitality", vit));
        this.stats.put(Attributes.Intelligence, new Attribute("Intellect", intl));
    }

    public Attribute getStat(Attributes attributes) {
        return this.stats.get(attributes);
    }

    public EnumMap<Attributes, Attribute> getStats() {
        return stats;
    }
}
