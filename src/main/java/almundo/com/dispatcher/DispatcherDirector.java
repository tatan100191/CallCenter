package almundo.com.dispatcher;

import java.util.List;

import almundo.com.model.Call;
import almundo.com.model.Director;
import almundo.com.model.Employee;

public class DispatcherDirector extends Dispatcher{
	
	private List<Director> directors;
	private Call call;
	
	public void dispatchCall(){
		for(Employee employee: directors){
			if (employee.getCall() == null){
				employee.addObserver(this);
				employee.setCall(call);
				System.out.println(employee.getName() + " answer call "+ call.getId());
				employee.answerCall();
			}
		}
		this.getCalls().add(call);
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

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void run() {
		this.dispatchCall();
	}
	
	

}