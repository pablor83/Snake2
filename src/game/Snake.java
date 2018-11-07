package game;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake {

	private int x;
	private int y;

	private int slength = 4;

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
	
	public void setLength(int length) {
		
		slength = length;
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

	public boolean snakeCollisionDetection() {

		boolean snakeCollision = false;

		if (listSnake.size() > 4) {

			for (int i = 0; i < listSnake.size() - 3; i++) {
				if (listSnake.get(listSnake.size() - 1).intersects(listSnake.get(i)))
					
					snakeCollision = true;
			}
		}

		else if (x > 475 || x < 25 || y < 25 || y > 425)			
			snakeCollision = true;

		return snakeCollision;
	}

	public void removeItemFromListSnake(int number) {

		listSnake.remove(number);
	}

	public void constantSnakeLength() {

		if (listSnake.size() > slength && (x<475 || x > 25 || y > 25 || y < 425))
			listSnake.remove(0);
	}

	public void goRight() {

		if (x == 475) {

			setXstep(1);
		}

		else if (x > 475 || snakeCollisionDetection() == true)
			setXstep(0);

		else {
			setXstep(25);
			addHeadRectList();
		}
	}

	public void goLeft() {

		if (x == 25) {

			setXstep(-1);
		}

		else if (x < 25 || snakeCollisionDetection() == true)
			setXstep(0);

		else {
			setXstep(-25);
			addHeadRectList();
		}

	}

	public void goUp() {

		if (y == 25) {

			setYstep(-1);
		}

		else if (y < 25 || snakeCollisionDetection() == true)
			setYstep(0);

		else {
			setYstep(-25);
			addHeadRectList();
		}

	}

	public void goDown() {

		if (y == 425) {

			setYstep(1);
		}

		else if (y > 425 || snakeCollisionDetection() == true)
			setYstep(0);

		else {
			setYstep(25);
			addHeadRectList();
		}

	}
	
	public void killSnake(int i) {
			
				listSnake.remove(i);
	}
}
