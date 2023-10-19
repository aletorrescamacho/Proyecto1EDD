/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1edd;
/**
*Clase Arista, cada Arista va a contener el vertice desde el que sale hasta el que llega la conexión
*@author: Alessandra Torres
*@version: 18/10/23
 */
public class Arista {
    Vertice origen;
    Vertice destino;
     
   // Constructor
    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
    }
}
