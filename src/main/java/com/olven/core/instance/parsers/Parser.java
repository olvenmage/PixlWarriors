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
    private TypeReference typeReference;
    private URL url;
    private String prefix;

   public void addResources() {
       ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

       String filename = new File(url.getPath()).getName();

       try {
           HashMap<String, T> read = mapper.readValue(url, typeReference);

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

    public void setURL(String path) {
        url = System.class.getResource(path);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRef(TypeReference ref) {
        this.typeReference = ref;
    }

    public TypeReference getRef() {
        return typeReference;
    }
}
