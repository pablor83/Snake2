import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class Snake {

	private int x;
	private int y;

	private int slength = 16;

	private int colorSnake = 0500100;

	private List<Rectangle> listSnake = new LinkedList<>();

	public void addHeadRectList() {

		listSnake.add(new Rectangle(x, y, 25, 25));

	}

	public void setColorSnake(int c) {

		colorSnake = c;
	}

	public void setXstep(int x) {

		this.x += x;
	}

	public void setYstep(int y) {

		this.y += y;
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
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
}
