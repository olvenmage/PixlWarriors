package com.olven.core.entities.effects.debuffs;

import com.olven.core.entities.effects.Effect;
import com.olven.core.event.events.StartOfCombatEvent;
import com.olven.core.event.events.TakeDamageEvent;
import com.olven.core.instance.Game;

public class Vulnerable extends Effect {

    public Vulnerable() {
        this(1);
    }

    public Vulnerable(int rank) {
        super(rank);
        this.setEvent(new TakeDamageEvent(0));
    }

    public void apply(Object val) {
        Game.log(val);
    }

    public void expire() {
        System.out.println("Expired!");
    }
}
