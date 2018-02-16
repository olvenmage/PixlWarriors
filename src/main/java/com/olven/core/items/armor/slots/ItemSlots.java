package com.olven.core.items.armor.slots;

public enum ItemSlots {
    Helmet("01", "Helmet"),
    Shoulders("02", "Shoulders"),
    Chestplate("03", "Chestplate"),
    Cloak("04", "Cloak"),
    Leggings("05", "Leggings"),
    Gloves("06", "Gloves"),
    Boots("07", "Boots"),
    Belt("08", "Armor"),;

    public final String code;
    public final String name;

    ItemSlots(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
