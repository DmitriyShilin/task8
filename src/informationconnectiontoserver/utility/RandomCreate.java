package informationconnectiontoserver.utility;

import java.util.Random;

public class RandomCreate{
    
    public static String createIP(){ 
        Random random = new Random();
        return random.nextInt(256)+"."+
               random.nextInt(256)+"."+
               random.nextInt(256)+"."+
               random.nextInt(256);
    }
    
    public static int createSessionId(){
        Random random = new Random();
        int min = 10_000_000;
        int max = 100_000_000;
        return min + random.nextInt(max-min);
    }
}
