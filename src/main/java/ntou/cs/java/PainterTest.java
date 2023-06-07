package ntou.cs.java;

import javax.swing.JFrame;

public class PainterTest {
	public static void main(String[] args) {
		PointReader reader = new FakePointReader();
		PointWriter writer = new FakePointWriter();

		PainterFrame application = new PainterFrame(reader, writer);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 200); // set frame size
		application.setVisible(true); // display frame
	} // end main

}
