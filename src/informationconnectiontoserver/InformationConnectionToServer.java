package informationconnectiontoserver;

import informationconnectiontoserver.information.Connection;
import informationconnectiontoserver.utility.ReadWriteDelete;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformationConnectionToServer {
    
    private static Logger logger = Logger.getLogger(InformationConnectionToServer.class.getName());
   
    public static void main(String[] args) {
        
        //create 10 Connection and write to log.txt
        AppThread app1 = new AppThread();
        Thread thread1 = new Thread(app1);
        thread1.start();
        AppThread app2 = new AppThread();
        Thread thread2 = new Thread(app2);
        thread2.start();
        AppThread app3 = new AppThread();
        Thread thread3 = new Thread(app3);
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
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
