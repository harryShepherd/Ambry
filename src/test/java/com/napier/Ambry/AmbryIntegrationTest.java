/*
package com.napier.Ambry;

import org.junit.jupiter.api.*;
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
        assertThrows(RuntimeException.class, () -> CountryReports.CountryStandard(""));

        // Test to see if SQL statements execute correctly, and return expected output
        assertEquals(
                "Aruba",
                CountryReports.CountryStandard("SELECT * FROM country LIMIT 1").get(0).getName()
        );
    }

    @Test
    void testCityStandard() {
        // Test to see if an error is thrown given a blank input
        assertThrows(
                RuntimeException.class,
                () -> CityReports.CityStandard("")
        );

        // Test to see if SQL statements execute correctly, and return expected output
        assertEquals(
                "Kabul",
                CityReports.CityStandard("SELECT * FROM city LIMIT 1").get(0).getName()
        );
    }

    @Test
    void testGetAllCountryLargeToSmall() {
        // Test to see if results are as expected
        assertEquals("China", CountryReports.getAllCountryLargeToSmall().get(0).getName());
    }

    @Test
    void testGetAllCountryPerContinent() {
        // Test to see if results are as expected
        assertEquals("Australia", CountryReports.getAllCountryPerContinent("Oceania").get(0).getName());
    }

    @Test
    void testGetAllCountryPerRegion() {
        // Test to see if results are as expected
        assertEquals("United States", CountryReports.getAllCountryPerRegion("North America").get(0).getName());
    }

    @Test
    void testTopNWorld() {
        ArrayList<Country> arr = CountryReports.TopNWorld(10);
        // Test to see if result is as big as we expect
        assertEquals(10, arr.size());
        // Test to see if results are as expected
        assertEquals("China", arr.get(0).getName());
    }

    @Test
    void testTopNContinent() {
        ArrayList<Country> arr = CountryReports.TopNContinent(10, "Oceania");
        // Test to see if result is as big as we expect
        assertEquals(10, arr.size());
        // Test to see if results are as expected
        assertEquals("Australia", arr.get(0).getName());
    }

    @Test
    void testTopNRegion() {
        ArrayList<Country> arr = CountryReports.TopNRegion(3, "North America");
        // Test to see if result is as big as we expect
        assertEquals(3, arr.size());
        // Test to see if results are as expected
        assertEquals("United States", arr.get(0).getName());
    }

    @Test
    void testWorldCities() {
        // Test to see if results are as expected
        assertEquals("Mumbai (Bombay)", CityReports.WorldCities().get(0).getName());
    }

    @Test
    void testRegionCities() {
        // Test to see if results are as expected
        assertEquals("Berlin", CityReports.RegionCities("Western Europe").get(0).getName());
    }

    @Test
    void testCountryCities() {
        // Test to see if results are as expected
        assertEquals("London", CityReports.CountryCities("United Kingdom").get(0).getName());
    }

    @Test
    void testDistrictCities() {
        // Test to see if results are as expected
        assertEquals("Boston", CityReports.DistrictCities("Massachusetts").get(0).getName());
    }

    @Test
    void testContinentCities() {
        assertEquals("Mumbai (Bombay)", CityReports.ContinentCity("Asia").get(0).getName());
    }
}*/
