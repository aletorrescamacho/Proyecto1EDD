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
*Clase Lista
*@author: Luis Soriano
*@version: 18/10/23
 */
public class Lista <T>{
    
    private Nodo <T> pFirst;
    private int iN;

    
    /**
    *Setters y geters que nos permiten obtener y modificar el tamaño y pFirst de la lista
    *@author: Luis Soriano
    *@version: 18/10/23
     */
    public Nodo <T> getpFirst() {
        return pFirst;
    }


    public void setpFirst(Nodo <T> pFirst) {
        this.pFirst = pFirst;
    }


    public int getiN() {
        return iN;
    }

    public void setiN(int iN) {
        this.iN = iN;
    }
    
    
}

