package com.olven.core.childs;

import com.olven.core.entities.attributes.Stats;
import com.olven.core.entities.enemies.Enemy;

public class Skeleton extends Enemy {

    public Skeleton(int baseHealth, Stats stats) {
        super(baseHealth, 1, stats);
    }

    public  void dance() {
        System.out.println(this + " started dancing");
    }
}
