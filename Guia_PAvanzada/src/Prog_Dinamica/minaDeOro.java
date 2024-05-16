package Prog_Dinamica;

public class minaDeOro {

	public static int minaDeOro(int[][] mina) {
		int res = 0;

		int fila = mina.length;
		int columna = mina[0].length;

		for (int i = 1; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < columna) {

					int mayorIzq = mina[i - 1][j] > mina[i - 1][j - 1] ? mina[i - 1][j] : mina[i - 1][j - 1];
					int mayorDer = mina[i - 1][j] > mina[i - 1][j + 1] ? mina[i - 1][j] : mina[i - 1][j + 1];

					int mayor = mina[i][j] + (mayorIzq > mayorDer ? mayorIzq : mayorDer);

					mina[i][j] = mayor;

				} else if (i - 1 >= 0 && j == 0) {

					int mayor = mina[i][j]
							+ (mina[i - 1][j] > mina[i - 1][j + 1] ? mina[i - 1][j] : mina[i - 1][j + 1]);

					mina[i][j] = mayor;
				} else if (i - 1 >= 0 && j == columna - 1) {
					int mayor = mina[i][j]
							+ (mina[i - 1][j] > mina[i - 1][j - 1] ? mina[i - 1][j] : mina[i - 1][j - 1]);
					mina[i][j] = mayor;
				}
			}
		}

		// encuentro mayor de la ultima fila
		res = mina[fila - 1][0];
		for (int i = 1; i < columna; i++) {
			if (mina[fila - 1][i] > res) {
				res = mina[fila - 1][i];
			}
		}

		return res;
	}
}
