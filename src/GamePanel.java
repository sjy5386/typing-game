import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	public JTextField inputText = new JTextField(60);
	private ScorePanel scorePanel = new ScorePanel();
	private JGameGroundPanel gameGroundPanel = new JGameGroundPanel();
	private JInputPanel inputPanel = new JInputPanel();

	public GamePanel() {
		setLayout(new BorderLayout());
		add(scorePanel, BorderLayout.NORTH);
		add(gameGroundPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
	}

	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(null);
		}
	}

	class JInputPanel extends JPanel {
		public JInputPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(new FlowLayout());
			add(inputText);
			inputText.addActionListener(e -> {
				String myWord = inputText.getText();
				inputText.setText("");
			});
		}
	}
}
