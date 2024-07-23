package Pedregal;

public class Pedregal {
	int[][] pedregal;
	int tamFilaCasa;
	int tamColCasa;

	Pedregal(int[][] pedregal, int tamFilaCasa, int tamColCasa) {
		this.pedregal = pedregal;
		this.tamFilaCasa = tamFilaCasa;
		this.tamColCasa = tamColCasa;
	}

	public int[][] getPedregal() {
		return pedregal;
	}

	public int getTamFilaCasa() {
		return tamFilaCasa;
	}

	public int getTamColCasa() {
		return tamColCasa;
	}

	public void imprimir() {
		for (int i = 0; i < this.pedregal.length; i++) {
			for (int j = 0; j < this.pedregal[i].length; j++) {
				System.out.print(this.pedregal[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(
				"Tamaño en filas y columnas de la casa Filas x Columnas:" + this.tamFilaCasa + "x" + this.tamColCasa);
	}

	public void procesar() {

		int fila = 0, col = 0;
		boolean espacioEncontrado = false;
		boolean espacioLibre = true;

		for (int i = 0; i < this.pedregal.length - this.tamFilaCasa; i++) {
			for (int j = 0; j < this.pedregal.length - this.tamColCasa; j++) {
				espacioLibre = true;
				for (int k = 0; k < this.tamFilaCasa; k++) {
					for (int l = 0; l < this.tamColCasa; l++) {
						if (this.pedregal[i + k][j + l] != 0) {
							espacioLibre = false;
							break;
						}

					}
					if (!espacioLibre) {
						break;
					}
				}
				if (espacioLibre) {
					fila = i;
					col = j;
					espacioEncontrado = true;
					break;
				}
			}
			if (espacioEncontrado)
				break;
		}

		Archivo a = new Archivo();
		if (espacioEncontrado) {
			a.grabarArchivo("Si", fila, col, 'N');
		} else {
			a.grabarArchivo();
		}

	}

}
