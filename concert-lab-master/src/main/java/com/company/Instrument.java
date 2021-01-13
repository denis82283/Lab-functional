package com.company;

public class Instrument {
    String name;
    InstrumentType type;

    public Instrument(String name, InstrumentType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public String getFullName() {
        return name + " (" + this.type + ")";
    }
}
