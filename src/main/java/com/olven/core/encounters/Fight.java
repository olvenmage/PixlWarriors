package com.olven.core.encounters;

import com.olven.core.entities.effects.Effect;
import com.olven.core.entities.enemies.Enemy;
import com.olven.core.event.events.KillEnemyEvent;
import com.olven.core.instance.Game;
import com.olven.core.entities.Entity;
import com.olven.core.event.events.StartOfCombatEvent;

import java.util.List;

public class Fight {
    private List<Entity> enemies;
    private boolean boss;
    private LootTable lootTable;

    public Fight(List<Entity> enemies, LootTable lootTable) {
        this.enemies = enemies;
        this.lootTable = lootTable;

    }

    public List<Entity> getEnemies() {
        return enemies;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void start() {
       Game.emit(new StartOfCombatEvent());
    }

    public void kill(Enemy enemy) {
        Game.emit(new KillEnemyEvent(enemy));
    }

    public static void endTurn() {
        Game.player.getResponders().forEach(mapping -> {
            Effect effect = (Effect) mapping;
            effect.setDuration(effect.getDuration() - 1);
            if (effect.getDuration() == 0) {
                Game.player.removeEffect(effect);
            }
        });
    }
}
