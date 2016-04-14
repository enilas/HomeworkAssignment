package com.weather.channel.triangle;

/**
 * Class to determine what type a triangle is depending on what the length of its sides are.
 * <p>
 * Created by Paul on 4/14/2016.
 */
class Triangle {


    enum TriangleType {EQUILATERAL, ISOSCELES, SCALENE}

    TriangleType getType(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Length of sides cannot be equal to or less than zero.");
        }

        checkTriangleValidity(a, b, c);

        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        } else if (a == b || b == c || a == c) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }

    /**
     * The largest side of a triangle must be shorter than the sum of its two shorter sides
     * according to the Triangle Inequality Theorem.
     *
     * @param a
     * @param b
     * @param c
     */
    private static void checkTriangleValidity(int a, int b, int c) {

        int max = Math.max(a, Math.max(b, c));

        if (max == a) {
            if (a >= Math.addExact(b, c)) {
                throw new IllegalArgumentException("The longest side of the triangle is larger than the sum of its two shorter sides.");
            }
        } else if (max == b) {
            if (b >= Math.addExact(a, c)) {
                throw new IllegalArgumentException("The longest side of the triangle is larger than the sum of its two shorter sides.");
            }
        } else {
            if (c >= Math.addExact(a, b)) {
                throw new IllegalArgumentException("The longest side of the triangle is larger than the sum of its two shorter sides.");
            }
        }

    }

}
