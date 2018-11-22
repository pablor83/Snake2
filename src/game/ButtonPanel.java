package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

public class ButtonPanel extends JPanel {

	private JButton restartButton;
	private JLabel restartButtonLabelInfoShorcut;
	private Board board; 
	private Subtitles subtitles;

	ButtonPanel(Board bd, Subtitles sub) {
		
		board = bd;
		subtitles = sub;
		
		addRestartButton();
		addRestartButtonLabelInfoShorcut();
		initLayout();
	}

	private void initLayout() {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		springLayout.putConstraint(SpringLayout.WEST, restartButton, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, restartButton, 20, SpringLayout.NORTH, this);

		springLayout.putConstraint(SpringLayout.WEST, restartButtonLabelInfoShorcut, 29, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, restartButtonLabelInfoShorcut, 50, SpringLayout.NORTH, this);

		this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 0, Color.BLACK));
	}

	private void addRestartButton() {

		restartButton = new JButton("Restart");
		add(restartButton);

		restartButton.addActionListener(restartAction -> {

			board.stopDirections();
			board.setGameOverSign(false);
			board.snake().setSnakeLength(3);
			subtitles.setStartLives(3);
			board.snake().setColorSnake(0);
			
			if(board.snake().getListSnakeSize()>0)
				board.snake().cleanSnakeList();
			
			if(board.getCoutdownStatus() == true)
				board.setStartCountdown(false);
				
			board.snake().setStartPosition();
			board.snake().addHeadRectList();
			
			board.food().removeItemFromTheFoodList(0);
			board.food().addFoodToTheList();
		});
	}

	private void addRestartButtonLabelInfoShorcut() {

		restartButtonLabelInfoShorcut = new JLabel("CTRL + R");
		restartButtonLabelInfoShorcut.setForeground(Color.BLACK);
		restartButtonLabelInfoShorcut.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(restartButtonLabelInfoShorcut);
	}

}
