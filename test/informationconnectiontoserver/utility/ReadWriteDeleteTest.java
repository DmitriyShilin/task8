package informationconnectiontoserver.utility;

import informationconnectiontoserver.information.Connection;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ReadWriteDeleteTest {
    
    private static List<Connection> originList;
    
    @BeforeClass
    public static void storeData(){
        originList = ReadWriteDelete.readFromFile();
    }

    @Test
    public void testReadFromFile() {
        long time = System.currentTimeMillis();
        int sessionId = RandomCreate.createSessionId();
        String ip = RandomCreate.createIP();
        Connection connection = new Connection(time, sessionId, ip);
        ReadWriteDelete.writeToFile(connection, false);
        LinkedList<Connection> result = ReadWriteDelete.readFromFile();
        assertNotNull(result);
        assertTrue(!result.isEmpty());
        assertTrue(result.size()==1);
        assertEquals(time, result.get(0).getTime());
        assertEquals(sessionId, result.get(0).getSessionId());
        assertEquals(ip, result.get(0).getIP());
    }
    
    @AfterClass
    public static void setDataToFile(){
        boolean append = false;
        for(Connection connection: originList){
            ReadWriteDelete.writeToFile(connection, append);
            append = true;
        }
    }
    
}
