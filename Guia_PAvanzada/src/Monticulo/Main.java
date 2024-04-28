package Monticulo;

public class Main {
	public static void main(String[] args) throws Exception {
		MiMonticulo monticulo = new MiMonticulo();
		monticulo.insertar(5);
		monticulo.insertar(7);
		monticulo.insertar(15);
		monticulo.insertar(14);
		monticulo.insertar(9);
		monticulo.insertar(18);
		monticulo.insertar(20);

		System.out.println("MONTICULO: ");
		monticulo.mostrar();

		System.out.println();

		System.out.println("Eliminando valor raiz: ");
		monticulo.eliminar();
		monticulo.mostrar();
	}
}
