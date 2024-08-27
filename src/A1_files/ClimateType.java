package A1_files;

import java.util.Arrays;

public enum ClimateType {
    RAINFALL,
    RAINFALL_SUNSHINE,
    RAINFALL_SUNSHINE_TEMPERATURE,
    ALL;

    private String[] names = new String[]{"Rainfall", "Sunshine", "Min.Temperature", "Max.Temperature"};

    public String[] getColumnNames() {
        //Find the position of the constant.
        int indexOfConstant = this.ordinal();

        return Arrays.copyOf(names, indexOfConstant+1);
    }

    public static ClimateType fromInt(int value) {
        return ClimateType.values()[value];
    }
}