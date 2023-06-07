package ntou.cs.java;

import java.util.ArrayList;

public interface PointWriter {
    public void openFile();
    public void writePoints(ArrayList<ColorPoint> points);
    public void closeFile();
}
