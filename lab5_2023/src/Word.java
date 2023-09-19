import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters;

    public Word() {
        this.letters = new ArrayList<>();
    }
    // Додати літеру до слова
    public void addLetter(Letter letter) {
        letters.add(letter);
    }
    // Отримати слово у вигляді рядка
    public String getWord() {
        StringBuilder wordBuilder = new StringBuilder();
        for (Letter letter : letters) {
            wordBuilder.append(letter.getCharacter());
        }
        return wordBuilder.toString();
    }
}
