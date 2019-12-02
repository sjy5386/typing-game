package view;

import javax.swing.*;
import java.awt.*;

public class LeaderBoardDialog extends JDialog {
    private LeaderBoardPanel leaderBoardPanel = new LeaderBoardPanel();

    public LeaderBoardDialog(Frame owner){
        super(owner, "리더보드", true);
        setMinimumSize(new Dimension(250,550));
        setResizable(false);
        setContentPane(leaderBoardPanel);
    }
}
