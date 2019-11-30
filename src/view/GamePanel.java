package view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private ScorePanel scorePanel = new ScorePanel();
	private GameGroundPanel gameGroundPanel = new GameGroundPanel();
	private InputPanel inputPanel = new InputPanel();

	public GamePanel() {
		setLayout(new BorderLayout());
		this.add(scorePanel, BorderLayout.NORTH);
		this.add(gameGroundPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
	}

	public ScorePanel getScorePanel() {
		return scorePanel;
	}

	public GameGroundPanel getGameGroundPanel() {
		return gameGroundPanel;
	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}
}
