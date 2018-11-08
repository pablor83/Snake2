package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class GraphicDesign extends JPanel {

	private Snake snake = new Snake();
	
	Color[] colorSnake = {new Color(000, 200, 000), Color.BLUE, Color.red}; 
	int setColorSnake = 0;

	GraphicDesign() {

		repaint();
	}
	
	public Snake snake() {
		
		return snake;
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

		g2d.drawString("X: " + snake.getXposition() + " Y: " + snake.getYposition(), 50, 50);
		
//		snake.constantSnakeLength();
		
		if (snake.snakeCollisionDetection() == true || snake.getListSnakeSize() == 0) {	
			
			int x = snake.getXposition();
			int y = snake.getYposition();
			
			int[] xP = { x + 10, x + 20, x + 40, x + 30, x + 50, x + 30, x + 40, x + 20, x + 10, x, x - 20, x - 10,
					x - 30, x - 10, x - 20, x };
			int[] yP = { y - 20, y, y - 20, y + 10, y + 20, y + 30, y + 60, y + 40, y + 60, y + 40, y + 60, y + 30,
					y + 20, y + 10, y - 20, y };
			
			setColorSnake = 2;

			GradientPaint gp = new GradientPaint(x, y, Color.yellow, x + 40, y + 60, Color.RED);
			g2d.setPaint(gp);
			g2d.fillPolygon(xP, yP, xP.length);

		}

		for (Rectangle rectSnakeList : snake.getRectSnakeList()) {

			g2d.setColor(colorSnake[setColorSnake]);

			g2d.fill(rectSnakeList);			
			
		}
		
		

		g2d.setColor(Color.lightGray);
		g2d.setStroke(new BasicStroke(18));
		g2d.drawRect(getWidth() / 2 - 250, getHeight() / 2 - 225, 500, 447);

		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(getWidth() / 2 - 240, getHeight() / 2 - 218, 481, 431);

		g2d.setColor(Color.red);
//		g2d.drawLine(getWidth() / 2 + 241, getHeight() / 2 - 214, getWidth() / 2 + 241, getHeight() / 2 + 209);
//		g2d.drawLine(getWidth() / 2 - 240, getHeight() / 2 - 214, getWidth() / 2 - 240, getHeight() / 2 + 209);
//		g2d.drawLine(getWidth() / 2 - 236, getHeight() / 2 - 218, getWidth() / 2 + 237, getHeight() / 2 - 218);
//		g2d.drawLine(getWidth() / 2 - 236, getHeight() / 2 + 213, getWidth() / 2 + 237, getHeight() / 2 + 213);

	}

}
