package informationconnectiontoserver;

import informationconnectiontoserver.information.Connection;
import informationconnectiontoserver.utility.RandomCreate;
import informationconnectiontoserver.utility.ReadWriteDelete;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThread implements Runnable{
    
    private Logger logger = Logger.getLogger(AppThread.class.getName());

    @Override
    public void run() {
        for(int i=0; i<3; i++){                
            for(int j=0; j<10; j++){            
                long time = System.currentTimeMillis();
                int sessionId = RandomCreate.createSessionId();
                String ip = RandomCreate.createIP();
                Connection connection = new Connection(time, sessionId, ip);
                ReadWriteDelete.writeToFile(connection, true);
            }
            if(i<2){
                try {
                    Thread.sleep(3*60*1000);
                } catch (InterruptedException ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }            
        }
    }
}
