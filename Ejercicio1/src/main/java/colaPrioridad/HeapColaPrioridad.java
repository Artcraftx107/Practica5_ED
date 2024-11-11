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

	private static int padre(int i) {  }
	private static int hijoIzq(int i) {  }
	private static int hijoDer(int i) {  }


	@SuppressWarnings("unchecked")
	public HeapColaPrioridad() {

	}

	@Override
	public void insertar(P prioridad, E elemento) {
	
	}

	@Override
	public Par<P,E> extraerMax() {

	}

	@Override
	public Par<P,E> consultarMax() {

	}

	@Override
	public boolean estaVacia() {
	
	}

	private void percolateUp(){
 
	}

	private void percolateDown() {

	}

   //@SuppressWarnings("unchecked")
   private void resize(int capacity) {
  
   }
   
   @Override
	 protected Par<P,E>[] toArray() {
	
	}
}
