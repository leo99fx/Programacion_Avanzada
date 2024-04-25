package Ordenamiento;

public class Ordenamiento {

	public static void main(String[] args) {

		int[] vec = { 99, 156485, 1258, 18, 22, 38, 1, 7, 2, 3 };

		System.out.print("\nVector original: ");
		for (int num : vec) {
			System.out.print(num + " ");
		}

		System.out.print("\nOrdenamiento por Shell: ");
		OrdenamientoShell(vec);

		for (int num : vec) {
			System.out.print(num + " ");
		}

	}

	private static void ordenarPorSeleccion(int[] datos) {
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

	public static void OrdenarQuickSort(int[] vec) {
		
		

	}

}
