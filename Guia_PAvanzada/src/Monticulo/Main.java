package Monticulo;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(25);

        heap.displayHeap();

        System.out.println("Removing max value: " + heap.remove());
        heap.displayHeap();
    }
}
