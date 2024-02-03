package org.example;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Translator {
    private Map<String,String> dictionary;
    public Translator(){
        this.dictionary=new HashMap<>();
    }

    public void addTranslation(String englishWord, String ukrainianWord){
        dictionary.put(englishWord.toLowerCase(),ukrainianWord.toLowerCase());
    }
    public String translate(String inputPhrase){
        String[] words = inputPhrase.split("\\s+");
        StringBuilder translatedPhrase = new StringBuilder();
        for (String word :words) {
            String translateWord = dictionary.getOrDefault(word.toLowerCase(), word);
            translatedPhrase.append(translateWord).append(" ");
        }
        return translatedPhrase.toString().trim();
    }
}
