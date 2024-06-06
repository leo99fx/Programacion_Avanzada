package Kruskal;

class UnionFind {
    private int[] padre;
    private int[] rango;

    public UnionFind(int n) {
        padre = new int[n];
        rango = new int[n];
        for (int i = 0; i < n; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    public int encontrar(int i) {
        if (padre[i] != i) {
            padre[i] = encontrar(padre[i]);
        }
        return padre[i];
    }

    public void unir(int i, int j) {
        int raizI = encontrar(i);
        int raizJ = encontrar(j);

        if (raizI != raizJ) {
            if (rango[raizI] > rango[raizJ]) {
                padre[raizJ] = raizI;
            } else if (rango[raizI] < rango[raizJ]) {
                padre[raizI] = raizJ;
            } else {
                padre[raizJ] = raizI;
                rango[raizI]++;
            }
        }
    }
}