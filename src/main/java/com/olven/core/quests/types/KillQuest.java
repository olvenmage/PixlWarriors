package com.olven.core.quests.types;

import com.olven.core.entities.NPC.NPC;
import com.olven.core.entities.enemies.Enemy;
import com.olven.core.event.events.KillEnemyEvent;
import com.olven.core.instance.Game;
import com.olven.core.quests.Quest;

public class KillQuest extends Quest {
    private Enemy enemy;
    private int amount;
    private int progress;

    public KillQuest(String name, String description, NPC completesAt, Enemy enemy, int amount) {
        super(name, description, completesAt);

        this.enemy = enemy;
        this.amount = amount;
        this.progress = 0;

        this.setEvent(new KillEnemyEvent(null));
    }

    public void complete() {
        Game.print(this.getName() + " completed!");
    }

    @Override
    public void apply(Object object) {
        if (this.enemy == (Enemy) object) {
            this.progress++;
            if (this.progress >= amount) {
                this.complete();
            }
        }
    }


}
