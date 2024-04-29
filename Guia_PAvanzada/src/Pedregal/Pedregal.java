package Pedregal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Pedregal {

	private int[][] pedregal;
	private int[][] casa;

	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void leerArchivo(int[][] pedregal, int[][] casa) {

		// leo el archivo
		// armo la matriz pedregal

		try {
			File archivo = new File("../Guia_PAvanzada/src/Pedregal/pedregal.in");

			Scanner scanner = new Scanner(archivo);

			// leo el tamaño del pedregal
			String[] tamPedregal = scanner.nextLine().split(" ");
			int fila1 = Integer.parseInt(tamPedregal[0]);
			int columna1 = Integer.parseInt(tamPedregal[1]);
			this.pedregal = new int[fila1][columna1];

			// leo el tamaño de la casa
			// scanner.nextLine().split(" ");
			String[] tamCasa = scanner.nextLine().split(" ");
			int filaCasa = Integer.parseInt(tamCasa[0]);
			int columnaCasa = Integer.parseInt(tamCasa[1]);
			this.casa = new int[filaCasa][columnaCasa];

			// obtengo la cantidad de coordenadas del pedregal
			int cantCoordenadas = Integer.parseInt(scanner.nextLine());

			// relleno la matriz con "1" del pedregal en las coordenadas

			for (int i = 0; i < cantCoordenadas; i++) {
				tamPedregal = scanner.nextLine().split(" "); // reutilizo variable
				int fila = Integer.parseInt(tamPedregal[0]) - 1;
				int columna = Integer.parseInt(tamPedregal[1]) - 1;

				if (fila >= 0 && columna >= 0 && fila <= fila1 && columna <= columna1) {
					this.pedregal[fila][columna] = 1;
				}

			}

			// relleno la matriz de la casa con 9 a modo de testeo
			for (int i = 0; i < filaCasa; i++) {
				for (int j = 0; j < columnaCasa; j++) {
					this.casa[i][j] = 9;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}

		// test imprimo matriz
		System.out.println("TERRENO: \n");
		imprimirMatriz(this.pedregal);
		System.out.println("\nCASA: ");
		imprimirMatriz(this.casa);

	}

	public void construirPedregal() {

		leerArchivo(pedregal, casa); // leo el archivo y armo la matriz

	}

	public void procesarConstruccion() {

		int tamCasaFila = this.casa.length;
		int tamCasaColumna = this.casa[0].length;
		int tamPedregalFila = this.pedregal.length;
		int tamPedregalColumna = this.pedregal[0].length;

		int coordenadaFila = 0, coordenadaColumna = 0;
		char esPosible = 'N', orientacion = 'N';

		// System.out.println(tamCasaColumna);

		// crear archivo salida
		generarArchivo(coordenadaFila, coordenadaColumna, esPosible, orientacion);

	}

	public void generarArchivo(int coordenadaFila, int coordenadaColumna, char esPosible, char orientacion) {

		try {
			String nombreArchivo = "../Guia_PAvanzada/src/Pedregal/pedregal.out";
			FileWriter escritor = new FileWriter(nombreArchivo);

			escritor.write(esPosible + "\n");
			escritor.write(coordenadaFila + " " + coordenadaColumna + "\n");
			escritor.write(orientacion + "\n");

			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo.");
			e.printStackTrace();
		}

	}

}
