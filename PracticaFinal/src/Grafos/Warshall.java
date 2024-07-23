package Grafos;

public class Warshall {

	public int[][] recorridoWarshall(int[][] grafo) {

		for (int k = 0; k < grafo.length; k++) {
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo.length; j++) {
					if (i != j && grafo[i][k] == 1 && grafo[k][j] == 1) {
						grafo[i][j] = 1;
					}
				}
			}
		}
		imprimirMatriz(grafo);
		return grafo;
	}

	public void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == Integer.MAX_VALUE) {
					System.out.print("INF ");
				} else {
					System.out.print(matriz[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void hayCamino(int[][] grafo, int nodoInicial, int nodoDestino) {
		if (grafo[nodoInicial][nodoDestino] == 1) {
			System.out.println("Hay camino");
		} else {
			System.out.println("No hay camino");

		}
	}

	public int[][] recorridoFloyd(int[][] grafo) {

		for (int k = 0; k < grafo.length; k++) {
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo.length; j++) {
					if(grafo[i][k] !=Integer.MAX_VALUE && grafo[k][j]!= Integer.MAX_VALUE) {
						if (i != j && (grafo[i][k] + grafo[k][j]) < grafo[i][j]) {
							grafo[i][j] = grafo[i][k] + grafo[k][j];
						}
					}
				}
			}
		}
		imprimirMatriz(grafo);
		return grafo;
	}

}
