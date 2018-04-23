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
	/**
     * metodo donde se deja al empleado sin llamada y se notifica para tomar alguna llamada
     * de la cola si esta no se encuentra vacia
     * 
     */
	public void update(Observable o, Object arg) {
		if(this.call != null && this.call.getId()== (Integer)arg){
			this.call = null;
			setChanged();
			notifyObservers();
		}	
	}
}
