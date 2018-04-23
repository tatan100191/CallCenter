package almundo.com.dispatcher;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import almundo.com.model.Call;
import almundo.com.model.Director;
import almundo.com.model.IncomingCalls;
import almundo.com.model.Operator;
import almundo.com.model.Supervisor;

public class DispatcherTest {
	
	/**
     * Test para verificar el programa en su totalidad en funcionamiento se crean los tipos de empleados así como sus dispatchers para el 
     * manejo del patron cadena de responsabilidad, se realiza la ejecución de los hilos al final del test se verifica que todas las llamadas
     * hayan sido contestadas
     *
     */
	@Test
	public void test() throws InterruptedException {
		DispatcherOperator dispatcherOperator = new DispatcherOperator();
		DispatcherSupervisor dispatcherSupervisor = new DispatcherSupervisor();
		DispatcherDirector dispatcherDirector = new DispatcherDirector();
		dispatcherOperator.setNext(dispatcherSupervisor);
		dispatcherSupervisor.setNext(dispatcherDirector);
		dispatcherDirector.setNext(dispatcherOperator);
		
		dispatcherOperator.setOperators(fillListOperators());
		dispatcherSupervisor.setSupervisors(fillListSupervisors());
		dispatcherDirector.setDirectors(fillListDirectors());
		
		IncomingCalls incomingCalls = IncomingCalls.getInstance();
		
		incomingCalls.setIncomingCalls(fillListCalls());
		int i = 0;
		while(i < 10){
			dispatcherOperator.setCallInQueue(false);
			Thread thread = new Thread(dispatcherOperator);
			thread.start();
			thread.join();
			i++;
		}
		
		Thread.sleep(30 * 1000);
		assertEquals(dispatcherOperator.getCalls().isEmpty(), true);
	}
	
	private List<Operator> fillListOperators(){
		List<Operator> listOperators = new ArrayList<Operator>();
		for(int i = 1; i < 4; i++){
			listOperators.add(new Operator("Operator"+ i));
		}
		return listOperators;
	}
	
	private List<Supervisor> fillListSupervisors(){
		List<Supervisor> listSupervisors = new ArrayList<Supervisor>();
		for(int i = 1; i < 3; i++){
			listSupervisors.add(new Supervisor("Supervisor"+ i));
		}
		return listSupervisors;
	}
	
	private List<Director> fillListDirectors(){
		List<Director> listDirectors = new ArrayList<Director>();
		for(int i = 1; i < 2; i++){
			listDirectors.add(new Director("Director"+ i));
		}
		return listDirectors;
	}
	
	private List<Call> fillListCalls(){
		List<Call> listCalls = new ArrayList<Call>();
		int duration = 1;
		for(int i = 1; i < 11; i++){
			duration = (int) (Math.random() * 5) + 5;
			listCalls.add(new Call(duration, i));
		}
		return listCalls;
	}

}
