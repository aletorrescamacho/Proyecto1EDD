/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
*Clase Relacion, incluye los getters y setter, el constructor y un Override para cuando se convierta en string convertirlo en el modelo utilizado
*@author: Alessandra Torres
*@version: 26/10/23
 */
public class Relacion {
    public Usuario usuarioOrig;

    public Usuario obtenerUsuarioOrig() {
        return usuarioOrig;
    }

    public void colocarUsuarioOrig(Usuario usuarioOrig) {
        this.usuarioOrig = usuarioOrig;
    }

    public Usuario obtenerUsuarioDest() {
        return usuarioDest;
    }
    public void colocarUsuarioDest(Usuario usuarioDest) {
        this.usuarioDest = usuarioDest;
    }
    public Usuario usuarioDest;

    public Relacion(Usuario usuarioOrig, Usuario usuarioDest) {
        this.usuarioOrig = usuarioOrig;
        this.usuarioDest = usuarioDest;
    }

    @Override
    public String toString() {
        return usuarioOrig + ", " + usuarioDest ;
    }
}
