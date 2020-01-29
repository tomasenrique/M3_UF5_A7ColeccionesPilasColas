package startApp.methodsAux;

public class Methods {

    /**
     * Esto metodos se encargara de gererar una un numero aleatorio
     *
     * @param min sera la entrada minima dada
     * @param max sera la entrada maxima dada
     * @return devolvera un numero entero aleatorio entre un minimo y maxima  ambos incluidos
     */
    public static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }


    /**
     * Esta funcion servira pra centrar el texto como titulo
     *
     * @param cadenaTitulo Sera la cadena a centrar
     * @param tamanyo      Sera el tamaño de linea a agregar para centrar el titulo
     */
    public static void textCenter(String cadenaTitulo, int tamanyo) {
        System.out.println();
        int left = (tamanyo - cadenaTitulo.length()) / 2;
        int right = tamanyo - left - cadenaTitulo.length();
        String charArepetir = "-"; // linea de titulo para concatenar
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < left; i++) {
            buff.append(charArepetir);
        }
        buff.append(cadenaTitulo);
        for (int i = 0; i < right; i++) {
            buff.append(charArepetir);
        }
        System.out.println(buff.toString());
    }
}
