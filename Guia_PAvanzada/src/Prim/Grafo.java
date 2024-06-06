package Prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int[][] matriz) {
        this.matrizAdyacencia = matriz;
        this.numVertices = matriz.length;
    }

    public List<Arista> prim(int nodoInicio) {
        boolean[] visitado = new boolean[numVertices];
        List<Integer> Vmst = new ArrayList<>();  // Lista de nodos visitados
        List<Integer> VG = new ArrayList<>();    // Lista de nodos no visitados
        List<Arista> mst = new ArrayList<>();    // Lista de aristas del MST
        PriorityQueue<Arista> pq = new PriorityQueue<>();  // Cola de prioridad para las aristas

        // Iniciar con el nodo de inicio
        visitado[nodoInicio] = true;
        Vmst.add(nodoInicio);
        
        // Agregar las aristas del nodo inicial a la cola de prioridad
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[nodoInicio][i] != 0) {
                pq.add(new Arista(nodoInicio, i, matrizAdyacencia[nodoInicio][i]));
            }
        }

        // Mientras haya aristas en la cola de prioridad
        while (!pq.isEmpty()) {
            Arista arista = pq.poll();  // Obtener la arista con el menor costo
            System.out.println(arista);
            // Si el nodo destino de la arista no ha sido visitado
            if (!visitado[arista.hasta]) {
                visitado[arista.hasta] = true;
                mst.add(arista);  // Agregar la arista al MST
                Vmst.add(arista.hasta);

                // Agregar las nuevas aristas del nodo recién visitado a la cola de prioridad
                for (int i = 0; i < numVertices; i++) {
                    if (!visitado[i] && matrizAdyacencia[arista.hasta][i] != 0) {
                        pq.add(new Arista(arista.hasta, i, matrizAdyacencia[arista.hasta][i]));
                    }
                }
            }
        }

        // Agregar los nodos no visitados a la lista VG
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                VG.add(i);
            }
        }

        // Imprimir las listas de nodos visitados y no visitados
        System.out.println("Vmst (Visitados): " + Vmst);
        System.out.println("VG (No Visitados): " + VG);

        return mst;
    }
}