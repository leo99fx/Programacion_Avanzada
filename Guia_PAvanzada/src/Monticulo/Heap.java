package Monticulo;

public class Heap {
    private int[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new int[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Método para insertar un elemento en el montículo
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false; // El montículo está lleno
        }
        heapArray[currentSize] = key; // Insertar el elemento al final del montículo
        trickleUp(currentSize++); // Mover el elemento hacia arriba para mantener la propiedad del montículo
        return true;
    }

    // Método para eliminar y devolver el elemento máximo del montículo
    public int remove() {
        int root = heapArray[0]; // El elemento máximo es la raíz del montículo
        heapArray[0] = heapArray[--currentSize]; // Reemplazar la raíz con el último elemento
        trickleDown(0); // Mover el elemento hacia abajo para mantener la propiedad del montículo
        return root; // Devolver el elemento máximo
    }

    // Método para mantener la propiedad del montículo moviendo un elemento hacia arriba
    private void trickleUp(int index) {
        int parentIndex = (index - 1) / 2;
        int bottom = heapArray[index]; // Guardar el elemento a mover
        while (index > 0 && heapArray[parentIndex] < bottom) {
            heapArray[index] = heapArray[parentIndex]; // Mover el padre hacia abajo
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom; // Colocar el elemento guardado en su posición correcta
    }

    // Método para mantener la propiedad del montículo moviendo un elemento hacia abajo
    private void trickleDown(int index) {
        int largerChild;
        int top = heapArray[index]; // Guardar el elemento a mover hacia abajo
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild] < heapArray[rightChild]) {
                largerChild = rightChild; // El hijo derecho es mayor
            } else {
                largerChild = leftChild; // El hijo izquierdo es mayor o no hay hijo derecho
            }
            if (top >= heapArray[largerChild]) {
                break; // La posición actual es correcta
            }
            heapArray[index] = heapArray[largerChild]; // Mover el hijo mayor hacia arriba
            index = largerChild;
        }
        heapArray[index] = top; // Colocar el elemento guardado en su posición correcta
    }

    // Método para mostrar el contenido del montículo
    public void displayHeap() {
        System.out.print("Heap array: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
}

