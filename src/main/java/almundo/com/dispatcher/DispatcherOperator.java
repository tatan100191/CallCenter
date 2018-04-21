package almundo.com.dispatcher;

import java.util.List;

import almundo.com.model.Call;
import almundo.com.model.Employee;

public class DispatcherOperator extends Dispatcher{
	
	private Dispatcher dispatcher;
	private List<Employee> employees;
	private String name;
	private Call call;
	
	public Boolean dispatchCall(Call call, Boolean callInQueue){
		for(Employee employee: employees){
			if (employee.getCall() == null){
				employee.setCall(call);
				return true;
			}
		}
		if(callInQueue){
			
		}
		return dispatcher.dispatchCall(call, false);		

	}
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}