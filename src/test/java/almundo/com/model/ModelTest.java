package almundo.com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import almundo.com.dispatcher.DispatcherOperator;

public class ModelTest {

	public Employee addCall(DispatcherOperator dispatcherOperator,Operator operator) {
		Call call = new Call(8, 1);
		IncomingCalls incomingCalls = IncomingCalls.getInstance();
		List <Call> calls = new ArrayList<Call>();
		calls.add(call);
		incomingCalls.setIncomingCalls(calls);
		dispatcherOperator.run();
		assertEquals(operator.getCall(), call); 
		return operator;
	}
	
	/**
     * Test para verificar el funcionamiento de los patrones observador, funcionalidad en la que el empleado queda sin llamadas
     *
     */
	@Test
	public void patternObserver() throws Exception {
		try{
			DispatcherOperator dispatcherOperator = new DispatcherOperator();
			Operator operator = new Operator("Operator");
			List<Operator> operators = new ArrayList<Operator>();
			operators.add(operator);
			dispatcherOperator.setOperators(operators);
			operator = (Operator) addCall(dispatcherOperator, operator);
			Thread.sleep(9 * 1000);
			assertEquals(operator.getCall(), null);
		}catch(Exception e){
			System.out.println("Error: "+ e.getMessage());
			fail();
		}
	}
	
	/**
     * Test para verificar el funcionamiento de los patrones observador, una vez que se realiza la terminación de la llamada
     * se procede a verificar con el empleado desocupado si se encuentra alguna llamada en espera si la hay se contesta y se gestiona
     * si no hay espera la entrada de mas, en el test se verifica que el usuario tome la llamada que se encuentra en la cola de espera
     *
     */
	@Test
	public void patternObserverQueue() {
		try{
			DispatcherOperator dispatcherOperator = new DispatcherOperator();
			Operator operator = new Operator("Operator");
			List<Operator> operators = new ArrayList<Operator>();
			operators.add(operator);
			dispatcherOperator.setOperators(operators);
			operator = (Operator) addCall(dispatcherOperator, operator);
			List <Call> calls = new ArrayList<Call>();
			Call call = new Call(10, 2);
			Call call2 = new Call(10, 3);
			calls.add(call);
			calls.add(call2);
			dispatcherOperator.setCalls(calls);
			Thread.sleep(9 * 1000);
			assertEquals(operator.getCall().getId(), call.getId());
		}catch(Exception e){
  			System.out.println("Error: "+ e.getMessage());
			fail();
		}
	}

}
