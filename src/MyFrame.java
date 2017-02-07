import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("MouseTest");
		 
        add(new MyPanel());
        setSize(new Dimension(300,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}
