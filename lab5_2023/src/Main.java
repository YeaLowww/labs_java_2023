import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Створюємо літери, слова, речення та текст
            Letter l1 = new Letter('H');
            Letter l2 = new Letter('e');
            Letter l3 = new Letter('l');
            Letter l4 = new Letter('l');
            Letter l5 = new Letter('o');

            Word word1 = new Word();
            word1.addLetter(l1);
            word1.addLetter(l2);
            word1.addLetter(l3);
            word1.addLetter(l4);
            word1.addLetter(l5);

            Sentence sentence1 = new Sentence();
            sentence1.addWord(word1);
            sentence1.addPunctuation(",");

            //Sentence sentence2 = new Sentence();
            //sentence2.addWord(word1);
            //sentence2.addPunctuation(",");

            Text text = new Text();
            text.addSentence(sentence1);
            //text.addSentence(sentence2);

            // Реалізуємо виконавчий метод для пошуку слова
            String result = findWordInText(text);

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static String findWordInText(Text text) throws Exception {
        if (text == null || text.getText().isEmpty()) {
            throw new Exception("Текст порожній або нульовий.");
        }

        // Отримуємо перше речення
        Sentence firstSentence = text.getSentences().get(0);
        String firstWord = firstSentence.getWords().get(0).getWord();

        // Перевіряємо кожне наступне речення на наявність слова
        for (int i = 1; i < text.getSentences().size(); i++) {
            Sentence sentence = text.getSentences().get(i);
            List<Word> words = sentence.getWords();
            for (Word word : words) {
                if (word.getWord().equals(firstWord)) {
                    return firstWord;
                }
            }
        }

        return "Слово не знайдено в наступних реченнях.";
    }
}
