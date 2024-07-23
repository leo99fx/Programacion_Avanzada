package Factorial;

public class Factorial {

	public static int factorial(int n) {
		int res = 1, ant = 1;

		for (int i = 0; i < n; i++) {
			res *= ant;
			ant += 1;
		}
		return res;
	}

	public static int factorialRec(int n) {
		if (n == 1) {
			return n;
		}

		return factorial(n - 1) * n;
	}

	public static void main(String[] args) {
		System.out.println(factorialRec(5));
	}

}
