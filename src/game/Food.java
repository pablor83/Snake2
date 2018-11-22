package game;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Food {

	private int xFood, yFood;

	private List<Rectangle> foodList = new LinkedList<>();

	private Random randomFoodPosition = new Random();

	public void addFoodToTheList() {

		setRandomFoofPosition();
		foodList.add(new Rectangle(xFood, yFood, 25, 25));
	}

	public void setRandomFoofPosition() {

		int[] x = new int[16];
		int[] y = new int[16];

		int snakeStep = 0;

		for (int i = 0; i < 16; i++) {

			snakeStep += 25;

			x[i] = snakeStep;
			y[i] = snakeStep;

		}

		int randomX = randomFoodPosition.nextInt(16);
		int randomy = randomFoodPosition.nextInt(16);

		xFood = x[randomX];
		yFood = y[randomy];

	}

	public List<Rectangle> getFoodList() {

		return foodList;
	}

	public Rectangle getItemFromTheFoodList(int numberPositionFromTheFoodList) {

		return foodList.get(numberPositionFromTheFoodList);
	}

	public void removeItemFromTheFoodList(int number) {

		foodList.remove(number);
	}

	public int getFoodListSize() {

		return foodList.size();
	}
}
