public class Main {
    public static void main(String[] args) {
        int n = 3;

        int[][] matrizTriangularS = {
            {2, 3, 4},
            {0, 5, 6},
            {0, 0, 5}
        };

        int[][] matrizDiag = {
            {1, 0, 0},
            {0, 5, 0},
            {0, 0, 5}
        };

        // Validador antes de procesar
        if (!esTriangularS(matrizTriangularS) || !esDiagonal(matrizDiag)) {
            System.out.println("Error: Las matrices no coinciden con su tipo esperado.");
            return;
        }

        System.out.println("=== MATRICES BASE ===");
        imprimirMatriz(matrizTriangularS);
        System.out.println("\nDiagonal:");
        imprimirMatriz(matrizDiag);

        // 1. Suma saltando ceros conocidos
        System.out.println("\n--- SUMA OPTIMIZADA (T + D) ---");
        imprimirMatriz(sumarOptimizado(matrizTriangularS, matrizDiag, n));

        // 2. Multiplicación (Solo escala los valores existentes)
        System.out.println("\n--- MULTIPLICACIÓN OPTIMIZADA (T * D) ---");
        imprimirMatriz(multiplicarOptimizado(matrizTriangularS, matrizDiag, n));

        // 3. Transpuesta (Solo procesa la mitad superior)
        System.out.println("\n--- TRANSPUESTA OPTIMIZADA ---");
        imprimirMatriz(transponerOptimizado(matrizTriangularS, n));
    }

    // --- MÉTODOS DE OPTIMIZACIÓN DE TIEMPO ---

    public static int[][] sumarOptimizado(int[][] T, int[][] D, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            // Saltamos j < i: en T y D son ceros, no operamos.
            for (int j = i; j < n; j++) { 
                res[i][j] = T[i][j] + D[i][j];
            }
        }
        return res;
    }

    public static int[][] multiplicarOptimizado(int[][] T, int[][] D, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            // j inicia en i: aprovechamos que T[i][0...i-1] es cero.
            for (int j = i; j < n; j++) {
                // Multiplicación directa por el escalar en la diagonal de D
                res[i][j] = T[i][j] * D[j][j];
            }
        }
        return res;
    }

    public static int[][] transponerOptimizado(int[][] T, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            // Solo leemos de la diagonal hacia la derecha (valores útiles)
            for (int j = i; j < n; j++) {
                res[j][i] = T[i][j];
            }
        }
        return res;
    }

    // --- VALIDACIÓN ---

    public static boolean esTriangularS(int[][] m) {
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static boolean esDiagonal(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i != j && m[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void imprimirMatriz(int[][] m) {
        for (int[] fila : m) {
            System.out.print(" ");
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println(" ");
        }
    }
}