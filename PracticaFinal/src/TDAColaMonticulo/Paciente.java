package TDAColaMonticulo;

public class Paciente {

	private String nombre;
	private Afeccion afeccion;

	public Paciente(String nombre, Afeccion afeccion) {
		this.nombre = nombre;
		this.afeccion = afeccion;
	}

	public String getNombre() {
		return nombre;
	}

	public Afeccion getAfeccion() {
		return afeccion;
	}

	@Override
	public String toString() {
		return "Paciente: " + nombre + ", Afección: " + afeccion;
	}
}
