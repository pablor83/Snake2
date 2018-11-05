package game;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake {

	private int x;
	private int y;

	private int slength = 3;

	private int colorSnake = 0500100;

	private List<Rectangle> listSnake = new LinkedList<>();

	private Random randomStartPosition = new Random();

	Snake() {

		setStartPosition();
		addHeadRectList();
	}

	public void addHeadRectList() {

		listSnake.add(new Rectangle(x, y, 25, 25));

	}

	public void setStartPosition() {

		int[] x = new int[16];
		int[] y = new int[16];

		int snakeStep = 25;

		for (int i = 0; i < 16; i++) {

			snakeStep += 25;

			x[i] = snakeStep;
			y[i] = snakeStep;

		}

		int randomX = randomStartPosition.nextInt(16);
		int randomy = randomStartPosition.nextInt(16);

		this.x = x[randomX];
		this.y = y[randomy];

	}

//	public void setColorSnake(int c) {
//
//		colorSnake = c;
//	}
//
	public void setXstep(int x) {

		this.x += x;
	}

	public void setYstep(int y) {

		this.y += y;
	}

//
//	public void setX(int x) {
//
//		this.x = x;
//	}
//
//	public void setY(int y) {
//
//		this.y = y;
//	}
//
	public int getXposition() {

		return x;
	}

	public int getYposition() {

		return y;
	}

	public int getListSnakeSize() {

		return listSnake.size();
	}

	public int getSnakeLength() {

		return slength;
	}

	public List<Rectangle> getRectSnakeList() {

		return listSnake;
	}

	public Rectangle getHeadRectCoordinates() {

		Rectangle rectHead = new Rectangle(x, y, 25, 25);

		if (listSnake.size() > 0)
			rectHead = listSnake.get(listSnake.size() - 1);

		return rectHead;
	}

	public boolean tailCollisionDetection() {

		boolean collision = false;

		if (listSnake.size() > 16) {

			for (int i = 0; i < listSnake.size() - 16; i++) {
				if (listSnake.get(listSnake.size() - 1).intersects(listSnake.get(i)))

					collision = true;

			}
		}

		return collision;
	}

	public void removeItemFromListSnake(int number) {

		listSnake.remove(number);
	}

	public void goRight() {

		setXstep(25);
		addHeadRectList();

	}

	public void goLeft() {
		setXstep(-25);
		addHeadRectList();

	}

	public void goUp() {
		setYstep(-25);
		addHeadRectList();

	}

	public void goDown() {

		setYstep(25);
		addHeadRectList();

	}
}
