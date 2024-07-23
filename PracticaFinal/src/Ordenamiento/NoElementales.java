package Ordenamiento;

public class NoElementales {

	public static void main(String[] args) {

		int[] vec = { 2, 4, 6, 8, 1, 3, 5, 7, 9, 10, 20, 18, 17, 16, 15, 19, 14, 13, 12, 11 };

		// ShellSort(vec);
		// QuickSort(vec, 0, vec.length - 1);
		// MergeSort(vec);
		TimSort(vec, 4);
		imprimirVec(vec);
	}

	public static void imprimirVec(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i]);
			if (i < vec.length - 1) {
				System.out.print(" - ");
			}
		}
		System.out.println();
	}

	public static void invertirArray(int[] vec) {
		int ini = 0;
		int fin = vec.length - 1;

		while (ini < fin) {
			// Intercambiar elementos
			int temp = vec[ini];
			vec[ini] = vec[fin];
			vec[fin] = temp;

			// Mover los índices
			ini++;
			fin--;
		}
	}

	public static void ShellSort(int[] vec) {
		int tamVec = vec.length;
		// h = hAnt*3+1
		// obtengo h
		int h = 1;
		int hAnt = h;
		while ((h * 3 + 1) < tamVec) {
			hAnt = h;
			h = hAnt * 3 + 1;
		}
		// hSig = (h-1)/3
		while (h >= 1) {
			for (int i = h; i < tamVec; i++) {
				int valor = vec[i];
				int j;
				for (j = i; j >= h && vec[j - h] > valor; j -= h) {
					vec[j] = vec[j - h];
				}
				vec[j] = valor;
			}
			h = (h - 1) / 3;
		}
	}

	public static void QuickSort(int[] vec, int ini, int fin) {

		if (ini < fin) {
			int posPivot = (ini + fin) / 2;
			int pivot = vec[posPivot];

			vec[posPivot] = vec[fin];
			vec[fin] = pivot;

			int i = ini;
			int j = fin - 1;

			while (i <= j) {
				while (i <= j && vec[i] < pivot) {
					i++;
				}
				while (i <= j && vec[j] > pivot) {
					j--;
				}
				if (i <= j) {
					int temp = vec[i];
					vec[i] = vec[j];
					vec[j] = temp;
					i++;
					j--;
				}
			}
			vec[fin] = vec[i];
			vec[i] = pivot;

			QuickSort(vec, ini, i - 1);
			QuickSort(vec, i + 1, fin);
		}
	}

	public static void MergeSort(int[] vec) {

		if (vec == null)
			return;

		MergeSort(vec, 0, vec.length - 1);

	}

	public static void MergeSort(int[] vec, int ini, int fin) {
		if (ini >= fin)
			return;

		int mitad = (fin + ini) / 2;

		MergeSort(vec, ini, mitad);
		MergeSort(vec, mitad + 1, fin);
		Merge(vec, ini, mitad, fin);
	}

	public static void Merge(int[] vec, int ini, int mitad, int fin) {

		int[] vecAux = new int[vec.length];

		// copio 1ra parte
		for (int i = ini; i <= mitad; i++) {
			vecAux[i] = vec[i];
		}
		// copio la 2da al reves
		for (int j = fin; j >= mitad + 1; j--) {
			vecAux[mitad + 1 + fin - j] = vec[j];
		}

		int i = ini;
		int j = fin;
		int k = ini;
		while (i < j) {
			if (vecAux[i] <= vecAux[j]) {
				vec[k] = vecAux[i];
				i++;
				k++;
			} else {
				vec[k] = vecAux[j];
				j--;
				k++;
			}
		}
		// si quedaron valores sin pasar
		while (i <= mitad) {
			vec[k] = vecAux[i];
			i++;
			k++;
		}
	}

	public static void TimSort(int[] vec, int maxDiv) {
		if (vec == null || vec.length < 2) {
			return;
		}
		TimSort(vec, 0, vec.length - 1, maxDiv);
	}

	public static void TimSort(int[] vec, int ini, int fin, int maxDiv) {
		if (ini < fin) {
			if (fin - ini <= maxDiv) {

				Elementales.insercion(vec, ini, fin);
			}
			int mitad = (fin + ini) / 2;
			TimSort(vec, ini, mitad, maxDiv);
			TimSort(vec, mitad + 1, fin, maxDiv);
			Merge(vec, ini, mitad, fin);

		}
	}

}
