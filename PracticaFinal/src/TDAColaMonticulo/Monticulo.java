package TDAColaMonticulo;

public class Monticulo {

	private int[] vec = null;

	public Monticulo(int[] x) {
		this.vec = x;
	}

	public void imprimir() {
		for (int i = 0; i < this.vec.length; i++) {
			System.out.printf("%s ", this.vec[i]);
		}
		System.out.println();
	}

	public void imprimir(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			System.out.printf("%s ", this.vec[i]);
		}
		System.out.println();
	}

	public void agregar(int x) {
		int[] aux = new int[this.vec.length + 1];
		int i = 0;
		for (i = 0; i < this.vec.length; i++) {
			aux[i] = this.vec[i];
		}

		aux[i] = x;

		int padre = i / 2;

		while (aux[padre] > aux[i]) {
			int aux2 = aux[padre];
			aux[padre] = aux[i];
			aux[i] = aux2;
			i = padre;
			padre = i / 2;
		}
		this.vec = aux;
	}

	public void sacar() {
		this.vec[0] = this.vec[this.vec.length - 1];
		int[] aux = new int[this.vec.length - 1];
		for (int i = 0; i < this.vec.length - 1; i++) {
			aux[i] = this.vec[i];
		}

		// Ordenar
		int i = 0;
		while (i < aux.length) {
			int hijoIzq = (2 * i) + 1;
			int hijoDer = (2 * i) + 2;
			int hijoMinimo = i;

			if (hijoIzq < aux.length && (hijoDer >= aux.length || aux[hijoIzq] < aux[hijoDer])) {
				hijoMinimo = hijoIzq;
			} else if (hijoDer < aux.length) {
				hijoMinimo = hijoDer;
			}

			if (aux[i] <= aux[hijoMinimo]) {
				break;
			}

			int temp = aux[i];
			aux[i] = aux[hijoMinimo];
			aux[hijoMinimo] = temp;
			i = hijoMinimo;
		}
		this.vec = aux;
	}

}
