import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> components;
    public Sentence() {
        this.components = new ArrayList<>();
    }

    // Додати слово до речення
    public void addWord(Word word) {
        components.add(word);
    }

    // Додати розділовий знак до речення
    public void addPunctuation(String punctuation) {
        components.add(punctuation);
    }

    // Отримати список слів
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object component : components) {
            if (component instanceof Word) {
                words.add((Word) component);
            }
        }
        return words;
    }
    // Отримати речення у вигляді рядка
    public String getSentence() {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (Object component : components) {
            if (component instanceof Word) {
                sentenceBuilder.append(((Word) component).getWord());
            } else if (component instanceof String) {
                sentenceBuilder.append((String) component);
            }
        }
        return sentenceBuilder.toString();
    }
}
