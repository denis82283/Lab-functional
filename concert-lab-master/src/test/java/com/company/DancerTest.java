package com.company;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DancerTest {
    @Test(expected = NotPerformableException.class)
    public void DancerFailToPerformWithInstrument() {
        Dancer dancer = new Dancer("Name", "+380", 10, 3, true, "Hip hop");
        var instrument = new Instrument("Guitar", InstrumentType.String);

        dancer.perform(instrument);
    }

    @Test(expected = NotPerformableException.class)
    public void MockDancerFailToPerformWithInstrument() {
        var dancer = mock(Dancer.class);
        var instrument = new Instrument("Guitar", InstrumentType.String);

        when(dancer.perform(instrument)).thenThrow(NotPerformableException.class);

        dancer.perform(instrument);
    }

    @Test
    public void DancerPerformsWithoutInstrument() {
        var dancer = new Dancer("Name", "+380", 10, 3, true, "Hip hop");

        var result = dancer.perform();

        assertEquals(dancer.name + " is dancing in " + dancer.style + " style", result);
    }
}
