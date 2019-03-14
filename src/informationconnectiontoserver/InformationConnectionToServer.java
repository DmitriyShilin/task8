package informationconnectiontoserver;

import informationconnectiontoserver.information.Connection;
import informationconnectiontoserver.utility.RandomCreate;
import informationconnectiontoserver.utility.ReadWriteDelete;
import java.util.LinkedList;
import java.util.logging.Logger;

public class InformationConnectionToServer {
    
    private static Logger logger = Logger.getLogger(InformationConnectionToServer.class.getName());
   
    public static void main(String[] args) {
        
        //create 10 Connection and write to log.txt
        for(int i=0; i<10; i++){
            Connection connection = new Connection(System.currentTimeMillis(), RandomCreate.createSessionId(), RandomCreate.createIP());
            ReadWriteDelete.writeToFile(connection, true);
        }
        
        //read and print log.txt
        LinkedList<Connection> connections = ReadWriteDelete.readFromFile();        
        for(Connection line: connections){
            logger.info(line.toString());
        }
        
        //delete old records
        ReadWriteDelete.deleteOldInformation();
    }
}
