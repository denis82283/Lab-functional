package com.company;

public class ArtistTeam {
    int personsCount;
    boolean needAccommodation;

    public ArtistTeam(int personsCount, boolean needAccommodation) {
        this.personsCount = personsCount;
        this.needAccommodation = needAccommodation;
    }

    public int getPersonsCount() {
        return personsCount;
    }

    public boolean isNeedAccommodation() {
        return needAccommodation;
    }
}
