package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Board extends JPanel {

	private Snake snake = new Snake();
	private Food food = new Food();

	private boolean xRight = false;
	private boolean xLeft = false;
	private boolean yUp = false;
	private boolean yDown = false;

	private boolean startCountdown = false;
	private boolean displayGameOver = false;
	private int coutdownValue;

	Board() {

		addKeyboardSteering();
		snake.setStartPosition();
		snake.addHeadRectList();
		checkThePositionOfFoodAndSnakeAndAddFood();
	}

	public Snake snake() {

		return snake;
	}

	public Food food() {

		return food;
	}

	private void checkThePositionOfFoodAndSnakeAndAddFood() {

		boolean start = true;
		boolean isItIntersect = false;
		food.setRandomFoofPosition();
		Rectangle randomRect = new Rectangle(food.getRandomX(), food.getRandomY(), 25, 25);

		while (start) {

			for (int i = 0; i < snake.getListSnakeSize(); i++) {
				
				if (randomRect.intersects(snake.getRectFromSnakeList(i))) {
					food.setRandomFoofPosition();
					randomRect.setLocation(food.getRandomX(), food.getRandomY());
					isItIntersect = true;
					break;
				}
			}

			if (!isItIntersect) {
				food.addFoodToTheList();
				start = false;
			}

			isItIntersect = false;

		}

	}

	public void setAmountAddedFood(int amount) {

		if (food.getFoodListSize() == 0) {

			for (int i = 0; i < amount; i++)
				checkThePositionOfFoodAndSnakeAndAddFood();
		}

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

	public void setStartCountdown(boolean b) {

		startCountdown = b;
	}

//	public void setCountdownValue(int i) {
//
//		coutdownValue = i;
//	}

	public void setRemoveSnake(MainWindow m, int setSpeedRemovingSnake) {

		int listSnakeSize = snake.getListSnakeSize();

		for (int i = 0; i < listSnakeSize; i++) {

			snake.killSnake();
			m.repaint();

			try {
				Thread.sleep(setSpeedRemovingSnake);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setCountdown(MainWindow m, int displayNumerOfSeconds, int millisecond) {

		for (int i = displayNumerOfSeconds; i > 0; i--) {

			coutdownValue = i;
			m.repaint();

			try {
				Thread.sleep(millisecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean getCoutdownStatus() {

		return startCountdown;
	}

	public void setGameOverSign(boolean b) {

		displayGameOver = b;
	}

	public void setRandomMoveDirectionOfSnake() {

		Random randomMove = new Random();

		snake.setStartPosition();
		snake.addHeadRectList();
		switch (randomMove.nextInt(4) + 1) {

		case 1:
			xRight = true;
			break;

		case 2:
			xLeft = true;
			break;

		case 3:
			yUp = true;
			break;

		case 4:
			yDown = true;
			break;
		}

	}

	public boolean isItFoodEaten() {

		boolean foodEaten = false;

		for (int i = 0; i < food.getFoodListSize(); i++) {
			if (snake.getHeadRectCoordinates().intersects(food.getItemFromTheFoodList(i))) {

				foodEaten = true;
				food.removeItemFromTheFoodList(i);

			}

		}

		return foodEaten;
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawString("X: " + snake.getXposition() + " Y: " + snake.getYposition(), 50, 50);

		if (snake.snakeCollisionDetection() || snake.getListSnakeSize() == 0) {

			int x = snake.getXposition();
			int y = snake.getYposition();
			
			if((snake.getXposition() < 25 && snake.getYposition() == 25) || (snake.getXposition() == 25 && snake.getYposition() < 25)) {
				x += 30; y += 25;
			}
			
			else if((snake.getXposition() < 25 && snake.getYposition() == 425) || (snake.getXposition() == 25 && snake.getYposition() > 425)) {
				x += 25; y -= 34;
			}

			else if((snake.getXposition() > 475 && snake.getYposition() == 25) || (snake.getXposition() == 475 && snake.getYposition() < 25)) {
				x -= 25; y += 25;
			}
			
			else if((snake.getXposition() > 475 && snake.getYposition() == 425) || (snake.getXposition() == 475 && snake.getYposition() > 425)) {
				x -= 25; y -= 34;
			}
			
			else if (snake.getXposition() < 25)
				x += 30;
			
			else if (snake.getXposition() > 475)
				x -= 25;
			
			else if (snake.getYposition() < 25)
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

			g2d.setColor(snake.getColorOfSnake());
			g2d.fill(rectSnakeList);

		}

		for (Rectangle rectFoodList : food.getFoodList()) {

			g2d.setColor(new Color(200300300));
			g2d.fill(rectFoodList);
		}

		if (startCountdown == true) {

			g2d.setColor(Color.red);
			g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
			g2d.drawString("Odrodzenie za: " + coutdownValue, 180, 220);
		}

		if (displayGameOver) {

			g2d.setColor(Color.red);
			g2d.setFont(new Font("TimesRoman", Font.BOLD, 24));
			g2d.drawString("Koniec Gry!", 200, 220);
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

				if (!xLeft && snake.getSnakeDirection() != 'W') {
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

				if (!xRight && snake.getSnakeDirection() != 'E') {
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

				if (!yDown && snake.getSnakeDirection() != 'S') {
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

				if (!yUp && snake.getSnakeDirection() != 'N') {
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
