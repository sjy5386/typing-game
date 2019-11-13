import java.awt.Color;

import javax.swing.*;

public class ScorePanel extends JPanel {
	private JLabel text = new JLabel("Á¡¼ö");
	private JLabel score = new JLabel("0");
	public ScorePanel() {
		setBackground(Color.YELLOW);
		setLayout(null);
		text.setSize(50, 30);
		text.setLocation(10, 10);
		add(text);
		
		score.setSize(100, 30);
		score.setLocation(70, 10);
		add(score);
	}
}
