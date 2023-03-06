package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

   private Convert convert = new Convert();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution(6) should equal to X", "X", convert.romanNumberExamples(10));
        assertEquals("solution(4) should equal to IX", "IX", convert.romanNumberExamples(9));
        assertEquals("solution(1) should equal to II", "II", convert.romanNumberExamples(2));
    }
}

