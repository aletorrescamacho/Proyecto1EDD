/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;



public class Nodo<T> {
    public T elem;
    public Nodo sig;
/**
*Setters y getters que nos permiten cambiar y obtener la información del nodo y su próximo
*@author: Luis Soriano
*@version: 18/10/23
 */
    public Nodo(T elem){
        this.elem = elem;
        sig = null;
    }

    public T obtenerElem() {
        return elem;
    }

    public void colocarElem(T elem) {
        this.elem = elem;
    }

    public Nodo obtenerSig() {
        return sig;
    }

    public void colocarSig(Nodo sig) {
        this.sig = sig;
    }
    
    
}