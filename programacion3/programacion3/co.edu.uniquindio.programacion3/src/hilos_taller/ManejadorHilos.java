package hilos_taller;

public class ManejadorHilos implements Runnable{

	BoundedSemaphore semaphore = new BoundedSemaphore(1);
	
	Thread hiloServicio1;
	Thread hiloServicio2;
	
	Boolean runHilo = false;
	String valorEntrada;
	String cadena = "";
	int contador = 1;
	int contador2 = 1;
	public Long starttime = null;
	long tiempoActual = 0;
	long tiempoFinal = 0;
	
	public ManejadorHilos() {
		
	}
	
	

	
	public void startHiloServicio1(String valorEntrada) {
		this.valorEntrada = valorEntrada;
		runHilo = true;
		
		hiloServicio1 = new Thread(this);
		hiloServicio1.start();
	}
	
	public void startHiloServicio2() {
		runHilo = true;
		hiloServicio2 = new Thread(this);
		hiloServicio2.start();
	}
	
	

	@Override
	public void run() {
		
		
		if(tiempoActual == 0){
			tiempoActual = System.currentTimeMillis();
			tiempoFinal = tiempoActual + 20000;
		}
		
		
		Thread hiloEnEjecucion = Thread.currentThread();
		
		
		try {
			semaphore.ocupar();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if (hiloEnEjecucion == hiloServicio1)
		{
			System.out.println("----------Hilo servicio 1 en ejecución");
			long tiempoHilo1 = System.currentTimeMillis();
			long tiempoFinalHilo1 = tiempoHilo1 + 6000;
			while (runHilo) {
				tiempoHilo1 = System.currentTimeMillis();
				
				if(tiempoHilo1 < tiempoFinalHilo1){
					
					if(cadena.equals("")){
						cadena = cadena + "hola";
						System.out.println("Cadena: "+ cadena);
					}else{
						cadena = cadena + " + hola";
						System.out.println("Cadena: "+ cadena);
						
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					runHilo = false;
					try {
						semaphore.liberar();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		if(hiloEnEjecucion == hiloServicio2)
		{
			
			System.out.println("----------Hilo servicio 2 en ejecución");
			String var = cadena;
			System.out.println("Valor de la variable obtenidad: "+var);
			var ="";
			cadena = "";
			try {
				semaphore.liberar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tiempoActual = System.currentTimeMillis();
			System.out.println("Tiempo actual = "+tiempoActual);
			System.out.println("Tiempo actual = "+tiempoFinal);
			
			if(tiempoActual > tiempoFinal){
				System.out.println("ya pasaron 20 segundos");
				runHilo = false;
			}else{
				startHiloServicio1(valorEntrada);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startHiloServicio2();
			}
		}
	}


	public void detenerHilo() {
		runHilo = false;
	}



	
	
}
