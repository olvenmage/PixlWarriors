package com.olven.core.entities.attributes;

public enum Attributes {
    Strength("str", "Strength"),
    Intelligence("int", "Intelligence"),
    Dexterity("dex", "Dexterity"),
    Wisdom("wis", "Wisdom"),
    Vitality("vit", "Vitality");

    Attributes(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
