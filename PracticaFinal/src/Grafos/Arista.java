package Grafos;

public class Arista implements Comparable<Arista> {

	private int nodoInicial;
	private int nodoFinal;
	private int costo;

	public Arista(int nodoInicial, int nodoFinal, int costo) {
		this.nodoInicial = nodoInicial;
		this.nodoFinal = nodoFinal;
		this.costo = costo;
	}

	public int getNodoInicial() {
		return nodoInicial;
	}

	public int getNodoFinal() {
		return nodoFinal;
	}

	public int getCosto() {
		return costo;
	}

	public int compareTo(Arista otra) {
		return Integer.compare(this.costo, otra.costo);
	}
}
