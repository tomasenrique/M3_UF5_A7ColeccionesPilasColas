package startApp.view;

import startApp.entities.ContainerDeque;

import java.util.Scanner;

public class Screen {

    private final static int STRING_INVERTED = 1;


    private final static int EXIT = 0;
    private final static Scanner read = new Scanner(System.in); // para la lectura de las opciones


    // Builder
    public Screen() {

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
                    String cadena;
                    ContainerDeque container =  new ContainerDeque();
                    System.out.print("Ingrese la cadena a invertir: ");
                    cadena = read.nextLine();
                    cadena = container.reverseSequence(cadena);
                    System.out.println(cadena);
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
