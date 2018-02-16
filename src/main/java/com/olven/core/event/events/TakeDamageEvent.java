package com.olven.core.event.events;

import com.olven.core.event.Event;

public class TakeDamageEvent extends Event {

    public TakeDamageEvent(int dmg) {
        this.setVal(dmg);
    }
}