/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1edd;

/**
 *
 * @author Alessandra Torres
 */
public class Relacion {
    public String nombreUsuarioOrig;
    public String nombreUsuarioDest;
    public int posicion;

    public Relacion(String nombreUsuarioOrig, String nombreUsuarioDest) {
        this.nombreUsuarioOrig = nombreUsuarioOrig;
        this.nombreUsuarioDest = nombreUsuarioDest;
    }

    public String getNombreUsuarioOrig() {
        return nombreUsuarioOrig;
    }

    public void setNombreUsuarioOrig(String nombreUsuarioOrig) {
        this.nombreUsuarioOrig = nombreUsuarioOrig;
    }

    public String getNombreUsuarioDest() {
        return nombreUsuarioDest;
    }

    public void setNombreUsuarioDest(String nombreUsuarioDest) {
        this.nombreUsuarioDest = nombreUsuarioDest;
    }
}
