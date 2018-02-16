package com.olven.core.instance.stages;

public enum Stages {
    Production("Production"),
    Debugging("Debugging");

    public final String name;

    Stages(String name) {

        this.name = name;
    }


    public String getName() {
        return name;
    }
}
