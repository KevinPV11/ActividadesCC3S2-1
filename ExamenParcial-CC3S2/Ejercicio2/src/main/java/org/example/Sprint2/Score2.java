package org.example.Sprint2;


import java.util.ArrayList;
import java.util.List;

public class Score2 {
    // La palabra correcta
    private final String correct;
    // La lista de resultados (letras evaluadas)
    private final List<Letter2> results = new ArrayList<>();
    // La posición actual en la palabra
    private int position;

    // Constructor que recibe la palabra correcta
    public Score2(String correct) {
        this.correct = correct;
    }

    // Devuelve la letra evaluada en una posición específica
    public Letter2 letter(int position) {
        return results.get(position);
    }

    // Evalúa un intento y actualiza la puntuación
    public void assess(String attempt) {
        for (char current : attempt.toCharArray()) {
            // Agregamos el resultado de la evaluación a la lista
            results.add(scoreFor(current));
            position++;
        }
    }

    // Comprueba si una letra es correcta en la posición actual
    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }

    // Comprueba si una letra aparece en la palabra correcta
    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    // Evalúa una letra y devuelve su puntuación
    private Letter2 scoreFor(char current) {
        if (isCorrectLetter(current)) {
            return Letter2.CORRECT;
        }
        if (occursInWord(current)) {
            return Letter2.PART_CORRECT;
        }
        return Letter2.INCORRECT;
    }

    public List<Letter2> getResults() {
        return results;
    }
}

