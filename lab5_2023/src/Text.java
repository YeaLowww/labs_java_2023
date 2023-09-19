import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text() {
        this.sentences = new ArrayList<>();
    }

    // Додати речення до тексту
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    // Отримати список речень
    public List<Sentence> getSentences() {
        return sentences;
    }

    // Отримати текст у вигляді рядка
    public String getText() {
        StringBuilder textBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            textBuilder.append(sentence.getSentence()).append(" "); // Додати пробіл між реченнями
        }
        return textBuilder.toString().trim(); // Видалити зайвий пробіл в кінці
    }
}
