package proyecto1edd;


import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Grafo {

    public final static int MAX_USUARIOS = 200;
    public String[] arrUsuarios;
    public String[][] arrRelaciones2d;

    public boolean[][] matrizAdy;

    public static int contUsuarios;
    public static int contRelaciones;

    public Grafo() {
        arrUsuarios = new String[MAX_USUARIOS];
        arrRelaciones2d = new String[MAX_USUARIOS][2];
        matrizAdy = new boolean[MAX_USUARIOS][MAX_USUARIOS];

        contUsuarios = 0;
        contRelaciones = 0;
    }

    public boolean[][] obtenerMatrizAdy(String[] pArrUsuarios, String[][] pArrRelaciones2d) {
        int posX;
        int posY;
        for (String[] pArrRelaciones2d1 : pArrRelaciones2d) {
            for (String arrConjUsuario : arrUsuarios) {
                posX = obtenerPosicionUsuario(pArrRelaciones2d1[0]);
                posY = obtenerPosicionUsuario(pArrRelaciones2d1[1]);
                matrizAdy[posY][posX] = true;
            }
        }
        return matrizAdy;
    }

    public boolean[][] obtenerMatrizAdy() {
        int posX;
        int posY;
        for (String[] pArrRelaciones2d1 : arrRelaciones2d) {
            for (String arrConjUsuario : arrUsuarios) {
                posX = obtenerPosicionUsuario(pArrRelaciones2d1[0]);
                posY = obtenerPosicionUsuario(pArrRelaciones2d1[1]);
                matrizAdy[posY][posX] = true;
            }
        }
        return matrizAdy;
    }



    public void agregarUsuario(String nombreUsuario) {
        if (contUsuarios < MAX_USUARIOS) {            
            arrUsuarios[contUsuarios] = nombreUsuario;
        } else {
            System.out.println("Error: No hay mas espacio");
            JOptionPane.showMessageDialog(null,
                    "Error: No hay mas espacio");
        }
        contUsuarios++;
    }



    public int obtenerPosicionUsuario(String pUsuario) {
        
        int pos = -1;
        for (int i = 0; i < contUsuarios; i++) {
            //System.out.println(" for obtenerPosUsuario: " + pUsuario + ", conUsuario: " + contUsuarios);
            //System.out.println( pUsuario + " ==  " + arrUsuarios[i]);
            if(pUsuario.equals(arrUsuarios[i])){
                return i;
            }
        }
        System.out.println("obtenerPosUsuario: " + pUsuario + " pos " + pos);
        return pos;
    }
    public int obtenerPosicionUsuario1(String pUsuario, String[] arr) {
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if(pUsuario.equals(arr[i])){
                return i;
            }
        }
        return pos;
    }
   
    
        public boolean[][] agregarRelacion(String[] parUsuarios) {

        String usuarioOrig = parUsuarios[0];
        String usuarioDest = parUsuarios[1];
        if (!usuarioOrig.equals(usuarioDest)) {
            //
            if (arrRelaciones2d[contRelaciones][0] == null && arrRelaciones2d[contRelaciones][1] == null) {
                ///*1ro añadimos a la lista de relaciones
                arrRelaciones2d[contRelaciones][0] = usuarioOrig;
                arrRelaciones2d[contRelaciones][1] = usuarioDest;
                //luego añadimos a la matriz de incidencia
                int posX = obtenerPosicionUsuario(usuarioOrig);
                int posY = obtenerPosicionUsuario(usuarioDest);
                matrizAdy[posY][posX] = true;
                contRelaciones++;
            } else {
                //contRelaciones--;
                System.out.println("La relacion ya existe");
                JOptionPane.showMessageDialog(null,
                        "La relacion ya existe");
            }
//            }
        } else {
            System.out.println("No se permiten relaciones consigo mismo!");
            JOptionPane.showMessageDialog(null,
                    "No se permiten relaciones consigo mismo!");
        }
        return matrizAdy;
    }

        
    public void imprimirUsuarios(JTextArea taNotepad) {
        taNotepad.setText("");
        int cont = 0;
        for (String linea : this.arrUsuarios) {
            taNotepad.append(linea);
            taNotepad.append("\n");
            if (cont >= contUsuarios) {
                break;
            }
            cont++;
        }
    }

    public void imprimirRelaciones(JTextArea taNotepad) {
        for (int i = 0; i < contRelaciones; i++) {
            taNotepad.append(arrRelaciones2d[i][0] + ", " + arrRelaciones2d[i][1] + "\n");
        }
    }
    
        public void imprimirMatriz(JTextArea taNotepad) {
        taNotepad.setFont(new Font("Serif", Font.PLAIN, 16));
        taNotepad.setText("");
        if (contUsuarios > 0) {
            for (int y = 0; y < contUsuarios; y++) {
                for (int x = 0; x <= contUsuarios; x++) {
                    taNotepad.append((matrizAdy[y][x] ? "1" : "0") + "  ");
                }
                taNotepad.append("\n");
            }
        } else {
            System.out.println("La matriz esta vacia");
            JOptionPane.showMessageDialog(null,
                    "La matriz esta vacia");
        }
    }
    



    public static void main(String[] args) {
//        Graph graph = new SingleGraph("Grapfo dirigido");
        Grafo grafo = new Grafo();


        String[] letras = {"a", "b", "c", "d", "e", "f", "@radiogaga"};

        int j = grafo.obtenerPosicionUsuario1("@radiogaga",letras);
        System.out.println("j: " + j);

    }
}

