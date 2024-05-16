package Prog_Dinamica;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	private static int fibonacci(int n, Map<Integer, Integer> mem) {
		int key = n;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		if (n < 2) {
			mem.put(key, n);
		} else {
			mem.put(key, fibonacci(n - 1, mem) + fibonacci(n - 2, mem));
		}
		return mem.get(key);
	} // top down

	public static int fibonacci(int n) {
		return fibonacci(n, new HashMap<Integer, Integer>());

	}

	public static int fibonacci_BottonUp(int n) {
		if (n < 2) {
			return n;
		}
		int anteriorDelAnterior = 0;
		int anterior = 1;
		int actual = 1;

		for (int i = 2; i <= n; i++) {
			actual = anteriorDelAnterior + anterior;
			anteriorDelAnterior = anterior;
			anterior = actual;
		}
		return actual;
	}

}
