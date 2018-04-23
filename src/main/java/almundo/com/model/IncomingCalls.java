package almundo.com.model;

import java.util.List;

public class IncomingCalls {
	
	private static IncomingCalls INSTANCE = null;
	private List<Call> incomingCalls;
	
	private IncomingCalls(){
		
	}
	public static IncomingCalls getInstance(){
		if(INSTANCE==null){
            synchronized(IncomingCalls.class){
              if(INSTANCE==null){
            	  INSTANCE= new IncomingCalls(); 
                      }      
              }
           }
     return INSTANCE;
	}
	
	public List<Call> getIncomingCalls() {
		return incomingCalls;
	}

	public void setIncomingCalls(List<Call> incomingCalls) {
		this.incomingCalls = incomingCalls;
	}
	
}
