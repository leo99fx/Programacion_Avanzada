package DivideYConquista;

public class Algoritmos {

	public int binarySearch(int[] vec, int x) {
		return binarySearch(vec, 0, vec.length, x);
	}

	private int binarySearch(int[] vec, int ini, int fin, int x) {

		if (fin < ini) {
			return -1;
		}

		int medio = (fin + ini) / 2;

		if (x < vec[medio]) {
			return binarySearch(vec, ini, medio - 1, x);
		} else if (x > vec[medio]) {
			return binarySearch(vec, medio + 1, fin, x);
		}

		return medio;
	}

	public int potenciaX(int x, int n) {
		if (n == 1) {
			return x;
		}

		if (n == 0) {
			return 1;
		}

		if (n % 2 == 0) {
			return potenciaX(x, n / 2) * potenciaX(x, n / 2);
		} else
			return x * potenciaX(x, n / 2) * potenciaX(x, n / 2);
	}

	public int sumaArray(int vec[]) {
		return sumaArray(vec, 0, vec.length - 1);
	}

	public int sumaArray(int[] vec, int ini, int fin) {

		if (ini == fin) {
			return vec[ini];
		}
		int mitad = (ini + fin) / 2;
		return sumaArray(vec, ini, mitad) + sumaArray(vec, mitad + 1, fin);

	}

	public int maximo(int[] vec) {
		if (vec == null)
			return -1;

		int max = vec[0];

		return maximo(vec, max, 0, vec.length - 1);

	}

	private int maximo(int[] vec, int max, int ini, int fin) {

		if (ini > fin)
			return max;

		if (max < vec[ini]) {
			max = vec[ini];
		}

		return maximo(vec, max, ini + 1, fin);
	}

	public int maximaSubCadena(int[] vec) {
		return maximaSubCadena(vec, 0, vec.length - 1);
	}

	private int maximaSubCadena(int[] vec, int ini, int fin) {

		if (ini == fin) {
			return vec[ini];
		}
		int mitad = (ini + fin) / 2;
		maximaSubCadena(vec, ini, mitad);
		maximaSubCadena(vec, mitad + 1, fin);

		int auxSuma = 0;
		int maxIzqSuma = Integer.MIN_VALUE;
		for (int i = mitad; i >= ini; i--) {
			auxSuma += vec[i];
			if (auxSuma > maxIzqSuma) {
				maxIzqSuma = auxSuma;
			}
		}

		auxSuma = 0;
		int maxDerSuma = Integer.MIN_VALUE;
		for (int i = mitad + 1; i < fin; i++) {
			auxSuma += vec[i];
			if (auxSuma > maxDerSuma) {
				maxDerSuma = auxSuma;
			}
		}

		int maxIntermedio = maxDerSuma + maxIzqSuma;

		return Math.max(Math.max(maxDerSuma, maxIntermedio), maxIzqSuma);
	}

	public Complejo[] transformadaRapida(Complejo[] x) throws Exception {
		int N = x.length;
		if (N == 1) {
			return new Complejo[] { x[0] };
		}

		if (N % 2 != 0) {
			throw new Exception("N IMPAR");
		}

		Complejo[] par = new Complejo[N / 2];
		Complejo[] impar = new Complejo[N / 2];

		for (int i = 0; i < N / 2; i++) {
			par[i] = x[2 * i];
		}
		transformadaRapida(par);

		for (int i = 0; i < N / 2; i++) {
			impar[i] = x[2 * i + 1];
		}

		transformadaRapida(impar);

		// combino
		Complejo[] res = new Complejo[N];
		for (int i = 0; i < N / 2; i++) {
			double exp = -2 * Math.PI * i / N;
			Complejo e = new Complejo(Math.cos(exp), Math.sin(exp));
			res[i] = par[i].suma(e.multiplicar(impar[i]));
			res[i + N / 2] = par[i].resta(e.multiplicar(impar[i]));

		}
		return res;
	}
}
