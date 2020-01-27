package startApp.view;

import startApp.entities.ContainerDeque;

import java.util.Scanner;

public class Screen {

    private final static int STRING_INVERTED = 1;
    private final static int BALANCED_PUNCTUATION = 2;


    private final static int EXIT = 0;
    private final static Scanner read = new Scanner(System.in); // para la lectura de las opciones

    private ContainerDeque container;

    // Builder
    public Screen() {
        container = new ContainerDeque();
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
