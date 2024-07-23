package Pedregal;

public class Main {

	public static void main(String[] args) {

		Archivo a = new Archivo();

		Pedregal res = a.leerArchivo();

		res.imprimir();
		res.procesar();

	}

}
