package A1_files;

import java.util.ArrayList;

public class Temperature extends Measurement{


    public Temperature(String dataLine) {
        super.measurementUnit = "° C";
        process(dataLine);
    }

    @Override
    public void process(String dataLine) {
        ArrayList<String> dataList = new ArrayList<>(java.util.List.of(dataLine.split("\t")));

        for (int i = 0; i < dataList.size(); i++) {
            double convertedNum = Double.parseDouble(dataList.get(i));
            if (convertedNum > 0) {
                super.data.add(i, convertedNum);
            } else if (convertedNum < 0) {super.data.add(i, 0.0); }
        }
    }
}
