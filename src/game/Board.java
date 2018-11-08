package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

import sun.security.x509.IssuerAlternativeNameExtension;

public class Board extends JFrame {

	private ControlAndButtonPanel controlAndButtonPanel = new ControlAndButtonPanel();
	private GraphicDesign graphicDesign = new GraphicDesign();
	
	private boolean isSnakeBeenRemove = false;

	Board() {

		Subtitles subtitles = new Subtitles();

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		setSize(550, 640);;
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

		add(graphicDesign, gridBagConstraints);
	}

	public static void main(String[] argh) {

		Board board = new Board();

		while (true) {
			
			

			if (board.controlAndButtonPanel.isItRightDirectionIsOn() == true)
				board.graphicDesign.startMovingRight();

			else if (board.controlAndButtonPanel.isItLeftDirectionIsOn() == true)
				board.graphicDesign.startMovingLeft();

			else if (board.controlAndButtonPanel.isItUpDirectionIsOn() == true)
				board.graphicDesign.startMovingUp();

			else if (board.controlAndButtonPanel.isItDownDirectionIsOn() == true)
				board.graphicDesign.startMovingDown();	
			
			if(board.graphicDesign.snake().snakeCollisionDetection() == true || board.isSnakeBeenRemove == true) {
				board.controlAndButtonPanel.stopDirections();
				board.isSnakeBeenRemove = true;
				
				for(int i = 0; i<board.graphicDesign.snake().getListSnakeSize(); i++) {
					
					board.graphicDesign.snake().killSnake();
					board.repaint();
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(board.graphicDesign.snake().getListSnakeSize() == 0)
				board.isSnakeBeenRemove = false;	
				
			}
				
			board.graphicDesign.snake().constantSnakeLength();
			
			board.repaint();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
