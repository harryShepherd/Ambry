package com.napier.Ambry;

import org.junit.jupiter.api.*;

import static com.napier.Ambry.City.*;
import static org.junit.jupiter.api.Assertions.*;

public class AmbryTest {
    @BeforeAll
    static void init(){
        // Runs on start
    }

    @Test
    void getCityTest() {
        City city = new City();

        city.setID(5);
        city.setName("Amsterdam");
        city.setCountryCode("NLD");
        city.setDistrict("Noord-Holland");
        city.setPopulation(731200);

        assertEquals(city.getID(), 5);
        assertEquals(city.getName(), "Amsterdam");
        assertEquals(city.getCountryCode(), "NLD");
        assertEquals(city.getDistrict(), "Noord-Holland");
        assertEquals(city.getPopulation(), 731200);
    }

    @Test
    void getCountryTest() {
        Country country = new Country();

        country.setCode("AUS");
        country.setName("Australia");
        country.setContinent("Oceania");
        country.setRegion("Australia and New Zealand");
        country.setSurfaceArea(7741220.00F);
        country.setIndepYear(1901);
        country.setPopulation(18886000);
        country.setLifeExpectancy(79.8F);
        country.setGNP(351182.00F);
        country.setGNPOld(392911.00F);
        country.setLocalName("Australia");
        country.setGovernmentForm("Constitutional Monarchy");
        country.setHeadOfState("Elisabeth II");
        country.setCapital(135);
        country.setCode2("AU");

        assertEquals("AUS", country.getCode());
        assertEquals("Australia", country.getName());
        assertEquals("Oceania", country.getContinent());
        assertEquals("Australia and New Zealand", country.getRegion());
        assertEquals(7741220.00F, country.getSurfaceArea());
        assertEquals(1901, country.getIndepYear());
        assertEquals(18886000, country.getPopulation());
        assertEquals(79.8F, country.getLifeExpectancy());
        assertEquals(351182.00F, country.getGNP());
        assertEquals(392911.00F, country.getGNPOld());
        assertEquals("Australia", country.getLocalName());
        assertEquals("Constitutional Monarchy", country.getGovernmentForm());
        assertEquals("Elisabeth II", country.getHeadOfState());
        assertEquals(135, country.getCapital());
        assertEquals("AU", country.getCode2());
    }

    // Harry
    @Test
    void unitCheckCountryStandard() {
    }

    // Harry
    @Test
    void unitCheckCityStandard(){
    }


    @Test
    void unitGetAllCountryLargeToSmall() {

    }

    @Test
    void unitGetAllCountryPerContinent() {

    }

    @Test
    void unitGetAllCountryPerRegion() {

    }

    @Test
    void unitTopNWorld(){}

    @Test
    void unitTopNContinent(){}

    @Test
    void unitTopNRegion(){}

    @Test
    void unitWorldCities(){
    }

    @Test
    void unitRegionCities(){
    }

    @Test
    void unitCountryCities(){
    }

    @Test
    void unitDistrictCities(){
    }


    @Test
    void unitContinentCity()
    {
    }
}


