package Prog_Dinamica;

import java.util.HashMap;
import java.util.Map;

public class Programacion_Dinamica {

	private static int fibonacci(int n, Map<Integer, Integer> mem) {
		int key = n;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		if (n < 2) {
			mem.put(key, n);
		} else {
			mem.put(key, fibonacci(n - 1, mem) + fibonacci(n - 2, mem));
		}
		return mem.get(key);
	} // top down

	public static int fibonacci(int n) {
		return fibonacci(n, new HashMap<Integer, Integer>());

	}

	public static int fibonacci_BottonUp(int n) {
		if (n < 2) {
			return n;
		}
		int anteriorDelAnterior = 0;
		int anterior = 1;
		int actual = 1;

		for (int i = 2; i <= n; i++) {
			actual = anteriorDelAnterior + anterior;
			anteriorDelAnterior = anterior;
			anterior = actual;
		}
		return actual;
	}

	// EL LADRON DE CASAS
	public static int ladronDeCasas(int[] vec) {

		int anterior = vec[1];
		int anteriorAnterior = vec[0];

		int tam = vec.length;
		int aux;

		for (int i = 2; i < tam; i++) {

			if (vec[i] + anteriorAnterior > anterior) {
				aux = anterior;
				anterior = anteriorAnterior + vec[i];
				anteriorAnterior = aux;
			} else {
				anteriorAnterior = anterior;
			}

		}

		return anterior > anteriorAnterior ? anterior : anteriorAnterior;
	}

	// LA MINA DE ORO

	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int minaDeOro(int[][] mina) {
		int res = 0;

		int fila = mina.length;
		int columna = mina[0].length;

		for (int i = 1; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < columna) {

					int mayorIzq = mina[i - 1][j] > mina[i - 1][j - 1] ? mina[i - 1][j] : mina[i - 1][j - 1];
					int mayorDer = mina[i - 1][j] > mina[i - 1][j + 1] ? mina[i - 1][j] : mina[i - 1][j + 1];

					int mayor = mina[i][j] + (mayorIzq > mayorDer ? mayorIzq : mayorDer);

					mina[i][j] = mayor;

				} else if (i - 1 >= 0 && j == 0) {

					int mayor = mina[i][j]
							+ (mina[i - 1][j] > mina[i - 1][j + 1] ? mina[i - 1][j] : mina[i - 1][j + 1]);

					mina[i][j] = mayor;
				} else if (i - 1 >= 0 && j == columna - 1) {
					int mayor = mina[i][j]
							+ (mina[i - 1][j] > mina[i - 1][j - 1] ? mina[i - 1][j] : mina[i - 1][j - 1]);
					mina[i][j] = mayor;
				}
			}
		}

		// encuentro mayor de la ultima fila
		res = mina[fila - 1][0];
		for (int i = 1; i < columna; i++) {
			if (mina[fila - 1][i] > res) {
				res = mina[fila - 1][i];
			}
		}

		return res;
	}

	public static void main(String[] args) {

//		for (int i = 0; i < 100; i++) {
//			System.out.println("Fibonacci de " + i + ": " + fibonacci(5));
//		}
		System.out.println(fibonacci(5));

//		int[] vec = { 2, 10, 3, 6, 8, 1, 7 };
//
//		int plata = ladronDeCasas(vec);
//
//		System.out.println(plata);

//		int[][] matriz = { { 3, 2, 12, 15, 10 }, { 6, 19, 7, 11, 17 }, { 8, 5, 12, 32, 21 }, { 3, 20, 2, 9, 7 } };
//
//		System.out.println("MATRIZ ORIGINAL:");
//		imprimirMatriz(matriz);
//		System.out.println("MAXIMO ORO A SACAR: " + minaDeOro(matriz));
//		System.out.println("MATRIZ LUEGO DE LA MINA:");
//		imprimirMatriz(matriz);

		// System.out.println(fibonacci_BottonUp(3));

	}

}
