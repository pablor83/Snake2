package game;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FoodGenerator {

	private List<Rectangle> foodList = new LinkedList<>();

	public void addFoodToTheList() {

		foodList.add(generateFoodOnRandomPosition());
	}

	public Rectangle generateFoodOnRandomPosition() {

		Random random = new Random();

		int randomX = random.nextInt(19) + 1;
		int randomY = random.nextInt(17) + 1;

		return new Rectangle(randomX * 25, randomY * 25, 25, 25);

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
