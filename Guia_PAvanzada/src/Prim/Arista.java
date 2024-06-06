package Prim;

class Arista implements Comparable<Arista> {
    int desde, hasta, costo;

    public Arista(int desde, int hasta, int costo) {
        this.desde = desde;
        this.hasta = hasta;
        this.costo = costo;
    }

    @Override
    public int compareTo(Arista otra) {
        return Integer.compare(this.costo, otra.costo);
    }

	@Override
	public String toString() {
		return "Arista [desde=" + desde + ", hasta=" + hasta + ", costo=" + costo + "]";
	}
    
    
}