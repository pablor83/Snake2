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

	private JButton restartButton;
	private JLabel restartButtonLabelInfoShorcut;

	private boolean xRight = false;
	private boolean xLeft = false;
	private boolean yUp = false;
	private boolean yDown = false;

	public void setRightDirection(boolean b) {

		xRight = b;
	}

	public void setLeftDirection(boolean b) {

		xLeft = b;
	}

	public void setUpDirection(boolean b) {

		yUp = b;
	}

	public void setDownDirection(boolean b) {

		yDown = b;
	}

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

	public void stopDirections() {

		xRight = false;
		xLeft = false;
		yUp = false;
		yDown = false;
	}

	ControlAndButtonPanel() {
		
		addRestartButton();
		addRestartButtonLabelInfoShorcut();
		initLayout();
		addKeyboardSteering();

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
	}

	private void addRestartButtonLabelInfoShorcut() {

		restartButtonLabelInfoShorcut = new JLabel("CTRL + R");
		restartButtonLabelInfoShorcut.setForeground(Color.BLACK);
		restartButtonLabelInfoShorcut.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(restartButtonLabelInfoShorcut);
	}

	private void addKeyboardSteering() {

		ActionMap actionMap = new ActionMap();

		this.setActionMap(actionMap);

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

				if (xLeft != true) {
					xRight = true;
					xLeft = false;
				}

				yUp = false;
				yDown = false;
			}
		};

		AbstractAction actionLeft = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (xRight != true) {
					xLeft = true;
					xRight = false;
				}

				yUp = false;
				yDown = false;
			}
		};

		AbstractAction actionUp = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (yDown != true) {
					yUp = true;
					yDown = false;
				}

				xRight = false;
				xLeft = false;

			}

		};

		AbstractAction actionDown = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (yUp != true) {
					yDown = true;
					yUp = false;
				}

				xRight = false;
				xLeft = false;
			}
		};

		actionMap.put("move_Right", actionRight);
		actionMap.put("move_Left", actionLeft);
		actionMap.put("move_Up", actionUp);
		actionMap.put("move_Down", actionDown);
		actionMap.put("pause", actionPauseGame);
		actionMap.put("restart", actionRestart);

		InputMap inputMap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "move_Right");
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "move_Left");
		inputMap.put(KeyStroke.getKeyStroke("UP"), "move_Up");
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "move_Down");
		inputMap.put(KeyStroke.getKeyStroke("P"), "pause");
		inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "restart");

	}

}
