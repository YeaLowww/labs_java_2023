public class Main {
    public static String findMinUniqueCharsWord(String input) {
        String[] words = input.split("\\s+");
        String result = null;
        int minUniqueChars = Integer.MAX_VALUE;

        for (String word : words) {
            int uniqueChars = countUniqueChars(word);
            if (uniqueChars < minUniqueChars) {
                minUniqueChars = uniqueChars;
                result = word;
            }
        }

        return result;
    }

    private static int countUniqueChars(String word) {
        boolean[] charExists = new boolean[256];
        for (char c : word.toCharArray()) {
            charExists[c] = true;
        }

        int uniqueChars = 0;
        for (boolean exists : charExists) {
            if (exists) {
                uniqueChars++;
            }
        }
        return uniqueChars;
    }


    public static void main(String[] args) {
        String input = "This is a sample string with some words";
        String minimalUniqueCharsWord = findMinUniqueCharsWord(input);
        System.out.println("Word with minimal unique characters: " + minimalUniqueCharsWord);
    }
}
