class ListaDobleCircular {
    private Nodo cabeza;

    public ListaDobleCircular() {
        cabeza = null;
    }

    // Insertar al final
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo ultimo = cabeza.anterior;

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
    }
public void mostrar() {
    if (cabeza == null) {
        System.out.println("Lista vacía");
        return;
    }

    Nodo aux = cabeza;

    do {
        System.out.print(aux.dato + " ");
        aux = aux.siguiente;
    } while (aux != cabeza);

    System.out.println();
}
public void eliminar(int dato) {
    if (cabeza == null) return;

    Nodo actual = cabeza;

    do {
        if (actual.dato == dato) {

            if (actual.siguiente == actual) {
                cabeza = null;
            } else {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;

                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                }
            }
            return;
        }

        actual = actual.siguiente;

    } while (actual != cabeza);
}

}