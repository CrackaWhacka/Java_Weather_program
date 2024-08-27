package A1_files;

import java.util.ArrayList;

public class Region {

    private String regionName = "UNKNOWN";
    private ArrayList<Measurement> regionData = new ArrayList<Measurement>();

    public Region() {}
    public Region(String regionName) { this.regionName = regionName; }


    public void process(String RainfallData) {
        Rainfall Rainfall_obj = new Rainfall(RainfallData);
        regionData.add(Rainfall_obj);
    }

    public void process(String RainfallData, String SunshineData) {
    process(RainfallData);
    Sunshine Sunshine_obj = new Sunshine(SunshineData);
    regionData.add(Sunshine_obj);
    }

    public void process(String RainfallData, String SunshineData, String minTemperature) {
        process(RainfallData, SunshineData);
        Temperature Temp_obj = new Temperature(minTemperature);
        regionData.add(Temp_obj);
    }

    public void process(String RainfallData, String SunshineData, String minTemperature, String maxTemperature) {
        process(RainfallData, SunshineData, minTemperature);
        Temperature Temp_obj = new Temperature(maxTemperature);
        regionData.add(Temp_obj);
    }

    public double getAverage(int coloumn) { return regionData.get(coloumn).getAverage(); }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%16s|", regionName));

        for (int i = 0; i < regionData.size(); i++) {
            sb.append(String.format("%16s|", regionData.get(i)));
        } return sb.toString();
    }

}
