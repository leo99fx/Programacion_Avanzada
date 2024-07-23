package Pedregal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	public Pedregal leerArchivo() {

		try {
			File archivo = new File("../PracticaFinal/src/Pedregal/pedregal.in");

			Scanner scanner = new Scanner(archivo);

			String[] tamPedregal = scanner.nextLine().split(" ");
			int fila = Integer.parseInt(tamPedregal[0]);
			int col = Integer.parseInt(tamPedregal[1]);
			int[][] pedregal = new int[fila][col];
			tamPedregal = scanner.nextLine().split(" ");
			fila = Integer.parseInt(tamPedregal[0]);
			col = Integer.parseInt(tamPedregal[1]);
			int tamFilaCasa = fila;
			int tamColCasa = col;

			int cantPiedras = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < cantPiedras; i++) {
				String[] linea = scanner.nextLine().split(" ");
				fila = Integer.parseInt(linea[0]);
				col = Integer.parseInt(linea[1]);
				pedregal[fila - 1][col - 1] = 1;
			}
			return new Pedregal(pedregal, tamFilaCasa, tamColCasa);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();

		}
		return null;
	}

	public void grabarArchivo() {

		File archivo = new File("../PracticaFinal/src/Pedregal/pedregal.out");
		try (FileWriter fw = new FileWriter(archivo); PrintWriter pw = new PrintWriter(fw)) {
			pw.println("NO");
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo");
			e.printStackTrace();
		}
	}

	public void grabarArchivo(String confirmacion, int fila, int col, char O) {

		File archivo = new File("../PracticaFinal/src/Pedregal/pedregal.out");
		try (FileWriter fw = new FileWriter(archivo); PrintWriter pw = new PrintWriter(fw)) {
			pw.println(confirmacion);
			pw.println(fila + " " + col);
			pw.println(O);
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo");
			e.printStackTrace();
		}
	}
}
