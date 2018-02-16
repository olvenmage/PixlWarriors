package com.olven.core.encounters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.olven.core.instance.Game;
import com.olven.core.items.ItemEntity;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unchecked")
public class LootTable {
    private HashMap<String, HashMap<String, Object>> pool;
    private String name;
    private boolean multiples;

    @JsonCreator
    public LootTable(
            @JsonProperty("name") String name,
            @JsonProperty("multiples") boolean multiples,
            @JsonProperty("pool") HashMap<String, HashMap<String, Object>> pool
    ) {
        this.name = name;
        this.multiples = multiples;
        this.pool = pool;
    }

    public List<ItemEntity> getDrop() {
        List<ItemEntity> loot = new ArrayList<>();

        for (Map.Entry entry : pool.entrySet()) {
            String key = (String) entry.getKey();
            HashMap<String, Object> map = (HashMap<String, Object>) entry.getValue();

            int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if ((int) map.get("chance") >= randomNum) {
                int min = (int) map.get("min");
                int max = (int) map.get("max");

                int amount = new Random().nextInt((max - min) + 1) + min;

                loot.add(new ItemEntity(Game.item(key), amount));

                if (!multiples) {
                    return loot;
                }
            }
        }

        return loot;
    }

    public HashMap<String, HashMap<String, Object>> getPool() {
        return pool;
    }

    public String getName() {
        return name;
    }

    public boolean isMultiples() {
        return multiples;
    }
}
