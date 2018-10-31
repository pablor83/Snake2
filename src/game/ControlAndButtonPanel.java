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

public class ControlAndButtonPanel extends JPanel {

	JButton restartButton;

	private boolean xRight = false;
	private boolean xLeft = false;
	private boolean yUp = false;
	private boolean yDown = false;

	public boolean isItRightDirectionIsOn() {

		return xRight;
	}

	public boolean isItLeftDirectionIsOn() {

		return xLeft;
	}

	public boolean isItUpDirectionIsOn() {

		return yUp;
	}

	public boolean isItDownDirectionIsOn() {

		return yDown;
	}

	ControlAndButtonPanel() {

		JLabel infoShortcutKey;
		SpringLayout springLayout = new SpringLayout();
		ActionMap actionMap = new ActionMap();

		setLayout(springLayout);

		restartButton = new JButton("Restart");
		add(restartButton);

		infoShortcutKey = new JLabel("CTRL + R");
		infoShortcutKey.setForeground(Color.BLACK);
		infoShortcutKey.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(infoShortcutKey);

		springLayout.putConstraint(SpringLayout.WEST, restartButton, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, restartButton, 20, SpringLayout.NORTH, this);

		springLayout.putConstraint(SpringLayout.WEST, infoShortcutKey, 29, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, infoShortcutKey, 50, SpringLayout.NORTH, this);

		this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 0, Color.BLACK));

		restartButton.setActionMap(actionMap);

		InputMap inputMap = restartButton.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "move_Right");
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "move_Left");
		inputMap.put(KeyStroke.getKeyStroke("UP"), "move_Up");
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "move_Down");
		inputMap.put(KeyStroke.getKeyStroke("P"), "pause");
		inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "restart");

		actionMap.put("move_Right", actionRight);
		actionMap.put("move_Left", actionLeft);
		actionMap.put("move_Up", actionUp);
		actionMap.put("move_Down", actionDown);
		actionMap.put("pause", actionPauseGame);
		actionMap.put("restart", actionRestart);

	}

	AbstractAction actionRestart = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			restartButton.doClick();
		}
	};

	AbstractAction actionPauseGame = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};

	AbstractAction actionRight = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			xRight = true;

			xLeft = false;
			yUp = false;
			yDown = false;
		}
	};

	AbstractAction actionLeft = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			xLeft = true;

			xRight = false;
			yUp = false;
			yDown = false;
		}
	};

	AbstractAction actionUp = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			yUp = true;

			yDown = false;
			xRight = false;
			xLeft = false;

		}

	};

	AbstractAction actionDown = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			yDown = true;

			yUp = false;
			xRight = false;
			xLeft = false;
		}
	};

}
