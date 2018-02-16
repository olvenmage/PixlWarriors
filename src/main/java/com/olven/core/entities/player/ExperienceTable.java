package com.olven.core.entities.player;

public class ExperienceTable {



    public static int getRequiredExp(int level) {

        int result = 40;
        for (int i = 1; i <= level; i++) {
            double prev = ((i-1) * 25)*1.15;
            result += (prev + i * 25)*1.15;
        }

        return result;

    }




}
