package startApp.view;

import startApp.entities.ContainerDeque;
import startApp.entities.Photography;
import startApp.entities.ReadingFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static startApp.methodsAux.Methods.textCenter;

public class Screen {

    private final static int STRING_INVERTED = 1;
    private final static int BALANCED_PUNCTUATION = 2;
    private final static int COUNT_LIKES = 3;
    private final static int PHOTOS_LIKES_BOTH = 4;
    private final static int PHOTOS_LIKES = 5;

    private final static int COUNT_ORDERED = 6;
    private final static int EXIT = 0;
    private final static Scanner read = new Scanner(System.in); // para la lectura de las opciones

    private ContainerDeque container; // contenedor de pilas
    private ReadingFile readingFile; // lectura de archivos de texto
    private Photography photography; // lista de fotografias  de juan y maria
    // Seran para obtener las lista de fotos de cada usuario
    private HashMap<Integer, Boolean> juan;
    private HashMap<Integer, Boolean> maria;

    // Builder
    public Screen() {
        container = new ContainerDeque();
        readingFile = new ReadingFile();
        photography = new Photography();
        juan = photography.getPhotosJuan();
        maria = photography.getPhotosMaria();
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
                    if (result) System.out.println("\tSignos de puntuacion balanceados.");
                    else System.out.println("\tLos signos no estan balanceados.");
                    break;

                case COUNT_LIKES:
                    textCenter("Juan realiza clicks a una lista de fotos", 50);
                    photography.randomClicks(juan);
                    System.out.println("A juan le gustan " + photography.countLikes(juan) + " Fotografias");
                    photography.showPhotographys(juan);
                    textCenter("-", 50);

                    System.out.println();

                    textCenter("Maria realiza clicks a una lista de fotos", 50);
                    photography.randomClicks(maria);
                    System.out.println("A Maria le gustan " + photography.countLikes(maria) + " Fotografias");
                    photography.showPhotographys(maria);
                    textCenter("-", 50);
                    break;

                case PHOTOS_LIKES_BOTH:
                    // Se obtiene las listas
                    juan = photography.getPhotosJuan();
                    maria = photography.getPhotosMaria();
                    // Se realiza clicks aleatoriamente
                    photography.randomClicks(juan);
                    photography.randomClicks(maria);
                    // se obtiene las fotos que les gusta a ambos usuarios
                    ArrayList<Integer>lista = photography.comparedPhotos(juan, maria);
                    System.out.print("A Maria y a Juan les gustas las siguentes fotos :" + lista);
                    break;

                case PHOTOS_LIKES:
                    // Se obtiene las listas
                    juan = photography.getPhotosJuan();
                    maria = photography.getPhotosMaria();
                    // Se realiza clicks aleatoriamente
                    photography.randomClicks(juan);
                    photography.randomClicks(maria);
                    // se compara las listas y se muestra una con valores true y otra con valores false
                    photography.comparedPhotography(juan, maria);
                    break;

                case COUNT_ORDERED:
                    readingFile.readingContent(new File("texto.txt")); // se pasa el archivo de texto a leer
                    String contenido = readingFile.getContent();

                    System.out.println("LEYENDO CONTENIDO DEL ARCHIVO");
                    System.out.println(contenido);

                    System.out.println("\n---------------------------------------------------");
                    System.out.println("ORDENANDO PALABRAS POR ORDEN ALFABETICO");
                    readingFile.countingOrdering(contenido);

                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("ORDENADO DESCENDENTE DE PALABRAS POR FRECUENCIA DE APARICION");
                    readingFile.descendingOrder();
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
        System.out.println("\n\n\nMENU PRINCIPAL");
        System.out.println("1. Invertir cadena.");
        System.out.println("2. Comprobar signos de puntuacioon balanceados.");
        System.out.println("3. Contador de LIKES.");
        System.out.println("4. Fotos que les gustan a maria y a juan.");
        System.out.println("5. Fotos que le gustan a maria pero no a Juan.");
        System.out.println("6. Conteo de palabras y ordenado por clave.");

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
