package readability;

public class IndexARI extends Index {
    @Override
    public double getIndexValue() {
        return 4.71 * numOfChars / numOfWordInSentences + 0.5 * numOfWordInSentences / numOfSentences - 21.43;
    }

    @Override
    String getDescription() {
        return "Automated Readability Index";
    }
}
