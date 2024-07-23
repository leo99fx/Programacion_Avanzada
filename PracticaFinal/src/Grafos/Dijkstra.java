package Grafos;

import java.util.Arrays;

public class Dijkstra {

	public boolean todosVisitados(boolean[] vec) {
		for (boolean visitado : vec) {
			if (!visitado) {
				return false;
			}
		}
		return true;
	}

	public void recorridoDijkstra(int[][] grafo, int nodoInicial, int nodoDestino) {
		boolean[] visitados = new boolean[grafo.length];
		int[] distancia = new int[grafo.length];
		int[] predecesores = new int[grafo.length];

		for (int j = 0; j < grafo.length; j++) {
			if (grafo[nodoInicial][j] != Integer.MAX_VALUE) {
				distancia[j] = grafo[nodoInicial][j];
				predecesores[j] = nodoInicial;
			} else {
				distancia[j] = Integer.MAX_VALUE;
				predecesores[j] = -1;
			}
		}

		distancia[nodoInicial] = 0;
		visitados[nodoInicial] = true;
		predecesores[nodoInicial] = nodoInicial;

		while (!todosVisitados(visitados)) {
			int nodoMenor = menorNodoNoVisitado(distancia, visitados);
			if (nodoMenor == -1) {
				break;
			}
			visitados[nodoMenor] = true;

			for (int i = 0; i < grafo.length; i++) {
				if (!visitados[i] && grafo[nodoMenor][i] != Integer.MAX_VALUE
						&& distancia[i] > distancia[nodoMenor] + grafo[nodoMenor][i]) {
					distancia[i] = distancia[nodoMenor] + grafo[nodoMenor][i];
					predecesores[i] = nodoMenor;
				}
			}
		}

		// Imprimir distancias y predecesores
		System.out.println("Nodo Inicial: " + nodoInicial);
		System.out.println("Nodo\tDistancia\tPredecesor");
		for (int i = 0; i < grafo.length; i++) {
			System.out.println(i + "\t" + distancia[i] + "\t\t" + predecesores[i]);
		}

		System.out.println("De nodoInicio a nodoDestino");
		imprimirCamino(predecesores, nodoDestino);
	}

	private int menorNodoNoVisitado(int[] distancia, boolean[] visitados) {
		int distanciaMenor = Integer.MAX_VALUE;
		int nodo = -1;
		for (int i = 0; i < distancia.length; i++) {
			if (!visitados[i] && distancia[i] < distanciaMenor) {
				distanciaMenor = distancia[i];
				nodo = i;
			}
		}
		return nodo;
	}

	private static void imprimirCamino(int[] predecesores, int nodoDestino) {
		if (predecesores[nodoDestino] == 0) {
			System.out.print(nodoDestino);
		} else {
			imprimirCamino(predecesores, predecesores[nodoDestino]);
			System.out.print(" -> " + nodoDestino);
		}

	}
}
