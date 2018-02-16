package com.olven.core.quests;

import java.util.HashMap;

public class QuestLog {
    private HashMap<String, Quest> collection = new HashMap<>();

    public void add(Quest quest) {
        collection.put(quest.getName(), quest);
    }

    public void remove(Quest quest) {
        collection.remove(quest.getName());
    }

    public Quest get(String string) {
        return collection.get(string);
    }

    public HashMap<String, Quest> all() {
        return collection;
    }
}
