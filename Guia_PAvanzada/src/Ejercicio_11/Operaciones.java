package Ejercicio_11;

public class Operaciones {

	public static long suma(int n) {
		long result = 0;
		for (int i = 0; i < 100000; i++) {
			result += n;
		}
		return result;
	}

	public static long multiplicacion(int n) {
		long result = 1;
		for (int i = 0; i < 1000000000; i++) {
			result *= n;
		}
		return result;
	}

	public static long division(int n) {
		long result = 1;
		for (int i = 0; i < 1000000000; i++) {
			result = n / 1;
		}
		return result;
	}

	public static void comparacion(int n) {
		boolean result;
		for (int i = 0; i < 1000000000; i++) {
			result = n > i;
		}
	}

	public static long asignaciones(int n) {
		long result = 1;
		for (int i = 0; i < 1000000000; i++) {
			result = n;
		}
		return result;
	}

	public static void main(String[] args) {
        int n = 5; // Puedes cambiar este valor según sea necesario
        
        // Medición de tiempo para la suma
        long startTimeSuma = System.nanoTime();
        suma(n);
        long endTimeSuma = System.nanoTime();
        long elapsedTimeSuma = endTimeSuma - startTimeSuma;
        System.out.println("Tiempo para realizar 100.000.000 de sumas: " + elapsedTimeSuma + " nanosegundos");

        // Medición de tiempo para la multiplicación
        long startTimeMultiplicacion = System.nanoTime();
        multiplicacion(n);
        long endTimeMultiplicacion = System.nanoTime();
        long elapsedTimeMultiplicacion = endTimeMultiplicacion - startTimeMultiplicacion;
        System.out.println("Tiempo para realizar 100.000.000 de multiplicaciones: " + elapsedTimeMultiplicacion + " nanosegundos");

        // Medición de tiempo para la división
        long startTimeDivision = System.nanoTime();
        division(n);
        long endTimeDivision = System.nanoTime();
        long elapsedTimeDivision = endTimeDivision - startTimeDivision;
        System.out.println("Tiempo para realizar 100.000.000 de divisiones: " + elapsedTimeDivision + " nanosegundos");

        // Medición de tiempo para las comparaciones
        long startTimeComparacion = System.nanoTime();
        comparacion(n);
        long endTimeComparacion = System.nanoTime();
        long elapsedTimeComparacion = endTimeComparacion - startTimeComparacion;
        System.out.println("Tiempo para realizar 100.000.000 de comparaciones: " + elapsedTimeComparacion + " nanosegundos");

        // Medición de tiempo para las asignaciones
        long startTimeAsignaciones = System.nanoTime();
        asignaciones(n);
        long endTimeAsignaciones = System.nanoTime();
        long elapsedTimeAsignaciones = endTimeAsignaciones - startTimeAsignaciones;
        System.out.println("Tiempo para realizar 100.000.000 de asignaciones: " + elapsedTimeAsignaciones + " nanosegundos");
        System.out.println("PRUEBA 2DO COMMIT");

	}
}
