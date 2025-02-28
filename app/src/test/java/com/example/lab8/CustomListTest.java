package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     */

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City a = new City("test", "test1");
        list.addCity(a);

        assertTrue(list.hasCity(a));

        City b = new City("test2", "test3");
        assertFalse(list.hasCity(b));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City a = new City("test", "test1");

        list.addCity(a);
        assertEquals(list.getCount(), 1);
        assertTrue(list.deleteCity(a));
        assertEquals(list.getCount(), 0);

        assertFalse(list.deleteCity(a));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        City a = new City("test", "test1");
        list.addCity(a);
        assertEquals(1, list.countCities());

        City b = new City("test2", "test3");
        list.addCity(b);
        assertEquals(2, list.countCities());

        list.deleteCity(b);
        assertEquals(1, list.countCities());

        list.deleteCity(a);
        assertEquals(0, list.countCities());
    }


}
