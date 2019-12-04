package view;

import model.LeaderBoardManager;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderBoardPanel extends JPanel {
    private LeaderBoardManager manager = new LeaderBoardManager();
    private ArrayList<Player> players = new ArrayList<>();
    private JPanel listPanel = new JPanel();

    public LeaderBoardPanel() {
        setLayout(new BorderLayout());

        players.addAll(manager.getLeaderBoard());
        listPanel.setPreferredSize(new Dimension(200, 500));
        listPanel.setBorder(BorderFactory.createLineBorder(MyColor.DARK, 15));
        listPanel.setBackground(MyColor.DARK);
        listPanel.setLayout(new GridLayout(11, 1, 5, 5));
        listPanel.add(new RankingItem("순위", "이름", "점수"));

        int size = players.size();
        if (size > 10)
            size = 10;
        for (int i = 0; i < size; i++) {
            listPanel.add(new RankingItem(String.valueOf(i+1), players.get(i).getName(), String.valueOf(players.get(i).getScore())));
        }
        add(listPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
class RankingItem extends JPanel{
    RankingItem(String rank, String name, String score){
        JLabel rankLabel = new JLabel(rank);
        JLabel playerName = new JLabel(name);
        JLabel playerScore = new JLabel(score);

        this.setBackground(MyColor.LIGHT);

        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        playerName.setHorizontalAlignment(JLabel.CENTER);
        playerScore.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1,3));
        this.add(rankLabel);
        this.add(playerName);
        this.add(playerScore);
    }
}