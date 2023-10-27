package proyecto1edd;


import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.graphstream.graph.Graph;

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
    
    /**
    *Metodo poblarMatrizAdy, crea la matriz
    *@author: Luis Soriano
    *@version: 26/10/23
     */

    public void poblarMatrizAdy(String[] pArrUsuarios, String[][] pArrRelaciones2d) {
        int posX;
        int posY;
        for (String[] pArrRelaciones2d1 : pArrRelaciones2d) {
            for (String arrConjUsuario : arrUsuarios) {
                posX = obtenerPosicionUsuario(pArrRelaciones2d1[0]);
                posY = obtenerPosicionUsuario(pArrRelaciones2d1[1]);
                matrizAdy[posY][posX] = true;
            }
        }
    }


    /**
    *Metodo agregarUsuario, Agrega usuario al array
    *@author: Luis Soriano
    *@version: 26/10/23
     */
    public void agregarUsuario(String nombreUsuario) {
        boolean existe = false;
        if (contUsuarios < MAX_USUARIOS) {
            //verificarsi el usuario ya existe
            for (int i = 0; i < Grafo.contUsuarios; i++) {
                if (nombreUsuario.equals(arrUsuarios)) {
                    existe = true;
                    JOptionPane.showMessageDialog(null,
                            "Error: El usuario ya existe");
                    break;
                }
            }
            if (!existe) {
                //asignacion de usuario al array
                arrUsuarios[contUsuarios] = nombreUsuario;
                contUsuarios++;
            }
        } else {
            System.out.println("Error: No hay mas espacio");
            JOptionPane.showMessageDialog(null,
                    "Error: No hay mas espacio");
        }
    }

    
    
    //probando
        public void agregarRelacionAlArray(String[] parUsuarios, Graph graph) {
        String usuarioOrig = parUsuarios[0];
        String usuarioDest = parUsuarios[1];
//        if (!usuarioOrig.equals(usuarioDest)) {
//            if (arrRelaciones2d[contRelaciones][0] == null && arrRelaciones2d[contRelaciones][1] == null) {
//                arrRelaciones2d[contRelaciones][0] = usuarioOrig;
//                arrRelaciones2d[contRelaciones][1] = usuarioDest;
//                //luego añadimos a la matriz de incidencia
//                int posUsuarioDest = obtenerPosicionUsuario(usuarioOrig);
//                int posUsuarioOrig = obtenerPosicionUsuario(usuarioDest);
//                matrizAdy[posUsuarioOrig][posUsuarioDest] = true;
//                contRelaciones++;
//            } else {
//                System.out.println("La relacion ya existe");
//                JOptionPane.showMessageDialog(null, "La relacion ya existe");
//            }
//        } else {
//            System.out.println("No se permiten relaciones consigo mismo!");
//            JOptionPane.showMessageDialog(null,
//                    "No se permiten relaciones consigo mismo!");
//        }
        Grafo.this.agregarRelacionAlArray(usuarioOrig, usuarioDest, graph);

    }

        //probando
         public boolean agregarRelacionAlArray(String usuarioOrig, String usuarioDest, Graph graph) {
//        if (!usuarioOrig.equals(usuarioDest)) {
//            arrRelaciones2d[contRelaciones][0] = usuarioOrig;
//            arrRelaciones2d[contRelaciones][1] = usuarioDest;
//
//            //Parametros para Graphstream
//            graph.addEdge(usuarioOrig + usuarioDest, usuarioOrig, usuarioDest);
//
//            contRelaciones++;
//            return true;
//        } else {
//            System.out.println("No se permiten relaciones consigo mismo!");
//            JOptionPane.showMessageDialog(null,
//                    "No se permiten relaciones consigo mismo!");
//        }
        if (!usuarioOrig.equals(usuarioDest)) {
            if (arrRelaciones2d[contRelaciones][0] == null && arrRelaciones2d[contRelaciones][1] == null) {
                arrRelaciones2d[contRelaciones][0] = usuarioOrig;
                arrRelaciones2d[contRelaciones][1] = usuarioDest;
                //luego añadimos a la matriz de incidencia
                System.out.println("gui 162: " +usuarioOrig );
                System.out.println("gui 163: " +usuarioDest );               
                int posUsuarioDest = obtenerPosicionUsuario(usuarioOrig);
                int posUsuarioOrig = obtenerPosicionUsuario(usuarioDest);
                System.out.println("gui 166: " +posUsuarioOrig );
                System.out.println("gui 167: " +posUsuarioDest );
                matrizAdy[posUsuarioOrig][posUsuarioDest] = true;
                contRelaciones++;
                return true;
            } else {
                System.out.println("La relacion ya existe");
                JOptionPane.showMessageDialog(null, "La relacion ya existe");
            }
        } else {
            System.out.println("No se permiten relaciones consigo mismo!");
            JOptionPane.showMessageDialog(null,
                    "No se permiten relaciones consigo mismo!");
        }
        return false;
    }
    
    
    
    
    
        /**
    *Metodo eliminarUsuario elimina el usuario del array pasandole su nombre por parametro
    *@author: Luis Soriano
    *@version: 26/10/23
     */
    public void eliminarUsuario(String nombreUsuario) {
        int pos = obtenerPosicionUsuario(nombreUsuario);
        eliminarUsuario(pos);

    }

     /**
    *Metodo eliminarUsuario elimina el usuario del array pasandole su indice en el arreglo por parametro
    *@author: Luis Soriano
    *@version: 26/10/23
     */
   
    public void eliminarUsuario(int posUsuario) {
        if (posUsuario <= contUsuarios) {
            for (int i = posUsuario; i < contUsuarios; i++) {
                arrUsuarios[i] = arrUsuarios[i + 1];
            }
            contUsuarios--;
        } else {
            System.out.println("No se puede eliminar un usuario fuera de rango");
            JOptionPane.showMessageDialog(null,
                    "No se puede eliminar un usuario fuera de rango");
        }
    }

     /**
    *Metodo obtenerPosicionUsuario devuelve el indice del usuario en el arreglo pasandole por paramterto el nombre del mismo
    *@author: Luis Soriano
    *@version: 26/10/23
     */
    
    public int obtenerPosicionUsuario(String pUsuario) {
        int pos = -1;
        for (int i = 0; i < contUsuarios; i++) {
            if(pUsuario.equals(arrUsuarios[i])){
                return i;
            }
        }
        return pos;
    }
  
     /**s
    *Metodo imprimirMatriz, imprime la matriz en el textarea
    *@author: Alessandra Torres
    *@version: 26/10/23
     */
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
        
         /**
    *Metodo imprimirUsuarios, imprime los usuarios que estan en el array en el text area de la interfaz
    *@author: Alessandra Torres
    *@version: 26/10/23
     */
        public void imprimirUsuariosTaNotepad(JTextArea taNotepad) {
        taNotepad.setText("");
        for (int i = 0; i < Grafo.contUsuarios; i++) {
            taNotepad.append(arrUsuarios[i] + "\n");
        }
    }

                 /**
    *Metodo imprimirRelaciones, imprime las relaciones que estan en el array en el text area de la interfaz
    *@author: Alessandra Torres
    *@version: 26/10/23
     */
    public void imprimirRelacionesTaNotepad(JTextArea taNotepad) {
        for (int i = 0; i < contRelaciones; i++) {
            taNotepad.append(arrRelaciones2d[i][0] + ", " + arrRelaciones2d[i][1] + "\n");
        }
    }

    
    public static void main(String[] args) {
//        Graph graph = new SingleGraph("Grapfo dirigido");
        Grafo grafo = new Grafo();


        String[] letras = {"a", "b", "c", "d", "e", "f", "@radiogaga"};
    }
}

