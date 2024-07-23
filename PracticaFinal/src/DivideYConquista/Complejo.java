package DivideYConquista;

public class Complejo {

	private double real;
	private double imag;

	public Complejo(double d, double e) {
		this.real = d;
		this.imag = e;
	}

	public Complejo suma(Complejo b) {
		return new Complejo(this.real + b.real, this.imag + b.imag);
	}

	public Complejo resta(Complejo b) {
		return new Complejo(this.real - b.real, this.imag - b.imag);
	}

	public Complejo escalar(int a) {
		return new Complejo(this.real * a, this.imag * a);
	}

	public Complejo multiplicar(Complejo b) {
		return new Complejo(this.real * b.real - this.imag * b.imag, this.real * b.imag + this.imag * b.real);
	}

	public Complejo conjugar() {
		return new Complejo(this.real, -this.imag);
	}

	@Override
	public String toString() {
		if (imag == 0)
			return real + "";
		if (real == 0)
			return imag + "i";
		if (imag < 0)
			return real + " - " + (-imag) + "i";
		return real + " + " + imag + "i";
	}
}
