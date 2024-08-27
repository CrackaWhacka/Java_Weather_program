package A1_files;

import java.util.ArrayList;

abstract class Measurement {

    protected ArrayList<Double> data = new ArrayList<> ();
    protected String measurementUnit;

    public double getAverage() {
        double total = 0;

        if (data.isEmpty()) { return 0.0; }

        for (double i: data) {
            total += i;
        }   return (total / data.size());
    }

    public abstract void process(String line);

    public String toString() {
        return String.format("%.2f%s", this.getAverage(), measurementUnit);
    }
}
