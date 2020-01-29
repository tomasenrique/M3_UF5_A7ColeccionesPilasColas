package startApp.entities;

import java.util.Deque;
import java.util.LinkedList;

public class ContainerDeque {

    private Deque<Character> letters; // To stock the characters

    // Builder
    public ContainerDeque() {
        this.letters = new LinkedList<>();
    }

    public Deque<Character> getLetters() {
        return letters;
    }

    public void setLetters(Deque<Character> letters) {
        this.letters = letters;
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


    /**
     * Este metodo servira para poder verificar si los signos de puntuacion de una cadena estan balanceados
     *
     * @param sequence Sera la cadena a verificar
     * @return Devolvera true si la cadena esta balanceada o false si no lo esta
     */
    public boolean balancedPunctuationSign(String sequence) {
        char character;
        boolean balanced = false;
        // Decompose string on characters and save in the stack
        for (int i = 0; i < sequence.length(); i++) {
            character = sequence.charAt(i);
            letters.push(character);
        }
        // Check if the content of the chain is correct
        for (int i = 0; i < letters.size(); i++) {
            if (letters.getFirst().equals('}') && letters.getLast().equals('{')) balanced = true;
            if (letters.getFirst().equals(')') && letters.getLast().equals('(')) balanced = true;
            if (letters.getFirst().equals(']') && letters.getLast().equals('[')) balanced = true;
        }
        letters.clear(); // Clean the stack to verify another new chain
        return balanced;
    }


}



