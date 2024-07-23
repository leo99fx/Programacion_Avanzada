package TDAColaMonticulo;

public class Hospital {

	private Paciente[] vec = null;

	public Hospital(Paciente[] x) {
		this.vec = x;
	}

	public void agregar(Paciente x) {
		Paciente[] aux = new Paciente[this.vec.length + 1];
		int i = 0;
		for (i = 0; i < this.vec.length; i++) {
			aux[i] = this.vec[i];
		}

		aux[i] = x;

		int padre = i / 2;

		while (aux[padre].getAfeccion().getNivelUrgencia() > aux[i].getAfeccion().getNivelUrgencia()) {
			Paciente aux2 = aux[padre];
			aux[padre] = aux[i];
			aux[i] = aux2;
			i = padre;
			padre = i / 2;
		}
		this.vec = aux;
	}

	public void sacar() {
		this.vec[0] = this.vec[this.vec.length - 1];
		Paciente[] aux = new Paciente[this.vec.length - 1];
		for (int i = 0; i < this.vec.length - 1; i++) {
			aux[i] = this.vec[i];
		}

		// Ordenar
		int i = 0;
		while (i < aux.length) {
			int hijoIzq = (2 * i) + 1;
			int hijoDer = (2 * i) + 2;
			int hijoMinimo = i;

			if (hijoIzq < aux.length && (hijoDer >= aux.length
					|| aux[hijoIzq].getAfeccion().getNivelUrgencia() < aux[hijoDer].getAfeccion().getNivelUrgencia())) {
				hijoMinimo = hijoIzq;
			} else if (hijoDer < aux.length) {
				hijoMinimo = hijoDer;
			}

			if (aux[i].getAfeccion().getNivelUrgencia() <= aux[hijoMinimo].getAfeccion().getNivelUrgencia()) {
				break;
			}

			Paciente temp = aux[i];
			aux[i] = aux[hijoMinimo];
			aux[hijoMinimo] = temp;
			i = hijoMinimo;
		}
		this.vec = aux;
	}

	public boolean estaVacio() {
		return this.vec.length == 0;
	}

	public Paciente obtenerMinimo() {
		if (this.vec.length == 0) {
			throw new IllegalStateException("El hospital está vacío");
		}
		return this.vec[0];
	}

}
