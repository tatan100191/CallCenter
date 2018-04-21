package almundo.com.dispatcher;

import java.util.List;

import almundo.com.model.Call;
import almundo.com.model.Employee;

public abstract class Dispatcher {
	
	private Dispatcher dispatcher;
	private List<Employee> employees;
	
	public Boolean dispatchCall(Call call, Boolean callInQueue){
		return dispatcher.dispatchCall(call, callInQueue);
	}
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
