package Ordenamiento;

public class Ordenamiento {

	public static void main(String[] args) {

		int[] vec = { 99, 156485, 1258, 11, 22, 38, 1, 7, 2, 3 };

		for (int num : vec) {
			System.out.print(num + " ");
		}

		System.out.print("\nOrdenamiento por Shell: ");
		OrdenamientoShell(vec);
		System.out.print("\n");
		for (int num : vec) {
			System.out.print(num + " ");
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

}
