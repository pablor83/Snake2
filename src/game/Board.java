package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class Board extends JFrame {

	private ControlAndButtonPanel controlAndButtonPanel = new ControlAndButtonPanel();
	private GraphicDesign graphicDesign = new GraphicDesign();

	Board() {

		Subtitles subtitles = new Subtitles();

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		setSize(540, 625);
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(540, 625));
		setLayout(new GridBagLayout());
		setVisible(true);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		gridBagConstraints.ipadx = 100;
		gridBagConstraints.ipady = 100;
		gridBagConstraints.insets = new Insets(7, 0, 0, 0);

		add(controlAndButtonPanel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;

		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 100;

		gridBagConstraints.insets = new Insets(7, 0, 0, 0);

		add(subtitles, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 500;
		gridBagConstraints.ipady = 460;

		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

		gridBagConstraints.weighty = 0;
		gridBagConstraints.insets = new Insets(2, 0, 0, 0);

		add(graphicDesign, gridBagConstraints);

	}

	public static void main(String[] argh) {

		Board board = new Board();

		while (true) {

			if (board.controlAndButtonPanel.isItRightDirectionIsOn() == true)
				board.graphicDesign.startMovingRight();

			if (board.controlAndButtonPanel.isItLeftDirectionIsOn() == true)
				board.graphicDesign.startMovingLeft();

			if (board.controlAndButtonPanel.isItUpDirectionIsOn() == true)
				board.graphicDesign.startMovingUp();

			if (board.controlAndButtonPanel.isItDownDirectionIsOn() == true)
				board.graphicDesign.startMovingDown();

			board.repaint();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
