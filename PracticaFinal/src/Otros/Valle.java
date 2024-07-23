package Otros;

public class Valle {
	
	public static void main(String[] args) {
		int[] vec = {5,3,-1,0,2,4};
		System.out.println(encontrarValle(vec));
	}

	public static int encontrarValle(int[] vec) {
		int tam = vec.length;

		int i = 0;
		int valle = -1;

		for (i = 0; i < tam - 1; i++) {
			if (vec[i] > vec[i + 1]) {
				continue;
			} else {
				break;
			}
		}

		valle = i;

		for (int j = i; j < tam - 1; j++) {
			if (vec[j] < vec[j + 1]) {
				continue;
			} else {
				return -1;
			}
		}

		return valle;
	}

}
