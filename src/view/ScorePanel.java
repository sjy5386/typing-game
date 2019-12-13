package view;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private JLabel scoreTextLabel = new JLabel("점수: ");
    private JLabel scoreLabel = new JLabel("0");
    private JLabel levelTextLabel = new JLabel("레벨: ");
    private JLabel levelLabel = new JLabel("0");
    private JLabel lifeTextLabel = new JLabel("목숨: ");
    private JLabel lifeLabel = new JLabel("0");

    public ScorePanel() {
        setBackground(MyColor.LIGHT);
        setLayout(new FlowLayout());
        add(scoreTextLabel);
        add(scoreLabel);
        add(levelTextLabel);
        add(levelLabel);
        add(lifeTextLabel);
        add(lifeLabel);
    }

    public void setScore(int score) {
        scoreLabel.setText(String.valueOf(score));
    }

    public void setLevel(int level) {
        levelLabel.setText(String.valueOf(level));
    }

    public void setLife(int life) {
        lifeLabel.setText(String.valueOf(life));
    }
}