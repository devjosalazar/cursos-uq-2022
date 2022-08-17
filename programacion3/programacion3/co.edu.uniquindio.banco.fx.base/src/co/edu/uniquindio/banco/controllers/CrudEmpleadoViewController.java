package co.edu.uniquindio.banco.controllers;

import co.edu.uniquindio.banco.model.Banco;

public class CrudEmpleadoViewController {

	ModelFactoryController modelFactoryController;
	Banco banco;
	
	public CrudEmpleadoViewController() {	
		modelFactoryController = ModelFactoryController.getInstance();
	}


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public void agregarCliente(String nombre, String apellido, String cedula) {
		getBanco().agregarCliente(nombre,apellido,cedula);
		
	}
}
