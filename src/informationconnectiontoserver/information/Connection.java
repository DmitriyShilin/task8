package informationconnectiontoserver.information;

public class Connection {
    
    private final long time;
    private final int sessionId;
    private final String ip;
    
    public Connection(long time, int sessionId, String ip){
        this.time = time;
        this.sessionId = sessionId;
        this.ip = ip;
    }
    
    public long getTime(){
        return time;
    }
    
    public int getSessionId(){
        return sessionId;
    }
    
    public String getIP(){
        return ip;
    }
    
    @Override
    public  String toString(){     
        return time + " " + sessionId + " " + ip;
    }
}