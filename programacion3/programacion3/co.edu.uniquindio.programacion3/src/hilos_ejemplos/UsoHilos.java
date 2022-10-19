package hilos_ejemplos;

public class UsoHilos {

	public static void main(String[] args) {
		
		
//	        usoHilo1();
	        usoHilo2();
	    }


	private static void usoHilo1() {

		System.out.println("Hilo principal iniciando.");
		//Primero, construye un objeto MiHilo.
		MiHilo mh=new MiHilo("#1");

		//Luego, construye un hilo de ese objeto.
		Thread nuevoh=new Thread(mh);
		//Finalmente, comienza la ejecución del hilo.
		nuevoh.start();

		for (int i=0; i<50;i++){
			System.out.print(i+" .");
		}try{
			Thread.sleep(100);
		}catch (InterruptedException exc){
			System.out.println("Hilo principal interrumpido.");
		}
		System.out.println("Hilo principal finalizado.");

	}
	
	
	private static void usoHilo2() {
		
		System.out.println("Hilo principal iniciando.");
		//Primero, construye un objeto MiHilo.
		MiHilo2 mh=new MiHilo2("#2");
		mh.start();

		for (int i=0; i<50;i++){
			System.out.print(" .");
		}try{
			Thread.sleep(300);
		}catch (InterruptedException exc){
			System.out.println("Hilo principal interrumpido.");
		}
		System.out.println("Hilo principal finalizado.");

	}
		
	

}
