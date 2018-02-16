package com.olven.core.entities.player;

import com.olven.core.entities.Entity;
import com.olven.core.entities.attributes.Attributes;
import com.olven.core.entities.attributes.Stats;
import com.olven.core.inventory.Inventory;
import com.olven.core.inventory.InventorySlot;
import com.olven.core.items.Item;
import com.olven.core.quests.QuestLog;

import java.util.List;


public class Player extends Entity {
    public QuestLog questLog = new QuestLog();
    private String playerName;
    private String gender;
    private int currentExperience;
    private int maxExperience;
    private int level;
    public Inventory inventory = new Inventory(20);


    public Player(String playerName, String gender) {
        super(40, new Stats(5, 5, 5, 5));

        this.playerName = playerName;
        this.gender = gender;

        this.level = 1;
        this.currentExperience = 0;
        this.maxExperience = ExperienceTable.getRequiredExp(2);

    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    public void setLevel(int level) {
        this.level = level;
        this.maxExperience = ExperienceTable.getRequiredExp(level + 1);
    }

    public void gainExp(int exp) {
        this.currentExperience += exp;
        levelCheck();
    }

    private void levelCheck() {
        while (this.currentExperience >= this.maxExperience) {
            this.currentExperience -= this.maxExperience;
            level++;
            this.maxExperience = ExperienceTable.getRequiredExp(level + 1);
        }
    }

    public int getLevel() {
        return level;
    }

    public InventorySlot invFind(Object search) {
        if (search instanceof String) {
            return inventory.getSlotByName((String) search);
        } else if (search instanceof Integer) {
            return inventory.getSlotByIndex((int) search);
        } else {
            return inventory.getSlotByItem((Item) search);
        }

    }

    public List<InventorySlot> getInventroy() {
        return inventory.getSlotCollection();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getGender() {
        return gender;
    }

    public int getBaseDex() {
        return this.stats.getStat(Attributes.Dexterity).getBase();
    }

    public int getBaseStr() {
        return this.stats.getStat(Attributes.Strength).getBase();
    }

    public int getBaseInt() {
        return this.stats.getStat(Attributes.Intelligence).getBase();
    }

    public int getBaseVit() {
        return this.stats.getStat(Attributes.Vitality).getBase();
    }

    public void setBaseDex(int amount) {
        this.stats.getStat(Attributes.Dexterity).setBase(amount);
    }

    public void setBaseStr(int amount) {
        this.stats.getStat(Attributes.Strength).setBase(amount);
    }

    public void setBaseInt(int amount) {
        this.stats.getStat(Attributes.Intelligence).setBase(amount);
    }

    public void setBaseVit(int amount) {
        this.stats.getStat(Attributes.Vitality).setBase(amount);
    }





}