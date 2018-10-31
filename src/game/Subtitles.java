package game;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Subtitles extends JPanel {

	

	Subtitles() {

		JLabel gameName, infoStart, infoPause, infoPoints, infoLives, infoLevel, infoColorSnake;
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

		infoPoints = new JLabel("Punkty: ");
		infoPoints.setForeground(Color.blue);
		infoPoints.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoPoints);

		infoLives = new JLabel("¯ycie: ");
		infoLives.setForeground(Color.RED);
		infoLives.setFont(new Font("TimesRoman", Font.BOLD, 14));
		add(infoLives);

		infoLevel = new JLabel("Poziom: ");
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
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, infoLives, 102, SpringLayout.HORIZONTAL_CENTER,
				this);

		springLayout.putConstraint(SpringLayout.NORTH, infoPoints, 45, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, infoPoints, 108, SpringLayout.HORIZONTAL_CENTER,
				this);

		springLayout.putConstraint(SpringLayout.NORTH, infoLevel, 70, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, infoLevel, 110, SpringLayout.HORIZONTAL_CENTER,
				this);

	}

}
