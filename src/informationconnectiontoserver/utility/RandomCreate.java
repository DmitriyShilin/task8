package informationconnectiontoserver.utility;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCreate{
    
    public static String createIP(){        
        return ThreadLocalRandom.current().nextInt(256)+"."+
               ThreadLocalRandom.current().nextInt(256)+"."+
               ThreadLocalRandom.current().nextInt(256)+"."+
               ThreadLocalRandom.current().nextInt(256);
    }
    
    public static int createSessionId(){
        return ThreadLocalRandom.current().nextInt(10_000_000, 100_000_000);
    }
}
