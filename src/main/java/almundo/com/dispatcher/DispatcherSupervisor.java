package almundo.com.dispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import almundo.com.model.Call;
import almundo.com.model.Employee;
import almundo.com.model.Supervisor;

public class DispatcherSupervisor extends Dispatcher{
	
	private Dispatcher dispatcher;
	private List<Supervisor> supervisors;
	private Call call;
	private boolean callInQueue;
	
	public void dispatchCall(){
		for(Employee employee: supervisors){
			if (employee.getCall() == null){
				employee.addObserver(this);
				employee.setCall(call);
				System.out.println(employee.getName() + " answer call "+ call.getId());
				employee.answerCall();
			}
		}
		dispatcher.setCall(this.getCall());	

	}
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

	public List<Supervisor> getSupervisors() {
		return supervisors;
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

	public void setSupervisors(List<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}

	public void run() {
		this.dispatchCall();
	}
	
}