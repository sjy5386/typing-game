package view;

import javax.swing.*;
import java.awt.*;

public class WordDialog extends JDialog {
    private WordPanel wordPanel = new WordPanel();

    public WordDialog(JFrame owner) {
        super(owner, "단어", true);
        setMinimumSize(new Dimension(400, 460));
        setResizable(false);
        setContentPane(wordPanel);
    }
}
