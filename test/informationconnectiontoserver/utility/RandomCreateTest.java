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
        int result = RandomCreate.createSessionId();
        assertTrue(10_000_000 <= result && result < 100_000_000);
    }
    
}
