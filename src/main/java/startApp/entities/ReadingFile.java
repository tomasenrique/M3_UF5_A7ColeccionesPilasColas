package startApp.entities;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingFile {

    private File file;
    private String content;
    private HashMap<String, Integer> listContent; // para almacenar las palabras

    // Builders
    public ReadingFile() {
        this.content = "";
        listContent = new HashMap<>();
    }

    // Setter and Getter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, Integer> getListContent() {
        return listContent;
    }

    public void setListContent(HashMap<String, Integer> listContent) {
        this.listContent = listContent;
    }

    // Methods
    public String readingContent(File file) { // lectura de archivo de texto
        this.file = file; // Recibe el archivo de texto
        String line = null; // para almacenar linea de texto del archivo
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder contentAux = new StringBuilder();
        // carga el archivo de texto
        try {
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

    // limpiara el texto de puntos y comas(simbolos)
    public String deletingSemicolons(String text) {
        String all = "";
        all = text.replaceAll("[.,;]", ""); // eliminara los simbolos del texto
        all = all.replaceAll("\n", " "); // reemplazara los saltos de lineas por espacios
        return all;
    }

    // contara las palabras y las guarda en la lista
    public void countWords(String string) {
        String[] array = string.split(" ");
        for (String s : array) {
            if (!listContent.containsKey(s)) { // verifica si la palabra ya esta en la lista
                listContent.put(s, 1); // si no esta se agrega a la lista
            } else { // si ya esta aumenta su valor que es la cantidad de veces que aparece en la lectura
                listContent.put(s, listContent.get(s) + 1);
            }
        }
        // Mostrara la lista con el conteo de las palabras
        for (HashMap.Entry<String, Integer> s : listContent.entrySet()) {
            System.out.println("Clave: " + s.getKey() + " - Valor: " + s.getValue());
        }
    }





}
