import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class Board extends JFrame {

	private ControlAndButtonPanel controlAndButtonPanel = new ControlAndButtonPanel();
	private GraphicDesign graphicDesign = new GraphicDesign();
	private Subtitles subtitles = new Subtitles();
	private Snake snake = new Snake();
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();

	Board() {

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

//		board.graphicDesign.setRandomPointFood();
//		board.graphicDesign.addFood();
//		board.snake.setStartPosition();
		board.snake.setStartPosition();
		board.snake.addHeadRectList();

		while (true) {

			if (board.controlAndButtonPanel.isItRightDirectionIsOn() == true)
				board.goRight();

			if (board.controlAndButtonPanel.isItLeftDirectionIsOn() == true)
				board.goLeft();

			if (board.controlAndButtonPanel.isItUpDirectionIsOn() == true)
				board.goUp();

			if (board.controlAndButtonPanel.isItDownDirectionIsOn() == true)
				board.goDown();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void goRight() {

		snake.setXstep(25);
		snake.addHeadRectList();
		repaint();

	}

	public void goLeft() {
		snake.setXstep(-25);
		snake.addHeadRectList();
		repaint();
	}

	public void goUp() {
		snake.setYstep(-25);
		snake.addHeadRectList();
		repaint();
	}

	public void goDown() {

		snake.setYstep(25);
		snake.addHeadRectList();
		repaint();

	}

}
