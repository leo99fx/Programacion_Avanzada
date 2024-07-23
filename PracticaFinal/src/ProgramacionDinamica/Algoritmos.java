package ProgramacionDinamica;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

public class Algoritmos {

	// fibonacci top down
	public int fibonacci(int n) {

		return fibonacci(n, new HashMap<Integer, Integer>());
	}

	public int fibonacci(int n, Map<Integer, Integer> m) {

		int key = n;

		if (m.containsKey(key)) {
			return m.get(key);
		}

		if (n < 2) {
			m.put(key, n);
		} else {
			m.put(key, fibonacci(n - 1, m) + fibonacci(n - 2, m));
		}

		return m.get(key);
	}

	// fibonacci bottonup
	public int fibonacciBottonUp(int n) {
		if (n < 2) {
			return n;
		}
		int anterior = 1;
		int anteriorAnterior = 0;

		for (int i = 2; i < n; i++) {
			int aux = anterior + 1;
			anterior = anteriorAnterior + anterior;
			anteriorAnterior = aux;
		}
		return anterior;
	}

	public void imprimirMatriz(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("\t" + mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int minaOro(int[][] mat) {

		int fila = mat.length;
		int columna = mat[0].length;
		for (int i = 1; i < fila; i++) {
			for (int j = 0; j < columna; j++) {

				if (j + 1 < columna && j - 1 >= 0) {
					int mayorDer = Math.max(mat[i - 1][j + 1], (mat[i - 1][j]));
					int mayorIzq = Math.max(mat[i - 1][j - 1], (mat[i - 1][j]));
					int mayor = Math.max(mayorDer, mayorIzq);
					mat[i][j] = mat[i][j] + mayor;
				}

				if (j == 0) {
					int mayor = Math.max(mat[i - 1][j + 1], (mat[i - 1][j]));
					mat[i][j] = mat[i][j] + mayor;
				}

				if (j == columna - 1) {
					int mayor = Math.max(mat[i - 1][j - 1], (mat[i - 1][j]));
					mat[i][j] = mat[i][j] + mayor;
				}

			}
		}

		int max = Integer.MIN_VALUE;
		for (int k = 0; k < mat[fila - 1].length; k++) {
			if (mat[fila - 1][k] > max) {
				max = mat[fila - 1][k];
			}
		}
		return max;
	}

	public void distanciaMinimaDeEdicion(String p1, String p2) {

		int tamP1 = p1.length();
		int tamP2 = p2.length();
		int[][] mat = new int[tamP1 + 1][tamP2 + 1];

		for (int i = 0; i < tamP1; i++) {
			mat[0][i] = i;
		}

		for (int i = 0; i < tamP2; i++) {
			mat[i][0] = i;
		}

		for (int i = 1; i <= tamP1; i++) {
			for (int j = 1; j <= tamP2; j++) {
				if (p1.charAt(i - 1) == p2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1];
				} else {
					mat[i][j] = 1 + Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]);
				}
			}
		}

		System.out.println("Minimo de edicion: " + mat[tamP1][tamP2]);
	}

	public void sumaSubrectanculos(int[][] mat) {
		int fila = mat.length;
		int col = mat[0].length;

		int[][] res = new int[fila][col];
		res[0][0] = mat[0][0];

		for (int i = 1; i < col; i++) {
			res[0][i] = res[0][i - 1] + mat[0][i];

		}
		for (int i = 1; i < fila; i++) {
			res[i][0] = res[i - 1][0] + mat[i][0];

		}

		for (int i = 1; i < fila; i++) {
			for (int j = 1; j < col; j++) {
				// Por cada posicion de la matriz "i" y "j"
				// debo recorrer de forma inversa y sumar los anteriores
				// acumulando el res en mi pos actual
				res[i][j] = res[i - 1][j] + res[i][j - 1] + mat[i][j] - res[i - 1][j - 1];

			}
		}
		imprimirMatriz(res);
		maximoSubrectangulo(res);
	}

	public void maximoSubrectangulo(int[][] mat) {

		int fila = mat.length;
		int col = mat[0].length;

		int max = Integer.MIN_VALUE;
		int filaMaxSuperior = 0;
		int filaMaxInferior = 0;
		int colMaxIzq = 0;
		int colMaxDer = 0;
		int sumatoria = 0;

		for (int i = 1; i < fila; i++) {
			for (int j = 1; j < col; j++) {

				for (int f = i; f < fila; f++) {
					for (int c = j; c < col; c++) {
						sumatoria = mat[f][c] - mat[f][j - 1] - mat[i - 1][c] + mat[i - 1][j - 1];
						if (sumatoria > max) {
							max = sumatoria;
							filaMaxSuperior = i;
							filaMaxInferior = f;
							colMaxIzq = j;
							colMaxDer = c;
						}
					}
				}

			}
		}
		System.out.println("Maximo subrectangulo, sumatoria: " + sumatoria);
		System.out.println("Fila maxima superior: " + filaMaxSuperior);
		System.out.println("Fila maxima inferior : " + filaMaxInferior);
		System.out.println("Columna maxima superior: " + colMaxIzq);
		System.out.println("Columna maxima inferior: " + colMaxDer);

	}

	public int ladronDeCasas(int[] vec) {
		int tam = vec.length;

		if (tam < 2) {
			return vec[0];
		}

		int anteriorAnterior = vec[0];
		int anterior = vec[1];

		for (int i = 2; i < tam; i++) {

			if ((vec[i] + anteriorAnterior) > anterior) {
				int aux = anterior;
				anterior = vec[i] + anteriorAnterior;
				anteriorAnterior = aux;
			} else {
				anteriorAnterior = anterior;
			}
		}

		return anterior > anteriorAnterior ? anterior : anteriorAnterior;
	}

	// problema de la mochila top down
	public int mochila(int[] objCosto, int[] objPeso, int pesoDisponible) {

		int dinero = 0;
		int nivel = 0;
		HashMap<SimpleEntry<Integer, Integer>, Integer> mapa = new HashMap<>();
		return mochila(objCosto, objPeso, pesoDisponible, nivel, dinero, mapa);
	}

	private int mochila(int[] objCosto, int[] objPeso, int pesoDisponible, int nivel, int dinero,
			HashMap<SimpleEntry<Integer, Integer>, Integer> mapa) {

		SimpleEntry<Integer, Integer> key = new SimpleEntry<>(nivel, pesoDisponible);

		if (mapa.containsKey(key)) {
			return mapa.get(key);
		}

		if (nivel == objPeso.length || pesoDisponible == 0) {
			mapa.put(key, 0);
		} else {
			if (pesoDisponible < objPeso[nivel]) {
				dinero = mochila(objCosto, objPeso, pesoDisponible, nivel + 1, dinero, mapa);
			} else {
				dinero = Integer.max(mochila(objCosto, objPeso, pesoDisponible, nivel + 1, dinero, mapa),
						objCosto[nivel]
								+ mochila(objCosto, objPeso, pesoDisponible - objPeso[nivel], nivel + 1, dinero, mapa));
			}
		}

		mapa.put(key, dinero);

		return dinero;
	}

	// problema de la mochilla botton up
	public int mochilaBottonUp(int[] objCosto, int[] objPeso, int pesoDisponible) {
		int[][] mochila = new int[objPeso.length][pesoDisponible];

		int pesoAux = pesoDisponible;
		int dineroMax = 0;
		for (int i = 0; i < objCosto.length; i++) {
			for (int j = 0; j < objPeso.length; j++) {
				if (pesoAux > 0 && (pesoAux - objPeso[j]) >= 0) {
					pesoAux -= objPeso[j];
					mochila[j][j] += objCosto[j];

					if (mochila[i][j] > dineroMax) {
						dineroMax = mochila[i][j];
					}
				}
			}
			pesoAux = pesoDisponible;
		}
		return dineroMax;
	}

	// ejercicio de varilla
	public int corteVarilla(int largoVarilla, int[] cortes) {

		int[] cortesExt = new int[cortes.length + 2];
		cortesExt[0] = 0;
		cortesExt[cortesExt.length - 1] = largoVarilla;

		System.arraycopy(cortes, 0, cortesExt, 1, cortes.length);

		HashMap<SimpleEntry<Integer, Integer>, Integer> mapaDeCortes = new HashMap<>();

		return corteVarilla(cortesExt, 0, cortesExt.length - 1, mapaDeCortes);
	}

	private int corteVarilla(int[] cortes, int izq, int der,
			HashMap<SimpleEntry<Integer, Integer>, Integer> mapaDeCortes) {

		SimpleEntry<Integer, Integer> key = new SimpleEntry<>(izq, der);

		if (der - izq <= 1) {
			return 0;
		}

		if (mapaDeCortes.containsKey(key)) {
			return mapaDeCortes.get(key);
		}

		int costoMin = Integer.MAX_VALUE;

		for (int i = izq + 1; i < der; i++) {
			int costo = cortes[der] - cortes[izq] + corteVarilla(cortes, izq, i, mapaDeCortes)
					+ corteVarilla(cortes, i, der, mapaDeCortes);

			if (costo < costoMin) {
				costoMin = costo;
			}
		}

		mapaDeCortes.put(key, costoMin);

		return costoMin;
	}

}
