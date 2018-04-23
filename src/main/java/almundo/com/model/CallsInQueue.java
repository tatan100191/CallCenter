package almundo.com.model;

import java.util.ArrayList;
import java.util.List;

public class CallsInQueue {
	private static CallsInQueue INSTANCE = null;
	private List<Call> calls = new ArrayList<Call>();
	
	private CallsInQueue(){
		
	}
	
	public static CallsInQueue getInstance(){
		if(INSTANCE==null){
            synchronized(CallsInQueue.class){
              if(INSTANCE==null){
            	  INSTANCE = new CallsInQueue(); 
                      }      
              }
           }
     return INSTANCE;
	}
	
	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}
	
}
