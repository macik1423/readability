package readability;

public class IndexSMOG extends Index {

    @Override
    public double getIndexValue() {
        return 1.043 * Math.sqrt(numOfPolysyllables * 30.0 / numOfSentences) + 3.1291;
    }

    @Override
    String getDescription() {
        return "Simple Measure of Gobbledygook";
    }
}
