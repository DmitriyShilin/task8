package informationconnectiontoserver.utility;

import informationconnectiontoserver.information.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWriteDelete {
    
    private static Logger logger = Logger.getLogger(ReadWriteDelete.class.getName());
    private static final String PATH = System.getProperty("user.dir") + File.separator + "log" + File.separator + "log.txt";
    
            
    public static LinkedList<Connection> readFromFile() {
        LinkedList<Connection> connections = new LinkedList<>();
        try(BufferedReader bufferFile = new BufferedReader(new FileReader(PATH))){
            String str;
            while ((str = bufferFile.readLine()) != null) {
                String[] strSplit = str.split(" ");
                connections.add(new Connection(Long.valueOf(strSplit[0]), Integer.valueOf(strSplit[1]), strSplit[2]));
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return connections;
    }    
    
    public static synchronized void writeToFile(Connection connection, boolean append) {
        try(FileWriter file = new FileWriter(PATH, append)){            
            file.write(connection.toString() + "\r\n");          
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeToFile(List<Connection> connections, boolean append) {        
        for(Connection connection: connections){
                writeToFile(connection, append);
            }  
    }
    
    public static void deleteOldInformation() {
        LinkedList<Connection> connections = readFromFile();
        Iterator<Connection> connection = connections.listIterator();
        while(connection.hasNext()){
            if(System.currentTimeMillis()- connection.next().getTime() > 3*24*60*60*1000){
                    connection.remove();                    
                }
        }        
        writeToFile(connections.pollFirst(), false);
        writeToFile(connections, true);
    }
}
