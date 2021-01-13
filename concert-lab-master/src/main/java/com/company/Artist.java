package com.company;

public abstract class Artist implements Performable {
    protected String name;
    protected String phone;
    protected int popularity;
    protected ArtistTeam team;

    public Artist(String name, String phone, int popularity, int teamPersons, boolean needAccommodation) {
        this.name = name;
        this.phone = phone;
        this.popularity = popularity;

        this.team = new ArtistTeam(teamPersons, needAccommodation);
    }

    public Artist(String name, String phone, int popularity, ArtistTeam team) {
        this.name = name;
        this.phone = phone;
        this.popularity = popularity;
        this.team = team;
    }

    public int getPersonsCount() {
        return this.team.getPersonsCount() + 1;
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public String getName() {
        return name;
    }

    public ArtistTeam getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name + " " + popularity + " stars";
    }
}
