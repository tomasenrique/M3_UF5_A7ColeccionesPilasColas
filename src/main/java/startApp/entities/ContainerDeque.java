package startApp.entities;

import java.util.Deque;
import java.util.LinkedList;

public class ContainerDeque {

    private Deque<Character> letters; // To stock the characters

    // Builder
    public ContainerDeque() {
        this.letters = new LinkedList<>();
    }

    // Methods

    /**
     * Este metodo invertira una cadena dada
     *
     * @param sequence Sera la cadena de texto ingresada
     * @return Devolvera una cadena de tipo String
     */
    public String reverseSequence(String sequence) {
        char character;
        StringBuilder compose = new StringBuilder();
        String string;

        // Decompose string on characters and save in the stack
        for (int i = 0; i < sequence.length(); i++) {
            character = sequence.charAt(i);
            letters.push(character);
        }

        // to compose the inverted string
        for (int i = 0; i < sequence.length(); i++) {
            compose.append(letters.pop());
        }
        string = compose.toString(); // To change of StringBuilder to String

        return string;
    }


}



