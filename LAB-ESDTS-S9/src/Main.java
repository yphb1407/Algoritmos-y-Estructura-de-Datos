public class Main {
    public static void main(String[] args) {

        ListaDobleCircular lista = new ListaDobleCircular();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        System.out.println("Lista:");
        lista.mostrar();

        lista.eliminar(20);

        System.out.println("Después de eliminar 20:");
        lista.mostrar();
    }
}