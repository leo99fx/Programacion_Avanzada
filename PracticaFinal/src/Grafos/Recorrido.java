package Grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Recorrido {
	public static int INF = Integer.MAX_VALUE;

	public void recorrerDFS(int[][] grafo, int nodoInicial) {
		boolean[] visitados = new boolean[grafo.length];
		Stack<Integer> stack = new Stack<>();

		stack.push(nodoInicial);
		int nodoActual = nodoInicial;
		while (!stack.isEmpty()) {

			for (int i = grafo.length - 1; i >= 0; i--) {
				if (grafo[nodoActual][i] != Integer.MAX_VALUE && visitados[i] != true) {
					stack.push(i);
					visitados[i] = true;

					System.out.println("Visite el nodo: " + i);
				}
			}
			nodoActual = stack.pop();
			System.out.println("->Retiro el nodo: " + nodoActual);
		}

	}

	public void recorrerBFS(int[][] grafo, int nodoInicial) {
		Queue<Integer> cola = new LinkedList<>();
		int[] costosVisitados = new int[grafo.length];

		for (int i = 0; i < costosVisitados.length; i++) {
			costosVisitados[i] = Integer.MAX_VALUE;
		}

		cola.add(nodoInicial);
		costosVisitados[nodoInicial] = 0;

		while (!cola.isEmpty()) {
			int nodoActual = cola.poll();
			int costoActual = costosVisitados[nodoActual];

			System.out.println("-> Retiro el nodo: " + nodoActual);

			for (int i = 0; i < grafo.length; i++) {

				if (grafo[nodoActual][i] != Integer.MAX_VALUE && costosVisitados[i] == Integer.MAX_VALUE) {
					cola.add(i);
					costosVisitados[i] = costoActual + 1;
					System.out.println("Visito el nodo: " + i);
				}
			}
		}

		for (int i = 0; i < costosVisitados.length; i++) {
			if (costosVisitados[i] == Integer.MAX_VALUE) {
				System.out.println("Nodo " + i + " - inalcanzable.");
			} else {
				System.out.println("Costo de " + i + " - " + costosVisitados[i]);
			}
		}
	}

	public boolean todosVisitados(boolean[] vec) {
		boolean res = true;

		for (int i = 0; i < vec.length; i++) {
			if (vec[i] == false) {
				res = false;
				break;
			}
		}
		return res;
	}

	public void recorridoPrim(int[][] grafo, int nodoInicial) {
		// tengo los vectores Vg y Vmst, Vg tendra todos los nodos del grafo
		// me posiciono en el nodoInicial en la matriz
		// Saco el nodo inicial de Vg y lo paso a Vmst
		// recorro toda la fila generando cada arista y esa arista
		// la pongo en una cola de prioridad (monticulo de minimos)
		// luego saco de la cola de prioridad el primero y me voy al nodoFinal
		// marco en mi arbol de recorrido el nodo incial y el final con su costo
		// y repito ciclo hasta que Vg quede vacio y Vmst tenga
		// todos los nodos visitados

		int nodoActual = nodoInicial;
		int costoAcumulado = 0;
		boolean[] visitados = new boolean[grafo.length];
		int[][] arbolRecorrido = new int[grafo.length][grafo.length];
		PriorityQueue<Arista> cola = new PriorityQueue<>();

		visitados[nodoActual] = true;
		// recorro todas las conexiones de mi nodoinicial
		for (int i = 0; i < grafo.length; i++) {
			if (grafo[nodoActual][i] != INF) {
				Arista a = new Arista(nodoActual, i, grafo[nodoActual][i]);
				cola.add(a);
			}
		}

		while (!todosVisitadosV2(visitados)) {
			Arista a = cola.poll();

			int nInicio = a.getNodoInicial();
			int nFin = a.getNodoFinal();

			if (visitados[nFin] == false) {
				int costoRec = a.getCosto();
				arbolRecorrido[nInicio][nFin] = costoRec;
				arbolRecorrido[nFin][nInicio] = costoRec;
				costoAcumulado += costoRec;
				nodoActual = nFin;
				visitados[nodoActual] = true;

				// recorro todas las conexiones de mi nodoinicial
				for (int i = 0; i < grafo.length; i++) {
					if (grafo[nodoActual][i] != INF) {
						Arista a2 = new Arista(nodoActual, i, grafo[nodoActual][i]);
						cola.add(a2);
					}
				}
			}
		}

		System.out.println("Costo: " + costoAcumulado);

		for (int i = 0; i < arbolRecorrido.length; i++) {
			System.out.print((char) (i + 65) + " - ");
			for (int j = 0; j < arbolRecorrido.length; j++) {
				if (arbolRecorrido[i][j] != 0)
					System.out.print((char) (j + 65) + " ");
			}
			System.out.println();
		}

	}

	public void recorridoKruskal(int[][] grafo) {
		PriorityQueue<Arista> cola = new PriorityQueue<>();
		int[] representanteNodo = new int[grafo.length];
		boolean[] visitados = new boolean[grafo.length];
		int costoAcumulado = 0;

		for (int i = 0; i < grafo.length; i++) {
			representanteNodo[i] = i+1;
			for (int j = 0; j < grafo.length; j++) {
				if (grafo[i][j] != INF) {
					Arista a = new Arista(i, j, grafo[i][j]);
					cola.add(a);
				}
			}
		}

		List<Arista> Vmst = new ArrayList<>();

		while (!todosVisitados(visitados)) {
			Arista a = cola.poll();

			int nodoIni = a.getNodoInicial();
			int nodoFin = a.getNodoFinal();
			int costoArista = a.getCosto();

			if (find(nodoIni+1, representanteNodo) == find(nodoIni+1, representanteNodo)) {
				union(nodoIni+1, nodoFin+1, representanteNodo);
				visitados[nodoIni] = true;
				visitados[nodoFin] = true;
				Vmst.add(a);
				costoAcumulado += costoArista;
			}
		}

		System.out.println("Costo total del recorrido: " + costoAcumulado);
		System.out.println("Recorrido del MST:");
		for (Arista a : Vmst) {
			System.out.println(a.getNodoInicial() + " - " + a.getNodoFinal());
		}
	}

	private int find(int nodo, int[] representanteNodo) {
		while (nodo != representanteNodo[nodo-1]) {
			nodo = representanteNodo[nodo-1];
		}
		return nodo;
	}

	private void union(int nodoIni, int nodoFin, int[] representanteNodo) {
		while (nodoIni != representanteNodo[nodoIni-1]) {
			nodoIni = representanteNodo[nodoIni-1];
		}

		while (nodoFin != representanteNodo[nodoFin-1]) {
			nodoFin = representanteNodo[nodoFin-1];
		}

		representanteNodo[nodoFin-1] = nodoIni;
	}

	public boolean todosVisitadosV2(boolean[] vec) {
		for (boolean visitado : vec) {
			if (!visitado) {
				return false;
			}
		}
		return true;
	}

}
