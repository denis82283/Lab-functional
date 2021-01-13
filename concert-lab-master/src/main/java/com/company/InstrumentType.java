package com.company;

public enum InstrumentType {
    String("String instruments, stringed instruments, or chordophones are musical instruments that produce sound from vibrating strings when the performer plays or sounds the strings in some manner.") {
        @Override
        public java.lang.String toString() {
            return "String type - " + this.getDescription();
        }
    },
    Woodwind("Woodwind instruments are a family of musical instruments within the more general category of wind instruments") {
        @Override
        public java.lang.String toString() {
            return "Woodwind type - " + this.getDescription();
        }
    },
    Brass("A brass instrument is a musical instrument that produces sound by sympathetic vibration of air in a tubular resonator in sympathy with the vibration of the player's lips") {
        @Override
        public java.lang.String toString() {
            return "Brass type - " + this.getDescription();
        }
    };

    String description;

    InstrumentType(java.lang.String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void printDescriptionsList() {
        for (InstrumentType it : InstrumentType.values()) {
            System.out.println(it.getDescription());
        }
    }
}
