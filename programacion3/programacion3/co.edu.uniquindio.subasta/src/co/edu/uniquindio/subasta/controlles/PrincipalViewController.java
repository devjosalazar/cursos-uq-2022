package co.edu.uniquindio.subasta.controlles;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import co.edu.uniquindio.subasta.Aplicacion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class PrincipalViewController {

	Aplicacion aplicacion;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rdbAnunciante;

    @FXML
    private Button btnIngresar;

    @FXML
    private RadioButton rdbComprador;

    @FXML
    void ingresarAction(ActionEvent event) {
    	ingresar();
    }

    ToggleGroup tg = new ToggleGroup();
    
	@FXML
    void initialize() {
		
		rdbAnunciante.setToggleGroup(this.tg);
		rdbComprador.setToggleGroup(this.tg);
		
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ob, Toggle oldSelection, Toggle newSelection)
			{
				RadioButton rb = (RadioButton)tg.getSelectedToggle();

//				if (rb != null) {
//					String s = rb.getText();
//					JOptionPane.showMessageDialog(null,"Radio buton seleccionado: --> "+s);
//				}
			}
		});

    }
    
	
	
    public Aplicacion getAplicacion() {
		return aplicacion;
	}


	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	private void ingresar() {
    	if(rdbAnunciante.isSelected()){
    		getAplicacion().mostrarVentanaAnunciante();
    	}
    	else{
    		getAplicacion().mostrarVentanaComprador();
    	}
	}
    
    
}
