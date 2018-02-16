package com.olven.core.entities.attributes;

public class Attribute {
    private String name;
    private int base;
    private int current;

    public Attribute(String name, int base) {
        this.name = name;
        this.base = base;
        this.current = base;
    }

    public String getName() {
        return name;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getCurrent() {
        return current;
    }

    public void gainTemporary(int temporary) {
        this.current += temporary;
    }
    public void reduceTemporary(int temporary) {
        this.current -= temporary;
    }

    public void resetTemporary() {
        this.current = base;
    }
}
