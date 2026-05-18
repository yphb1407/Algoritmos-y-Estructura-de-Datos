
class ListaEnlazada {

    private Nodo cabeza;
    private int tamaño = 0;

    private final int MAX = 10;

    // =========================
    // INSERTAR INICIO
    // =========================
    public void insertarInicio(int valor) {

        if (tamaño >= MAX) {
            return;
        }

        Nodo nuevo = new Nodo(valor);

        nuevo.siguiente = cabeza;

        cabeza = nuevo;

        tamaño++;
    }

    // =========================
    // INSERTAR FINAL
    // =========================
    public void insertarFinal(int valor) {

        if (tamaño >= MAX) {
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

    // =========================
    // INSERTAR MEDIO
    // =========================
    public void insertarMedio(int ref, int valor) {

        if (tamaño >= MAX) {
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

    // =========================
    // ELIMINAR INICIO
    // =========================
    public void eliminarInicio() {

        if (cabeza == null) {
            return;
        }

        cabeza = cabeza.siguiente;

        tamaño--;
    }

    // =========================
    // ELIMINAR FINAL
    // =========================
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

    // =========================
    // ELIMINAR MEDIO
    // =========================
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

    // =========================
    // MOSTRAR
    // =========================
    public void mostrar() {

    if (tieneCiclo()) {

        System.out.println(
                "No se puede mostrar: hay ciclo");

        return;
    }

    Nodo aux = cabeza;

    System.out.print("Lista: ");

    while (aux != null) {

        System.out.print(
                "[" + aux.dato + "]");

        aux = aux.siguiente;

        if (aux != null) {
            System.out.print(" -> ");
        }
    }

    System.out.println();
}

    private boolean tieneCiclo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}