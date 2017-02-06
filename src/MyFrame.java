import java.awt.FlowLayout;
import java.io.File;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Rysowanie");
		
		setLayout(new FlowLayout());
		
		File imageFile = new File("java.jpg");
		JPanel panel1 = new MyPanel(imageFile);
		JPanel panel2;
		URL imageUrl;
		try {
			imageUrl = new URL("http://www.minecraftman.com/wp-content/uploads/2013/10/64-bit-Java.jpg");
			panel2 = new MyPanel(imageUrl);
			add(panel1);
			add(panel2);
		} catch (Exception e) {
			System.err.println("Błąd wczytywania URL");
			e.printStackTrace();
		}


		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
