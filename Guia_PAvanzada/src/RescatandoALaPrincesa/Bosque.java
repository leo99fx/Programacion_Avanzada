package RescatandoALaPrincesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bosque {

	public static int INF = 1000000;
	private List<Integer> dragones;
	private int[][] bosque;
	private int claroPrincipe;
	private int claroPrincesa;
	private static final int DRAGON = 999999;

	public Bosque(List<Integer> dragones, int[][] bosque, int claroPrincipe, int claroPrincesa) {

		this.dragones = new ArrayList<Integer>();
		this.dragones = dragones;

		this.bosque = new int[bosque.length][bosque.length];
		this.bosque = bosque;

		this.claroPrincipe = claroPrincipe - 1; // resto uno sino desbordo la matriz
		this.claroPrincesa = claroPrincesa - 1;
	}

	public void Dijkstra() {

		int nodoInicial = this.claroPrincipe;
		int nodoDestino = this.claroPrincesa;
		int[][] mat = this.bosque;
		int tamMat = mat.length;
		int[] costos = new int[tamMat];
		int[] predecesores = new int[tamMat];
		boolean[] visitados = new boolean[tamMat];

		int flagInterceptado = 0;

		// inicio vectores
		for (int i = 0; i < tamMat; i++) {
			if (mat[nodoInicial][i] != INF) {
				costos[i] = mat[nodoInicial][i];
			} else {
				costos[i] = INF;
			}
			predecesores[i] = -1;
		}

		costos[nodoInicial] = 0;

		for (int visita = 0; visita < tamMat; visita++) { // debo recorrer mi vector y tomar mi primer menor costo
			int menorCosto = INF;
			int nodoMenorCosto = -1;

			for (int i = 0; i < tamMat; i++) {
				if (!visitados[i] && costos[i] < menorCosto) {
					menorCosto = costos[i];
					nodoMenorCosto = i;
				}
			}

			if (nodoMenorCosto == -1) {
				break;
			}

			visitados[nodoMenorCosto] = true;

			for (int i = 0; i < tamMat; i++) {
				if (!visitados[i] && (costos[nodoMenorCosto] + mat[nodoMenorCosto][i]) < costos[i]) {
					costos[i] = (costos[nodoMenorCosto] + mat[nodoMenorCosto][i]);
					predecesores[i] = nodoMenorCosto;
					if (this.dragones.contains(nodoMenorCosto)) {
						Archivo.interceptado();
						System.out.println("PRINCIPE INTERCEPTADO - INTERRUPCION DE CALCULO");
						flagInterceptado = 1;
						break;
					} else {
						continue;
					}
				}
			}
			if (flagInterceptado != 1) {
				System.out.println("Iteración " + (visita + 1) + ":");
				imprimirEstado(costos, predecesores);
			} else {
				break;
			}

		}

		// imprimo el camino y el costo total
		if (flagInterceptado != 1) {
			if (costos[nodoDestino] == INF) {
				System.out.println("No se puede llegar del nodo " + nodoInicial + " al nodo " + nodoDestino);
				Archivo.noHayCamino();
			} else {
				System.out.println("Camino desde el nodo " + nodoInicial + " hasta el nodo " + nodoDestino + ":");
				imprimirCamino(predecesores, nodoDestino);
				System.out.println("\nCosto total: " + costos[nodoDestino]);
				Archivo.escribirCaminoYPuntaje(this.claroPrincipe, predecesores, this.claroPrincesa, 100);
			}
		}
	}

	private static void imprimirEstado(int[] costos, int[] predecesores) {
		System.out.println("Costos: " + Arrays.toString(costos));
		System.out.println("Predecesores: " + Arrays.toString(predecesores));
		System.out.println();
	}

	private static void imprimirCamino(int[] predecesores, int nodoDestino) {
		if (predecesores[nodoDestino] == -1) {
			System.out.print(nodoDestino);
		} else {
			imprimirCamino(predecesores, predecesores[nodoDestino]);
			System.out.print(" -> " + nodoDestino);
		}

	}

	public void imprimirDatos() { // a modo de prueba para visualizar en consola
		System.out.println("Dragones:");
		for (Integer dragon : dragones) {
			System.out.print(dragon + " ");
		}
		System.out.println();

		System.out.println("Bosque:");
		for (int i = 0; i < bosque.length; i++) {
			for (int j = 0; j < bosque[i].length; j++) {
				System.out.print(bosque[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Claro del Príncipe: " + claroPrincipe);
		System.out.println("Claro de la Princesa: " + claroPrincesa);
	}

	public void reemplazarCerosPorINF() {
		for (int i = 0; i < bosque.length; i++) {
			for (int j = 0; j < bosque[i].length; j++) {
				if (bosque[i][j] == 0) {
					bosque[i][j] = INF;
				}
			}
		}
	}
}
