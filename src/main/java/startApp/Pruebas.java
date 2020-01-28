package startApp;

import startApp.entities.ReadingFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pruebas {
    public static void main(String[] args) {

/*        File texto = null;
        texto = new File ("texto.txt");

        Archivo archivo = new Archivo(texto);

        System.out.println(archivo.getContenido());
        System.out.println("-----------------");
        System.out.println(archivo.getPalabras());

        System.out.println("-----------------");
        System.out.println(archivo.getCaracteres());

        System.out.println("-----------------");
        System.out.println(archivo.getLineas());

        System.out.println("-----------------");
        System.out.println(archivo.getCaracteres());*/



        ReadingFile readingFile = new ReadingFile();
        readingFile.readingContent(new File("texto.txt"));


        String contenido = readingFile.getContent();
        System.out.println("CONTENIDO DEL ARCHIVO");
        System.out.println(contenido);

        System.out.println("-----------------------");

        System.out.println("CONTENIDO DEL ARCHIVO LIMPIO");
        String contenidoLimpio = readingFile.deletingSemicolons(contenido);
        System.out.println(contenidoLimpio);

        System.out.println("-----------------------");
        System.out.println("CONTANDO PALABRAS");
        readingFile.countWords(contenidoLimpio);


        System.out.println("-----------------------");
        System.out.println("ORDENANDO LAS PALABRAS");







































/*        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("texto.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }*/












     /*   String str4 = "En un lugar de la mancha estaba tomas, de aqui; en un lugar, tomas.\n" +
                        "esta es la segunda linea.\n" +
                        "esta es la tercera linea.";
        String resultado1 = comprobar(str4);
        System.out.println("-------------------");
        System.out.println(resultado1);*/
    }

/*    public static String comprobar(String elem){
        String all = "";
        System.out.println("Cadena: " +elem);
        System.out.println("-------------------");
        all = elem.replaceAll("[.,;]", ""); // eliminara los simbolos del texto
        return all;
    }*/
}
