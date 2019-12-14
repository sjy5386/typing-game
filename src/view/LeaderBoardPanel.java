package view;

import model.LeaderBoardManager;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderBoardPanel extends JPanel {
    private LeaderBoardManager leaderBoardManager = new LeaderBoardManager();
    private ArrayList<Player> players = new ArrayList<>();
    private JPanel listPanel = new JPanel();

    public LeaderBoardPanel() {
        setLayout(new BorderLayout());

        players.addAll(leaderBoardManager.getLeaderBoard());
        listPanel.setPreferredSize(new Dimension(200, 500));
        listPanel.setBorder(BorderFactory.createLineBorder(MyColor.DARK, 15));
        listPanel.setBackground(MyColor.DARK);
        listPanel.setLayout(new GridLayout(11, 1, 5, 5));
        listPanel.add(new LeaderBoardItem("순위", "이름", "점수"));

        int size = players.size();
        if (size > 10)
            size = 10;
        for (int i = 0; i < size; i++)
            listPanel.add(new LeaderBoardItem(String.valueOf(i + 1), players.get(i).getName(), String.valueOf(players.get(i).getScore())));
        add(listPanel, BorderLayout.CENTER);
    }
}
