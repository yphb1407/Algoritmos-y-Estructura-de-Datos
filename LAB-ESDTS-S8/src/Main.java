import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("""
                               1.instIn 2.instFin 3.insMid 4.eliIn 5.eliFin 6.eliMedio 7.invertir 8.floyd 9.crearCiclo 10.fusionar 11.salir""");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertarInicio(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Dato: ");
                    lista.insertarFinal(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Despues de: ");
                    int ref = sc.nextInt();
                    System.out.print("Dato: ");
                    int nuevo = sc.nextInt();
                    lista.insertarMedio(ref, nuevo);
                    break;
                case 4:
                    lista.eliminarInicio();
                    break;
                case 5:
                    lista.eliminarFinal();
                    break;
                case 6:
                    System.out.print("Dato: ");
                    lista.eliminarMedio(sc.nextInt());
                    break;
                case 7:
                    lista.invertir();
                    System.out.println("Lista invertida");
                    break;
                case 8:
                    if (lista.tieneCiclo()) {
                        System.out.println("La lista tiene ciclo");
                    } else {
                        System.out.println("La lista NO tiene ciclo");
                    }
                    break;
                case 9:
                    lista.crearCiclo();
                    System.out.println("Ciclo creado");
                    break;
                case 10:
                    ListaEnlazada l2= new ListaEnlazada();
                    int n2;
                    System.out.print("Cantidad lista 2: ");
                    n2 = sc.nextInt();
                    System.out.println("Datos ordenados:");
                    for (int i = 0; i < n2; i++) {l2.insertarFinal(sc.nextInt());}
                    lista = ListaEnlazada.fusionar(lista,l2);
                    System.out.println("Fusion completada");
                    break;
            }
            if (op != 11
                    && op != 10) {
                lista.mostrar();
            }
        } while (op != 11);
        sc.close();
    }
}