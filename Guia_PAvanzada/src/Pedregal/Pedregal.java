package Pedregal;

import java.io.File;
import java.io.FileNotFoundException;
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
			File archivo = new File("pedregal.in");

			Scanner scanner = new Scanner(archivo);

			// leo el tamaño del pedregal
			String[] tamPedregal = scanner.nextLine().split(" ");
			int fila1 = Integer.parseInt(tamPedregal[0]);
			int columna1 = Integer.parseInt(tamPedregal[1]);
			pedregal = new int[fila1][columna1];

			// leo el tamaño de la casa
			// scanner.nextLine().split(" ");
			String[] tamCasa = scanner.nextLine().split(" ");
			int filaCasa = Integer.parseInt(tamCasa[0]);
			int columnaCasa = Integer.parseInt(tamCasa[1]);
			casa = new int[filaCasa][columnaCasa];

			// obtengo la cantidad de coordenadas del pedregal
			int cantCoordenadas = Integer.parseInt(scanner.nextLine());

			// relleno la matriz del pedregal con las coordenadas

			for (int i = 0; i < cantCoordenadas; i++) {
				tamPedregal = scanner.nextLine().split(" "); // reutilizo variable
				int fila = Integer.parseInt(tamPedregal[0]) - 1;
				int columna = Integer.parseInt(tamPedregal[1]) - 1;

				if (fila >= 0 && columna >= 0 && fila <= fila1 && columna <= columna1) {
					pedregal[fila][columna] = 1;
				}

			}
			
			for (int i = 0; i < filaCasa; i++) {
			    for (int j = 0; j < columnaCasa; j++) {
			    	casa[i][j] = 9;
			    }
			}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}

		// imprimo matriz
		imprimirMatriz(pedregal);
		System.out.println();
		imprimirMatriz(casa);

	}

	public void construirPedregal() {

		leerArchivo(pedregal, casa); // leo el archivo y armo la matriz

	}

}
