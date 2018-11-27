package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Subtitles extends JPanel {

	private int lives = 3;
	private int points = 0;
	private int levels = 1;
	private JLabel infoPause, infoPoints, infoLives, infoLevel;

	Subtitles() {

		JLabel gameName, infoStart, infoColorSnake;

		SpringLayout springLayout = new SpringLayout();

		setLayout(springLayout);

		setBorder(BorderFactory.createMatteBorder(4, 0, 4, 4, Color.BLACK));

		gameName = new JLabel("W¹¿");
		gameName.setForeground(Color.GREEN);
		gameName.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(gameName);

		infoStart = new JLabel("Aby rozpocz¹æ u¿yj którejœ ze strza³ek");
		infoStart.setForeground(Color.BLACK);
		infoStart.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(infoStart);

		infoPause = new JLabel("Pauza -  naciœnij P");
		infoPause.setForeground(Color.RED);
		infoPause.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoPause);

		infoPoints = new JLabel("Punkty: " + points);
		infoPoints.setForeground(Color.blue);
		infoPoints.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoPoints);

		infoLives = new JLabel("¯ycie: " + lives);
		infoLives.setForeground(Color.RED);
		infoLives.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoLives);

		infoLevel = new JLabel("Poziom: " + levels);
		infoLevel.setForeground(Color.BLACK);
		infoLevel.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoLevel);

		infoColorSnake = new JLabel("Zielony - w¹¿");
		infoColorSnake.setForeground(Color.GREEN);
		infoColorSnake.setFont(new Font("TimesRoman", Font.BOLD, 12));
		add(infoColorSnake);

		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gameName, 0, SpringLayout.HORIZONTAL_CENTER, this);

		springLayout.putConstraint(SpringLayout.WEST, infoStart, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, infoStart, 20, SpringLayout.NORTH, this);

		springLayout.putConstraint(SpringLayout.WEST, infoColorSnake, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, infoColorSnake, 40, SpringLayout.NORTH, this);

		springLayout.putConstraint(SpringLayout.WEST, infoPause, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, infoPause, 60, SpringLayout.NORTH, this);

		springLayout.putConstraint(SpringLayout.NORTH, infoLives, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, infoLives, 283, SpringLayout.WEST,
				this);

		springLayout.putConstraint(SpringLayout.NORTH, infoPoints, 45, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, infoPoints, 283, SpringLayout.WEST,
				this);

		springLayout.putConstraint(SpringLayout.NORTH, infoLevel, 70, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, infoLevel, 283, SpringLayout.WEST,
				this);

	}

	public void setLives(int l) {

		lives -= l;
		infoLives.setText("¯ycie: " + lives);
	}

	public void setStartLives(int i) {

		lives = i;
	}

	public void setPoints(int p) {

		points += p;
		infoPoints.setText("Punkty: " + points);
	}
	
	public void setLevels(int i) {
		
		levels = i;
		infoLevel.setText("Poziom: "+levels);
	}

	public int getLives() {

		return lives;
	}

	public int getPoints() {

		return points;
	}
}
