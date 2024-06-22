package Grafos;

import java.util.Arrays;

import java.util.Arrays;

public class ColoreoSecuencial {

	private int cantVertices;
	private int[][] matrizAdyacencia;

	public ColoreoSecuencial(int[][] matriz) {
		matrizAdyacencia = matriz;
		cantVertices = matriz.length;
	}

	public void colorear() {

		int[] colorVertice = new int[this.cantVertices];
		boolean[] verticeDisponible = new boolean[cantVertices];

		Arrays.fill(colorVertice, -1);
		Arrays.fill(verticeDisponible, true);

		colorVertice[0] = 0; //

		for (int i = 1; i < cantVertices; i++) {
			for (int j = 0; j < cantVertices; j++) {
				if (matrizAdyacencia[i][j] == 1 && colorVertice[j] != -1) {
					verticeDisponible[colorVertice[j]] = false;
				}
			}

			int color;
			for (color = 0; color < cantVertices; color++) {
				if (verticeDisponible[color]) {
					break;
				}
			}
			colorVertice[i] = color;
			Arrays.fill(verticeDisponible, true);

		}

		imprimir(colorVertice);

	}

	private void imprimir(int[] color) {
		System.out.println("Resultado de Coloreo de Vértices:");
		for (int i = 0; i < cantVertices; i++)
			System.out.println("Vértice " + i + " --->  Color " + color[i]);
	}

	public static void main(String[] args) {

		int[][] matriz = {
				// A;B;C;D;E;F;G;H;I;J
				{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 }, // A
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // B
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, // C
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, // D
				{ 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 }, // E
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 }, // F
				{ 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 }, // G
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, // H
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 }, // I
				{ 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 } // J
		};

		ColoreoSecuencial grafo = new ColoreoSecuencial(matriz);
		grafo.colorear();
	}

}
