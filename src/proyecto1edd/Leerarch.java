/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1edd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*Clase leer archivo (prueba)
*@author: Alessandra Torres
*@version: 18/10/23
 */
public class Leerarch {
    public static void main(String[] args) {
        // try-catch para evitar errores con el archivo
        try {
            // Buscar el archivo por su ruta
            File f = new File("rrss.txt");
            
            // Scanner para leer el archivo
            Scanner leer = new Scanner(f);
            
            // Imprimir linea por linea
            while (leer.hasNextLine()) {
                String data = leer.nextLine();
                System.out.println(data);
            }
            leer.close();
            
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }
}


