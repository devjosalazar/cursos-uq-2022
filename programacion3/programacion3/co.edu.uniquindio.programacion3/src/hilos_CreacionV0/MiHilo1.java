package hilos_CreacionV0;

public class MiHilo1 extends Thread{
	
	boolean runHilo;
	
	public MiHilo1() {
		this.runHilo = true;
	}
	
	
	@Override
	public void run() {
		
		int contador = 1;
		
		while (runHilo) {
			System.out.println("Preparados para el parcial del Jueves");
			String hola  = "Como estan";
			System.out.println(hola);
			System.out.println("Contando...:"+contador);
			if(contador == 10)
				runHilo = false;
			contador++;
		}
	}
}
