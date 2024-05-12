package Prog_Dinamica;

import java.util.HashSet;
import java.util.Set;

public class Varilla {

	public static void main(String[] args) {

		int varilla = 7; // va de 0 a 7
		int[] cortes = { 1, 3, 4, 5 };

		corteVarilla(varilla, cortes);

	}

	public static void corteVarilla(int varilla, int[] cortes) {
		// restricciones
		if (varilla < 2 || varilla >= 1000000 || cortes.length < 1 || cortes.length > 100) {
			return;
		}
		for (int i : cortes) {
			if (i < 1) {
				return;
			}
		}
		Set<Integer> set = new HashSet<>(); // verifico duplicados
		for (int numero : cortes) {
			if (set.contains(numero)) {
				return;
			}
			set.add(numero);
		}
		
		int cantCortes = cortes.length;
		
		
	}

}
