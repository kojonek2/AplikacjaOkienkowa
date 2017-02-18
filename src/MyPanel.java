import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	private static final int RECT_WIDTH = 10;
	private static final int RECT_HEIGHT = 10;

	private int draggingOffsetOfRectCornerX;
	private int draggingOffsetOfRectCornerY;
	private Point draggedRectangle;

	List<Point> points = new ArrayList<Point>();

	public MyPanel() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
		drawRectangles(g2d);
	}

	private void drawRectangles(Graphics2D g2d) {
		for (Point p : points) {
			int x = (int) p.getX();
			int y = (int) p.getY();
			g2d.fillRect(x, y, RECT_WIDTH, RECT_HEIGHT);
		}
	}

	private boolean clickedOnRectangle(MouseEvent event) {
		boolean clickedOnRectangle = false;
		for (Point point : points) {
			if (isRectangleClicked(point, event)) {
				clickedOnRectangle = true;
			}
		}
		return clickedOnRectangle;
	}

	private void addRectangle(MouseEvent e) {
		int x = e.getX() - RECT_WIDTH / 2;
		int y = e.getY() - RECT_HEIGHT / 2;
		points.add(new Point(x, y));
		repaint();
	}

	private boolean isRectangleClicked(Point p, MouseEvent event) {
		if (event.getX() <= p.getX() + RECT_WIDTH && event.getX() >= p.getX() && event.getY() <= p.getY() + RECT_HEIGHT
				&& event.getY() >= p.getY()) {
			return true;
		}
		return false;
	}

	private void startDragging(MouseEvent event) {
		if (points.size() == 0)
			return;
		for (Point point : points) {
			if (isRectangleClicked(point, event)) {
				draggingOffsetOfRectCornerX = event.getX() - (int) point.getX();
				draggingOffsetOfRectCornerY = event.getY() - (int) point.getY();
				draggedRectangle = point;
			}
		}
	}

	private void stopDragging(MouseEvent event) {
		draggedRectangle = null;
	}

	private void updateDraggedRectangle(MouseEvent event) {
		if (draggedRectangle == null)
			return;
		int newXOfRectCorner = event.getX() - draggingOffsetOfRectCornerX;
		int newYOfRectCorner = event.getY() - draggingOffsetOfRectCornerY;
		draggedRectangle.x = newXOfRectCorner;
		draggedRectangle.y = newYOfRectCorner;
		repaint();
	}

	private void removeRectangleForEvent(MouseEvent event) {
		for (int i = points.size() - 1; i >= 0; i--) {
			Point point = points.get(i);
			if (isRectangleClicked(point, event)) {
				points.remove(i);
				repaint();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			removeRectangleForEvent(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			if (clickedOnRectangle(e)) {
				startDragging(e);
			} else {
				addRectangle(e);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		stopDragging(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		updateDraggedRectangle(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
