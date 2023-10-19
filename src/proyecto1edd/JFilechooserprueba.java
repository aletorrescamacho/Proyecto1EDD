/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1edd;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


/**
*Clase leer archivo (prueba)
*@author: Alessandra Torres
*@version: 18/10/23
 */
public class JFilechooserprueba {
    public static void main(String[] args) {
        
        // Se instancia el JFilechooser
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int a;
        int returnValue = jfc.showOpenDialog(null);
        // Verifica que el numero guardado sea el de opción aprovada, de ser así imprime su ruta
        if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
        }

}  
}
