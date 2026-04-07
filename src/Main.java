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


}
