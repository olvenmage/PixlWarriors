package com.olven.core.instance.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.olven.core.encounters.LootTable;

import java.util.HashMap;

public class LootTableParser extends Parser {

    public LootTableParser() {
        this.setRef(new TypeReference<HashMap<String, LootTable>>() {});
        this.setURL("/LootTables.yml");
        this.setPrefix("table");

        this.addResources();
    }
}
