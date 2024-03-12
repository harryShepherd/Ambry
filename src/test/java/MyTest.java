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
}
