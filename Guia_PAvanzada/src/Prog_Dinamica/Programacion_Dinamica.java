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
	}

	public static int fibonacci(int n) {
		return fibonacci(n, new HashMap<Integer, Integer>());

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
	
	public static int minaDeOro(int[][]mina) {
		int res=0;
		
		
		
		
		return res;
	}

	public static void main(String[] args) {

//		for (int i = 0; i < 100; i++) {
//			System.out.println("Fibonacci de " + i + ": " + fibonacci(i));
//		}

//		int[] vec = { 2, 10, 3, 6, 8, 1, 7 };
//
//		int plata = ladronDeCasas(vec);
//
//		System.out.println(plata);
		
		int[][] matriz= {{3,2,12,15,10},
					{6,19,7,11,17},
					{8,5,12,32,21},
					{3,20,2,9,7}};
		
		System.out.println(minaDeOro(matriz));

	}

}
