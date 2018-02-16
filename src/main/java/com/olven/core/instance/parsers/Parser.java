package com.olven.core.instance.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.olven.core.instance.Game;
import com.olven.core.sets.ItemSet;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser<T> {
    public Parser(String path, String prefix) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        URL url = System.class.getResource(path);
        String filename = new File(url.getPath()).getName();

        try {
            HashMap<String, T> read = mapper.readValue(url, new TypeReference<HashMap<String, T>>() {
            });

            if (!read.isEmpty()) {
                Game.log("--- " + filename + " ---");
                read.forEach((key, table) -> {
                    Game.storage.addGeneric(key, table, prefix);
                    Game.log("Table [" + key + "] loaded");
                });


                Game.log("Loaded [" + read.size() + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected static <T> List<T> mapJsonToObjectList(T typeDef, String json, Class clazz) throws Exception
    {
        List<T> list;
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        TypeFactory t = TypeFactory.defaultInstance();
        list = mapper.readValue(json, t.constructCollectionType(ArrayList.class,clazz));

        return list;
    }
}
