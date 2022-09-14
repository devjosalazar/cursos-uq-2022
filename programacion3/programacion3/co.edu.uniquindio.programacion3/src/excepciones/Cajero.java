package excepciones;

public class Cajero {

	
	public static void main(String[] args)
	{
		Cuenta cuenta=new Cuenta();
		cuenta.ingresar(100);
		
		//Capturar la excepción
		try {
			extraerDineroBanco(101, cuenta);
		} catch (CuentaException e) {
			e.printStackTrace();
		}
		
		System.out.println(cuenta.saldo);
		System.out.println("Continuación del programa");
	}

	private static void extraerDineroBanco(int i, Cuenta cuenta) throws CuentaException {
		cuenta.extraer(101);
	}
	
	
	
	
	
	
	
}
