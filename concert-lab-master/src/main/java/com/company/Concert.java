package com.company;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Concert {
    private final String title;
    GregorianCalendar date;
    private Cashbox cashbox;
    private ArrayList<Artist> artists;
    private ArrayList<Staff> staff;

    public Concert(String title, GregorianCalendar date, float maxCashboxCapacity) {
        this.title = title;
        this.date = date;
        this.cashbox = new Cashbox(maxCashboxCapacity);
        this.artists = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public void inviteArtist(Artist artist) {
        this.artists.add(artist);
    }

    public void addStaff(Staff staff) {
        if (!this.staff.contains(staff)) {
            this.staff.add(staff);
        }
    }

    public String getTitle() {
        return title;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Cashbox getCashbox() {
        return cashbox;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    private class Cashbox {
        private float maxCapacity;
        private float balance = 0;

        public Cashbox(float maxCapacity) {
            this.maxCapacity = maxCapacity;
        }

        @Override
        public String toString() {
            return "" + maxCapacity;
        }
    }
}
