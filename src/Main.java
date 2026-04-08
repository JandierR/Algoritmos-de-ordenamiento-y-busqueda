import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] palabras;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        llenarArreglo();

        System.out.println("Arreglo original");
        mostrarArreglo();

        imprimirMenu();
        int opcion = leerOpcion();

        procesarOpcion(opcion);

        System.out.println("Resultado");
        mostrarArreglo();

    }

    public static void llenarArreglo() throws IOException {
        System.out.println();
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamano = Integer.parseInt(in.readLine());

        palabras = new String[tamano];

        System.out.println("A continuación, llene el arreglo con palabras: ");

        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Palabra a ingresar -> ");

            palabras[i] = in.readLine();
        }
        System.out.println("Enhorabuena. Ha llenado el arreglo de palabras!!!");
    }

    public static void mostrarArreglo() {
        System.out.println();
        System.out.println("Mostrando arreglo...");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }
    }

    public static void imprimirMenu() {
        System.out.println("""
                -1. Selección
                -2. Inserción
                -3. Burbuja
                -4. Mezcla
                -5. Rapido
                -0. Salir""");
    }

    public static int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> seleccion();
            case 2 -> inserccion();
//            case 3 -> burbuja();
//            case 4 -> mezcla();
//            case 5 -> rapido();
            case 3 -> burbuja();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Valor invalido!");
        }
    }

    public static void seleccion() {
        int n = palabras.length;
        int min;
        String temp;

        for (int i = 0; i < n - 1; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (palabras[j].compareTo(palabras[min]) < 0) {
                    min = j;
                }
            }

            temp = palabras[i];
            palabras[i] = palabras[min];
            palabras[min] = temp;
        }
    }

    public static void inserccion() {
        int n = palabras.length;
        String[] palabrasNuevas = new String[n];
        int posicionInsertar = 0;
        int cantidadInsertados = 0;

        for (int i = 0; i < n; i++) {
            //Se ingresa el primer valor al arreglo nuevo desde el arreglo original.
            if (i == 0) {
                palabrasNuevas[i] = palabras[i];
            } else {
                    posicionInsertar = cantidadInsertados;
                for (int j = 0; j < cantidadInsertados; j++) {
                    if (palabras[i].compareTo(palabrasNuevas[j]) < 0) {
                        posicionInsertar = j;
                        break;
                    }
                }
                for (int k = cantidadInsertados; k > posicionInsertar; k--) {
                    palabrasNuevas[k] = palabrasNuevas[k - 1];
                }
                palabrasNuevas[posicionInsertar] = palabras[i];
            }
            cantidadInsertados++;
        }

        for (int c = 0; c < palabras.length; c++) {
            palabras[c] = palabrasNuevas[c];
        }
    }

    public static void burbuja() {
        int n = palabras.length;
        String temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (palabras[j].compareTo(palabras[j + 1]) > 0) {
                    temp = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = temp;
                }
            }
        }

        //Complejidad de tiempo:
        //El mejor caso es O(n)
        //El pero caos es O(n al cuadrado)
    }
}
