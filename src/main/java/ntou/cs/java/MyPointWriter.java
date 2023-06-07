package ntou.cs.java;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.ArrayList;

public class MyPointWriter implements PointWriter {

	private String fileName;
	private Formatter output;

	public MyPointWriter(String filename) {
		this.fileName = filename;
	}

	public void openFile() {
		try {			
			output = new Formatter(fileName);	
		} // end try
		catch (SecurityException securityException) {
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		} // end catch
		catch (FileNotFoundException filesNotFoundException) {
			System.err.println("Error creating file.");
			System.exit(1);
		}
	}

	public void writePoints(ArrayList<ColorPoint> points) {

		for (ColorPoint point: points) {
			output.format("%d %d %s%n", point.getX(), point.getY(), point.getColor());
		}
	}

	public void closeFile() {
		if (output != null)
			output.close();
	} // end method closeFile
	
}
