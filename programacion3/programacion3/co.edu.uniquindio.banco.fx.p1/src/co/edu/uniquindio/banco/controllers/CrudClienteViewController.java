package co.edu.uniquindio.banco.controllers;

import co.edu.uniquindio.banco.model.Banco;

public class CrudClienteViewController {

	ModelFactoryController modelFactoryController;
	Banco banco;
	
	public CrudClienteViewController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
		banco = modelFactoryController.getBanco();
	}


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


}
