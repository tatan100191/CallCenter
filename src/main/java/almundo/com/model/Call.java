package almundo.com.model;

import java.util.Observable;

public class Call extends Observable implements Runnable{
	private int duration;
	private int id;
	public void run() {
		try {
			System.out.println("Start call");
			Thread.sleep(this.duration);
			setChanged();
			notifyObservers(id);
			System.out.println("End call");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
