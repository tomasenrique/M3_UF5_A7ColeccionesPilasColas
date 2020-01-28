package startApp.view;

import startApp.entities.ContainerDeque;
import startApp.entities.ReadingFile;

import java.io.File;
import java.util.Scanner;

public class Screen {

    private final static int STRING_INVERTED = 1;
    private final static int BALANCED_PUNCTUATION = 2;
    private final static int COUNT_ORDERED = 3;


    private final static int EXIT = 0;
    private final static Scanner read = new Scanner(System.in); // para la lectura de las opciones

    private ContainerDeque container;
    private ReadingFile readingFile;

    // Builder
    public Screen() {
        container = new ContainerDeque();
        readingFile = new ReadingFile();
    }

    /**
     * Funcion para iniciar el programa principal
     */
    public void inicio() {
        int opcion; // opcion elegida
        do {
            menuPrincipal();
            opcion = elegirOpcion();
            switch (opcion) {
                case EXIT:
                    break;

                case STRING_INVERTED:
                    String cadenaInvertida;
                    System.out.print("Ingrese la cadena a invertir: ");
                    cadenaInvertida = read.nextLine();
                    cadenaInvertida = container.reverseSequence(cadenaInvertida);
                    System.out.println(cadenaInvertida);
                    break;

                case BALANCED_PUNCTUATION:
                    boolean result;
                    System.out.print("Ingrese la cadena a comprobar: ");
                    result = container.balancedPunctuationSign(read.nextLine());
                    if (result) System.out.println("Signos de puntuacion balanceados.");
                    else System.out.println("Los signos no estan balanceados.");
                    break;

                case COUNT_ORDERED:
                    readingFile.readingContent(new File("texto.txt")); // se pasa el archivo de texto a leer
                    String contenido = readingFile.getContent();

                    System.out.println("CONTENIDO DEL ARCHIVO");
                    System.out.println(contenido);

                    System.out.println("---------------------------------------------------");
                    System.out.println("CONTENIDO DEL ARCHIVO LIMPIO");
                    String contenidoLimpio = readingFile.deletingSemicolons(contenido);
                    System.out.println(contenidoLimpio);

                    System.out.println("---------------------------------------------------");
                    System.out.println("CONTANDO PALABRAS");
                    readingFile.countWords(contenidoLimpio);

                    System.out.println("---------------------------------------------------");
                    System.out.println("ORDENANDO LAS PALABRAS");


                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != EXIT);
    }


    /**
     * Mostra el menú principal de la aplicación.
     */
    private static void menuPrincipal() {
        System.out.println("\n\nMENU PRINCIPAL");
        System.out.println("1. Invertir cadena.");
        System.out.println("2. Comprobar signos de puntuacioon balanceados.");
        System.out.println("3. Conteo de palabras y ordenado por clave.");


        System.out.println("0. Salir");
        System.out.print("\tOpcion: ");
    }

    /**
     * Lee un entero que representa una opción de menos.
     *
     * @return un entero, -1 si la entrada no se numerica
     */
    private static int elegirOpcion() {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(read.nextLine());
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        return opcion;
    }

}
