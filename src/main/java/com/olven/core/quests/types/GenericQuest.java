package com.olven.core.quests.types;

import com.olven.core.entities.NPC.NPC;
import com.olven.core.event.Event;
import com.olven.core.quests.Quest;

public class GenericQuest extends Quest {

    public GenericQuest(String name, String description, NPC completesAt, Event event, boolean main) {
        super(name, description, completesAt, main);

        this.setEvent(event);
    }
}
