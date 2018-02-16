package com.olven.core.entities.enemies;

import com.olven.core.entities.Entity;
import com.olven.core.entities.attributes.Stats;

public class Enemy extends Entity {

    private int level;
    public Enemy(int baseHealth, int level, Stats stats) {
        super(baseHealth, stats);

        this.level = level;
    }
}
