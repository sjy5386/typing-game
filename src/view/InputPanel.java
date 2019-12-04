package view;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JTextField inputText = new JTextField(60);

    public InputPanel() {
        setBackground(MyColor.LIGHT);
        setLayout(new FlowLayout());
        this.add(inputText);
    }

    public JTextField getInputText() {
        return inputText;
    }
}
