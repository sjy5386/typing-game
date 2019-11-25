import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
	public JTextField inputText = new JTextField(60);
	private ScoreBoard scBoard = new ScoreBoard();

	public GamePanel() {
		setLayout(new BorderLayout());
		add(new JGameGroundPanel(), BorderLayout.CENTER);
		add(new JInputPanel(), BorderLayout.SOUTH);
	}

	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(null);
		}
	}

	class ScoreBoard{
		private JLabel text = new JLabel("점수");
		private int score = 0;
		private JLabel scoreLabel = new JLabel(String.valueOf(score));
		private JLabel nowLevel = new JLabel("현재 레벨");
		private int level = 0;
		private JLabel nowLevelLabel = new JLabel(String.valueOf(level));
		public ScoreBoard(){
			text.setSize(70, 30);
			text.setLocation(10, 10);
			add(text);

			scoreLabel.setSize(100, 30);
			scoreLabel.setLocation(70, 10);
			add(scoreLabel);

			nowLevel.setSize(70, 30);
			nowLevel.setLocation(10, 30);
			add(nowLevel);

			nowLevelLabel.setSize(100,30);
			nowLevelLabel.setLocation(70,30);
			add(nowLevelLabel);
		}

		public void setScore(){
			score++;
			scoreLabel.setText(String.valueOf(score));
		}

		public void setLevel(){
			level = score / 100;
			nowLevelLabel.setText(String.valueOf(level));
		}
	}


	class JInputPanel extends JPanel {
		public JInputPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(new FlowLayout());
			add(inputText);
			inputText.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String word = inputText.getText();
					scBoard.setScore();
					scBoard.setLevel();
					inputText.setText("");
				}
			});
		}
	}
}
