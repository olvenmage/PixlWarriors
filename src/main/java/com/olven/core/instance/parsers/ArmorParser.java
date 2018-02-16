package com.olven.core.instance.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.olven.core.instance.Game;
import com.olven.core.items.armor.lib.Armor;
import com.olven.core.items.armor.slots.ItemSlots;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

public abstract class ArmorParser {

    public static void parse() {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        HashMap<String, ItemSlots> slots = new HashMap<>();

        slots.put("Belts.yml", ItemSlots.Belt);
        slots.put("Chestplates.yml", ItemSlots.Chestplate);
        slots.put("Helmets.yml", ItemSlots.Helmet);
        slots.put("Cloaks.yml", ItemSlots.Cloak);
        slots.put("Boots.yml", ItemSlots.Boots);
        slots.put("Leggings.yml", ItemSlots.Leggings);
        slots.put("Gloves.yml", ItemSlots.Gloves);
        slots.put("Shoulders.yml", ItemSlots.Shoulders);

        try {
            URL url = System.class.getResource("/armory");

            File dir = null;

            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                dir = new File(url.getPath());
            }


            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File child : directoryListing) {
                    HashMap<String, Armor> read = mapper.readValue(child, new TypeReference<HashMap<String, Armor>>() {
                    });

                    String filename = new File(child.getPath()).getName();

                    Game.log("Loading " + filename);

                    if (!read.isEmpty()) {
                        Game.log("--- " + filename + " ---");

                        read.forEach((key, item) -> {
                            Game.storage.addItem(key, item, slots.get(filename));
                            Game.log("Table [" + key + "] loaded" );
                        });

                        Game.log("Loaded [" + read.size() + "]");
                    }


                }
            }



        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
