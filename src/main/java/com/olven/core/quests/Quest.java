package com.olven.core.quests;

import com.olven.core.entities.NPC.NPC;
import com.olven.core.event.Responder;
import com.olven.core.instance.Game;

public class Quest extends Responder {
    private String name;
    private String description;
    private NPC completesAt;
    private boolean done = false;

    public Quest(String name, String description, NPC completesAt) {
        this.name = name;
        this.description = description;
        this.completesAt = completesAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public NPC getCompletesAt() {
        return completesAt;
    }

    public void turnIn() {
        if (done) {
            Game.player.questLog.remove(this);
            Game.print("turned in");
        }
    }

    public void expire(){}
    public void apply(Object object){}
}
