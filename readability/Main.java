package readability;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextDecomposer textDecomposer = new TextDecomposer();
        textDecomposer.decomposeText(args);
        textDecomposer.getStatistics();

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String option = sc.nextLine();
        if ("all".equals(option)) {
            System.out.println(Index.getAllDescriptions());
        } else {
            System.out.println(Index.getResult(TypeIndex.valueOf(option).getTypeIndex()));
        }

        System.out.println(Index.getAvg());

    }


}
