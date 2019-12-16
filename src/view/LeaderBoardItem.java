package view;

import javax.swing.*;
import java.awt.*;

public class LeaderBoardItem extends JPanel {
    public LeaderBoardItem(String rank, String name, String score) {
        JLabel rankLabel = new JLabel(rank);
        JLabel playerName = new JLabel(name);
        JLabel playerScore = new JLabel(score);

        this.setBackground(MyColor.LIGHT);

        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        playerName.setHorizontalAlignment(JLabel.CENTER);
        playerScore.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new GridLayout(1, 3));
        this.add(rankLabel);
        this.add(playerName);
        this.add(playerScore);
    }
}
