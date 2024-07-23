package ProgramacionDinamica;

public class Main {

	public static void main(String[] args) {
		Algoritmos alg = new Algoritmos();

//		System.out.println(alg.fibonacciBottonUp(5));
//		int[][] mat = {{3,2,12,15,10},
//						{6,19,7,11,17},
//						{8,5,12,32,21},
//						{3,20,2,9,7}};
//		alg.imprimirMatriz(mat);
//		System.out.println(alg.minaOro(mat));

//		alg.distanciaMinimaDeEdicion("inside", "index");

//		int[][] mat= {	{-5,3,5,8,2,1,-4},
//						{3,-8,-10,2,-2,5,4},
//						{1,8,3,-6,0,9,3},
//						{12,7,1,-4,-9,5,-6},
//						{-15,8,-12,6,3,-10,3}
//					};
//		alg.sumaSubrectanculos(mat);
//		int[] vec = { 2, 10, 3, 6, 8, 1, 7 };
//		System.out.println(alg.ladronDeCasas(vec));

//		int[] objCosto = { 200, 300, 150 };
//		int[] objPeso = { 3, 3, 1 };
//		int pesoDisponible = 4;
//		System.out.println(alg.mochilaBottonUp(objCosto, objPeso, pesoDisponible));
		int[] cortes = { 3, 5, 1, 4 };
		System.out.println(alg.corteVarilla(7, cortes));

	}
}
