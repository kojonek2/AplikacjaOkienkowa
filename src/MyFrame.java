import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		super("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setSize(300, 100);
		setLocation(500, 500);
		add(new JButton("Przycisk 1"));
		add(new JButton("Przycisk 2"));
		add(new JButton("Przycisk 3"));
		
		setVisible(true);
	}
}
