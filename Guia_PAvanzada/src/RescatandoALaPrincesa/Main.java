package RescatandoALaPrincesa;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Bosque bosque;

		bosque = Archivo.leerArchivo();

		bosque.imprimirDatos();
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("=======================");

		bosque.Dijkstra();

	}

}
