package com.olven.core.event;

import com.olven.core.event.Event;
import com.olven.core.instance.Game;

public abstract class Responder implements ResponderInterface {
    private Event event;

    public abstract void apply(Object val);
    public abstract void expire();

    public void setEvent(Event event) {
        this.event = event;
        Game.addResponder(this);
    }

    public Event getEvent() {
        return event;
    }
}
