package ntou.cs.java;

import java.util.ArrayList;

public interface PointReader {
    public void openFile();
    public void readPoints();
    public ArrayList<ColorPoint> getPoints();
    public void closeFile();
}
