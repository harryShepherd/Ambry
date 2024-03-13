package com.napier.Ambry;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AmbryIntegrationTest {

    static Database db;

    @BeforeAll
    static void init() {
        db = new Database();
        db.connect("localhost:33060", 30000);
    }

    @Test
    void testCountryStandard() {
        // Test to see if an error is thrown given a blank input
        assertThrows(RuntimeException.class, () -> Country.CountryStandard(""));

        // Test to see if SQL statements execute correctly, and return expected output
        assertEquals(
                "Aruba",
                Country.CountryStandard("SELECT * FROM country LIMIT 1").get(0).getName()
        );
    }

    @Test
    void testCityStandard() {
        // Test to see if an error is thrown given a blank input
        assertThrows(
                RuntimeException.class,
                () -> City.CityStandard("")
        );

        // Test to see if SQL statements execute correctly, and return expected output
        assertEquals(
                "Kabul",
                City.CityStandard("SELECT * FROM city LIMIT 1").get(0).getName()
        );
    }

    @Test
    void testGetAllCountryLargeToSmall() {
        assertEquals("China", Country.getAllCountryLargeToSmall().get(0).getName());
    }

    @Test
    void testGetAllCountryPerContinent() {
        assertEquals("Australia", Country.getAllCountryPerContinent("Oceania").get(0).getName());
    }

    @Test
    void testGetAllCountryPerRegion() {
        assertEquals("United States", Country.getAllCountryPerRegion("North America").get(0).getName());
    }

    @Test
    void testTopNWorld() {
        ArrayList<Country> arr = Country.TopNWorld(10);
        assertEquals(10, arr.size());
        assertEquals("China", arr.get(0).getName());
    }
}
