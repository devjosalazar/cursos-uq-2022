package co.edu.uniquindio.banco.controllers;

import co.edu.uniquindio.banco.model.Banco;

public class CrudClienteViewController {

	ModelFactoryController modelFactoryController;
	Banco banco;
	
	public CrudClienteViewController() {	
		modelFactoryController = ModelFactoryController.getInstance();
	}


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public void agregarCliente(String nombre, String apellido, String cedula) {
		modelFactoryController.agregarCliente(nombre,apellido,cedula);
		
	}
}
