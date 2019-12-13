package view;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JTextField inputText = new JTextField(60);
    private ImageIcon inputImage = new ImageIcon("res/hot_balloon_input.jpg");

    public InputPanel() {
        setBackground(MyColor.LIGHT);
        setLayout(new FlowLayout());
        this.add(inputText);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(inputImage.getImage(), 0, 0, null);
    }


    public JTextField getInputText() {
        return inputText;
    }
}
