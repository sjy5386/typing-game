package view;

import javax.swing.*;
import java.awt.*;

public class WordDialog extends JDialog {
    public WordDialog(Frame owner) {
        super(owner);
        setTitle("단어");
        setMinimumSize(new Dimension(400, 430));
        setResizable(false);
        add(new WordPanel());
    }
}
