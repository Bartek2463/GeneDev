package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ConvertTest {

   private Convert convert = new Convert();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution 10 should equal to IX", "IX", convert.romanNumberExamples(9));
        assertEquals("solution 5  should equal to V", "V", convert.romanNumberExamples(5));
        assertEquals("solution 1  should equal to I", "I", convert.romanNumberExamples(1));
        assertEquals("solution 10 should equal to X", "X", convert.romanNumberExamples(10));
        assertEquals("solution 6 should equal to VI", "VI", convert.romanNumberExamples(6));
        assertEquals("solution 2 should equal to II", "II", convert.romanNumberExamples(2));
    }
}

