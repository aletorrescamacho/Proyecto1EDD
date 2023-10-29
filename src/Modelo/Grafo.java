
package Modelo;

import EDD.Lista;
import EDD.Nodo;

public class Grafo {
    public Lista<Usuario> cUsuarios;
    public Lista<Relacion> cRelaciones;
    
    public Grafo() {
    cUsuarios = new Lista<>();
    cRelaciones = new Lista<>();
    }
    
    
        /**
    *Metodo agregar usuario, agrega un nuevo usuario a la lista de usuarios
    *@author: Luis Soriano
    *@version: 28/10/23
     */
    public void agregarUsuario(String usuario) {
        Usuario objUsuario = new Usuario(usuario);
        cUsuarios.agregarElem(objUsuario);
    }
    
     /**
    *Metodo eliminar usuario, elimina el usuario indicado de la lista de usuarios
    *@author: Luis Soriano
    *@version: 28/10/23
     */
    public void eliminarUsuario(String usuario) {
        Usuario objUsuario = new Usuario(usuario);
        cUsuarios.eliminarElemXnombre(objUsuario);
    }
    
             /**
    *Metodo agregar relacion, agrega relacion a la lista de relaciones
    *@author: Luis Soriano
    *@version: 28/10/23
     */
    public void agregarRelacion(String usuarioOrig, String usuarioDest) {
        Relacion relacion = new Relacion(new Usuario(usuarioOrig), new Usuario(usuarioDest));
        cRelaciones.agregarElem(relacion);
    }
    
     /**
    *Metodo eliminar relacion, elimina una relacion de la lista de relaciones
    *@author: Luis Soriano
    *@version: 28/10/23
     */
    public void eliminarRelacion(String usOrig, String usDest) {
        cRelaciones.eliminarElemXnombre(new Relacion(new Usuario(usOrig), new Usuario(usDest)));

    }
    
      /**
    *Matriz Adyacencia
    *@author: Luis Soriano y Alessandra Torres
    *@version: 28/10/23
     */
    
    public int [][] obtenerMatAdy (){
        int dim = cUsuarios.obtenerTamano();
        int [][] matAdy = new int [dim][dim];
        int contador = 0;
        for (int i = 0; i < dim; i++) {
            for(int b = 0; b < dim; b++){
                matAdy [i][b] = 0;
            }
        }            
            Nodo <Relacion> aux = cRelaciones.prim;
            while (contador < cRelaciones.obtenerTamano()){
                int x = cUsuarios.obtenerPosXelem(aux.obtenerElem().usuarioOrig);
                int y = cUsuarios.obtenerPosXelem(aux.obtenerElem().usuarioDest);
                matAdy [y][x] = 1 ;
                aux = aux.sig;
                contador ++;
            }
            for (int i = 0; i < dim; i++){
                for (int b=0; b < dim; b++){
                    System.out.print(matAdy[i][b]);
                }
        }
       return matAdy;
    }
    
}
