package com.olven.core.instance.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.olven.core.sets.ItemSet;

import java.util.HashMap;

public class ItemSetParser extends Parser {
    public ItemSetParser() {
        this.setRef(new TypeReference<HashMap<String, ItemSet>>() {});
        this.setURL("/ItemSets.yml");
        this.setPrefix("item_set");

        this.addResources();
    }
}
