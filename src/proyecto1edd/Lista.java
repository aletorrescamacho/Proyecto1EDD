/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author luiss
 */


/**
*Clase Lista nodos conectados
*@author: Luis Soriano
*@version: 19/10/23
 */
public class Lista <T>{
    
    
    Nodo<T> inicio;
    Nodo<T> fin;
    int cantNodos;

    public Lista() {
        cantNodos = 0;
        this.inicio = null;
        this.fin = null;
    }

    public void agregarFinal(T elem) {
        Nodo<T> nodoNuevo = new Nodo<>(elem);
        Nodo<T> temp;
        if (getInicio() == null) {
            this.setInicio(nodoNuevo);
            this.setFin(nodoNuevo);
        } else {
            temp = getInicio();
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = nodoNuevo;
        }
        setCantNodos(getCantNodos() + 1);
    }

    public void imprimirLista() {
        if (getInicio() == null) {
            System.out.println("La lista esta vacia");
        } else {
            while (getInicio() != null) {
//              System.out.print(inicio.elem + "\n");
                System.out.print(getInicio().info+ ", ");
                setInicio(getInicio().proximo);
            }
        }
    }

    /**
     * @return the inicio
     */
    
    /**
    *Setters y geters que nos permiten obtener y modificar el tamaño y pFirst de la lista
    *@author: Luis Soriano
    *@version: 18/10/23
     */
    
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public Nodo<T> getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    /**
     * @return the cantNodos
     */
    public int getCantNodos() {
        return cantNodos;
    }

    /**
     * @param cantNodos the cantNodos to set
     */
    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }
   
      
}

   