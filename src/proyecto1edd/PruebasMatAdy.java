package proyecto1edd;

/**
*Clase Lista prueba de matriz de adyacencia
*@author: Luis Soriano
*@version: 19/10/23
 */

public class PruebasMatAdy {
    

    static Lista<Lista<Boolean>> matAdy;// = new Lista<>();

    public static void main(String[] args) {

        matAdy = new Lista<>();

        Lista<Boolean> listaBool1 = new Lista<>();
        listaBool1.agregarFinal(false);
        listaBool1.agregarFinal(true);
        listaBool1.agregarFinal(false);
        listaBool1.agregarFinal(true);

        Lista<Boolean> listaBool2 = new Lista<>();
        listaBool2.agregarFinal(true);
        listaBool2.agregarFinal(false);
        listaBool2.agregarFinal(true);
        listaBool2.agregarFinal(true);

        Lista<Boolean> listaBool3 = new Lista<>();
        listaBool3.agregarFinal(true);
        listaBool3.agregarFinal(false);
        listaBool3.agregarFinal(true);
        listaBool3.agregarFinal(true);

        Lista<Boolean> listaBool4 = new Lista<>();
        listaBool4.agregarFinal(true);
        listaBool4.agregarFinal(false);
        listaBool4.agregarFinal(true);
        listaBool4.agregarFinal(true);

        matAdy.agregarFinal(listaBool1);
        matAdy.agregarFinal(listaBool2);
        matAdy.agregarFinal(listaBool3);
        matAdy.agregarFinal(listaBool4);

        //matAdy.imprimirLista(); 
        imprimirMatrizAdy(matAdy);
    }

    static void imprimirMatrizAdy(Lista<Lista<Boolean>> matAdy) {
        while (matAdy.inicio != null) {

            matAdy.inicio.info.imprimirLista();
            System.out.println("");

            matAdy.inicio = matAdy.inicio.proximo;
        }
    }
}

//  0      1     2      3

//0 false, true, false, true,

//1 true, false, true, true,

//2 true, false, false, true,

//3 true, false, true, false, 