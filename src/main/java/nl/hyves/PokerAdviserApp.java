package nl.hyves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Poker adviser application.
 */
public class PokerAdviserApp {

    public static void main(String[] args)  {
        String dataFileName = "data.txt";
        if (args.length != 0) {
            dataFileName = args[0];

        }
        final Scanner scanner;
        try {
            scanner = new Scanner(new File(dataFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            while (scanner.hasNextLine()) {
                final String advice = PokerAdviser.advice(scanner.nextLine());
                System.out.println(advice);
            }
        } finally {
            scanner.close();
        }

    }

}
