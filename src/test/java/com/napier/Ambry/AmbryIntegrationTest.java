package com.napier.Ambry;

import org.junit.jupiter.api.*;

public class AmbryIntegrationTest {

    static Database db;

    @BeforeAll
    static void init() {
        db = new Database();
        db.connect("localhost:33060", 30000);
    }

    @Test
    void testCountryStandard() {
        Country.CountryStandard("SELECT * FROM country LIMIT 1");
    }

}
