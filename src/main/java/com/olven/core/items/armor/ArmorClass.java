package com.olven.core.items.armor;

public class ArmorClass {
    private double reduction;
    private int heaviness;

    public ArmorClass(double reduction, int heaviness) {
        this.reduction = reduction;
        this.heaviness = heaviness;
    }

    public double getReduction() {
        return reduction;
    }

    public int getHeaviness() {
        return heaviness;
    }
}
