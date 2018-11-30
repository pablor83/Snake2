package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private Board board = new Board();
	private Subtitles subtitles = new Subtitles();
	private ButtonPanel buttonPanel = new ButtonPanel(board, subtitles);

	private boolean isSnakeBeenRemove = false;
	private int setNumberOfFood = 1;
	private int speed;

	MainWindow() {

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		setSize(550, 640);
		;
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(550, 640));
		setLayout(new GridBagLayout());
		setVisible(true);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		gridBagConstraints.ipadx = 100;
		gridBagConstraints.ipady = 100;
		gridBagConstraints.insets = new Insets(1, 3, 0, 0);

		add(buttonPanel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;

		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 100;

		gridBagConstraints.insets = new Insets(1, 0, 0, 3);

		add(subtitles, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 515;
		gridBagConstraints.ipady = 470;

		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

		gridBagConstraints.weighty = 0;
		gridBagConstraints.insets = new Insets(6, 0, 0, 0);

		add(board, gridBagConstraints);
	}

	public static void main(String[] argh) {

		MainWindow mainWindow = new MainWindow();

		while (true) {

			if (mainWindow.board.snake().getListSnakeSize() == 1
					&& mainWindow.board.getStatusStopKillingSnakeAndCountdown()) {
				mainWindow.isSnakeBeenRemove = false;
				mainWindow.board.setStopKillingSnakeAndCountdown(false);
			}

			if (mainWindow.subtitles.getPoints() == 0 && mainWindow.board.snake().getListSnakeSize() == 1)
				mainWindow.speed = 500;

			if (!mainWindow.board.getPauseStatus()) {

				if (mainWindow.board.isItRightDirectionIsOn() && mainWindow.board.snake().getListSnakeSize() > 0)
					mainWindow.board.startMovingRight();

				else if (mainWindow.board.isItLeftDirectionIsOn() && mainWindow.board.snake().getListSnakeSize() > 0)
					mainWindow.board.startMovingLeft();

				else if (mainWindow.board.isItUpDirectionIsOn() && mainWindow.board.snake().getListSnakeSize() > 0)
					mainWindow.board.startMovingUp();

				else if (mainWindow.board.isItDownDirectionIsOn() && mainWindow.board.snake().getListSnakeSize() > 0)
					mainWindow.board.startMovingDown();

				mainWindow.board.snake().constantSnakeLength();

				if (mainWindow.board.snake().snakeCollisionDetection() || mainWindow.isSnakeBeenRemove) {

					int keepSnakeLength = mainWindow.board.snake().getSnakeLength();

					mainWindow.board.snake().setColorSnake(2);
					mainWindow.subtitles.setLives(1);

					if (mainWindow.subtitles.getLives() > 0) {

						mainWindow.board.stopDirections();
						mainWindow.isSnakeBeenRemove = true;

						mainWindow.board.setRemoveSnake(mainWindow, 150);

						mainWindow.board.setStartCountdown(true);
						mainWindow.board.setCountdown(mainWindow, 3, 1000);
						mainWindow.board.setStartCountdown(false);

						if (mainWindow.board.snake().getListSnakeSize() == 0)
							mainWindow.isSnakeBeenRemove = false;

						mainWindow.board.snake().setSnakeLength(keepSnakeLength);
						mainWindow.board.snake().setColorSnake(0);
						mainWindow.board.setRandomMoveDirectionOfSnake();
					} else {

						mainWindow.isSnakeBeenRemove = false;
						mainWindow.board.setRemoveSnake(mainWindow, 250);
						mainWindow.board.setGameOverSign(true);
					}

				}

				if (mainWindow.board.isItFoodEaten()) {

					mainWindow.subtitles.setPoints(1);
					mainWindow.board.snake().setSnakeLength(mainWindow.board.snake().getSnakeLength() + 1);
					mainWindow.board.setAmountAddedFood(mainWindow.setNumberOfFood);
				}

				switch (mainWindow.subtitles.getPoints()) {

				case (5):
					mainWindow.setNumberOfFood = 2;
					mainWindow.speed = 250;
					mainWindow.subtitles.setLevels(2);
					break;

				case (10):
					mainWindow.setNumberOfFood = 3;
					mainWindow.subtitles.setLevels(3);
					break;

				case (15):
					mainWindow.setNumberOfFood = 4;
					mainWindow.speed = 150;
					mainWindow.subtitles.setLevels(4);
					break;

				}

				mainWindow.repaint();

			}

			else if (mainWindow.board.getPauseStatus())
				mainWindow.repaint();

			try {
				Thread.sleep(mainWindow.speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}