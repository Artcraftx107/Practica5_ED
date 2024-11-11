import colaPrioridad.ColaPrioridad;
import colaPrioridad.HeapColaPrioridad;

public class EjemploUso {
	public static class Elemento {
		private String texto;
		private int prioridad;

		public Elemento(String texto, int prioridad) {
			this.texto = texto;
			this.prioridad = prioridad;
		}

		public String getTexto() {
			return texto;
		}

		public int getPrioridad() {
			return prioridad;
		}

		@Override
		public String toString() {
			return "Elemento{" +
					"texto='" + texto + '\'' +
					", prioridad=" + prioridad +
					'}';
		}
	}

	public static void main(String[] args) {
		// Crear una instancia de HeapColaPrioridad
		ColaPrioridad<Integer, String> colaPrioridad = new HeapColaPrioridad<Integer, String>();

		// Insertar elementos en la cola con prioridad
		colaPrioridad.insertar(3, "Elemento A");
		colaPrioridad.insertar(1, "Elemento B");
		colaPrioridad.insertar(4, "Elemento C");
		colaPrioridad.insertar(2, "Elemento D");
		colaPrioridad.insertar(5, "Elemento E");

		System.out.println( colaPrioridad );
		System.out.println( "" );

		// Extraer y mostrar los elementos en orden de prioridad
		System.out.println("Elementos extraídos en orden de prioridad:");
		while (!colaPrioridad.estaVacia()) {
			System.out.println(colaPrioridad.extraerMax());
		}
	}
}
