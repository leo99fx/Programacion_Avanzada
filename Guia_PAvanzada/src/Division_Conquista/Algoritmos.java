package Division_Conquista;

public class Algoritmos {

	public static int binarySearch(int[] vec, int elem, int izq, int der) {

		if (der < izq) {
			return -1;
		}

		int medio = (der + izq) / 2;

		if (elem < vec[medio]) {
			return binarySearch(vec, elem, izq, medio - 1);
		} else if (vec[medio] < elem) {
			return binarySearch(vec, elem, medio + 1, der);
		}
		return medio;
	} // Complejidad T(n) = (log2 n)

	public static int binarySearch(int[] vec, int elem) {
		return binarySearch(vec, elem, 0, vec.length);

	}

	public static int calculoXN(int x, int n) {

		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		if ((n % 2) == 0) {
			return calculoXN(x, n / 2) * calculoXN(x, n / 2);
		} else {
			return x * calculoXN(x, n / 2) * calculoXN(x, n / 2);
		}

	} // COMPLEJIDAD O(log2 (n))

	public static int sumaVector(int[] vec) {

		return sumaVector(vec, 0, vec.length - 1);

	}

	public static int sumaVector(int[] vec, int izq, int der) {

		if (der == izq) {
			return vec[izq];
		}

		int medio = (der + izq) / 2;

		return sumaVector(vec, izq, medio) + sumaVector(vec, medio + 1, der);

	} // COMPLEJIDAD O(log2 (n))

}
