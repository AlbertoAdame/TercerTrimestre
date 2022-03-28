package utilidades;

public class Utilidades {

	public static <T> void volcarArray(T[] origen, T[] destino) {
		int tamaño = Math.min(origen.length, destino.length);
		for (int i = 0; i < tamaño; i++) {
			destino[i] = origen[i];
		}
	}
	
	public static <S> String toString(S[] array) {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if(array[i]!=null)
				resultado = resultado.append(array[i]+"\n");
		}return resultado.toString();

	}
}
