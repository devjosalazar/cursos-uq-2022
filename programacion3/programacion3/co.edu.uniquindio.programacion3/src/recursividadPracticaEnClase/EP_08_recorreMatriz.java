package recursividadPracticaEnClase;

/**
 * 
 * Recorrer una matriz de forma recursiva.
 */
public class EP_08_recorreMatriz {
 
    public static void main(String[] args) {
    	
    	
    	int [][] matriz = {
    			{1,2,3},
    			{4,5,6},
    			{7,8,9}
    	};
    	
    	recorrerMatriz(matriz,0,0);
    	
    }

	private static void recorrerMatriz(int[][] matriz, int i, int j) {
		
		if(i == matriz.length || j == matriz[i].length){
			System.out.println("Fin del recorrido");
		}else{
			System.out.print(""+ matriz[i][j]);
			if(j == matriz[i].length-1){
				i++;
				j = 0;
				System.out.println("");
			}else{
				j++;
			}
			recorrerMatriz(matriz, i, j);
		}
	}
    
 
 
}