package com.olven.core.event.events;

import com.olven.core.entities.enemies.Enemy;
import com.olven.core.event.Event;

public class KillEnemyEvent extends Event {

    public KillEnemyEvent(Enemy enemy) {
        this.setVal(enemy);
    }
}
