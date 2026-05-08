import java.util.Scanner;
public class SistemaListasEnlazadas {
    // ----- NODO -----
    static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int d) {
            dato = d;
        }
    }
    // ----- VARIABLES -----
    private Nodo cabeza;
    private int tamaño = 0;
    private final int MAX_CAPACIDAD = 10;
    // ----- INSERTAR INICIO -----
    public void insertarInicio(int valor) {
        if (tamaño >= MAX_CAPACIDAD) {
            return;
        }
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }
    // ----- INSERTAR FINAL -----
    public void insertarFinal(int valor) {
        if (tamaño >= MAX_CAPACIDAD) {
            return;
        }
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamaño++;
    }
    // ----- INSERTAR MEDIO -----
    public void insertarMedio(int ref, int valor) {
        if (tamaño >= MAX_CAPACIDAD) {
            return;
        }
        Nodo aux = cabeza;
        while (aux != null && aux.dato != ref) {
            aux = aux.siguiente;
        }
        if (aux == null) {
            return;
        }
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = aux.siguiente;
        aux.siguiente = nuevo;
        tamaño++;
    }
    // ----- ELIMINAR INICIO -----
    public void eliminarInicio() {
        if (cabeza == null) {
            return;
        }
        cabeza = cabeza.siguiente;
        tamaño--;
    }
    // ----- ELIMINAR FINAL -----
    public void eliminarFinal() {
        if (cabeza == null) {
            return;
        }
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = null;
        }
        tamaño--;
    }
    // ----- ELIMINAR MEDIO -----
    public void eliminarMedio(int valor) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }
        Nodo aux = cabeza;
        while (aux.siguiente != null
                && aux.siguiente.dato != valor) {

            aux = aux.siguiente;
        }
        if (aux.siguiente != null) {

            aux.siguiente
                    = aux.siguiente.siguiente;
            tamaño--;
        }
    }
    // ----- MOSTRAR -----
    public void mostrar() {
        Nodo aux = cabeza;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print("[" + aux.dato + "]");
            aux = aux.siguiente;
            if (aux != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    // ----- MAIN -----
    public static void main(String[] args) {
        SistemaListasEnlazadas lista = new SistemaListasEnlazadas();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != 7) {
            System.out.print(
                    "\n1.InsIni 2.InsFin 3.InsMed "
                    + "4.EliIni 5.EliFin 6.EliMed 7.Salir: "
            );
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Dato: ");
                    lista.insertarInicio(
                            sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Dato: ");
                    lista.insertarFinal(
                            sc.nextInt());
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
                    lista.eliminarMedio(
                            sc.nextInt());
                }
            }
            if (op != 7) {
                lista.mostrar();
            }
        }
        sc.close();
    }
}
