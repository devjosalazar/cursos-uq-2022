package hilos_CreacionV2;

public class HiloServicio1 extends Thread{

	boolean runHilo;
	int contador;
	
	
	public HiloServicio1() {
		this.runHilo = true;
		this.contador = 1;
		
	}
	
	
	@Override
	public void run() {
		
		while(runHilo){
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Hilo servicio 1 en ejecución: "+contador);
			contador++;
		}
	}


	public void detener() {
		this.runHilo = false;
	}
	
}
