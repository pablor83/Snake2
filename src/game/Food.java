package game;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Food {

	int xFood, yFood;

	private List<Rectangle> foodList = new LinkedList<>();

	private Random randomFoodPosition = new Random();

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
}
