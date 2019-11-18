import java.awt.Color;

import javax.swing.*;

public class ScorePanel extends JPanel {
	private JLabel text = new JLabel("점수");
	private JLabel score = new JLabel("0");
	private JLabel nowLevel = new JLabel("현재 레벨");
	public ScorePanel() {
		setBackground(new Color(195, 250, 255));
		setLayout(null);
		text.setSize(70, 30);
		text.setLocation(10, 10);
		add(text);
		
		score.setSize(100, 30);
		score.setLocation(70, 10);
		add(score);

		nowLevel.setSize(70, 30);
		nowLevel.setLocation(10, 30);
		add(nowLevel);
	}
}
