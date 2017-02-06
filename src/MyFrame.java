import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Rysowanie");
		JPanel panel = new MyPanel();
		JPanel pane2 = new MyPanel();
		setLayout(new FlowLayout());

		add(panel);
		add(pane2);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
