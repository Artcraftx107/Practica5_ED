/*******************************
 * Copyright (C) [2024] [J.L. Triviño]
 *
 * Este programa es software libre: puedes redistribuirlo y/o modificarlo 
 * bajo los términos de la Licencia Pública General de GNU según lo publicado 
 * por la Free Software Foundation, ya sea la versión 3 de la Licencia, o 
 * (a tu elección) cualquier versión posterior.
 *
 * Este programa se distribuye con la esperanza de que sea útil, pero 
 * SIN NINGUNA GARANTÍA; ni siquiera la garantía implícita de 
 * COMERCIABILIDAD o IDONEIDAD PARA UN PROPÓSITO PARTICULAR. 
 * Consulta la Licencia Pública General de GNU para obtener más detalles.
 *
 * Deberías haber recibido una copia de la Licencia Pública General de GNU
 * junto con este programa. Si no es así, consulta <http://www.gnu.org/licenses/>.
 */


package colaPrioridad;

import java.util.Arrays;

public class HeapColaPrioridad<P extends Comparable<P>, E> extends AbstractColaPrioridad<P, E> {
	private static final int CAPACIDAD_INICIAL = 10;
	private Par<P,E>[] heap;

	private static int padre(int i) {
		return (i-1)/2;
	}
	private static int hijoIzq(int i) {
		return 2*i+1;
	}
	private static int hijoDer(int i) {
		return 2*i+2;
	}


	@SuppressWarnings("unchecked")
	public HeapColaPrioridad() {
		heap = new Par[CAPACIDAD_INICIAL];
		size=0;
	}

	@Override
	public void insertar(P prioridad, E elemento) {
		if(prioridad == null){
			throw new NullPointerException("La prioridad no puede ser nula ");
		}

		if(size == heap.length){
			resize(heap.length*2);
		}

		Par<P, E> nuevoElem = new Par<>(prioridad, elemento);
		heap[size] = nuevoElem;
		size++;
		percolateUp();
	}

	@Override
	public Par<P,E> extraerMax() {
		if(estaVacia()){
			throw new IllegalStateException("La cola esta vacia");
		}

		Par<P, E> max = heap[0];
		heap[0]=heap[size-1];
		heap[size--] = null; 
		percolateDown();
		return max;
	}

	@Override
	public Par<P,E> consultarMax() {
		if(estaVacia()){
			throw new IllegalStateException("La cola esta vacia");
		}

		return heap[0];
	}

	@Override
	public boolean estaVacia() {
		return size==0;
	}

	private void percolateUp(){
		int index = size-1;
		Par<P, E> elemAux = heap[index];
		int parentIndex = padre(index);
		Par<P, E> parentElem = heap[parentIndex];
		while (index>0 && elemAux.prioridad().compareTo(parentElem.prioridad())>0){
			parentIndex = padre(index);
			parentElem = heap[parentIndex];

			heap[index] = parentElem;
			index=parentIndex;
		}
		heap[index] = elemAux;
	}

	private void percolateDown() {
		int index = 0;
		Par<P, E> elemAux = heap[index];
		boolean bigger = false;
		while (hijoIzq(index) < size && !bigger) {
			int left = hijoIzq(index);
			int right = hijoDer(index);
			int max = left;

			if (right < size && heap[right].prioridad().compareTo(heap[left].prioridad()) > 0) {
				max = right;
			}

			if (elemAux.prioridad().compareTo(heap[max].prioridad()) >= 0) {
				bigger=true;
			}else{
				heap[index] = heap[max];
				index = max;
			}
		}

		heap[index] = elemAux;
	}

   //@SuppressWarnings("unchecked")
   private void resize(int capacity) {
		heap=Arrays.copyOf(heap, capacity);
   }
   
   @Override
   protected Par<P,E>[] toArray(){
		return Arrays.copyOf(heap, size);
   }
}
