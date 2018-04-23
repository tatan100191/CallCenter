# CallCenter

Se realizo la prueba utilizando los patrones de diseño:
	Cadena de responsabilidad: para establecer la jerarquia al contestar las llamadas entrantes
	Singleton: para mantener una unica instancia y facilitar su uso en los hilos
	Observador: para establecer cuando se terminaba una llamada y realizar el llamado y a su vez verificar cuando un empleado se encontraba 
		disponible
	
Descargar proyecto del repositorio
Correr pruebas no se hizo clase Main debido a que el Test DispatcherTest contiene la generación de llamadas y de los dispatcher
 path: ...\CallCenter  
 mvn compile
 mvn test
 
 El programa se realizo en el IDE STS