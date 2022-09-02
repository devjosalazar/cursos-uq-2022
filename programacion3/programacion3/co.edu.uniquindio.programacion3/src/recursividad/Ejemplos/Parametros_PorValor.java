package recursividad.Ejemplos;

public class Parametros_PorValor {

	public static void main(String[] args) 
	{
		//Paso por valor
		Integer valor = 5;
		
		System.out.println("Valor antes de cambiarlo: "+valor);
		
		Clase clase = new Clase();
		clase.cambiarValor(valor);
		
		System.out.println("Valor despues de cambiarlo: "+valor);

	}

}
