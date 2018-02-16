package com.olven.core.entities.effects.debuffs;

import com.olven.core.instance.Game;
import com.olven.core.entities.attributes.Attributes;
import com.olven.core.entities.effects.Effect;
import com.olven.core.event.events.StartOfCombatEvent;

public class Crippled extends Effect {

    public Crippled() {
        this(1);
    }

    public Crippled(int rank) {
        super(rank);
        this.setEvent(new StartOfCombatEvent());
    }

    public void apply(Object val) {
        Game.print("crippled");
        Game.player.stats.getStat(Attributes.Dexterity).reduceTemporary(this.getRank() * 2);
    }

    public void expire() {
        Game.player.stats.getStat(Attributes.Dexterity).gainTemporary(this.getRank() * 2);
    }
}
