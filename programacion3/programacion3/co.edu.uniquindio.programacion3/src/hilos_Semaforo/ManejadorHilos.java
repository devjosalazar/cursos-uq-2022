package hilos_Semaforo;

public class ManejadorHilos implements Runnable{

	Hilo_Servicio1 hiloServicio1;
	Hilo_Servicio2 hiloServicio2;
	Hilo_Servicio3 hiloServicio3;
	
	BoundedSemaphore semaphore = new BoundedSemaphore(1);
	
	Thread hiloServicio4;
	Thread hiloServicio5;
	
	Boolean flagHilo = false;
	int valorEntrada;
	int contador = 1;
	int contador2 = 1;
	public Long starttime = null;
	
	public ManejadorHilos() {
		
	}
	
	
	public void startHiloServicio1() {
		hiloServicio1 = new Hilo_Servicio1(this);
	}


	public void detenerHiloServicio1() {
		
		if(hiloServicio1 != null)
			hiloServicio1.detenerHilo();
	}
	
	
	public void startHiloServicio2() {
		
		hiloServicio2 = new Hilo_Servicio2(this);
	}


	public void detenerHiloServicio2() {
		
		if(hiloServicio2 != null)
			hiloServicio2.detenerHilo();
	}
	
	public void startHiloServicio3() {
		
		hiloServicio3 = new Hilo_Servicio3(this);
	}


	public void detenerHiloServicio3() {
		
		if(hiloServicio3 != null)
			hiloServicio3.detenerHilo();
	}

	
	public void startHiloServicio4(int valorEntrada) {
		this.valorEntrada = valorEntrada;
		flagHilo = true;
		
		hiloServicio4 = new Thread(this);
		hiloServicio4.start();
	}
	
	public void startHiloServicio5() {
		flagHilo = true;
		hiloServicio5 = new Thread(this);
		hiloServicio5.start();
	}
	
	

	@Override
	public void run() {
		
		Thread hiloEnEjecucion = Thread.currentThread();
		
		long tiempoActual = System.currentTimeMillis();
		
		
		try {
			semaphore.ocupar();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if (hiloEnEjecucion == hiloServicio4)
		{
			while (flagHilo) {
				System.out.println("valor de entrada: "+valorEntrada+"*"+contador+" = "+valorEntrada*contador);
				contador++;
//				System.out.println(starttime);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(contador == 20)
				{
					System.out.println("valor de entrada: "+valorEntrada+"*"+contador+" = "+valorEntrada*contador);
					flagHilo = false;
					try {
						semaphore.liberar();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		if(hiloEnEjecucion == hiloServicio5)
		{
			flagHilo = true;
			System.out.println("Entro");
			
			while (flagHilo) {
				valorEntrada = valorEntrada + valorEntrada;
				System.out.println("Suma por valor de entrada: "+valorEntrada);
				contador2++;
				try {
					Thread.sleep(500);
					
					if(contador2 == 5)
						flagHilo = false;
					
					try {
						semaphore.liberar();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
//		startHiloServicio4(2);
//		startHiloServicio5();
		
	}


	public void detenerHilo() {
		flagHilo = false;
	}



	
	
}
