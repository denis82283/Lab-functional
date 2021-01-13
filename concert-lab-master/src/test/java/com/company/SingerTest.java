package com.company;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SingerTest {
    @Test
    public void PerformResultWithoutInstrument() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");

        var result2 = acdc.perform();
        var desiredResult2 = "AC/DC is singing in Rock genre";

        assertEquals(result2, desiredResult2);
    }

    @Test
    public void PerformResultWithInstrument() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var instrument = new Instrument("Guitar", InstrumentType.String);

        var result1 = acdc.perform(instrument);
        var desiredResult1 = "AC/DC is singing in Rock genre using Guitar (String type - String instruments, stringed instruments, or chordophones are musical instruments that produce sound from vibrating strings when the performer plays or sounds the strings in some manner.) instrument";

        assertEquals(result1, desiredResult1);
    }

    @Test
    public void PerformResultWithMockInstrument() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var instrument = mock(Instrument.class);

        when(instrument.getFullName()).thenReturn("Test Instrument");

        assertEquals(acdc.perform(instrument), "AC/DC is singing in Rock genre using Test Instrument instrument");
        verify(instrument).getFullName();
    }
}
