package colaPrioridad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class HeapColaPrioridadTest {
//extends HeapColaPrioridad<Integer, String>{

    @Test
    void testColaPrioridad() {
        var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        colaPrioridad.insertar(3, "Elemento A");
        colaPrioridad.insertar(1, "Elemento B");
        colaPrioridad.insertar(4, "Elemento C");
        colaPrioridad.insertar(2, "Elemento D");
        colaPrioridad.insertar(5, "Elemento E");

        // Verificar tamaño de la cola
        assertEquals(5, colaPrioridad.tamaño());

        // Extraer y verificar elementos en orden de prioridad
        assertEquals("Elemento E", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento C", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento A", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento D", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento B", colaPrioridad.extraerMax().valor());

        // Verificar que la cola está vacía después de extraer todos los elementos
        assertTrue(colaPrioridad.estaVacia());
    }


    @Test
    void testHeapVacio() {
        var  colaPrioridad = new HeapColaPrioridad<Integer,String>();
        assertThrows(IllegalStateException.class, () -> colaPrioridad.extraerMax());
    }

    @Test
    void testResize() {
        var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        for (int i = 1; i <= 100; i++) {
            colaPrioridad.insertar(i, String.valueOf(i));
        }
        
        for(int i = 100; i > 0; i-- ){ 
        		assertEquals(String.valueOf(i), colaPrioridad.extraerMax().valor());
        }
    }

    @Test
    void testPrioridadNula() {
        var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        assertThrows(NullPointerException.class, () -> colaPrioridad.insertar(null, "algo"));
    }

    @Test
    void testConsultarMax() {
        var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        colaPrioridad.insertar(3, "tres");
        colaPrioridad.insertar(1, "uno");
        assertEquals("tres", colaPrioridad.consultarMax().valor());
        assertFalse(colaPrioridad.estaVacia(), "La cola no debería estar vacía después de hacer peek");
        assertEquals("tres", colaPrioridad.consultarMax().valor());
        assertFalse(colaPrioridad.estaVacia(), "La cola no debería estar vacía después de hacer peek");
    }

    @Test
    void testEstaVacia() {
         var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        assertTrue(colaPrioridad.estaVacia());
        colaPrioridad.insertar(1, "uno");
        assertFalse(colaPrioridad.estaVacia());
    }
    
    @Test
    void testToArray() {
         var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        // Insertar varios elementos
        colaPrioridad.insertar(10, "Elemento 10");
        colaPrioridad.insertar(5, "Elemento 5");
        colaPrioridad.insertar(20, "Elemento 20");

        // Obtener el array mediante el método protegido toArray
        ColaPrioridad.Par<Integer, String>[] array = colaPrioridad.toArray();

        // Verificar que el tamaño del array es correcto
        assertEquals(3, array.length, "El tamaño del array debe ser igual al número de elementos en la cola");

        // Crear una lista con los elementos esperados
        List<String> elementosEsperados = Arrays.asList("Elemento 10", "Elemento 5", "Elemento 20");

        // Extraer los elementos del array y verificar que contiene todos los elementos insertados
        for (ColaPrioridad.Par<Integer, String> par : array) {
        		//@SuppressWarnings("unchecked")
            assertTrue(elementosEsperados.contains(((ColaPrioridad.Par<Integer, String>) par).valor()), 
                       "El array debe contener todos los elementos insertados");
        }
    }
    
    @Test
    void testToArray2() {
        var colaPrioridad = new HeapColaPrioridad<Integer,String>();
        colaPrioridad.insertar(3, "Elemento A");
        colaPrioridad.insertar(1, "Elemento B");
        colaPrioridad.insertar(4, "Elemento C");
        colaPrioridad.insertar(2, "Elemento D");
        colaPrioridad.insertar(5, "Elemento E");

        // Verificar tamaño de la cola
        assertEquals(5, colaPrioridad.tamaño());

        // Obtener el array mediante el método protegido toArray
        ColaPrioridad.Par<Integer, String>[] array = colaPrioridad.toArray();

			for( int i = 0; i < 5; i++ ){
				array[i] = null;
			}
 
        // Extraer y verificar elementos en orden de prioridad
        assertEquals("Elemento E", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento C", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento A", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento D", colaPrioridad.extraerMax().valor());
        assertEquals("Elemento B", colaPrioridad.extraerMax().valor());

        // Verificar que la cola está vacía después de extraer todos los elementos
        assertTrue(colaPrioridad.estaVacia());
    }

    @Test
    void testEqualsSameElementsSameOrder() {
        HeapColaPrioridad<Integer, String> colaPrioridad1 = new HeapColaPrioridad<Integer,String>();
        HeapColaPrioridad<Integer, String> colaPrioridad2 = new HeapColaPrioridad<Integer,String>();
        colaPrioridad1.insertar(10, "Elemento 10");
        colaPrioridad1.insertar(5, "Elemento 5");
        colaPrioridad1.insertar(20, "Elemento 20");

        colaPrioridad2.insertar(10, "Elemento 10");
        colaPrioridad2.insertar(5, "Elemento 5");
        colaPrioridad2.insertar(20, "Elemento 20");

        assertEquals(colaPrioridad1, colaPrioridad2, "Las colas con los mismos elementos en el mismo orden deben ser iguales");
    }

    @Test
    void testEqualsDifferentElements() {
        HeapColaPrioridad<Integer, String> colaPrioridad1 = new HeapColaPrioridad<Integer,String>();
        HeapColaPrioridad<Integer, String> colaPrioridad2= new HeapColaPrioridad<Integer,String>();
        colaPrioridad1.insertar(10, "Elemento 10");
        colaPrioridad1.insertar(5, "Elemento 5");

        colaPrioridad2.insertar(10, "Elemento 10");
        colaPrioridad2.insertar(15, "Elemento 15");

        assertNotEquals(colaPrioridad1, colaPrioridad2, "Las colas con diferentes elementos deben ser diferentes");
    }

    @Test
    void testEqualsSameElementsDifferentOrder() {
        HeapColaPrioridad<Integer, String> colaPrioridad1= new HeapColaPrioridad<Integer,String>();
        HeapColaPrioridad<Integer, String> colaPrioridad2= new HeapColaPrioridad<Integer,String>();
        colaPrioridad1.insertar(10, "Elemento 10");
        colaPrioridad1.insertar(20, "Elemento 20");

        colaPrioridad2.insertar(20, "Elemento 20");
        colaPrioridad2.insertar(10, "Elemento 10");

        assertEquals(colaPrioridad1, colaPrioridad2, "Las colas con los mismos elementos en diferente orden deben ser iguales");
    }

    @Test
    void testEqualsNull() {
        HeapColaPrioridad<Integer, String> colaPrioridad1= new HeapColaPrioridad<Integer,String>();

        assertNotEquals(colaPrioridad1, null, "Una cola de prioridad no debería ser igual a null");
    }

    @Test
    void testEqualsDifferentType() {
        HeapColaPrioridad<Integer, String> colaPrioridad1= new HeapColaPrioridad<Integer,String>();

        assertNotEquals(colaPrioridad1, "Una Cadena", "Una cola de prioridad no debería ser igual a un objeto de otro tipo");
    }

}
