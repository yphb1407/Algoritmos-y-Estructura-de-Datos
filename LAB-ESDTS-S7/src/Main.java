import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista =new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != 7) {
            System.out.print(
                "\n1.InsIni 2.InsFin 3.InsMed " +
                "4.EliIni 5.EliFin 6.EliMed 7.Salir: "
            );
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
            }
            if (op != 7) {
                lista.mostrar();
            }
        }
        sc.close();
    }
}