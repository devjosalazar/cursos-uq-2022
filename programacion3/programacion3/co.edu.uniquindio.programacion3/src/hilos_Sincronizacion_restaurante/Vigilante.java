package hilos_Sincronizacion_restaurante;


public class Vigilante {


	int aforo = 0;
	int numeroClientes = 0;

	public Vigilante(int aforo) {
		this.aforo = aforo;
	}


	public synchronized void entrar() throws InterruptedException{

		while(numeroClientes == aforo){
			System.out.println("El "+Thread.currentThread().getName()+" está esperando");
			wait();
		}
		numeroClientes++;
		notify();
	}

	public synchronized void salir() throws InterruptedException{
		while(numeroClientes == 0){
			wait();
		}

		numeroClientes--;
		notify();
	}




}
