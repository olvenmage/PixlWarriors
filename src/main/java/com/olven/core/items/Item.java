package com.olven.core.items;

import com.olven.core.instance.Game;
import com.olven.core.inventory.Inventory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("unchecked")
public class Item {

    private int price;

    private String name;

    private HashMap<String, Integer> ingredients;
    private int max;
    private int min;
    private boolean hasRecipe;

    public Item(String name, int price, HashMap<String, Object> recipe) {
        this.name = name;
        this.price = price;

        if (recipe != null) {
            hasRecipe = true;
            if (recipe.get("ingredients") != null) {
                this.ingredients = (HashMap<String, Integer>) recipe.get("ingredients");
            } else {
                this.ingredients = null;
            }

            if (recipe.get("max") != null) {
                this.max =  (int) recipe.get("max");
            } else {
                this.max = 1;
            }

            if (recipe.get("min") != null) {
                this.min =  (int) recipe.get("min");
            } else {
                this.min = 1;
            }
        } else {
            this.ingredients = new HashMap<>();
            this.max = 1;
            this.min = 1;
            this.hasRecipe = false;
        }



    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasRecipe() {
       return hasRecipe;
    }

    public void craft() {
        if (!hasRecipe()) {
            return;
        }

        Inventory inv = Game.player.inventory;
        AtomicBoolean broke = new AtomicBoolean(false);

        ingredients.forEach((item, amount) -> {
            if (!inv.hasItem(Game.item(item), amount)) {
                broke.set(true);
            }
        });


        if (!broke.get()) {
            ingredients.forEach((item, amount) -> {
                inv.useItem(Game.item(item), amount);
            });

            int amount = new Random().nextInt((max - min) + 1) + min;

            Game.player.inventory.addItem(this, amount);
        }
    }


    @Override
    public String toString() {
        return name;
    }
}
