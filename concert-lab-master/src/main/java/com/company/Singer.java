package com.company;

public class Singer extends Artist {
    private final String genre;

    public Singer(String name, String phone, int popularity, int teamPersons, boolean needAccommodation, String genre) {
        super(name, phone, popularity, teamPersons, needAccommodation);
        this.genre = genre;
    }

    @Override
    public String perform() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());
        sb.append(" is singing in ");
        sb.append(genre);
        sb.append(" genre");

        return sb.toString();
    }

    @Override
    public String perform(Instrument instrument) {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());
        sb.append(" is singing in ");
        sb.append(genre);
        sb.append(" genre using ");
        sb.append(instrument.getFullName());
        sb.append(" instrument");

        return sb.toString();
    }
}
