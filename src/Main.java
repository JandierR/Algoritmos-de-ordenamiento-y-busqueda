import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

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

        System.out.println("-".repeat(50));
        System.out.println("Ahora realizaremos la busqueda binaria");
        System.out.print("Digite la palabra que desea buscar: ");

        String palabraBuscar = in.readLine();

        busquedaBinaria(palabras, palabraBuscar);
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
            case 3 -> burbuja();
            case 4 -> mezcla();
            case 5 -> rapido();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Valor invalido!");
        }
    }

    public static void seleccion() {
        int n = palabras.length;
        int min;
        String temp;

        //Se recorre el arreglo
        for (int i = 0; i < n - 1; i++) {

            //El primer valor siempre es el menor
            min = i;

            //Se busca el valor menor en el arreglo
            for (int j = i + 1; j < n; j++) {
                if (palabras[j].compareTo(palabras[min]) < 0) {
                    min = j;
                }
            }

            //Aquí se intercambia el actual elemento con el menor que se encontró
            temp = palabras[i];
            palabras[i] = palabras[min];
            palabras[min] = temp;
        }

        /*
        Busca el elemento menor del arreglo y lo posiciona en el lugar correcto

        Complejidad temporal:
        Mejor caso: O(n al cuadrado)
        Caso promedio: O(n al cuadrado)
        Peor caso: O(n al cuadrado)
         */
    }

    public static void inserccion() {
        int n = palabras.length;
        String[] palabrasNuevas = new String[n];
        int posicionInsertar = 0;
        int cantidadInsertados = 0;

        //Se recorre el arreglo
        for (int i = 0; i < n; i++) {
            //Se ingresa el primer valor al arreglo nuevo desde el arreglo original.
            if (i == 0) {
                palabrasNuevas[i] = palabras[i];
            } else {
                    posicionInsertar = cantidadInsertados;
                for (int j = 0; j < cantidadInsertados; j++) {
                    //Busca las posiciones correctas comparando de manera alfabética
                    if (palabras[i].compareTo(palabrasNuevas[j]) < 0) {
                        posicionInsertar = j;
                        break;
                    }
                }
                //Los elementos se mueven a la derecha
                for (int k = cantidadInsertados; k > posicionInsertar; k--) {
                    palabrasNuevas[k] = palabrasNuevas[k - 1];
                }
                //Se coloca la palabra en el lugar correcto
                palabrasNuevas[posicionInsertar] = palabras[i];
            }
            cantidadInsertados++;
        }

        //Se copia el arreglo nuevo al original
        for (int c = 0; c < palabras.length; c++) {
            palabras[c] = palabrasNuevas[c];
        }

        /*
        Inserta cada elemento en la posicion correcta en el array

        Complejidad temporal:
        Mejor caso: O(n)
        Promedio: O(n al cuadrado)
        Peor caso: O(n al cuadrado)
         */
    }

    public static void burbuja() {
        int n = palabras.length;
        String temp;

        //Se recorre el arreglo
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                //Se comparan las palabras
                if (palabras[j].compareTo(palabras[j + 1]) > 0) {

                    //Se intercambian las palabras
                    temp = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = temp;
                }
            }
        }

        //Este metodo burbuja compara elementos adyacentes e intercambia si
        // están en orden incorrecto.
        //Por otro lado, en cada iteración, el mayor elemento se posiciona al final

        //Complejidad de tiempo:
        //El mejor caso es O(n)
        //El pero caos es O(n al cuadrado)
    }

    public static void mezcla() {
        mergeSort(palabras, 0, palabras.length - 1);
    }

    public static void mergeSort(String[] arr, int inicio, int fin) {
        if (inicio < fin) {

            int medio = (inicio + fin) / 2;
            //La parte izqueirda se ordena
            mergeSort(arr, inicio, medio);

            //La parte derecha se ordena
            mergeSort(arr, medio + 1, fin);

            //Se mezclan las dos mitades
            merge(arr, inicio, medio, fin);
        }


    }
    public static void merge(String[] arr, int inicio, int medio, int fin) {

        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        String[] izquierda = new String[n1];
        String[] derecha = new String[n2];

        for (int i = 0; i < n1; i++) {
            izquierda[i] = arr[inicio + i];
        }

        for (int j = 0; j < n2; j++) {
            derecha[j] = arr[medio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;

        //Se mezclan comparando las palabras
        while (i < n1 && j < n2) {

            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        //Se copian las sobrantes
        while (i < n1) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = derecha[j];
            j++;
            k++;
        }

        /*
        El Merge sort divide el array en mitades, las ordena recursivamente
        y despues las combina

        Complejidad temporal:
        O(n log n)
         */
    }

    public static void rapido() {
        quickSort(palabras, 0, palabras.length - 1);
    }

    public static void quickSort(String[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndex = partition(arr, inicio, fin);

            quickSort(arr, inicio, pivoteIndex - 1);
            quickSort(arr, pivoteIndex + 1, fin);
        }
    }

    public static int partition(String[] arr, int inicio, int fin) {

        String pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            //Se compara la palabra con el pivote
            if (arr[j].compareTo(pivote) < 0) {
                i++;

                //Se hace intercambio de las palabras
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //Se reinicia el pivote a su posicion correcta
        String temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;

        /* Este metodo lo que hace es seleccionar un pivote y reorganiza
        el arreglo a elementos menores y mayores del pivote.
        -------------------------------------------------------
        Complejidad temporal
        En mejor caso -> O(n log n)
        Promedio -> O(n log n)
        Peor caso -> O(n al cuadrado)
        * */
    }


    public static void busquedaBinaria(String[] palabras, String palabraBuscada) {

        //Se declaran e inicializan las variables
        int n = palabras.length;
        int pivote = (n / 2) - 1;
        int limiteMenor = 0;
        int limiteMayor = n - 1;

        //El loop reduce el intervalo de busqueda mientras no se encuentra el valor
        while (!Objects.equals(palabras[pivote], palabraBuscada)) {

            //Se ajustan los límites en comparación con el pivote
            if (palabras[pivote].compareTo(palabraBuscada) > 0) {
                limiteMayor = pivote - 1;
            }else {
                limiteMenor = pivote + 1;
            }

            //Si los límites se traslapan, se indica que el valor no se encontró
            if (limiteMenor > limiteMayor) {
                System.out.println("El dato no se encontró");
                return;
            }

            //Se redefine el pivote para la siguiente iteración
            pivote = (limiteMayor + limiteMenor) / 2;
        }

        System.out.println("La palabra se encontró en la casilla: " + pivote);
        System.out.println("Palabra = " + palabras[pivote]);


        /*
        La busqueda binaria busca la palabra ingresada en un arreglo ya ordenado
        dividiendo el intervalo de busqueda a la mitad, las veces necesarias.

        Complejidad temporal:
        Mejor caso: O(1)
        Caso promedio: O(log n)
        Peor caso: O(log n)
         */
    }
}
