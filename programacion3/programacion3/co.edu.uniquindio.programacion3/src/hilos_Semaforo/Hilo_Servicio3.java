package hilos_Semaforo;

public class Hilo_Servicio3 extends Thread{

	Boolean runHilo;
	ManejadorHilos manejadorServicios;
	
	public Hilo_Servicio3(ManejadorHilos manejadorServicios) {
		
		this.manejadorServicios =  manejadorServicios;
		this.runHilo = true;
		start();
		
	}
	
	
	
	@Override
	public void run() {
		
		int contador = 0;
		while (runHilo) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador = contador+10;
			System.out.println("Hilo Servicio 3 en ejecución:"+contador);			
		}
		
	}
	
	public void detenerHilo() {
		runHilo = false;

	}

	
}
