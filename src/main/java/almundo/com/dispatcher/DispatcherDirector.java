package almundo.com.dispatcher;

import java.util.List;
import java.util.Observable;

import almundo.com.model.Call;
import almundo.com.model.Director;
import almundo.com.model.Employee;

public class DispatcherDirector extends Dispatcher{
	
	private Dispatcher dispatcher;
	private List<Director> directors;
	private Call call;
	private boolean callInQueue;
	private List<Call> calls;
	
	public Boolean dispatchCall(){
		for(Employee employee: directors){
			if (employee.getCall() == null){
				employee.addObserver(this);
				employee.setCall(call);
				System.out.println(employee.getName() + " answer call "+ call.getId());
				employee.answerCall();
				dispatcher.setCallInQueue(false);
				return true;
			}
		}
		dispatcher.setCall(this.getCall());
		dispatcher.setCallInQueue(true);
		return dispatcher.dispatchCall();		

	}
	
	public void setNext(Dispatcher dispatcher) {
		this.dispatcher = dispatcher; 
	}
	
	public Dispatcher getNext() {
		return this.dispatcher; 
	}

	public List<Director> getDirectors() {
		return directors;
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

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void run() {
		this.dispatchCall();
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	@Override
	public void addQueueCall(List<Call> calls) {
		this.setCalls(calls);
	}
	
	public void update(Observable o, Object arg) {
		Employee employee = ((Employee) o);
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
	}
	
	public synchronized void getCallQueue(){
		
	}

}