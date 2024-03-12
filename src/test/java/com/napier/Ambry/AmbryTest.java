package com.napier.Ambry;

import org.junit.jupiter.api.*;

import static com.napier.Ambry.City.*;
import static org.junit.jupiter.api.Assertions.*;

public class AmbryTest {
    @BeforeAll
    static void init(){

    }

    @Test
    void unitCheckNull(){}

    // Harry
    @Test
    void unitCheckCountryStandard() {
        // Check if CountryStandard throws an error if given an empty string
        assertThrows(Exception.class, () -> Country.CountryStandard(""));
    }

    // Harry
    @Test
    void unitCheckCityStandard(){
        // Check if CityStandard throws an error if given an empty string
        assertThrows(Exception.class, () -> City.CityStandard(""));
    }


    @Test
    void unitGetAllCountryLargeToSmall() {
        assertNotNull(Country.getAllCountryLargeToSmall(), "getAllCountryLargeToSmall() Not Null!");
    }

    @Test
    void unitGetAllCountryPerContinent() {
        assertNotNull(Country.getAllCountryPerContinent("Asia"), "getAllCountryPerContinent() Not Null");
    }

    @Test
    void unitGetAllCountryPerRegion() {
        assertNotNull(Country.getAllCountryPerRegion("Southern Europe"), "getAllCountryPerRegion() Not Null");
    }

    @Test
    void unitTopNWorld(){}

    @Test
    void unitTopNContinent(){}

    @Test
    void unitTopNRegion(){}

    @Test
    void unitWorldCities(){
        assertNotEquals(null, WorldCities());

    }

    @Test
    void unitRegionCities(){
        assertNotEquals(null, RegionCities(""));
    }

    @Test
    void unitCountryCities(){
        assertNotEquals(null, CountryCities(""));
    }

    @Test
    void unitDistrictCities(){
        assertNotEquals(null, DistrictCities(""));
    }


    @Test
    void unitContinentCity()
    {
        assertNotEquals(null, ContinentCity(""));
    }
}


