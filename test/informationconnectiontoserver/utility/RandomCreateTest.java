package informationconnectiontoserver.utility;

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomCreateTest {

    @Test
    public void testCreateIP() {
        String result = RandomCreate.createIP();
        assertNotNull(result);
    }

    @Test
    public void testCreateSessionId() {
        int expResult = 10_000_000;
        int result = RandomCreate.createSessionId();
        assertEquals(expResult, result, 90_000_000);
    }
    
}
