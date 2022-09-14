package excepciones;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ExcepcionesEjemplo {

	public static void main(String[] args) {	
		ejemplo1();
	}


	private static void ejemplo1() {
		
//		ArrayList<String> lista = null;
//		lista.add("hola");
		
		
		int a[];

		a = new int[3];
		a[0] = 8;
		a[1] = 2;
		
		try {
			a[2] = a[0] / a[1];
			JOptionPane.showMessageDialog(null, a[2]);
		}
//		finally {
//			System.out.println("se ejecuto");
//		}
		
		catch (ArithmeticException e) 
		{
			JOptionPane.showMessageDialog(null, "División por cero","Dialogo de Error",JOptionPane.ERROR_MESSAGE);
		}
		
//		catch (ArrayIndexOutOfBoundsException e) 
//		{
//			JOptionPane.showMessageDialog(null, "Indice fuera de rango","Dialogo de Error",JOptionPane.ERROR_MESSAGE);
//		}

//		catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) 
//		{
//			JOptionPane.showMessageDialog(null, "Se generó"+e,"Dialogo de Error",JOptionPane.ERROR_MESSAGE);
//		}
		
		//Detecta el tipo de excepcion e imprime el resultado de acuerdo a dicha expcecion
//		catch (Exception e) 
//		{
//			JOptionPane.showMessageDialog(null, "Se generó, "+e,"Dialogo de Error",JOptionPane.ERROR_MESSAGE);
//		}
		
	}
	
	

}
