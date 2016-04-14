package com.weather.channel.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paul on 4/14/2016.
 */
class CommonLists {


    private static HashMap<Object, Integer> convertToHashMap(List<Object> list) {
        HashMap<Object, Integer> entrySet = new HashMap<>();

        for (Object object : list) {
            Integer count = entrySet.get(object);
            if (count == null) {
                entrySet.put(object, 1);
            } else {
                entrySet.put(object, ++count);
            }
        }
        return entrySet;
    }

    /**
     * Method for determining whether two lists contain the same values.
     *
     * @param listOne
     * @param listTwo
     * @return
     */
    boolean containsValues(List<Object> listOne, List<Object> listTwo) {

        HashMap<Object, Integer> smaller;
        HashMap<Object, Integer> larger;

        if (listOne == null || listTwo == null || listOne.isEmpty() || listTwo.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null.");
        }
        if (listOne.size() < listTwo.size()) {
            smaller = convertToHashMap(listOne);
            larger = convertToHashMap(listTwo);
        } else {
            smaller = convertToHashMap(listTwo);
            larger = convertToHashMap(listOne);
        }


        for (Map.Entry<Object, Integer> entry : smaller.entrySet()) {
            Object key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key is: " + key + "  Integer is : " + value);
            if (larger.get(key) == null || !larger.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }
}
