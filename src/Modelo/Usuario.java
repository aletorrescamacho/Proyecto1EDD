/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
*Clase Usuario, cuando se utiliza el metodo tostring devuelve el nombre y se utilizó override
*@author: Alessandra Torres
*@version: 26/10/23
 */
public class Usuario {
    public String usuario;
    
    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
        Usuario u = (Usuario)obj;       
        return this.usuario.equals(u.usuario);
    }

    @Override
    public String toString() {
        return this.usuario;
    }
}
