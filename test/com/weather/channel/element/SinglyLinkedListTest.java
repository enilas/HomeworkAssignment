package com.weather.channel.element;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul on 4/14/2016.
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList<Object> list;

    @Before
    public void setUp() throws Exception {
        list = new SinglyLinkedList<>();
        list.add("A");
        list.add(1);
        list.add(1.0);
        list.add(3);
    }

    @Test
    public void nthToLastTest() {
        assertEquals(3, list.nthToLast(list.getHead(), 0));
        assertEquals(1.0, list.nthToLast(list.getHead(), 1));
        assertEquals(1, list.nthToLast(list.getHead(), 2));
        assertEquals("A", list.nthToLast(list.getHead(), 3));

    }

    @Test(expected = IllegalArgumentException.class)
    public void numberGreaterThanListTestException() {
        list.nthToLast(list.getHead(), 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberLessThanZeroTestException() {
        list.nthToLast(list.getHead(), -20);
    }

    @Test(expected = NullPointerException.class)
    public void nullInputTestException() {
        list.nthToLast(null, 20);
    }
}