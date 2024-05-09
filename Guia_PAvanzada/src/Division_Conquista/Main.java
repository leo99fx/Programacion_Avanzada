package Division_Conquista;

public class Main {

	public static void main(String[] args) {

// ===========================================================================
		// *BUSQUEDA BINARIA*
//		int[] vec = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 10, 11, 12, 15 };
//
//		int elem = Algoritmos.binarySearch(vec, 13);
//
//		System.out.println("Encontrar valor 12: " + elem);

// ===========================================================================
		// *EJERCICIO CLASE*
//		Dado un número real X y un número entero n >= 0, calcular X^n
//		mediante división y conquista.

//		int n = 9;
//		int x = 2;
//		System.out.println("X: " + x + " N: " + n + " \nResultado: "+Algoritmos.calculoXN(x, n));

// ===========================================================================	

//		Dado un array arr de enteros, realizar un algoritmo que por medio de
//		División y Conquista sume todos los elementos del mismo.

		int[] vec = { 5, 10, 15, 20, 25, 30 };

		System.out.println("Vector: ");
		for (int i = 0; i < vec.length; i++) {
			System.out.println(vec[i]);
		}

		int suma = 0; // suma esperada solo a modo verificacion propia
		for (int num : vec) {
			suma += num;
		}
		System.out.println("Suma esperada del vector: " + suma);

		System.out.println("Resultado de la suma del vector: " + Algoritmos.sumaVector(vec));

// ===========================================================================	

	}

}
