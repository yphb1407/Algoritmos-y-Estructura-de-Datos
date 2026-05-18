
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("""
                               1.instIn 2.instFin 3.insMid 4.eliIn 5.eliFin 6.eliMedio 7.MostarListaYfin""");
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Dato: ");
                    lista.insertarInicio(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Dato: ");
                    lista.insertarFinal(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Despues de: ");
                    int ref = sc.nextInt();
                    System.out.print("Dato: ");
                    int nuevo = sc.nextInt();
                    lista.insertarMedio(ref, nuevo);
                }
                case 4 ->
                    lista.eliminarInicio();
                case 5 ->
                    lista.eliminarFinal();
                case 6 -> {
                    System.out.print("Dato: ");
                    lista.eliminarMedio(sc.nextInt());
                }
                case 7 ->
                    lista.mostrar();
            }
            if (op != 7
                    && op != 8) {
                lista.mostrar();
            }
        } while (op != 7);
        sc.close();
    }
}
