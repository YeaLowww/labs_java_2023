package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        populateDictionary(translator);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть фразу англ: ");
        String inputPhrase = scanner.nextLine();

        String translatedPhrase = translator.translate(inputPhrase);
        System.out.println("Переклад укр: " + translatedPhrase);
        populateDictionaryFromInput(translator);

        System.out.print("Введіть фразу англ: ");
        String inputPhrase2 = scanner.nextLine();

        String translatedPhrase2 = translator.translate(inputPhrase2);
        System.out.println("Переклад укр: " + translatedPhrase2);
    }

    private static void populateDictionary(Translator translator) {
        translator.addTranslation("hello", "привіт");
        translator.addTranslation("world", "світ");
    }

    private static void populateDictionaryFromInput(Translator translator) {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Введіть слово англ: ");
            String englishWord = scanner.nextLine();

            System.out.print("Введіть слово укр: ");
            String ukrainianWord = scanner.nextLine();
            translator.addTranslation(englishWord, ukrainianWord);

            System.out.print("Хочете ввести ще слово? (y/n): ");
            addMore = scanner.nextLine().toLowerCase();
        } while (addMore.equals("y"));
    }
}
