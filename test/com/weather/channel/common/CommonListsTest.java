package com.weather.channel.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 4/14/2016.
 */
public class CommonListsTest {

    private CommonLists common;
    private List<Object> commonShortList;
    private List<Object> commonLongList;
    private List<Object> uniqueList;
    private List<Object> emptyList;
    private List<Object> nullList;

    @Before
    public void setUp() throws Exception {

        common = new CommonLists();

        commonShortList = new ArrayList<>();
        commonShortList.add(-1);
        commonShortList.add(-1);
        commonShortList.add(1.0);
        commonShortList.add('a');
        commonShortList.add('a');
        commonShortList.add("A");


        commonLongList = new ArrayList<>();
        commonLongList.add(-1);
        commonLongList.add(-1);
        commonLongList.add(1.0);
        commonLongList.add(3.0);
        commonLongList.add('a');
        commonLongList.add('a');
        commonLongList.add("A");
        commonLongList.add("B");
        commonLongList.add("C");

        uniqueList = new ArrayList<>();
        uniqueList.add("Z");

        emptyList = new ArrayList<>();
    }

    @Test
    public void containsValuesTrueTest() {
        Assert.assertTrue(common.containsValues(commonShortList, commonLongList));
    }

    @Test
    public void containsValuesFalseTest() {
        Assert.assertFalse(common.containsValues(uniqueList, commonShortList));
        Assert.assertFalse(common.containsValues(commonShortList, uniqueList));
    }

    @Test
    public void oppositeOrderTest() {
        Assert.assertTrue(common.containsValues(commonLongList, commonShortList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyListTestException() {
        common.containsValues(commonShortList, emptyList);
        common.containsValues(emptyList, commonShortList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullListTest() {
        common.containsValues(uniqueList, nullList);
        common.containsValues(nullList, uniqueList);
        common.containsValues(uniqueList, null);
        common.containsValues(null, uniqueList);
    }

}