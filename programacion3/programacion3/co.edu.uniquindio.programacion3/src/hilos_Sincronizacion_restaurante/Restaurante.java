package hilos_Sincronizacion_restaurante;


public class Restaurante {

	private String nombre;
	Vigilante vigilante;


	public Restaurante(String nombre,int aforo) {
		this.nombre = nombre;
		this.vigilante = new Vigilante(aforo);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void entrar() {
		try {
			vigilante.entrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void salir() {

		try {
			vigilante.salir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void simularClientes(){

		Cliente cliente = null;
		for (int i = 1; i <= 10 ; i++) {
			cliente = new Cliente("Cliente "+i, this);
			cliente.start();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
