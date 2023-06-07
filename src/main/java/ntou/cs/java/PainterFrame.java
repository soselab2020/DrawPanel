package ntou.cs.java;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterFrame extends JFrame {

	private final JButton loadButton;
	private final JButton saveButton;
	private final PaintPanel paintPanel;

	public PainterFrame(PointReader reader, PointWriter writer) {
		super("An enhanced paint program");

		loadButton = new JButton("Load from File");
		loadButton.addActionListener(new ImportHandler());

		saveButton = new JButton("Save to File");
		saveButton.addActionListener(new ImportHandler());

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1,1));
		menuPanel.add(saveButton);
		menuPanel.add(loadButton);
		add(menuPanel, BorderLayout.SOUTH);

		paintPanel = new PaintPanel(reader, writer); // create paint panel
		add(paintPanel, BorderLayout.CENTER); // in center
	}

	private class ImportHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(loadButton)) {
				paintPanel.load();
			} else if (e.getSource().equals(saveButton)) {
				paintPanel.save();
			}
		}
	}

} 
