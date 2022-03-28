package utilidades;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] origen = { "Luis", "Pepe", "Lola" };
		String[] destino = new String[7];
		Integer[] array1Int = { 10, 20, 30 };
		Integer[] array2Int = new Integer[7];
		Utilidades.volcarArray(origen, destino);
		Utilidades.volcarArray(array1Int, array2Int);
		System.out.println(Utilidades.toString(origen));
		System.out.println(Utilidades.toString(destino));
		System.out.println(Utilidades.toString(array1Int));
		System.out.println(Utilidades.toString(array2Int));

	}

}
