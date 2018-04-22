package almundo.com.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Employee extends Observable implements Observer {
	
	private String name;
	private Call call;
	private List<Call> calls;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Call getCall() {
		return call;
	}
	public void setCall(Call call) {
		this.call = call;
	}
	
	public List<Call> getCalls() {
		return calls;
	}
	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public boolean answerCall() {
		try{
			call.addObserver(this);
			new Thread(call).start();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public void update(Observable o, Object arg) {
		if(this.call.getId()== (Integer)arg){
			this.call = null;
			setChanged();
			notifyObservers();
		}	
	}
}
