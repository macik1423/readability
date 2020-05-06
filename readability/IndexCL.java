package readability;


public class IndexCL extends Index {

    @Override
    public double getIndexValue() {
        double L = 1.0 * numOfChars / numOfWordInSentences * 100;
        double S = 1.0 * numOfSentences / numOfWordInSentences * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }

    @Override
    String getDescription() {
        return "Coleman–Liau index";
    }

}
