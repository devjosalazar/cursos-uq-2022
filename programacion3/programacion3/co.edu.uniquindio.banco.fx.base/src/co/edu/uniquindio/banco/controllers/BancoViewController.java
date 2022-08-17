package co.edu.uniquindio.banco.controllers;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.banco.Aplicacion;
import co.edu.uniquindio.banco.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BancoViewController {

	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	CrudClienteViewController crudClienteViewController;
	
	ObservableList<Empleado> listaEmpleadosData = FXCollections.observableArrayList();
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnActualizar;

    @FXML
    void nuevoCienteAction(ActionEvent event) {
    	mostrarMensaje("Hola", "Como", "van con el proyecto", AlertType.INFORMATION);
    }



    @FXML
    void initialize() {
    	modelFactoryController = ModelFactoryController.getInstance();
    	crudClienteViewController = new CrudClienteViewController(modelFactoryController);
    	inicializarEmpleadoView();
    }
    
	private void inicializarEmpleadoView() {
//		this.clNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//		this.clApellidoEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellido"));
//		this.clCedulaEmpleado.setCellValueFactory(new PropertyValueFactory<>("cedula"));
//		this.clFechaEmpleado.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
//		
//		
//		tableEmpleados.getItems().clear();
//		tableEmpleados.setItems(getListaEmpleadosData());
		
	}
    
    
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public ObservableList<Empleado> getListaEmpleadosData() {
		return listaEmpleadosData;
	}
	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert aler = new Alert(alertType);
		aler.setTitle(titulo);
		aler.setHeaderText(header);
		aler.setContentText(contenido);
		aler.showAndWait();
	}

	private boolean mostrarMensajeConfirmacion(String mensaje) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmación");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean datosValidos(String nombre, String apellido, String documento,  String direccion) {

		String mensaje = "";


		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n" ;

		if(documento == null || documento.equals(""))
			mensaje += "El documento es invalido \n" ;

		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n" ;



		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
    
}
