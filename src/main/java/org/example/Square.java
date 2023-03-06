package org.example;

/**
 * Write a function that returns the first perfect square that is greater than its integer argument.
 * A perfect square is an integer that is equal to some integer squared. For example 16 is a perfect
 * square because 16 = 4 * 4. However 15 is not a perfect square because there is no integer n such
 * that 15 = n*n.
 */

public class Square {

    public int firstPerfectSquare(int number) {

        int numberPlus = 1;
        int exponent = 2;

        if (number < 0) return 0;

        int equalWidth = (int) Math.floor(Math.sqrt(number));
        return (int) Math.pow(equalWidth + numberPlus, exponent);
    }


}
