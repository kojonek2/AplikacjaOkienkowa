import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private BufferedImage image; 
	
	public MyPanel(File imageFile) {
		super();
		
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Błąd wczytywania obrazka");
			e.printStackTrace();
		}
		
		Dimension dimesnion = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimesnion);
	}
	
	public MyPanel(URL imageUrl) {
		super();
		
		try {
			image = ImageIO.read(imageUrl);
		} catch (IOException e) {
			System.err.println("Błąd wczytywania obrazka");
			e.printStackTrace();
		}
		
		Dimension dimesnion = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimesnion);
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
}
