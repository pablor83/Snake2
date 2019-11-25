package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake {

	private int x;
	private int y;

	private int slength = 3;

	private int colorOfSnake = 0;
	private Color[] colorSnake = { new Color(000, 200, 000), Color.BLUE, Color.red };

	private List<Rectangle> listSnake = new LinkedList<>();

	public void addHeadRectList() {

		listSnake.add(new Rectangle(x, y, 25, 25));

	}

	public void setStartPosition() {

		Random randomStartPosition = new Random();

		int randomX = randomStartPosition.nextInt(15)+2;
		int randomY = randomStartPosition.nextInt(15)+2;

		x = randomX * 25;
		y = randomY * 25;

	}

	public void setSnakeLength(int length) {

		slength = length;
	}

	public void setColorSnake(int i) {

		colorOfSnake = i;
	}

	public void setXstep(int x) {

		this.x += x;
	}

	public void setYstep(int y) {

		this.y += y;
	}

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

	public Color getColorOfSnake() {

		return colorSnake[colorOfSnake];
	}

	public Rectangle getRectFromSnakeList(int positionFromList) {

		return listSnake.get(positionFromList);
	}

	public boolean copmareXpositionFromSnakeList() {

		boolean isVarious = true;

		if (listSnake.size() <= 1)
			isVarious = true;

		else if (listSnake.get(listSnake.size() - 1).getX() == listSnake.get(listSnake.size() - 2).getX())
			isVarious = false;

		return isVarious;
	}

	public boolean copmareYpositionFromSnakeList() {

		boolean isVarious = true;

		if (listSnake.size() <= 1)
			isVarious = true;

		else if (listSnake.get(listSnake.size() - 1).getY() == listSnake.get(listSnake.size() - 2).getY())
			isVarious = false;

		return isVarious;
	}

	public char getSnakeDirection() {

		char direction = '0';

		if (!copmareYpositionFromSnakeList()
				&& listSnake.get(listSnake.size() - 1).getX() > listSnake.get(listSnake.size() - 2).getX())
			direction = 'E';

		else if (!copmareYpositionFromSnakeList()
				&& listSnake.get(listSnake.size() - 1).getX() < listSnake.get(listSnake.size() - 2).getX())
			direction = 'W';

		else if (!copmareXpositionFromSnakeList()
				&& listSnake.get(listSnake.size() - 1).getY() < listSnake.get(listSnake.size() - 2).getY())
			direction = 'N';

		else if (!copmareXpositionFromSnakeList()
				&& listSnake.get(listSnake.size() - 1).getY() > listSnake.get(listSnake.size() - 2).getY())
			direction = 'S';

		return direction;
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

		if (listSnake.size() > 4 && (x < 475 || x > 25 || y > 25 || y < 425)) {

			for (int i = 0; i < listSnake.size() - 3; i++) {
				if (listSnake.get(listSnake.size() - 1).intersects(listSnake.get(i)))

					snakeCollision = true;
			}
		}

		if (listSnake.size() > 0 && (x > 475 || x < 25 || y < 25 || y > 425)) {
			snakeCollision = true;
		}

		return snakeCollision;
	}

	public void removeItemFromListSnake(int number) {

		listSnake.remove(number);
	}

	public void constantSnakeLength() {

		if (listSnake.size() > slength && (x < 475 || x > 25 || y > 25 || y < 425))
			listSnake.remove(0);
	}

	public void goRight() {

		if (x == 475) {

			setXstep(1);
		}

		else if (x > 475)
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

		else if (x < 25)
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

		else if (y < 25)
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

		else if (y > 425)
			setYstep(0);

		else {
			setYstep(25);
			addHeadRectList();
		}

	}

	public void killSnake() {

		if (listSnake.size() > 0)
			listSnake.remove(0);

	}

	public void cleanSnakeList() {

		listSnake.removeAll(listSnake);
	}
}
