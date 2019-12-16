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
    private JLabel timeTextLabel = new JLabel("시간: ");
    private JLabel timeLabel = new JLabel("0");
    private ImageIcon scoreImage = new ImageIcon("res/hot_balloon_score.jpg");

    public ScorePanel() {
        setLayout(new FlowLayout());
        add(scoreTextLabel);
        add(scoreLabel);
        add(levelTextLabel);
        add(levelLabel);
        add(lifeTextLabel);
        add(lifeLabel);
        add(timeTextLabel);
        add(timeLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scoreImage.getImage(), 0, 0, null);
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

    public void setTime(float time) {
        timeLabel.setText(String.valueOf(time));
    }
}