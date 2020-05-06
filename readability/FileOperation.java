package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperation {

    public static String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }
        return "";
    }

}