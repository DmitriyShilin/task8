package informationconnectiontoserver.information;

public class Connection {
    
    private final long time;
    private final int sessionId;
    private final String IP;
    
    public Connection(long time, int sessionId, String IP){
        this.time = time;
        this.sessionId = sessionId;
        this.IP = IP;
    }
    
    public long getTime(){
        return time;
    }
    
    public int getSessionId(){
        return sessionId;
    }
    
    public String getIP(){
        return IP;
    }
    
    @Override
    public  String toString(){     
        return time + " " + sessionId + " " + IP;
    }
}