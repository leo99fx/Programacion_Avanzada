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
		} // O(n)

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

	} // O(n^(3/2))

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
			} // O(n)
		} while (i <= j);

		if (primero < j)
			quicksortv2(arreglo, primero, j); // T(n/2)
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

	// FUSION
	public static void ordenarFusion(int[] vec) {

		int tam = vec.length;

		if (vec == null || tam <= 2) {
			return;
		}

		ordenarFusion(vec, 0, tam - 1);

	}

	public static void ordenarFusion(int[] vec, int izq, int der) {

		if (izq < der) {
			int medio = (izq + der) / 2;

			ordenarFusion(vec, izq, medio);
			ordenarFusion(vec, medio + 1, der);

			fusion(vec, izq, medio, der);

		}

	}

	public static void fusion(int[] vec, int izq, int medio, int der) {

		int n1 = medio - izq + 1;
		int n2 = der - medio;

		int[] vecAux1 = new int[n1]; // creo vectores del tamaño de cada sub array auxiliares
		int[] vecAux2 = new int[n2];

		// copio el contenido del vector original y sus sub array a los auxiliares

		for (int i = 0; i < n1; i++) {
			vecAux1[i] = vec[izq + i];
		}

		for (int i = 0; i < n2; i++) {
			vecAux2[i] = vec[medio + i + 1];
		}

		// ordeno los subarray

		ordenarPorSeleccion(vecAux1);
		ordenarPorSeleccion(vecAux2);

		int i = 0, j = 0; // indices arrayAux1 y 2

		// copio primer parte igual y la 2da al revez

		while (i < n1 && j < n2) {

			vec[izq + i] = vecAux1[i];
			vec[der - j] = vecAux2[i];
			i++;
			j++;
		}

		// ordeno por seleccion
		int n = der - izq + 1;
		for (i = 0; i < n - 1; i++) {
			int menor = i + izq;
			for (j = i + 1 + izq; j <= der; j++)
				if (vec[j] < vec[menor])
					menor = j;
			int swap = vec[i + izq];
			vec[i + izq] = vec[menor];
			vec[menor] = swap;
		}

	} // O(n) = n*log(n)

	public static void ordenarTimSort(int[] vec, int cantElemXGrupo) {

		int tam = vec.length;

		if (vec == null) {
			return;
		}

		ordenarTimSort(vec, 0, tam - 1, cantElemXGrupo);

	}

	public static void ordenarTimSort(int[] vec, int izq, int der, int cantElemXGrupo) {

		if (izq < der && (der - izq) >= cantElemXGrupo) {

			int medio = (izq + der) / 2;

			ordenarTimSort(vec, izq, medio, cantElemXGrupo);
			ordenarTimSort(vec, medio + 1, der, cantElemXGrupo);

			timsort(vec, izq, medio, der);

		}

	}

	public static void timsort(int[] vec, int izq, int medio, int der) {

		int n1 = medio - izq + 1;
		int n2 = der - medio;

		int[] vecAux1 = new int[n1]; // creo vectores del tamaño de cada sub array auxiliares
		int[] vecAux2 = new int[n2];

		// copio el contenido del vector original y sus sub array a los auxiliares

		for (int i = 0; i < n1; i++) {
			vecAux1[i] = vec[izq + i];
		}

		for (int i = 0; i < n2; i++) {
			vecAux2[i] = vec[medio + i + 1];
		}

		// ordeno los subarray

		insercion(vecAux1);
		insercion(vecAux2);

		int i = 0, j = 0, k = izq; // indices arrayAux1 y 2

		// copio primer parte igual y la 2da al revez

		while (i < n1 && j < n2) {
			if (vecAux1[i] <= vecAux2[j]) {
				vec[k] = vecAux1[i];
				i++;
			} else {
				vec[k] = vecAux2[j];
				j++;
			}
			k++;
		}

		// Copia los elementos restantes de vecAux1, si los hay
		while (i < n1) {
			vec[k] = vecAux1[i];
			i++;
			k++;
		}

		// Copia los elementos restantes de vecAux2, si los hay
		while (j < n2) {
			vec[k] = vecAux2[j];
			j++;
			k++;
		}

	} // O(n) = n*log(n)

}
