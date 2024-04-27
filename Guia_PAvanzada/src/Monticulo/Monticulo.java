package Monticulo;


public class Monticulo {
    private int[] arregloMonticulo;
    private int tamanoMaximo;
    private int tamanoActual;

    public Monticulo(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        this.tamanoActual = 0;
        this.arregloMonticulo = new int[tamanoMaximo];
    }

    // Método para verificar si el montículo está vacío
    public boolean estaVacio() {
        return tamanoActual == 0;
    }

    // Método para insertar un elemento en el montículo
    public boolean insertar(int clave) {
        if (tamanoActual == tamanoMaximo) {
            return false; // El montículo está lleno
        }
        arregloMonticulo[tamanoActual] = clave; // Insertar el elemento al final del montículo
        hacerFlotar(tamanoActual++); // Mover el elemento hacia arriba para mantener la propiedad del montículo
        return true;
    }

    // Método para eliminar y devolver el elemento máximo del montículo
    public int eliminar() {
        int raiz = arregloMonticulo[0]; // El elemento máximo es la raíz del montículo
        arregloMonticulo[0] = arregloMonticulo[--tamanoActual]; // Reemplazar la raíz con el último elemento
        hacerHundir(0); // Mover el elemento hacia abajo para mantener la propiedad del montículo
        return raiz; // Devolver el elemento máximo
    }

    // Método para mantener la propiedad del montículo moviendo un elemento hacia arriba
    private void hacerFlotar(int indice) {
        int indicePadre = (indice - 1) / 2;
        int fondo = arregloMonticulo[indice]; // Guardar el elemento a mover
        while (indice > 0 && arregloMonticulo[indicePadre] < fondo) {
            arregloMonticulo[indice] = arregloMonticulo[indicePadre]; // Mover el padre hacia abajo
            indice = indicePadre;
            indicePadre = (indicePadre - 1) / 2;
        }
        arregloMonticulo[indice] = fondo; // Colocar el elemento guardado en su posición correcta
    }

    // Método para mantener la propiedad del montículo moviendo un elemento hacia abajo
    private void hacerHundir(int indice) {
        int hijoMayor;
        int tope = arregloMonticulo[indice]; // Guardar el elemento a mover hacia abajo
        while (indice < tamanoActual / 2) {
            int hijoIzquierdo = 2 * indice + 1;
            int hijoDerecho = hijoIzquierdo + 1;
            if (hijoDerecho < tamanoActual && arregloMonticulo[hijoIzquierdo] < arregloMonticulo[hijoDerecho]) {
                hijoMayor = hijoDerecho; // El hijo derecho es mayor
            } else {
                hijoMayor = hijoIzquierdo; // El hijo izquierdo es mayor o no hay hijo derecho
            }
            if (tope >= arregloMonticulo[hijoMayor]) {
                break; // La posición actual es correcta
            }
            arregloMonticulo[indice] = arregloMonticulo[hijoMayor]; // Mover el hijo mayor hacia arriba
            indice = hijoMayor;
        }
        arregloMonticulo[indice] = tope; // Colocar el elemento guardado en su posición correcta
    }

    // Método para mostrar el contenido del montículo
    public void mostrarMonticulo() {
        System.out.print("Arreglo del montículo: ");
        for (int i = 0; i < tamanoActual; i++) {
            System.out.print(arregloMonticulo[i] + " ");
        }
        System.out.println();
    }
}
