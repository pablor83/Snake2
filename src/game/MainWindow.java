package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

import sun.security.x509.IssuerAlternativeNameExtension;

public class MainWindow extends JFrame {

	private ControlAndButtonPanel controlAndButtonPanel = new ControlAndButtonPanel();
	private Board board = new Board();

	private boolean isSnakeBeenRemove = false;
	
	private int snakeXposition;
	private int snakeYposition;

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

		add(controlAndButtonPanel, gridBagConstraints);

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

			if (mainWindow.controlAndButtonPanel.isItRightDirectionIsOn() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0) {
			
				mainWindow.snakeXposition = mainWindow.board.snake().getXposition();
				
				mainWindow.board.startMovingRight();				
			}

			else if (mainWindow.controlAndButtonPanel.isItLeftDirectionIsOn() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingLeft();

			else if (mainWindow.controlAndButtonPanel.isItUpDirectionIsOn() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0)
				mainWindow.board.startMovingUp();

			else if (mainWindow.controlAndButtonPanel.isItDownDirectionIsOn() == true && mainWindow.compareXposition() == true
					&& mainWindow.board.snake().getListSnakeSize() > 0) {
				
				
				mainWindow.board.startMovingDown();
			}
				

			if (mainWindow.board.snake().snakeCollisionDetection() == true || mainWindow.isSnakeBeenRemove == true) {
				mainWindow.controlAndButtonPanel.stopDirections();
				mainWindow.isSnakeBeenRemove = true;
				mainWindow.board.setColorSnake(2);

				if (mainWindow.board.snake().snakeCollisionDetection() == true
						&& mainWindow.board.snake().getXposition() > 25
								&& mainWindow.board.snake().getXposition() < 475
								&& mainWindow.board.snake().getYposition() > 25
								&& mainWindow.board.snake().getYposition() < 425)
					mainWindow.board.snake()
							.removeItemFromListSnake(mainWindow.board.snake().getListSnakeSize() - 1);

				for (int i = 0; i < mainWindow.board.snake().getListSnakeSize(); i++) {
					
					mainWindow.board.snake().killSnake();
					mainWindow.repaint();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

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
	
	private boolean compareXposition() {

		boolean isVarious = false;
		
		if(snakeXposition != board.snake().getXposition());
		isVarious = true;
		
		return isVarious;
				
	}

}
