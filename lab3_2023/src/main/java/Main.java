public class Main {
    public static void main(String[] args) {
        int number = 1107;
        int С3 = number %3;
        int С17 = number %17;

        System.out.println(С3);
        System.out.println( С17);

        StringBuilder text = new StringBuilder("Це перше речення. Це друге речення. Це третє речення.");

        String[] sentences = text.toString().split("\\.");

        if (sentences.length > 1) {
            String[] firstSentenceWords = sentences[0].trim().split("\\s+");

            StringBuilder result = new StringBuilder();
            // Пройдемося по словах першого речення.
            for (String word : firstSentenceWords) {
                boolean wordFoundInOtherSentences = false;

                for (int i = 1; i < sentences.length; i++) {
                    if (sentences[i].contains(word)) {
                        wordFoundInOtherSentences = true;
                        break;
                    }
                }

                if (!wordFoundInOtherSentences) {
                    result.append(word).append(" ");
                }
            }
            if (result.length()>0){
                System.out.println("Слова, яких немає в інших реченнях: " + result.toString().trim());

            }else System.out.println("Немає такого слова ");
        } else {
            System.out.println("У тексті немає більше одного речення.");
        }
    }

}

