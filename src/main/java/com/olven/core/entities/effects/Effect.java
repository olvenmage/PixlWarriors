package com.olven.core.entities.effects;


import com.olven.core.event.Responder;


public abstract class Effect extends Responder {
    private int duration;
    private int rank;

    public Effect(int rank) {
        this.rank = rank;
    }

    public int getDuration() {
        return duration;
    }

    public void reduceDuration() {
        duration--;
    }

    public Effect setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



    public boolean hasRanks() {
        return this.rank > 0;
    }


}

