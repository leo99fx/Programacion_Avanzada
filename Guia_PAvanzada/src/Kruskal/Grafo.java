package Kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grafo {
    private List<Arista> aristas;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.aristas = new ArrayList<>();
    }

    public void agregarArista(int desde, int hasta, int costo) {
        aristas.add(new Arista(desde, hasta, costo));
    }

    public List<Arista> kruskal() {
        Collections.sort(aristas); // Ordenar las aristas por costo

        UnionFind uf = new UnionFind(numVertices);
        List<Arista> mst = new ArrayList<>();

        for (Arista arista : aristas) {
            int desdeRaiz = uf.encontrar(arista.desde);
            int hastaRaiz = uf.encontrar(arista.hasta);

            if (desdeRaiz != hastaRaiz) {
                mst.add(arista);
                uf.unir(desdeRaiz, hastaRaiz);
            }
        }

        return mst;
    }
}