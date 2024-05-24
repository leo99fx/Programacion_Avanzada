package RescatandoALaPrincesa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private static File file;
	private static Scanner scanner = null;

	public static Bosque leerArchivo() throws IOException {

		Bosque bosque = null;
		List<Integer> dragones = new ArrayList<Integer>();
		;
		int[][] claros;

		try {
			file = new File("../Guia_PAvanzada/src/RescatandoALaPrincesa/princesa.in");

			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);

			// Leer primera linea
			String linea = scanner.nextLine();
			String[] atributos = linea.split("\t");

			int cantidadClaros = Integer.parseInt(atributos[0]);
			int cantidadSenderos = Integer.parseInt(atributos[1]);
			int cantidadDragones = Integer.parseInt(atributos[2]);

			// Leer segunda linea
			linea = scanner.nextLine();
			atributos = linea.split("\t");

			int claroPrincesa = Integer.parseInt(atributos[0]);
			int claroPrincipe = Integer.parseInt(atributos[1]);

			// Leer linea de dragones
			linea = scanner.nextLine();
			atributos = linea.split("\t");

			// dragones = new int[atributos.length];
			for (int i = 0; i < atributos.length; i++) {
				dragones.add(Integer.parseInt(atributos[i]) - 1);
			}

			claros = new int[cantidadClaros][cantidadClaros];
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				atributos = linea.split("\t");

				int claroInicial = Integer.parseInt(atributos[0]);
				int claroFinal = Integer.parseInt(atributos[1]);
				int largoDelSendero = Integer.parseInt(atributos[2]);

				claros[claroInicial - 1][claroFinal - 1] = largoDelSendero;
			}

			bosque = new Bosque(dragones, claros, claroPrincipe, claroPrincesa);
			bosque.reemplazarCerosPorINF();
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return bosque;
	}

	public static void noHayCamino() {
		String rutaArchivo = "../Guia_PAvanzada/src/RescatandoALaPrincesa/princesa.out";

		try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
			escritor.println("NO HAY CAMINO");
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

	public static void interceptado() {
		String rutaArchivo = "../Guia_PAvanzada/src/RescatandoALaPrincesa/princesa.out";

		try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
			escritor.println("INTERCEPTADO");
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

	public static void escribirCaminoYPuntaje(int nodoPrincipe, int[] vector, int nodoPrincesa, int puntaje) {
		String rutaArchivo = "../Guia_PAvanzada/src/RescatandoALaPrincesa/princesa.out";

		try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
			// Escribir el nodoPrincipe, los valores del vector y el nodoPrincesa en la
			// misma línea
			escritor.print(nodoPrincipe+1 + " ");
			for (int valor : vector) {
				if (valor >= 0) {
					escritor.print(valor+1 + " ");
				}
			}
			escritor.println(nodoPrincesa+1);

			// Escribir el puntaje en un segundo renglón
			escritor.println("Puntaje: " + puntaje);
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

}