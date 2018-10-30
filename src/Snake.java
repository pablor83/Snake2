import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake {

	private int x;
	private int y;

	private static int slength = 5;

	private int colorSnake = 0500100;

	private static List<Rectangle> listSnake = new LinkedList<>();

	private Random randomStartPosition = new Random();

	public void addHeadRectList() {

		listSnake.add(new Rectangle(x, y, 25, 25));

	}

	public void setStartPosition() {

		int[] x = new int[16];
		int[] y = new int[16];

		int snakeStep = 0;

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
//	public int getXposition() {
//
//		return x;
//	}
//
//	public int getYposition() {
//
//		return y;
//	}
//
	public static int getListSnakeSize() {

		return listSnake.size();
	}

	public static int getSnakeLength() {

		return slength;
	}

	public static List<Rectangle> getRectSnakeList() {

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

	public static void removeItemFromListSnake(int number) {

		listSnake.remove(number);
	}
}
