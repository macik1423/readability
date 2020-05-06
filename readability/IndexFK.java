package readability;

public class IndexFK extends Index {

    @Override
    public double getIndexValue() {
        return 0.39 * numOfWordInSentences / numOfSentences + 11.8 * numOfSyllables / numOfWordInSentences - 15.59;
    }

    @Override
    String getDescription() {
        return "Flesch–Kincaid readability tests";
    }
}
