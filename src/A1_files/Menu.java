package A1_files;

import jdk.jshell.StatementSnippet;

import java.util.Scanner;

public class Menu {

    public void displayMenu() {

        System.out.println("Choose the types of a data to analyse:");
        System.out.println("0 - Rainfall only\n" +
                "1 - Rainfall and Sunshine\n" +
                "2 - Rainfall, Sunshine and Minimum Temperature\n" +
                "3 - All data");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        Statistics stats = null;

        switch (choice) {
            case "0" -> {
                stats = new Statistics(ClimateType.RAINFALL);
            }
            case "1" -> {
                 stats = new Statistics(ClimateType.RAINFALL_SUNSHINE);
            }
            case "2" -> {
                 stats = new Statistics(ClimateType.RAINFALL_SUNSHINE_TEMPERATURE);
            }
            case "3" -> {
                 stats = new Statistics(ClimateType.ALL);
            }
        }

        Scanner inputFileName = new Scanner(System.in);

        do  {
            System.out.println("Enter data file name (Enter 'EXIT' to finish):");
            String fileName = inputFileName.nextLine();
            if (!(fileName.equals("EXIT"))) { stats.process(fileName); }
            else break;
        } while (true);

        stats.displayTable();
    }
}
