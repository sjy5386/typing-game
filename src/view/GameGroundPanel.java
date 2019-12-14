package view;

import javax.swing.*;
import java.awt.*;

public class GameGroundPanel extends JPanel {
    private ImageIcon backImage = new ImageIcon("res/hot_balloon.jpg");
    public GameGroundPanel() {
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backImage.getImage(), 0, 0, null);
    }
}
