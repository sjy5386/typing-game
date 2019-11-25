import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private JLabel scoreTextLabel = new JLabel("점수: ");
    private int score = 0;
    private JLabel scoreLabel = new JLabel(String.valueOf(score));
    private JLabel levelTextLabel = new JLabel("레벨: ");
    private int level = 0;
    private JLabel levelLabel = new JLabel(String.valueOf(level));

    public ScorePanel() {
        setBackground(MyColor.LIGHT);
        setLayout(new FlowLayout());
        add(scoreTextLabel);
        add(scoreLabel);
        add(levelTextLabel);
        add(levelLabel);
    }

    public void setScore(int length){
        score = score + length;
        scoreLabel.setText(String.valueOf(score));
    }
    public void setLevel(){
        level = score /100;
        levelLabel.setText(String.valueOf(level));
    }

}