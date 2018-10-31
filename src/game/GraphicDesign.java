package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class GraphicDesign extends JPanel {

	private Snake snake = new Snake();

	GraphicDesign() {

		repaint();
	}

	public void startMovingRight() {

		snake.goRight();

	}

	public void startMovingLeft() {

		snake.goLeft();

	}

	public void startMovingUp() {

		snake.goUp();

	}

	public void startMovingDown() {

		snake.goDown();

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		for (Rectangle rectSnakeList : snake.getRectSnakeList()) {

			g2d.setColor(Color.BLUE);

			g2d.fill(rectSnakeList);
		}

		if (snake.getListSnakeSize() > snake.getSnakeLength())
			snake.removeItemFromListSnake(0);

		g2d.setColor(Color.lightGray);
		g2d.setStroke(new BasicStroke(20));
		g2d.drawRect(getWidth() / 2 - (500 / 2), getHeight() / 2 - (434 / 2), 500, 434);

		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(getWidth() / 2 - (476 / 2), getHeight() / 2 - (420 / 2), 476, 420);

	}

}
