/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
*Clase Lista nodos conectados
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

    public void agregarElem(T elem) {//ok
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

    public void eliminarElemXnombre(T elem) {
        Nodo aux = prim;
        Nodo pred = null;
        if(aux == null){
            System.out.println("prim es nulo");
            return;
        }
        while(aux != null){
            if(elem.equals(aux.elem))
            pred = aux;
            aux = aux.sig;
        }
        tamano--;
    }

    public void eliminarElemXpos(int pos) {
    }

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