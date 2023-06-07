package ntou.cs.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyPointReader implements PointReader {

	private ArrayList<ColorPoint> points = new ArrayList<ColorPoint>();
	private String fileName;
	private Scanner input;

	public MyPointReader(String filename) {
		this.fileName = filename;
	}

	// enable user to open file
	public void openFile() {
		try {
			input = new Scanner(new File(fileName));
		} // end try
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		} // end catch
	} // end method openFile

	// read record from file
	public void readPoints() {

		while (input.hasNext()) {
			try {
				ColorPoint point = new ColorPoint();
				point.setX(input.nextInt());
				point.setY(input.nextInt());
				point.setColor(input.next());
				
				points.add(point);
			} // end try
			catch (NoSuchElementException elementException) {
				System.err.println("File improperly formed.");
				input.nextLine();
			} // end catch
			catch (IllegalStateException stateException) {
				System.err.println("Error reading from file.");
				System.exit(1);
			} // end catch
		} // end while

	} // end method readRecords

	public ArrayList<ColorPoint> getPoints() {
		return points;
	}

	// close file and terminate application
	public void closeFile() {
		if (input != null)
			input.close(); // close file
	} // end method closeFile
}
