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

    @Test
    void testTopCitiesWorld() {
        ArrayList<City> cities = CityReports.TopCitiesWorld(10);
        assertEquals(10, cities.size());
        assertEquals("Mumbai (Bombay)", cities.get(0).getName());
    }

    @Test
    void testTopCitiesContinent() {
        ArrayList<City> cities = CityReports.TopCitiesContinent("Europe", 5);
        assertEquals(5, cities.size());
        assertEquals("Moscow", cities.get(0).getName());
    }

    @Test
    void testTopCitiesRegion() {
        ArrayList<City> cities = CityReports.TopCitiesRegion("Western Europe", 5);
        assertEquals(5, cities.size());
        assertEquals("Berlin", cities.get(0).getName());
    }

    @Test
    void testTopCitiesCountry() {
        ArrayList<City> cities = CityReports.TopCitiesCountry("United Kingdom", 5);
        assertEquals(5, cities.size());
        assertEquals("London", cities.get(0).getName());
    }

    @Test
    void testTopCitiesDistrict() {
        ArrayList<City> cities = CityReports.TopCitiesDistrict("Massachusetts", 5);
        assertEquals(5, cities.size());
        assertEquals("Boston", cities.get(0).getName());
    }

    @Test
    void testCapitalWorld() {
        ArrayList<City> city = CityReports.CapitalWorld();
        assertEquals("Seoul", city.get(0).getName());
    }

    @Test
    void testCapitalContinent() {
        ArrayList<City> city = CityReports.CapitalContinent("North America");
        assertEquals("Ciudad de México", city.get(0).getName());
    }

    @Test
    void testCapitalRegion() {
        ArrayList<City> city = CityReports.CapitalRegion("Western Europe");
        assertEquals("Berlin", city.get(0).getName());
    }

    @Test
    void testWorldCapitals() {
        ArrayList<City> cities = CityReports.WorldCapitals(10);
        assertEquals(10, cities.size());
        assertEquals("Seoul", cities.get(0).getName());
    }

    @Test
    void testContinentCapitals() {
        ArrayList<City> cities = CityReports.ContinentCapitals("North America", 10);
        assertEquals(10, cities.size());
        assertEquals("Ciudad de México", cities.get(0).getName());
    }

    @Test
    void testRegionCapitals() {
        ArrayList<City> cities = CityReports.RegionCapitals("Western Europe", 5);
        assertEquals(5, cities.size());
        assertEquals("Berlin", cities.get(0).getName());
    }

    @Test
    void testPopulationInRegion() {
        int pop = CityReports.PopulationInRegion("Western Europe");
        int pop_in_city = CityReports.PopulationLivingInCitiesRegion("Western Europe");
        int pop_not_in_city = CityReports.PopulationNotLivingInCitiesRegion("Western Europe");
        assertEquals(183247600, pop);

        assertEquals(pop, pop_in_city+pop_not_in_city);
    }

    @Test
    void testPopulationLivingInCitiesRegion() {
        int pop = CityReports.PopulationLivingInCitiesRegion("Western Europe");
        assertEquals(pop, 45683298);
    }

    @Test
    void testPopulationNotLivingInCitiesRegion() {
        int pop = CityReports.PopulationNotLivingInCitiesRegion("Western Europe");
        assertEquals(pop, 137564302);
    }

    @Test
    void testPopulationInContinent() {
        int pop = CityReports.PopulationInContinent("Europe");
        int pop_in_city = CityReports.PopulationLivingInCitiesContinent("Europe");
        int pop_not_in_city = CityReports.PopulationNotLivingInCitiesContinent("Europe");
        assertEquals(730074600, pop);

        assertEquals(pop, pop_in_city+pop_not_in_city);
    }

    @Test
    void testPopulationLivingInCitiesContinent() {
        int pop = CityReports.PopulationLivingInCitiesContinent("Europe");
        assertEquals(241942813, pop);
    }

    @Test
    void testPopulationNotLivingInCitiesContinent() {
        int pop = CityReports.PopulationNotLivingInCitiesContinent("Europe");
        assertEquals(488131787, pop);
    }

    @Test
    void testPopulationInCountry() {
        int pop = CountryReports.PopulationOfCountry("United Kingdom");
        int pop_in_city = CountryReports.PopulationLivingInCities("United Kingdom");
        int pop_not_in_city = CountryReports.PopulationNotLivingInCities("United Kingdom");
        assertEquals(59623400, pop);

        assertEquals(pop, pop_in_city+pop_not_in_city);
    }

    @Test
    void testPopulationLivingInCitiesCountry() {
        int pop = CountryReports.PopulationLivingInCities("United Kingdom");
        assertEquals(22436673, pop);
    }

    @Test
    void testPopulationNotLivingInCitiesCountry() {
        int pop = CountryReports.PopulationNotLivingInCities("United Kingdom");
        assertEquals(37186727, pop);
    }

}
