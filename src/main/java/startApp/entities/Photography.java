package startApp.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static startApp.methodsAux.Methods.numeroAleatorio;

public class Photography {
    private final int CANTIDAD_PHOTOS = 30; // Sera la cantidad de fotos
    private final int CANTIDAD_LIKES = 20; // Sera la cantidad de likes
    private final int START_RANDOM = 1; // Sera la cantidad de likes
    private final int END_RANDOM = 20; // Sera la cantidad de likes
    private HashMap<Integer, Boolean> photosJuan;
    private HashMap<Integer, Boolean> photosMaria;

    // Builders
    public Photography() {
        photosJuan = new HashMap();
        photosMaria = new HashMap<>();
        // Inicializa las listas
        for (int i = 0; i < CANTIDAD_PHOTOS; i++) {
            photosJuan.put(i + 1, false);
            photosMaria.put(i + 1, false);
        }
    }

    // Setter and Getters
    public HashMap<Integer, Boolean> getPhotosJuan() {
        return photosJuan;
    }

    public void setPhotosJuan(HashMap<Integer, Boolean> photosJuan) {
        this.photosJuan = photosJuan;
    }

    public HashMap<Integer, Boolean> getPhotosMaria() {
        return photosMaria;
    }

    public void setPhotosMaria(HashMap<Integer, Boolean> photosMaria) {
        this.photosMaria = photosMaria;
    }

    // Methods

    /**
     * Este metodo genera una cantidad de likes a una lista de fotografias
     *
     * @param listaFotos Sera la lista de fotos del usuarios
     */
    public void randomClicks(HashMap<Integer, Boolean> listaFotos) {
        for (int i = 0; i < CANTIDAD_LIKES; i++) {
            int clave = numeroAleatorio(START_RANDOM, END_RANDOM);
            if (listaFotos.containsKey(clave)) {
                listaFotos.put(clave, true);
            }
        }
    }

    /**
     * Este metodo Contara la cantida de fotos con like
     *
     * @param listaFotos Sera la lista de fotos del usuarios
     * @return
     */
    public int countLikes(HashMap<Integer, Boolean> listaFotos) {
        int cantidad = 0;
        for (int i = 0; i < 30; i++) {
            if (photosJuan.get(i + 1)) { // compara su el valor es igual a true
                cantidad++;
            }
        }
        return cantidad;
    }


    /**
     * Este metodo mostrara una lista de fotos con like
     *
     * @param listaFotos Sera la lista de fotos del usuarios
     */
    public void showPhotographys(HashMap<Integer, Boolean> listaFotos) {
        for (HashMap.Entry<Integer, Boolean> s : listaFotos.entrySet()) {
            if (s.getValue()) {
                System.out.println("Photography: " + s.getKey());
            }
        }
    }

    /**
     * Este metodo compara dos listas Key:Value por medio de su valor
     *
     * @param lista1 Sera una la primera lista Key:Value a comparar
     * @param lista2 Sera una la segunda lista Key:Value a comparar
     * @return Devolvera una lista de tipo enteros con las claves de fotos que son iguales
     */
    public ArrayList<Integer> comparedPhotos(HashMap<Integer, Boolean> lista1, HashMap<Integer, Boolean> lista2) {
        ArrayList<Integer> fotos = new ArrayList<>();
        int index = 0; // sera un indice para una de las listas a comparar
        for (HashMap.Entry<Integer, Boolean> entry1 : lista1.entrySet()) {
            index++;
            boolean value = entry1.getValue(); // Obtiene el valor de una lista para comparar con la otra lista
            int key = entry1.getKey(); // Obtiene la clave(Foto) para mostrar
            if (value == lista2.get(index)) {   //Compara los campos valor de cada lista para saber si son iguales.
                fotos.add(key); //si son iguales se guarda la clave en un arraylist para mostrar luego
            }
        }
        return fotos;
    }


    /**
     * Este metodo mostrara las fotos que le gustan a maria pero no a juan
     *
     * @param lista1 Sera una la primera lista Key:Value a comparar y devolvera con valores true
     * @param lista2 Sera una la segunda lista Key:Value a comparar y devolvera con valores false
     */
    public void comparedPhotography(HashMap<Integer, Boolean> lista1, HashMap<Integer, Boolean> lista2) {
        ArrayList<Integer> fotoslista1 = new ArrayList<>(); // juan
        ArrayList<Integer> fotoslista2 = new ArrayList<>(); // maria
        int index = 0; // sera un indice para una de las listas a comparar
        for (HashMap.Entry<Integer, Boolean> entry1 : lista1.entrySet()) {
            index++;
            if (entry1.getValue()) {   //Compara los campos valor de cada lista para saber si son iguales.
                fotoslista1.add(entry1.getKey());
            } else if (!lista2.get(index)) {
                fotoslista2.add(index);
            }
        }
        System.out.print("Las fotos que le gustan a Maria: ");
        System.out.println(fotoslista1);
        System.out.println();
        System.out.print("Las fotos que no le gustan a Juan: ");
        System.out.println(fotoslista2);
    }


}
