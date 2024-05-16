package Prog_Dinamica;

public class ladronDeCasas {

	public static int ladronDeCasas(int[] vec) {

		int anterior = vec[1];
		int anteriorAnterior = vec[0];

		int tam = vec.length;
		int aux;

		for (int i = 2; i < tam; i++) {

			if (vec[i] + anteriorAnterior > anterior) {
				aux = anterior;
				anterior = anteriorAnterior + vec[i];
				anteriorAnterior = aux;
			} else {
				anteriorAnterior = anterior;
			}

		}

		return anterior > anteriorAnterior ? anterior : anteriorAnterior;
	}
}
