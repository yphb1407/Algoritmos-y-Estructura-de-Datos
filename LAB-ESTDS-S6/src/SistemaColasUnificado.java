import java.util.Scanner;
public class SistemaColasUnificado {
    static class Nodo {
        int dato, prioridad;
        Nodo siguiente;
        Nodo(int d, int p) { this.dato = d; this.prioridad = p; }
    }
    private Nodo frente, fin;
    private int tamaño = 0;
    private final int MAX_CAPACIDAD = 5;
    // --- ENCOLAR NORMAL (Prioridad 0) ---
    public void enqueueNormal(int valor) {
        if (tamaño >= MAX_CAPACIDAD) return;
        Nodo nuevo = new Nodo(valor, 0);
        if (fin == null) frente = fin = nuevo;
        else { fin.siguiente = nuevo; fin = nuevo; }
        tamaño++;
    }
    // --- ENCOLAR CON PRIORIDAD ---
    public void enqueuePrioridad(int valor, int prioridad) {
        if (tamaño >= MAX_CAPACIDAD) return;
        Nodo nuevo = new Nodo(valor, prioridad);
        // Si la cola está vacía o el nuevo tiene más prioridad que el primero
        if (frente == null || prioridad > frente.prioridad) {
            nuevo.siguiente = frente;
            frente = nuevo;
            if (fin == null) fin = frente;
        } else {
            // Buscar el lugar adecuado (detrás de prioridades mayores o iguales)
            Nodo aux = frente;
            while (aux.siguiente != null && aux.siguiente.prioridad >= prioridad) {
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
            if (nuevo.siguiente == null) fin = nuevo;
        }
        tamaño++;
    }
    public int dequeue() {
        if (frente == null) return -1;
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamaño--;
        return valor;
    }
    public void mostrar() {
        Nodo aux = frente;
        System.out.print("Cola: ");
        while (aux != null) {
            System.out.print("[" + aux.dato + "," + aux.prioridad + "]");
            aux = aux.siguiente;
            if (aux != null) System.out.print(",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SistemaColasUnificado sistema = new SistemaColasUnificado();
        Scanner lector = new Scanner(System.in);
        int op = 0;
        while (op != 4) {
            System.out.print("\n1.Normal 2.Prioridad 3.Desencolar 4.Salir: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Dato: ");
                    sistema.enqueueNormal(lector.nextInt());
                    break;
                case 2:
                    System.out.print("Dato: ");
                    int d = lector.nextInt();
                    System.out.print("Prioridad: ");
                    sistema.enqueuePrioridad(d, lector.nextInt());
                    break;
                case 3:
                    int s = sistema.dequeue();
                    if (s != -1) System.out.println("Salida: " + s);
                    break;
            }
            if (op != 4) sistema.mostrar();
        }
        lector.close();
    }
}
