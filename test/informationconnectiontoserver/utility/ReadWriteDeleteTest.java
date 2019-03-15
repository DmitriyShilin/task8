package informationconnectiontoserver.utility;

import informationconnectiontoserver.information.Connection;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReadWriteDeleteTest {
    
    public ReadWriteDeleteTest() {
    }

    @Test
    public void testReadFromFile() {
        LinkedList<Connection> result = ReadWriteDelete.readFromFile();
        assertNotNull(result);
    }
    
}
