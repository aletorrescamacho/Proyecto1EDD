/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author luiss
 */
public class Nodo <T> {
/**
*Setters y getters que nos permiten cambiar y obtener la información del nodo y su próximo
*@author: Luis Soriano
*@version: 18/10/23
 */
    
    public T info;
    public Nodo <T> proximo;
    
    public Nodo (T elem){
        info = elem;
        proximo = null;
    }

    public String getInfo() {
        return (String) info;
    }
    public void setInfo(String info){
        this.info = (T) info;
    }
    public Nodo getProxNodo(){
        return proximo;
    }
    public void setProxNodo(Nodo n){
        proximo = n;
    }
}