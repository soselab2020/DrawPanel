package ntou.cs.java;

import java.util.ArrayList;

public class FakePointReader implements PointReader {

	// enable user to open file
	public void openFile() {
		System.out.println("Open!");
	} // end method openFile

	// read record from file
	public void readPoints() {
		System.out.println("Read!");
	} // end method readRecords

	public ArrayList<ColorPoint> getPoints() {

		System.out.println("Get!");
		ArrayList<ColorPoint> points = new ArrayList<ColorPoint>();
		ColorPoint point = new ColorPoint();
		point.setX(100);
		point.setY(100);
		point.setColor("B");

		points.add(point);
		return points;
	}

	// close file and terminate application
	public void closeFile() {
		System.out.println("Closed!");
	} // end method closeFile
}
