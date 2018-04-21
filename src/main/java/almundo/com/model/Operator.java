package almundo.com.model;

import java.util.List;
import java.util.Observable;

public class Operator extends Employee{
	
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
	
	@Override
	public void answerCall() {
		call.run();
	}
	
	public void update(Observable arg0, Object arg1) {
		if(this.call.getId()== (Integer)arg1){
			this.call = null;
			this.call = !calls.isEmpty()? calls.get(0): null;
			calls.remove(0);
		}
	}
}
