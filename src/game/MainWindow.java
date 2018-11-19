package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

import sun.security.x509.IssuerAlternativeNameExtension;

public class MainWindow extends JFrame {

	private ButtonPanel buttonPanel = new ButtonPanel();
	private Board board = new Board();

	private boolean isSnakeBeenRemove = false;

	MainWindow() {

		Subtitles subtitles = new Subtitles();

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

			if (mainWindow.board.isItRightDirectionIsOn() == true && mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingRight();

			else if (mainWindow.board.isItLeftDirectionIsOn() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingLeft();

			else if (mainWindow.board.isItUpDirectionIsOn() == true && mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingUp();

			else if (mainWindow.board.isItDownDirectionIsOn() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingDown();

			if (mainWindow.board.snake().snakeCollisionDetection() == true || mainWindow.isSnakeBeenRemove == true) {
				mainWindow.board.stopDirections();
				mainWindow.isSnakeBeenRemove = true;
				mainWindow.board.setColorSnake(2);
				int listSnakeSize = mainWindow.board.snake().getListSnakeSize();

//				if (mainWindow.board.snake().snakeCollisionDetection() == true
//						&& mainWindow.board.snake().getXposition() > 25 && mainWindow.board.snake().getXposition() < 475
//						&& mainWindow.board.snake().getYposition() > 25
//						&& mainWindow.board.snake().getYposition() < 425)
//					mainWindow.board.snake().removeItemFromListSnake(mainWindow.board.snake().getListSnakeSize() - 1);

				for (int i = 0; i < listSnakeSize; i++) {

					mainWindow.board.snake().killSnake();
					mainWindow.repaint();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				mainWindow.board.setStartCountdown(true);

				for (int i = 3; i >= 0; i--) {

					mainWindow.board.setCountdownValue(i);
					mainWindow.repaint();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				mainWindow.board.setStartCountdown(false);

				if (mainWindow.board.snake().getListSnakeSize() == 0)
					mainWindow.isSnakeBeenRemove = false;

			}

			mainWindow.board.snake().constantSnakeLength();

			mainWindow.repaint();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
