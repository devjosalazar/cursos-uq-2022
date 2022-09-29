package co.edu.uniquindio.subasta;
	
import java.io.IOException;

import co.edu.uniquindio.subasta.controlles.PrincipalViewController;
import co.edu.uniquindio.subasta.controlles.SubastaActorViewController;
import co.edu.uniquindio.subasta.controlles.SubastaWorkerViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Subastas UQ");
		mostrarVentanaPrincipal();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void mostrarVentanaPrincipal() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("views/PrincipalView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			PrincipalViewController principalViewController = loader.getController();
			principalViewController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}

	public void mostrarVentanaAnunciante() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("views/SubastaActorView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			SubastaActorViewController subastaActorViewController = loader.getController();
//			subastaActorViewController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
	}

	public void mostrarVentanaComprador() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("views/SubastaWorkerView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			SubastaWorkerViewController subastaWorkerViewController = loader.getController();
//			subastaWorkerViewController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	


}
