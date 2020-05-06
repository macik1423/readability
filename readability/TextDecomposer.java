package readability;

public class TextDecomposer {
    protected static int numOfWordInSentences;
    protected static int numOfSentences;
    protected static int numOfChars;
    protected static int numOfSyllables;
    protected static int numOfPolysyllables;

    public TextDecomposer() {
    }

    public void decomposeText(String[] args) {
        String text = FileOperation.readFile(args[0]);
        String[] sentences = text.split("[!.?]");
        numOfSentences = sentences.length;
        numOfChars = text.replaceAll("\\s", "").length();
        for (String sentence : sentences) {
            String[] wordsInSentence = sentence.trim().split("[ \\u00a0]");
            numOfWordInSentences += wordsInSentence.length;
            for (String word : wordsInSentence) {
                numOfSyllables += countSyllables(word);
                if (countSyllables(word) > 2) {
                    numOfPolysyllables++;
                }
            }
        }
    }

    private int countSyllables(String word) {
        word = word.toLowerCase();
        int count = 0;
        char[] wordToArray = word.toCharArray();
        if (isContainVowel(wordToArray[0])) {
            count++;
        }
        for (int i = 1; i < wordToArray.length; i++) {
            if (isContainVowel(wordToArray[i]) && !isContainVowel(wordToArray[i - 1])) {
                count++;
            }
        }
        if (wordToArray[wordToArray.length - 1] == 'e') {
            count--;
        }
        if (count == 0) {
            count++;
        }
        return count;
    }

    private boolean isContainVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (char vowel : vowels) {
            if(vowel == c) {
                return true;
            }
        }
        return false;
    }

    public void getStatistics() {
        System.out.println("Words: " + numOfWordInSentences);
        System.out.println("Sentences: " + numOfSentences);
        System.out.println("Characters: " + numOfChars);
        System.out.printf("Syllables: %d\n", numOfSyllables);
        System.out.printf("Polysyllables: %d\n", numOfPolysyllables);
    }

}
