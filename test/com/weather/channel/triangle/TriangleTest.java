package com.weather.channel.triangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul on 4/14/2016.
 */
public class TriangleTest {

    private static Triangle triangle;

    @Before
    public void setUp() {
        triangle = new Triangle();
    }


    @Test
    public void scaleneTest() {
        assertEquals(Triangle.TriangleType.SCALENE, triangle.getType(2, 3, 4));
    }

    @Test
    public void isoscelesTest() {
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType(2, 2, 3));
    }

    @Test
    public void equilateralTest() {
        assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.getType(1, 1, 1));
    }

    @Test(expected = ArithmeticException.class)
    public void overflowTestException() {
        triangle.getType(2000000000, 2000000000, 2000000000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalLengthTestException() {
        triangle.getType(0, 1, 1);
        triangle.getType(-1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTriangleValidityTestException() {
        triangle.getType(1, 1, 2);
        triangle.getType(1, 2, 1);
        triangle.getType(2, 1, 1);
    }
}