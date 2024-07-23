package TDAColaMonticulo;

public class Main {

	public static void main(String[] args) {
		int[] vec = { 5, 7, 15, 14, 9, 18, 20 };

		Monticulo monticulo = new Monticulo(vec);
		System.out.println("Monticulo antes de agregar valor");
		monticulo.imprimir();
		monticulo.agregar(6);
		System.out.println("Monticulo despues de agregar valor");
		monticulo.imprimir();
		System.out.println();
		System.out.println("Saco el primero");
		monticulo = new Monticulo(vec);
		System.out.println("MONTICULO ORIGINAL");
		monticulo.imprimir();
		monticulo.sacar();
		System.out.println("MONTICULO POST");
		monticulo.imprimir();
//
//		Paciente[] pacientesIniciales = {};
//		Hospital hospital = new Hospital(pacientesIniciales);
//
//		Paciente paciente1 = new Paciente("Juan Perez", new Resucitar("Paro cardiaco"));
//		Paciente paciente2 = new Paciente("Ana Lopez", new SinUrgencia("Gripe"));
//		Paciente paciente3 = new Paciente("Carlos Gomez", new Emergencia("Infarto"));
//		Paciente paciente4 = new Paciente("Maria Rodriguez", new Urgencia("Fractura"));
//		Paciente paciente5 = new Paciente("Luis Fernandez", new PocaUrgencia("Corte leve"));
//
//		hospital.agregar(paciente1);
//		hospital.agregar(paciente2);
//		hospital.agregar(paciente3);
//		hospital.agregar(paciente4);
//		hospital.agregar(paciente5);
//
//		System.out.println("Paciente de mayor prioridad: " + hospital.obtenerMinimo());
//
//		while (!hospital.estaVacio()) {
//			System.out.println("Atendiendo al paciente: " + hospital.obtenerMinimo());
//			hospital.sacar();
//		}
	}

}
