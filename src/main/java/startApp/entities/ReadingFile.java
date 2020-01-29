package startApp.entities;

import java.io.*;
import java.util.*;

public class ReadingFile {

    private File file;
    private String content;
    private TreeMap<String, Integer> listContent; // para almacenar las palabras

    // Builders
    public ReadingFile() {
        this.content = "";
        listContent = new TreeMap<>();
    }

    // Setter and Getter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    // Methods

    /**
     * Este metodo servira para poder cargar el archivo de texto
     *
     * @param file Sera la ruta de ubicion del archivo de texto pasado como parametro
     * @return Devolvera una cadena de texto de tipo string obtenida del archivo de texto
     */
    public String readingContent(File file) {
        this.file = file; // Recibe el archivo de texto y obtiene la informacion.
        String line; // Para almacenar el texto del archivo recido
        FileReader fileReader; // Permitira leer el contenido del archivo de texto
        BufferedReader bufferedReader; // Almacena en memoria el archivo de texto cargado
        StringBuilder contentAux = new StringBuilder(); // Para almacenar las cadenas de texto

        try {  // carga el archivo de texto
            fileReader = new FileReader(this.file);
            bufferedReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferedReader.readLine()) != null) { // lee el archivo
                    contentAux.append(line); // agrega linea por linea al aux
                    contentAux.append("\n"); // agrega el salto de linea
                }
            } catch (IOException ex) {
                System.out.println("ERROR: ex1" + ex);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: ex2" + e);
        }
        return this.content = contentAux.toString();
    }

    /**
     * Este metodo Llama a los metodos privados deletingSemicolons y countWords
     *
     * @param text Sera la cadena de texto obtenida de la lectura del archivo
     */
    public void countingOrdering(String text) {
        String contenido = deletingSemicolons(text);
        countWords(contenido);
    }

    /**
     * Este metodo limpiara el texto de puntos y comas(simbolos)
     *
     * @param text Sera la cadena de texto obtenida de la lectura del archivo
     * @return Devolvera una cadena de texto de tipo string para poder trabajar con ella.
     */
    private String deletingSemicolons(String text) {
        String all = "";
        all = text.replaceAll("[.,;]", ""); // eliminara los simbolos del texto
        all = all.replaceAll("\n", " "); // reemplazara los saltos de lineas por espacios
        return all;
    }


    /**
     * Este metodo contara las palabras y las guarda en la lista
     *
     * @param string Sera la cadena de texto(palabras) para guardar y ordenar
     */
    private void countWords(String string) {
        String[] array = string.split(" ");
        for (String s : array) {
            if (!listContent.containsKey(s)) { // verifica si la palabra ya esta en la lista
                listContent.put(s, 1); // si no esta se agrega a la lista
            } else { // si ya esta aumenta su valor que es la cantidad de veces que aparece en la lectura
                listContent.put(s, listContent.get(s) + 1);
            }
        }
        // Mostrara la lista con el conteo de las palabras ordenados
        for (HashMap.Entry<String, Integer> s : listContent.entrySet()) {
            System.out.println("Clave: " + s.getKey() + " - Valor: " + s.getValue());
        }
    }


}
