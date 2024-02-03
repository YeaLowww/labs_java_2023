package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String url = "https://www.youtube.com/";

        try {
            Document document = Jsoup.connect(url).get();
            Map<String, Integer> tagFrequency = new HashMap<>();

            // Отримання тегів
            for (Element element : document.getAllElements()) {
                String tagName = element.tagName();
                tagFrequency.put(tagName, tagFrequency.getOrDefault(tagName, 0) + 1);
            }

            // Виведення в лексикографічному порядку
            System.out.println("Результати в лексикографічному порядку:");
            tagFrequency.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

            // Виведення в зростанні
            System.out.println("\nРезультати в порядку зростання по частоті:");
            tagFrequency.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
