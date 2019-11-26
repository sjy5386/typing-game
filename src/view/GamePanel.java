package view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private ScorePanel scorePanel = new ScorePanel();
	private JGameGroundPanel gameGroundPanel = new JGameGroundPanel();
	private JInputPanel inputPanel = new JInputPanel();

	public GamePanel() {
		setLayout(new BorderLayout());
		this.add(scorePanel, BorderLayout.NORTH);
		this.add(gameGroundPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
	}

	public void initFocus() {
		inputPanel.inputText.setFocusable(true);
		inputPanel.inputText.requestFocus();
	}

	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(null);
		}
	}

	class JInputPanel extends JPanel {
		private JTextField inputText = new JTextField(60);

		public JInputPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(new FlowLayout());
			this.add(inputText);
			inputText.addActionListener(e -> {
				String myWord = inputText.getText();
				scorePanel.setLevel(1);
				inputText.setText("");
			});
		}
	}
}
