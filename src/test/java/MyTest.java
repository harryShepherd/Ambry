import com.napier.Ambry.Database;
import org.junit.jupiter.api.*;

import static com.napier.Ambry.City.*;
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
    void unitCheckCountryStandard(){}

    @Test
    void unitCheckCityStandard(){}

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
    void unitWorldCities(){}

    @Test
    void unitRegionCities(){}

    @Test
    void unitCountryCities(){}

    @Test
    void unitDistrictCities(){}

    @Test
    void unitContinentCity(){}





    @Test
    void unitCityID(){}

    @Test
    void unitCityName(){}

    @Test
    void unitCityCountryCode(){}

    @Test
    void unitCityDistrict(){}

    @Test
    void unitCityPopulation(){}

    @Test
    void unitCountryCode(){}

    @Test
    void unitCountryName(){}

    @Test
    void unitCountryContinent(){}

    @Test
    void unitCountryRegion(){}

    @Test
    void unitCountrySurfaceArea(){}

    @Test
    void unitCountryIndepYear(){}

    @Test
    void unitCountryPopulation(){}

    @Test
    void unitCountryGNP(){}

    @Test
    void unitCountryGNPOld(){}

    @Test
    void unitCountryLocalName(){}

    @Test
    void unitCountryGovernmentForm(){}

    @Test
    void unitCountryHeadOfState(){}

    @Test
    void unitCountryCapital(){}

    @Test
    void unitCountryCode2(){}
}
