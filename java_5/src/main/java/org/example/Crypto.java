package org.example;
import java.io.*;


public class Crypto {

    public static String encrypt(String input, char keySymbol) {
        try (CharArrayWriter charArrayWriter = new CharArrayWriter();
             PrintWriter printWriter = new PrintWriter(charArrayWriter)) {

            for (char c : input.toCharArray()) {
                // Замінюємо кожен символ на код, більший на значення коду ключового символу
                printWriter.write(c + keySymbol + " ");
            }

            return charArrayWriter.toString();
        }
    }

    public static String decrypt(String encryptedInput, char keySymbol) {
        try (StringReader stringReader = new StringReader(encryptedInput);
             BufferedReader bufferedReader = new BufferedReader(stringReader)) {

            StringBuilder decryptedString = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Розділяємо рядок на числа та декодуємо кожен символ
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    if (!number.isEmpty()) {
                        int code = Integer.parseInt(number) - (int) keySymbol;
                        decryptedString.append((char) code);
                    }
                }
            }

            return decryptedString.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String readFromFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
