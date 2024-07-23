package TDAColaMonticulo;

public abstract class Afeccion implements Comparable<Afeccion> {
	private String nombre;
	private int nivelUrgencia;

	protected Afeccion(String nombre, int nivelUrgencia) {
		this.nombre = nombre;
		this.nivelUrgencia = nivelUrgencia;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNivelUrgencia() {
		return nivelUrgencia;
	}

	@Override
	public String toString() {
		return nombre + " (Nivel de urgencia: " + nivelUrgencia + ")";
	}

	@Override
	public int compareTo(Afeccion otraAfeccion) {
		return Integer.compare(this.nivelUrgencia, otraAfeccion.getNivelUrgencia());
	}
}

class Resucitar extends Afeccion {
	public Resucitar(String nombre) {
		super(nombre, 1);
	}
}

class Emergencia extends Afeccion {
	public Emergencia(String nombre) {
		super(nombre, 2);
	}
}

class Urgencia extends Afeccion {
	public Urgencia(String nombre) {
		super(nombre, 3);
	}
}

class PocaUrgencia extends Afeccion {
	public PocaUrgencia(String nombre) {
		super(nombre, 4);
	}
}

class SinUrgencia extends Afeccion {
	public SinUrgencia(String nombre) {
		super(nombre, 5);
	}
}