import com.napier.Ambry.Database;
import org.junit.jupiter.api.*;

import static com.napier.Ambry.City.*;
import static com.napier.Ambry.Country.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @BeforeAll
    static void init(){
        Database db = new Database();

        db.connect("localhost:33060", 30000);
    }
    @Test
    void unitTest() {
        assertEquals(null, CityStandard(""));
    }

    @Test
    void unitCheckNull(){}

    @Test
    void unitCheckCountryStandard(){
        assertEquals(null, CountryStandard(""));
    }

    @Test
    void unitCheckCityStandard(){
        assertEquals(null, CityStandard(""));
    }


    @Test
    void unitGetAllCountryLargeToSmall(){}

    @Test
    void unitGetAllCountryPerContinent(){}

    @Test
    void unitGetAllCountryPerRegion(){}

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


