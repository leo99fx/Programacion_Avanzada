package Kruskal;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        int[][] matriz = { 
                { 0, 2, 0, 4, 0, 5, 0 }, 
                { 2, 0, 7, 1, 3, 8, 4 },
                { 0, 7, 0, 0, 10, 0, 6 },
                { 4, 1, 0, 0, 2, 0, 0 },
                { 0, 3, 10, 2, 0, 0, 0 },
                { 5, 8, 0, 0, 0, 0, 1 },
                { 0, 4, 6, 0, 0, 1, 0 }
            };

            int numVertices = matriz.length;
            Grafo grafo = new Grafo(numVertices);

            // Agregar las aristas desde la matriz de adyacencia
            for (int i = 0; i < numVertices; i++) {
                for (int j = i + 1; j < numVertices; j++) {  // Evitar duplicados
                    if (matriz[i][j] != 0) {
                        grafo.agregarArista(i, j, matriz[i][j]);
                    }
                }
            }

		List<Arista> mst = grafo.kruskal();

		System.out.println("Aristas del MST:");
		for (Arista arista : mst) {
			System.out.println("Desde " + arista.desde + " hasta " + arista.hasta + " con costo " + arista.costo);
		}
	}
}
