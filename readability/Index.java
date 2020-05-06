package readability;

import java.util.HashMap;
import java.util.Map;

abstract class Index extends TextDecomposer {
    public static Map<Long, Integer> scoreAge;

    static {
        scoreAge = new HashMap<>();
        scoreAge.put(1L, 6);
        scoreAge.put(2L, 7);
        scoreAge.put(3L, 9);
        scoreAge.put(4L, 10);
        scoreAge.put(5L, 11);
        scoreAge.put(6L, 12);
        scoreAge.put(7L, 13);
        scoreAge.put(8L, 14);
        scoreAge.put(9L, 15);
        scoreAge.put(10L, 16);
        scoreAge.put(11L, 17);
        scoreAge.put(12L, 18);
        scoreAge.put(13L, 24);
        scoreAge.put(14L, 24);
    }

    abstract double getIndexValue();

    abstract String getDescription();

    public static String getAvg() {
        double sum = 0;
        for (TypeIndex typeIndex : TypeIndex.values()) {
            sum += scoreAge.get(Math.round(typeIndex.getTypeIndex().getIndexValue()));
        }
        double avg = sum / TypeIndex.values().length;
        return String.format("This text should be understood in average by %.2f year olds.", avg);
    }

    public static String getResult(Index index) {
        return String.format("%s: %.2f (about %s year olds).",
                index.getDescription(),
                index.getIndexValue(),
                scoreAge.get(Math.round(index.getIndexValue())));
    }

    public static String getAllDescriptions() {
        StringBuilder sb = new StringBuilder();
        for (TypeIndex typeIndex : TypeIndex.values()) {
            sb.append(getResult(typeIndex.getTypeIndex()));
            sb.append("\n");
        }
        return sb.toString();
    }

}
