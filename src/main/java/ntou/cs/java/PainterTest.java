package ntou.cs.java;

import javax.swing.JFrame;

public class PainterTest {
	public static void main(String[] args) {
		PointReader reader = new MyPointReader("points.txt");
		PointWriter writer = new MyPointWriter("points.txt");

		PainterFrame application = new PainterFrame(reader, writer);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 200); // set frame size
		application.setVisible(true); // display frame
	} // end main

}
