package Monticulo;

import java.util.ArrayList;

public class MiMonticulo {

	private ArrayList<Integer> arrayMonticulo;

	public MiMonticulo() {

		this.arrayMonticulo = new ArrayList<>();
	}

	public boolean vacio() {
		return this.arrayMonticulo.isEmpty();
	}

	public void insertar(int elem) {

		arrayMonticulo.add(elem);

		int indexUlt = arrayMonticulo.size() - 1;
		int indexPadre = (arrayMonticulo.size() - 1) / 2;

		while (indexUlt > 0 && arrayMonticulo.get(indexPadre) > elem) {

			arrayMonticulo.set(indexUlt, arrayMonticulo.get(indexPadre));
			indexUlt = indexPadre;
			indexPadre = (indexPadre - 1) / 2;
		}

		arrayMonticulo.set(indexUlt, elem);

	}

	public void mostrar() {
		for (int elem : this.arrayMonticulo) {
			System.out.println(elem);
		}
	}

	public void eliminar() throws Exception {

		if (this.arrayMonticulo.isEmpty()) {
			throw new Exception("LISTA VACIA");
		}

		int raiz = arrayMonticulo.get(0); // obtengo el raiz

		int ultElem = arrayMonticulo.remove(arrayMonticulo.size() - 1); // guardo y borro el ultimo elemento

		arrayMonticulo.set(0, ultElem); // piso el raiz con el ultimo elemento

		// ahora ordenamos el arbol

		int hijoMenor;
		int hijoIzq, hijoDer;
		int indice = 0;

		raiz = arrayMonticulo.get(0);

		while (indice < arrayMonticulo.size() / 2) {

			hijoIzq = 2 * indice + 1;
			hijoDer = hijoIzq + 1;

			if (arrayMonticulo.get(hijoIzq) < arrayMonticulo.get(hijoDer)) {
				hijoMenor = hijoIzq;
			} else {
				hijoMenor = hijoDer;
			}

			if (raiz <= arrayMonticulo.get(hijoIzq)) {
				break; // llegue al final, break y salgo para no pisar valores
			}

			arrayMonticulo.set(indice, arrayMonticulo.get(hijoMenor)); // seteo en indice el hijo menor

			indice = hijoMenor; // mi nuevo indice ahora es el hijo menor para continuar ordenando
		}

		arrayMonticulo.set(indice, raiz); // una vez finalize, en mi ultimo indice pego el raiz viejo que va a ser
											// seguro un valor menor
	}

}
