package recursividadPracticaEnClase;

public class EP_01_CifrasNumero {

	public static void main(String[] args) {
		
		
		int numero = 34567;
		int resultado = 0;
		
		contarCifrasV1(numero);
		contarCifrasV2(numero);
		contarCifras(numero);
		
		

	}

	private static void contarCifras(int numero) {
		
		
	}

	private static void contarCifrasV1(int numero) {
		String digito = Integer.toString(numero);
		System.out.println("Cifras = "+ digito.length());
	}
	
	
	//34567
	//3456
	//345
	//34
	//3
	//0
	private static void contarCifrasV2(int numero) {
		int contador= 0;
		for (int i = 0; numero > 0 ; i++) {
			numero = numero / 10;
			++contador;
		}
		System.out.println("Cifras = "+ contador);
	}
}
