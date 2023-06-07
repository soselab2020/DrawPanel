package ntou.cs.java;

import java.util.ArrayList;

public class FakePointWriter implements PointWriter {

	public void openFile() {
		System.out.println("Open!");
	}

	public void writePoints(ArrayList<ColorPoint> points) {
		System.out.println("Write!");
	}

	public void closeFile() {
		System.out.println("Closed!");
	} // end method closeFile
	
}
