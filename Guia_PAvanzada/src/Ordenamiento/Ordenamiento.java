package Ordenamiento;

public class Ordenamiento {

	public static void ordenarPorSeleccion(int[] datos) {
		int n = datos.length;
		for (int i = 0; i < (n - 1); i++) {
			int menor = i;
			for (int j = i + 1; j < n; j++)
				if (datos[j] < datos[menor])
					menor = j;
			int swap = datos[i];
			datos[i] = datos[menor];
			datos[menor] = swap;
		}
	}

	public static void OrdenamientoShell(int[] vec) {

		int n = vec.length;
		int h = 1;
		int aux = 1;

		while (h < n) {
			aux = h;
			h = (aux * 3) + 1;
		}

		while (h >= 1) {

			for (int i = h; i < n; i++) {

				int temp = vec[i];

				int j;
				for (j = i; j >= h && vec[j - h] > temp; j -= h) {

					vec[j] = vec[j - h];
				}

				vec[j] = temp;
			}

			h = (h - 1) / 3;
		}

	}

	public static void OrdenarQuickSort(int[] vec, int ini, int fin) {

		int p = vec[(ini + fin) / 2];
		int aux, i, j;
		i = ini;
		j = fin;

		aux = vec[(ini + fin) / 2];
		vec[(ini + fin) / 2] = vec[fin - 1];
		vec[fin - 1] = aux;

		do {

			while (vec[i] < p) {
				i++;
			}

			while (vec[j] > p) {
				j--;
			}

			if (i <= j) {
				aux = vec[i];
				vec[i] = vec[j];
				vec[j] = aux;
				i++;
				j--;
			}

		} while (i <= j);

		if (ini < i - 1) {
			OrdenarQuickSort(vec, ini, i - 1);
		}
		if (i + 1 < fin) {
			OrdenarQuickSort(vec, i + 1, fin);
		}
	}

	public static void quicksortv2(int arreglo[], int primero, int ultimo) {
		int central, i, j;
		int pivote;
		central = (primero + ultimo) / 2;
		pivote = arreglo[central];
		i = primero;
		j = ultimo;
		do {
			while (arreglo[i] < pivote)
				i++;
			while (arreglo[j] > pivote)
				j--;
			if (i <= j) {
				int temp;
				temp = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = temp;
				i++;
				j--;
			}
		}

		while (i <= j);
		if (primero < j)
			quicksortv2(arreglo, primero, j);
		if (i < ultimo)
			quicksortv2(arreglo, i, ultimo);
	}

	public static void insercion(int[] vec) {

		int n = vec.length;

		for (int i = 0; i < n; i++) {
			int j = i;
			while (j > 0 && vec[j - 1] > vec[j]) {
				int aux = vec[j];
				vec[j] = vec[j - 1];
				vec[j - 1] = aux;
				j--;
			}
		}

	}

	public static void OrdenarFusion(int[] vec) {

	}

}
