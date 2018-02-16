package com.olven.core.event;

public interface ResponderInterface {
    void apply(Object object);
    void expire();
}
