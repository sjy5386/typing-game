package view;

import javax.swing.*;
import java.awt.*;

public class AudioDialog extends JDialog {
    private AudioPanel audioPanel = new AudioPanel(this);

    public AudioDialog(JFrame owner) {
        super(owner, "소리 설정");
        setMinimumSize(new Dimension(300, 140));
        setResizable(false);
        setContentPane(audioPanel);
    }
}
