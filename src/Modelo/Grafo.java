/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import EDD.Lista;

public class Grafo {
    public Lista<Usuario> cUsuarios;
    public Lista<Relacion> cRelaciones;
    
    public Grafo() {
    cUsuarios = new Lista<>();
    cRelaciones = new Lista<>();
    }
    
    public void agregarUsuario(String usuario) {
        Usuario objUsuario = new Usuario(usuario);
        cUsuarios.agregarElem(objUsuario);
    }
    
}
