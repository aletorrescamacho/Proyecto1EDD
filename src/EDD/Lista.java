
package EDD;

/**
*Clase Lista simplemente enlazada
*@author: Luis Soriano
*@version: 19/10/23
 */
public class Lista<T> {

    public Nodo<T> prim;
    public Nodo<T> ult;
    public static int tamano;

    public Lista() {
        prim = null;
        ult = null;
        tamano = 0;
    }

    /**
*Metodo agregar elemento a la lista simplemente enlazada
*@author: Luis Soriano
*@version: 19/10/23
 */
    public void agregarElem(T elem) {
        Nodo nodoNuevo = new Nodo(elem);
        Nodo pred =null;
        if (this.prim == null) {
            prim = ult = nodoNuevo;
        } else {
            Nodo aux = prim;
            while (aux != null) {
                pred = aux;
                aux = aux.sig;
            }

            pred.sig = nodoNuevo;
        }
        tamano++;
    }

        /**
*Metodo eliminar elemento a la lista simplemente enlazada
*@author: Luis Soriano
*@version: 19/10/23
 */
    public void eliminarElemXnombre(T elem) {
        Nodo aux = prim;
        if(aux == null){
            System.out.println("prim es nulo");
            return;
        }
        while(aux != null){
            if(aux.sig.elem.equals(elem)){
                System.out.print("encontrado");
                Nodo aux2 = aux.sig;
                aux.sig = aux.sig.sig;   
                aux2.sig = null;
                tamano--;
                return;
            }
            aux = aux.sig;
        }
    }

        /**
*Metodo obtener elemento por posicion  lista simplemente enlazada
*@author: Luis Soriano
*@version: 19/10/23
 */
    public T obtenerElemXpos(int pos) {
        int cont = 0;
        Nodo<T> aux = prim;
        while (aux != null) {
            if (pos == cont) {
                return aux.elem;
            }
            aux = aux.sig;
            tamano--;
        }
        return null;
    }

        /**
*Metodo obtener posicion por elemento en  la lista simplemente enlazada
*@author: Luis Soriano
*@version: 19/10/23
 */
    public int obtenerPosXelem(T elem) {
        int cont = 0;
        Nodo<T> aux = prim;
        while (aux != null) {
            if (elem.equals(aux)) {
                return cont;
            }
            cont++;
            aux = aux.sig;
        }
        return -1;
    }

    public int obtenerTamano() {
        return tamano;
    }

    public void imprimirLista() {
        Nodo<T> aux = this.prim;
        while (aux != null) {
            System.out.println(aux.elem);
            aux = aux.sig;
        }
    }
}