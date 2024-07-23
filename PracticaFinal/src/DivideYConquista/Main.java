package DivideYConquista;

public class Main {

	public static void main(String[] args) {
		int vec[] = { 1, 2, 3, 49, 5, 6, 7, 8, 9, 10 };
		Algoritmos alg = new Algoritmos();
//		System.out.println(alg.binarySearch(vec, 19));

//		System.out.println(alg.potenciaX(2,8));

//		System.out.println(alg.sumaArray(vec)); // 55
//		System.out.println(alg.maximo(vec));

//		int[] vec2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//		System.out.println(alg.maximaSubCadena(vec2));
//		

		int N = 8; // Debe ser potencia de 2
		Complejo[] x = new Complejo[N];
		for (int i = 0; i < N; i++) {
			x[i] = new Complejo(i, 0);
		}

		Complejo[] y = null;
		try {
			y = alg.transformadaRapida(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("FFT Result:");
		for (int i = 0; i < N; i++) {
			System.out.println(y[i]);
		}

	}

}
