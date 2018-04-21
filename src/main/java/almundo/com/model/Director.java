package almundo.com.model;

import java.util.Observable;

public class Director extends Employee{
	
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
	public void update(Observable o, Object arg) {
		if(this.call.getId()== (Integer)arg){
			this.call = null;
		}
	}
	
}
