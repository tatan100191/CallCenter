package almundo.com.model;

import java.util.Observable;

public class Call extends Observable implements Runnable{
	private int duration;
	private int id;
	
	public Call(int duration, int id) {
		this.duration = duration;
		this.id = id;
	}
	
	/**
     * metodo donde se realiza la llamada y se notifica su cambio una vez terminada
     * 
     */
	public void run() {
		try {
			System.out.println("Start call " + id);
			Thread.sleep(this.duration * 1000);
			setChanged();
			System.out.println("End call " + id);
			notifyObservers(id);
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
