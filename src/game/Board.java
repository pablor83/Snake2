package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Board extends JPanel {

	private Snake snake = new Snake();

	private Color[] colorSnake = { new Color(000, 200, 000), Color.BLUE, Color.red };
	private int setColorSnake = 0;

	private boolean xRight = false;
	private boolean xLeft = false;
	private boolean yUp = false;
	private boolean yDown = false;

	private boolean startCountdown = false;
	private int coutdownValue;

	Board() {

		addKeyboardSteering();
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

	public void setColorSnake(int i) {

		setColorSnake = i;
	}

	public void setStartCountdown(boolean b) {

		startCountdown = b;
	}

	public void setCountdownValue(int i) {

		coutdownValue = i;
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawString("X: " + snake.getXposition() + " Y: " + snake.getYposition(), 50, 50);

		if (snake.snakeCollisionDetection() == true || snake.getListSnakeSize() == 0) {

			int x = snake.getXposition();
			int y = snake.getYposition();

			if (snake.getXposition() < 25)
				x += 30;
			else if (snake.getXposition() > 475)
				x -= 25;

			if (snake.getYposition() < 25)
				y += 25;
			else if (snake.getYposition() > 425)
				y -= 34;

			int[] xP = { x + 10, x + 20, x + 40, x + 30, x + 50, x + 30, x + 40, x + 20, x + 10, x, x - 20, x - 10,
					x - 30, x - 10, x - 20, x };
			int[] yP = { y - 20, y, y - 20, y + 10, y + 20, y + 30, y + 60, y + 40, y + 60, y + 40, y + 60, y + 30,
					y + 20, y + 10, y - 20, y };

			if (snake.getListSnakeSize() == 0) {
				GradientPaint gp = new GradientPaint(x, y, Color.yellow, x + 40, y + 60, Color.RED);
				g2d.setPaint(gp);
				g2d.fillPolygon(xP, yP, xP.length);
			}

		}

		for (Rectangle rectSnakeList : snake.getRectSnakeList()) {

			g2d.setColor(colorSnake[setColorSnake]);

			g2d.fill(rectSnakeList);

		}

		if (startCountdown == true) {

			g2d.setColor(Color.red);
			g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
			g2d.drawString("Odrodzenie za: " + coutdownValue, 180, 220);
		}

		g2d.setColor(Color.lightGray);
		g2d.setStroke(new BasicStroke(18));
		g2d.drawRect(getWidth() / 2 - 250, getHeight() / 2 - 225, 500, 447);

		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(getWidth() / 2 - 240, getHeight() / 2 - 218, 481, 431);

//		g2d.drawLine(getWidth() / 2 + 241, getHeight() / 2 - 214, getWidth() / 2 + 241, getHeight() / 2 + 209);
//		g2d.drawLine(getWidth() / 2 - 240, getHeight() / 2 - 214, getWidth() / 2 - 240, getHeight() / 2 + 209);
//		g2d.drawLine(getWidth() / 2 - 236, getHeight() / 2 - 218, getWidth() / 2 + 237, getHeight() / 2 - 218);
//		g2d.drawLine(getWidth() / 2 - 236, getHeight() / 2 + 213, getWidth() / 2 + 237, getHeight() / 2 + 213);

	}

	public void setRightDirection(boolean b) {

		xRight = b;
	}

	public void setLeftDirection(boolean b) {

		xLeft = b;
	}

	public void setUpDirection(boolean b) {

		yUp = b;
	}

	public void setDownDirection(boolean b) {

		yDown = b;
	}

	public boolean isItRightDirectionIsOn() {

		return xRight;
	}

	public boolean isItLeftDirectionIsOn() {

		return xLeft;
	}

	public boolean isItUpDirectionIsOn() {

		return yUp;
	}

	public boolean isItDownDirectionIsOn() {

		return yDown;
	}

	public void stopDirections() {

		xRight = false;
		xLeft = false;
		yUp = false;
		yDown = false;
	}

	private void addKeyboardSteering() {

		ActionMap actionMap = new ActionMap();

		this.setActionMap(actionMap);

		AbstractAction actionRestart = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		};

		AbstractAction actionPauseGame = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};

		AbstractAction actionRight = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (xLeft != true && snake.getSnakeDirection() != 'W') {
					xRight = true;
					xLeft = false;
					yUp = false;
					yDown = false;
				}

			}
		};

		AbstractAction actionLeft = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (xRight != true && snake.getSnakeDirection() != 'E') {
					xLeft = true;
					xRight = false;
					yUp = false;
					yDown = false;
				}

			}
		};

		AbstractAction actionUp = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (yDown != true && snake.getSnakeDirection() != 'S') {
					yUp = true;
					yDown = false;
					xRight = false;
					xLeft = false;
				}

			}

		};

		AbstractAction actionDown = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (yUp != true && snake.getSnakeDirection() != 'N') {
					yDown = true;
					yUp = false;
					xRight = false;
					xLeft = false;
				}

			}
		};

		actionMap.put("move_Right", actionRight);
		actionMap.put("move_Left", actionLeft);
		actionMap.put("move_Up", actionUp);
		actionMap.put("move_Down", actionDown);
		actionMap.put("pause", actionPauseGame);
		actionMap.put("restart", actionRestart);

		InputMap inputMap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "move_Right");
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "move_Left");
		inputMap.put(KeyStroke.getKeyStroke("UP"), "move_Up");
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "move_Down");
		inputMap.put(KeyStroke.getKeyStroke("P"), "pause");
		inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "restart");

	}

}
