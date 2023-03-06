package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class SquareTest {

    private Square square = new Square();

    @Test
    public void shouldFirstPerfectSquare() {
        assertEquals(0, square.firstPerfectSquare(-1));
        assertEquals(1, square.firstPerfectSquare(0));
        assertEquals(4, square.firstPerfectSquare(1));
        assertEquals(9, square.firstPerfectSquare(4));
        assertEquals(16, square.firstPerfectSquare(9));
        assertEquals(25, square.firstPerfectSquare(16));

        assertEquals(9, square.firstPerfectSquare(6));
        assertEquals(16, square.firstPerfectSquare(11));
        assertEquals(25, square.firstPerfectSquare(23));


    }


}