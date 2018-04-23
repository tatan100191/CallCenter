package almundo.com.dispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import almundo.com.model.Call;
import almundo.com.model.CallsInQueue;
import almundo.com.model.Employee;

public abstract class Dispatcher implements Observer, Runnable {	
	
	private Dispatcher dispatcher;
	private Call call;
	private boolean callInQueue;
	private CallsInQueue callsInQueue;
	private Employee working = null;
	private List<Employee> employees = new ArrayList<Employee>();
	
	public abstract void dispatchCall();
	
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

	public synchronized void setCallInQueue(boolean callInQueue) {
		this.callInQueue = callInQueue;
	}

	public CallsInQueue getCallsInQueue() {
		this.callsInQueue = CallsInQueue.getInstance();
		return this.callsInQueue;
	}
	
	public List<Call> getCalls() {
		return this.getCallsInQueue().getCalls();
	}
	
	public void setCalls(List<Call> calls) {
		this.getCallsInQueue().setCalls(calls);
	}
		
	/**
     * metodo propio de la clase Observer en la cual se realiza la actualización del empleado una vez termina 
     * con la llamada que esta atendiendo y hay llamadas en cola, se manejo synchronized y una bandera para que el recurso 
     * call solo pueda ser gestionado por un empleado a la vez
     * @param o El objeto observable, arg argumentos que se deseen enviar
     */
	
	public synchronized void update(Observable o, Object arg) {
		Employee employee = ((Employee) o);
		employees.add(employee);
		working = working == null? employee : working;
		if(working == null){
			while(working !=  employee){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if(this.getCalls() != null && !this.getCalls().isEmpty()){
			employee.setCall(this.getCalls().get(0));
			this.setCall(this.getCalls().get(0));
			this.getCalls().remove(0);
			System.out.println(employee.getName() + " answer call "+ employee.getCall().getId());
			employee.answerCall();
		}else{
			employee.setCall(null);
			this.setCall(null);
		}
		working = !employees.isEmpty() ? employees.get(0): null;
	}
}
