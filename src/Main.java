import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] palabras;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        llenarArreglo();

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

    public void imprimirMenu() {
        System.out.println("""
                -1. Selección
                -2. Inserción
                -3. Burbuja
                -4. Mezcla
                -5. Rapido
                -0. Salir""");
    }

    public int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> seleccion();
            case 2 -> inserccion();
            case 3 -> burbuja();
            case 4 -> mezcla();
            case 5 -> rapido();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Valor invalido!");
        }
    }


}
