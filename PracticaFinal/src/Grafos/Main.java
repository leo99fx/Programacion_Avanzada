package Grafos;

public class Main {

	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {

//		Dijkstra grafo = new Dijkstra();
//		int[][] matriz = { { INF, 7, 3, INF }, { INF, INF, INF, 2 }, { INF, 2, INF, 8 }, { INF, INF, INF, INF } };
//		grafo.recorridoDijkstra(matriz, 0, 3);
//		
//		Warshall grafo2 = new Warshall();
//		int[][] matriz2 = {{0,1,1},{1,0,0},{0,1,0}};
//		matriz2 = grafo2.recorridoWarshall(matriz2);
//		grafo2.hayCamino(matriz2, 1, 1);
//		
//		int[][] matriz3 =  {{0,8,5},{3,0,INF},{INF,2,0}};
//		matriz3 = grafo2.recorridoFloyd(matriz3);

//		int[][] matriz4 = { 
//				{ INF, 1, INF, INF, INF, INF, INF, INF, 1, INF, INF, INF, INF }, // 0
//				{ INF, INF, 1, INF, INF, 1, INF, INF, INF, INF, INF, INF, INF }, // 1
//				{ INF, INF, INF, 1, INF, INF, INF, INF, INF, INF, INF, INF, INF }, // 2
//				{ INF, INF, 1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF }, // 3
//				{ INF, INF, INF, INF, INF, 1, INF, INF, 1, INF, INF, INF, INF }, // 4
//				{ INF, INF, INF, INF, 1, INF, 1, INF, INF, 1, INF, INF, INF }, // 5
//				{ INF, INF, INF, INF, INF, 1, INF, 1, INF, INF, INF, INF, INF }, // 6
//				{ INF, INF, INF, INF, INF, INF, 1, INF, INF, INF, INF, INF, INF }, // 7
//				{ 1, INF, INF, INF, 1, INF, INF, INF, INF, 1, INF, INF, INF }, // 8
//				{ INF, INF, INF, INF, INF, INF, INF, INF, 1, INF, 1, INF, INF }, // 9
//				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, 1, INF, INF, INF }, // 10
//				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 1 }, // 11
//				{ INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 1, INF }, // 12
//		};
//
//		Recorrido grafo = new Recorrido();
//		grafo.recorrerBFS(matriz4, 0);

		Recorrido grafoMST = new Recorrido();
		int[][] matriz5 = { { INF, 2, INF, 4, INF, 5, INF, }, { 2, INF, 7, 1, 3, 8, 4 },
				{ INF, 7, INF, INF, 10, INF, 6 }, { 4, 1, INF, INF, 2, INF, INF }, { INF, 3, 10, 2, INF, INF, INF },
				{ 5, 8, INF, INF, INF, INF, 1 }, { INF, 4, 6, INF, INF, 1, INF }, };

		// grafoMST.recorridoPrim(matriz5, 0);
		grafoMST.recorridoKruskal(matriz5);

	}

}
