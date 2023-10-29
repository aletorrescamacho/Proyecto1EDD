/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import Interfaz.Interfaz;
import static Interfaz.Interfaz.archivoCargado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import Modelo.Relacion;
import Modelo.Usuario;
import EDD.Lista;

/**
*Clase Operaciones
*@author: Luis Soriano y Alessandra Torres
*@version: 28/10/23
 */
public class Operaciones {


    static String rutaAbsolutadeArchivo = null;

    public static Lista<Usuario> cUsuarios = new Lista<>();
    public static Lista<Relacion> cRelaciones = new Lista<>();
/**
*Con ayuda de Jfilechooser seleccionamos el archivo y colocamos la información en su respectiva lista
*@author: Luis Soriano y Alessandra Torres
*@version: 28/10/23
 */
    public static Lista[] cargarArchivo() {
        Lista lista = null;
        String stConjunto = null;
        JFileChooser fChooser;
        File fileOpened = null;
        Scanner in = null;
        int returnValue;
        try {
            fChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            returnValue = fChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                fileOpened = fChooser.getSelectedFile();
                System.out.println(fileOpened.getAbsolutePath());
                rutaAbsolutadeArchivo = fileOpened.getAbsolutePath();

                in = new Scanner(fileOpened);

                while (in.hasNextLine()) {
                    String linea;
                    while (in.hasNextLine()) {
                        linea = in.nextLine();
                        if ('@' != linea.charAt(0)) {
                            stConjunto = linea.toUpperCase();
                        } else {
                            switch (stConjunto) {
                                case "USUARIOS":
                                    //agregarUsuarioAlArray(linea);
                                    cUsuarios.agregarElem(new Usuario(linea));
                                    break;
                                case "RELACIONES":
                                    String[] txtRelacion = linea.split(",");
                                    String usuarioOrig = txtRelacion[0].strip();
                                    String usuarioDest = txtRelacion[1].strip();
                                    Relacion relacion = new Relacion(new Usuario(usuarioOrig), new Usuario(usuarioDest));
                                    cRelaciones.agregarElem(relacion);

                            }
                        }
                        //}

                        lista = new Lista();
                        //cUsuarios.imprimirLista();
                        //cRelaciones.imprimirLista();

                    }
                    Interfaz.archivoCargado = true;
                    in.close();
                    Lista[] arrLista = {cUsuarios, cRelaciones};
//                    return cUsuarios;
                    return arrLista;
                }
                        
            }
            }catch (FileNotFoundException e) {
            System.out.println("Un error ha ocurrido.");
        }catch (Exception e) {
            System.out.println("ha ocurrido un error");
        }finally {
        }
            return null;
        }

    

    
/**
*Guardar el archivo, lee las listas creadas y lo reescribe en el archivo con las modificaciones
*@author: Luis Soriano y Alessandra Torres
*@version: 28/10/23
 */
    public static void guardarArchivo() {
        if (archivoCargado) {
            if (cUsuarios.tamano > 0) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(rutaAbsolutadeArchivo);

                    fileWriter.write("usuarios" + "\n");
                    int cont = 0;
                    for (int i = 0; i < cUsuarios.tamano; i++) {
                        fileWriter.append(cUsuarios.prim.elem.usuario + "\n");
                    }

                    fileWriter.append("relaciones" + "\n");
                    cont = 0;
                    for (int i = 0; i < cRelaciones.tamano; i++) {
                        fileWriter.append(cRelaciones.prim.elem.usuarioOrig.usuario + ", "
                                + cRelaciones.prim.elem.usuarioDest.usuario + "\n");
                    }

                } catch (IOException e) {
                } finally {
                    try {
                        if (fileWriter != null) {
                            fileWriter.flush();
                            fileWriter.close();
                        }
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
