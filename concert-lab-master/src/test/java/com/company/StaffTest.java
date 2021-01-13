package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTest {
    @Test
    public void StaffEqualsSameTypeAndName() {
        var s1 = new Staff(StaffType.Organizer, "Den");
        var s2 = new Staff(StaffType.Organizer, "Den");

        assertEquals(s1, s2);
    }

    @Test
    public void StaffEqualsToItself() {
        var s1 = new Staff(StaffType.Organizer, "Den");

        assertEquals(s1, s1);
    }

    @Test
    public void StaffNotEquals() {
        var s1 = new Staff(StaffType.Organizer, "Den");
        var s3 = new Staff(StaffType.Organizer, "Bob");
        var s4 = new Staff(StaffType.Engineer, "Bob");

        var test_instrument = new Instrument("Test Instrument", InstrumentType.String);

        assertNotEquals(s1, test_instrument);
        assertNotEquals(s1, s3);
        assertNotEquals(s1, s4);
        assertNotEquals(s1, null);
    }

    @Test
    public void StaffToStringConversion() {
        var s1 = new Staff(StaffType.Organizer, "Den");

        assertEquals(s1.toString(), "Staff member: " + s1.name + " - " + s1.type);
    }
}
