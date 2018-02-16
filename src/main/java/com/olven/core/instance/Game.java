package com.olven.core.instance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.olven.core.encounters.LootTable;
import com.olven.core.entities.attributes.Stats;
import com.olven.core.event.Responder;
import com.olven.core.entities.player.Player;
import com.olven.core.event.Event;
import com.olven.core.instance.parsers.ArmorParser;
import com.olven.core.instance.parsers.ItemSetParser;
import com.olven.core.instance.parsers.LootTableParser;
import com.olven.core.instance.parsers.Parser;
import com.olven.core.instance.stages.Stages;
import com.olven.core.items.Item;
import com.olven.core.sets.ItemSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static Scanner reader = new Scanner(System.in);
    public static Player player;
    public static Storage storage = new Storage();
    private static Game self;
    private List<Responder> responders = new ArrayList<>();
    private Stages stage;

    public static void log(Object msg) {
        if (self.stage == Stages.Debugging) {
            System.out.println(msg);
        }
    }

    public static String readText(Object msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        scanner.close();

        return result;
    }

    public static Object readInt(Object msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        scanner.close();

        return result;
    }

    public static void init() {
        init(Stages.Production);
    }

    public static void init(Stages stage) {
        self = new Game();
        Game.setStage(stage);


        Game.log("Loading resources");
        Game.log("----------------");
        new LootTableParser();
        new ItemSetParser();
        new ArmorParser();
        Game.log("----------------");

        if (stage == Stages.Debugging) {
            Game.log("Game is running in DEBUGGING mode");
        }

        Game.print("Welcome to the world of PixlWarriors!");
        Game.createPlayer(Game.readText("What is your name?"), "female");
        Game.print("Welcome " + Game.charName());
    }

    public static Item item(String key) {
        return (Item) storage.getCollection().get("item." + key);
    }

    public static LootTable table(String key) {
        return (LootTable) storage.getCollection().get("table." + key);
    }

    public static ItemSet itemSet(String key) {
        return (ItemSet) storage.getCollection().get("item_set." + key);
    }

    public static void print(Object msg) {
        System.out.println(msg);
    }

    public static void paste(Object msg) {
        System.out.print(msg);
    }

    public static void createPlayer(String name, String gender) {
        if (player == null) {
            player = new Player(name, gender);
        } else {
            Game.log("Error, player already defined");
        }
    }

    public static void deletePlayer() {
        self.player = null;
    }

    public static String charName() {
        return self.player.getPlayerName();
    }

    public static Game get() {
        return self;
    }

    public static Stats attributes() {
        return self.player.stats;
    }

    public static void addResponder(Responder responder) {
        self.responders.add(responder);
    }

    public static void emit(Event event) {
        self.responders.forEach(mapping -> {
            if (mapping.getEvent().getClass() == event.getClass()) {
                mapping.apply(event.getVal());
            }
        });
    }

    public Stages getStage() {
        return stage;
    }

    public static void setStage(Stages stage) {
        self.stage = stage;

    }

    public Player getPlayer() {
        return player;
    }
}
