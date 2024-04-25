package Ordenamiento;

public class Main {

	public static void main(String[] args) {

		int[] vec = { 99, 156485, 1258, 18, 22, 38, 1, 7, 2, 3 };

		System.out.print("\nVector original: ");
		for (int num : vec) {
			System.out.print(num + " ");
		}

		// System.out.print("\nOrdenamiento por Shell: ");
		// Ordenamiento.OrdenamientoShell(vec);

		System.out.print("\n ");
		System.out.print("\nOrdenamiento por QuickSort: ");
		
		Ordenamiento.OrdenarQuickSort(vec, 0, vec.length - 1);

		//Ordenamiento.quicksortv2(vec, 0, vec.length - 1);

		//System.out.print("\n ");
		//System.out.print("\nOrdenamiento por Insercion: ");
		//Ordenamiento.insercion(vec);
		
		for (int num : vec) {
			System.out.print(num + " ");
		}
		
	}
}
