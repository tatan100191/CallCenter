package almundo.com.dispatcher;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import almundo.com.model.Call;
import almundo.com.model.Employee;

public abstract class Dispatcher implements Observer, Runnable {
	
	private Dispatcher dispatcher;
	private Call call;
	private boolean callInQueue;
	
	public abstract Boolean dispatchCall();
	
	public abstract void addQueueCall(List<Call> call2);
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Call getCall() {
		return call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public boolean isCallInQueue() {
		return callInQueue;
	}

	public void setCallInQueue(boolean callInQueue) {
		this.callInQueue = callInQueue;
	}

}
