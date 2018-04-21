package almundo.com.model;

import java.util.Observer;

public abstract class Employee  implements Observer{
	
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
	
	public void  answerCall(){
		call.run();
	}
}
