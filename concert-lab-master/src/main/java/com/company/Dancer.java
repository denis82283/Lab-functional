package com.company;

public class Dancer extends Artist {
    protected String style;
    protected String firstname;
    protected String lastname;

    public Dancer(String name, String phone, int popularity, int teamPersons, boolean needAccommodation, String style) {
        super(name, phone, popularity, teamPersons, needAccommodation);
        this.style = style;

        String[] parts = name.split(" ");

        this.firstname = parts[0];

        if (parts.length > 2) {
            this.lastname = parts[1];
        }
    }

    public Dancer(String name, String phone, int popularity, ArtistTeam team, String style) {
        super(name, phone, popularity, team);
        this.style = style;

        String[] parts = name.split(" ");

        this.firstname = parts[0];

        if (parts.length > 2) {
            this.lastname = parts[1];
        }
    }

    @Override
    public String perform() {
        var sb = new StringBuilder();
        sb.append(getName());
        sb.append(" is dancing in ");
        sb.append(style);
        sb.append(" style");

        return sb.toString();
    }

    @Override
    public String perform(Instrument instrument) {
        throw new NotPerformableException();
    }
}
