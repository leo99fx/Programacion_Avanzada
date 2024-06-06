package Ordenamiento;

public class Main {

	public static void main(String[] args) {

		int[] vec = { 8, 2, 6, 4, 1, 3, 7, 9 ,5};

		System.out.print("\nVector original: ");
		for (int num : vec) {
			System.out.print(num + " ");
		}

//		System.out.print("\n ");
//		System.out.print("\nOrdenamiento por Insercion: ");
//		Ordenamiento.insercion(vec);
//
//		System.out.print("\nOrdenamiento por Shell: ");
//		Ordenamiento.OrdenamientoShell(vec);
//
//		System.out.print("\n ");
//		System.out.print("\nOrdenamiento por QuickSort: ");
//
//		Ordenamiento.quicksortv2(vec, 0, vec.length - 1);
//
//		System.out.print("\n ");
//		System.out.print("\nOrdenamiento por Fusion - Merge: ");
//
//		Ordenamiento.ordenarFusion(vec);

		System.out.print("\n ");
		System.out.print("\nOrdenamiento por TimSort: ");

		Ordenamiento.ordenarTimSort(vec,2);

		for (int num : vec) {
			System.out.print(num + " ");
		}

	}
}
