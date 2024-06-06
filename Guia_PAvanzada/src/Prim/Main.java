package Prim;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Definir la matriz de adyacencia del grafo
		int[][] matriz = { { 0, 2, 0, 4, 0, 5, 0 }, 
				{ 2, 0, 7, 1, 3, 8, 4 },
				{ 0, 7, 0, 0, 10, 0, 6 },
				{ 4, 1, 0, 0, 2, 0, 0 },
				{ 0, 3, 10, 2, 0, 0, 0 },
				{ 5, 8, 0, 0, 0, 0, 1 },
				{0, 4, 6, 0, 0, 1, 0} 
				};

		// Crear el grafo a partir de la matriz de adyacencia
		Grafo grafo = new Grafo(matriz);
		int nodoInicio = 0; // Nodo inicial para el algoritmo de Prim
		List<Arista> mst = grafo.prim(nodoInicio); // Obtener el MST
	}
}
