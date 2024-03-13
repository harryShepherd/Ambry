package com.napier.Ambry;

import org.junit.jupiter.api.*;
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
        assertEquals(
                "Aruba",
                Country.CountryStandard("SELECT * FROM country LIMIT 1").get(0).getName()
        );
    }

}
