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

import java.util.Objects;
import java.util.Arrays;

public abstract class AbstractColaPrioridad<P extends Comparable<P>, E> implements ColaPrioridad<P,E> {
    protected int size = 0;

    @Override
    public boolean estaVacia() {
        return size == 0;
    }

    @Override
    public int tamaño() {
        return size;
    }

    protected abstract Par<P,E>[] toArray();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractColaPrioridad<?, ?> that = (AbstractColaPrioridad<?, ?>) o;
        return size == that.size && Arrays.equals(toArray(), that.toArray());
    }

    @Override
    public int hashCode() {
    		var elements = toArray();
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;    	
    }

    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "elements=" + Arrays.toString(toArray()) +
                ", size=" + size +
                '}';   	
    }
}
