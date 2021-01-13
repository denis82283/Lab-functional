package com.company;

import java.util.ArrayList;

public class Staff {
    protected final StaffType type;
    protected final String name;
    protected ArrayList<Artist> connectedArtists;

    public Staff(StaffType type, String name) {
        this.type = type;
        this.name = name;
        this.connectedArtists = new ArrayList<>();
    }

    public ArrayList<Artist> getConnectedArtists() {
        return connectedArtists;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Staff member: " + name + " - " + type);

        if (connectedArtists.size() > 0) {
            s.append(" - Connected Artists:\n");
        }

        for (Artist artist : connectedArtists) {
            s.append(" * ");
            s.append(artist.perform());
            s.append("\n");
        }

        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Staff other = (Staff) obj;

        if (type != other.type)
            return false;

        return name.equals(other.name);
    }
}
