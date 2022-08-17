package co.edu.uniquindio.banco.controllers;


import co.edu.uniquindio.banco.model.Banco;
import co.edu.uniquindio.banco.model.Cliente;

public class ModelFactoryController {

	Banco banco;
	
	
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}

	private void inicializarDatos() {

		banco = new Banco();
		
		
		Cliente cliente = new Cliente();
		cliente.setNombre("juan");
		cliente.setApellido("arias");
		cliente.setCedula("125454");
		cliente.setDireccion("Armenia");
		cliente.setCorreo("uni1@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Pedro");
		cliente.setApellido("Perez");
		cliente.setCedula("77787");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni2@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		cliente = new Cliente();
		cliente.setNombre("Alberto");
		cliente.setApellido("Arias");
		cliente.setCedula("12555");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni3@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		System.out.println("Banco inicializado "+banco );
		
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void agregarCliente(String nombre, String apellido, String cedula) {
		getBanco().agregarCliente(nombre, apellido, cedula);		
	}
	
	
	
}
