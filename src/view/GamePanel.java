package view;

import controller.GameApp;
import model.WordManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	public JTextField inputText = new JTextField(60);
	private ScorePanel scorePanel = new ScorePanel();
	private JGameGroundPanel gameGroundPanel = new JGameGroundPanel();
	private JInputPanel inputPanel = new JInputPanel();
	private WordManager manager = GameApp.wordManager;
	private String randomWord = manager.getRandomWord();
	private WordLabel makeLabel = new WordLabel(randomWord);

	public GamePanel() {
		setLayout(new BorderLayout());
		this.add(scorePanel, BorderLayout.NORTH);
		this.add(gameGroundPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		createWord();
	}

	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(null);
		}
	}

	public void createWord(){
		randomWord = manager.getRandomWord();
		makeLabel = new WordLabel(randomWord);
		gameGroundPanel.add(makeLabel);
	}

	public void removeWord(){
		gameGroundPanel.remove(makeLabel);
		gameGroundPanel.revalidate();
		gameGroundPanel.repaint();
	}

	class JInputPanel extends JPanel {
		public JInputPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(new FlowLayout());
			this.add(inputText);
			inputText.addActionListener(e -> {
				String myWord = inputText.getText();
				if(myWord.equals(randomWord)){
					removeWord();
					scorePanel.setScore(randomWord.length());
					createWord();
				}
				scorePanel.setLevel();
				inputText.setText("");
			});
		}
	}
}
