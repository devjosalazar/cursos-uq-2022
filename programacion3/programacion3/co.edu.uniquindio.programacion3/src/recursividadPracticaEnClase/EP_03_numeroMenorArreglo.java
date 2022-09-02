package recursividadPracticaEnClase;

public class EP_03_numeroMenorArreglo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arreglo = new int [10];
		arreglo[0] = 2;
		arreglo[1] = 1;
		arreglo[2] = 3;
		arreglo[3] = 4;
		arreglo[4] = 5;
		arreglo[5] = 7;
		arreglo[6] = 1;
		arreglo[7] = 9;
		arreglo[8] = 10;
		arreglo[9] = 3;
		
		int indice = arreglo.length-1;
		int mayor = 0;
		
		mayor = obtenerMayor(arreglo, indice);	

	}

	private static int obtenerMayor(int[] arreglo, int indice) {
		int mayor = 0;
		if(indice == 0){
			return arreglo[indice];
		}else{
			mayor = obtenerMayor(arreglo, indice-1);
			
			if(arreglo[indice] > mayor){
				mayor = arreglo[indice];
			}
			return mayor;
		}
	}



}
