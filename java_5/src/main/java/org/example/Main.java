package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //String location = getUserInput("Введіть розташування файлу куди зберігати: ");
        //String fileName = getUserInput("Введіть ім'я файлу: ");
        //String path = location + fileName;

        try {
            System.out.print("Введіть шлях до файлу: ");

            BufferedReader reader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));

            String line;
            String maxWordCountLine = "";
            int maxWordCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > maxWordCount) {
                    maxWordCount = words.length;
                    maxWordCountLine = line;
                }
            }

            System.out.println("Рядок з максимальною кількістю слів: " + maxWordCountLine);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
// Приклад вхідного рядка та ключового символу

        String inputString = Crypto.readFromFile("src/main/resources/input.txt");
        if (inputString.isEmpty()) {
            System.out.println("Could not read input from file.");
            return;
        }
        char keySymbol = 'A';
        try {


            // Шифрування
            String encryptedString = Crypto.encrypt(inputString, keySymbol);
            System.out.println("Encrypted: " + encryptedString);
            //Crypto.writeToFile(path, encryptedString);
            Crypto.writeToFile("src/main/resources/encrypted.txt", encryptedString);
            // Дешифрування
            String decryptedString = Crypto.decrypt(encryptedString, keySymbol);
            System.out.println("Decrypted: " + decryptedString);
        }catch (Exception e) {
            System.err.println("Помилка при шифруванні");
        }
    }

    private static String getUserInput(String prompt) {
        // Вивести повідомлення для користувача та отримати введені дані
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim(); // Видалити зайві пробіли
    }
}