package A1_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {

    private ArrayList<Region> regions = new ArrayList<Region>();
    private String[] columnNames;
    private ClimateType climateType;

    public Statistics(ClimateType climateType) {
        this.columnNames = climateType.getColumnNames();
        this.climateType = climateType;
    }

    public void process(String regionDataFileName) {
        Scanner input = null;
        try {
            String regionName = regionDataFileName.substring(
                    regionDataFileName.lastIndexOf("/") + 1,
                    regionDataFileName.length() - 4);

            ArrayList<String> dataList = new ArrayList<String>();
            input = new Scanner(new File(regionDataFileName));

            input.useDelimiter("\n");
            while (input.hasNextLine()) {
                dataList.add(input.next());
            }

            Region region = new Region(regionName);

            switch (columnNames.length-1) {
                case 0 -> region.process(dataList.get(0));
                case 1 -> region.process(dataList.get(0), dataList.get(1));
                case 2 -> region.process(dataList.get(0), dataList.get(1), dataList.get(2));
                case 3 -> region.process(dataList.get(0), dataList.get(1), dataList.get(2), dataList.get(3));
            }
            regions.add(region);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        finally { if (input != null) { input.close(); } }
    }

    public void displayTable() {

        System.out.println("Average climatological data for selected locations throughout NZ\n" +
                "================================================================\n" +
                "================================================================");

        StringBuilder rowSperator = new StringBuilder("=================");
        StringBuilder sb = new StringBuilder("\n          Region|");
        StringBuilder dataRow = new StringBuilder();

        for (String columnName : columnNames) {
            sb.append(String.format("%16s|",columnName));
            rowSperator.append("=================");}

        for (Region region : regions) {
            dataRow.append(region.toString() + "\n"); }

        System.out.println(sb.toString());
        System.out.println(rowSperator.toString());
        System.out.println(dataRow.deleteCharAt(dataRow.length()-1).toString());
    }

    public static void main(String[] args) {

        Statistics s = new Statistics(ClimateType.ALL);
        s.process("text_files/files/Nelson.txt");
        s.process("text_files/files/Auckland.txt");
        s.process("text_files/files/Hamilton.txt");
        s.process("text_files/files/Masterton.txt");
        s.displayTable();
    }

}
