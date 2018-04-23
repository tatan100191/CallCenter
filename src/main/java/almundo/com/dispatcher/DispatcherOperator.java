package almundo.com.dispatcher;

import java.util.List;

import almundo.com.model.Call;
import almundo.com.model.IncomingCalls;
import almundo.com.model.Operator;

public class DispatcherOperator extends Dispatcher{
	
	private Dispatcher dispatcher;
	private List<Operator> operators;
	private Call call;
	
	/**
     * metodo principal de la cadena de responsabilidad el cual tiene la función de asignar la llamada 
     * a un empleado y realizar 
     * @param o El objeto observable, arg argumentos que se deseen enviar
     */
	public void dispatchCall(){
		getCallOfIncomingCalls();
		for(Operator employee: operators){
				if (employee.getCall() == null){
					employee.addObserver(this);
					employee.setCall(call);
					System.out.println(employee.getName() + " answer call "+ call.getId());
					employee.answerCall();
				}
		}
		dispatcher.setCall(this.getCall());
	}
	

	public List<Operator> getOperators() {
		return operators;
	}


	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}

	public Call getCall() {
		return call;
	}

	public void setCall(Call call) {
		this.call = call;
	}
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

	public void run() {
		this.dispatchCall();
	}
	
	/**
     * metodo propio de la clase Observer en la cual se realiza la actualización del empleado una vez termina 
     * con la llamada que esta atendiendo y hay llamadas en cola
     * @param o El objeto observable, arg argumentos que se deseen enviar
     */
	
	private synchronized void getCallOfIncomingCalls(){
		IncomingCalls incomingCalls = IncomingCalls.getInstance();
		if(!incomingCalls.getIncomingCalls().isEmpty()){
			call = incomingCalls.getIncomingCalls().get(0);
			incomingCalls.getIncomingCalls().remove(0);
		}
	}
	

}