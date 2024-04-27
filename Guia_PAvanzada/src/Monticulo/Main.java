package Monticulo;

public class Main {
    public static void main(String[] args) {
        Monticulo monticulo = new Monticulo(10);
        monticulo.insertar(10);
        monticulo.insertar(20);
        monticulo.insertar(15);
        monticulo.insertar(30);
        monticulo.insertar(25);

        monticulo.mostrarMonticulo();

        System.out.println("Eliminando el valor máximo: " + monticulo.eliminar());
        monticulo.mostrarMonticulo();
    }
}
