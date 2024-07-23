package Ordenamiento;

public class Elementales {

	/*
	 * - Burbujeo - Insersion - Seleccion
	 */
	public static void main(String[] args) {
		int[] vec = { 2, 4, 6, 8, 1, 3, 5, 7, 9, 10 };

		// burbujeo(vec);
		// insercion(vec);
		seleccion(vec);
		imprimirVec(vec);
	}

	public static void imprimirVec(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i] + " - ");
		}
	}

	public static void burbujeo(int[] vec) {
		int tamVec = vec.length;

		for (int i = 0; i < tamVec; i++) {
			for (int j = 0; j < tamVec; j++) {
				if (vec[i] < vec[j]) {
					int aux = vec[i];
					vec[i] = vec[j];
					vec[j] = aux;
				}
			}
		}
	}

	public static void insercion(int[] vec) {
		int tamVec = vec.length;
		for (int i = 1; i < tamVec; i++) {
			int j = i;
			while (j > 0 && vec[j - 1] > vec[j]) {
				int aux = vec[j];
				vec[j] = vec[j - 1];
				vec[j - 1] = aux;
				j--;
			}
		}
	}

	public static void insercion(int[] vec, int ini, int fin) {
		for (int i = ini; i < fin; i++) {
			int j = i;
			while (j > 0 && vec[j - 1] > vec[j]) {
				int aux = vec[j];
				vec[j] = vec[j - 1];
				vec[j - 1] = aux;
				j--;
			}
		}
	}

	public static void seleccion(int[] vec) {
		int tamVec = vec.length;

		for (int i = 0; i < tamVec - 1; i++) {
			int min = i;
			for (int j = i + 1; j < tamVec - 1; j++) {
				if (vec[j] < vec[min]) {
					min = j;
				}
			}
			// intercambio
			int aux = vec[min];
			vec[min] = vec[i];
			vec[i] = aux;
		}
	}
}
