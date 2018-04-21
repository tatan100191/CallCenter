package almundo.com.model;

import java.util.Observable;

public class Operator extends Employee{
	
	private String name;
	private Call call;
	
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
		
		
	}
}
