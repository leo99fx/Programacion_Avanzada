package Ejercicio_10;

public class Factorial {

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int factorialSinRec(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 15;

		long startTimeRec = System.currentTimeMillis();
		System.out.println(factorial(n));
		long endTimeRec = System.currentTimeMillis();
		long elapsedTimeRec = endTimeRec - startTimeRec;
		System.out.println("Tiempo con recursividad: " + elapsedTimeRec + " milisegundos");

		long startTimeSinRec = System.currentTimeMillis();
		System.out.println(factorialSinRec(n));
		long endTimeSinRec = System.currentTimeMillis();
		long elapsedTimeSinRec = endTimeSinRec - startTimeSinRec;
		System.out.println("Tiempo sin recursividad: " + elapsedTimeSinRec + " milisegundos");
	}
}
