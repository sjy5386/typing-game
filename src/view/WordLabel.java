package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WordLabel extends JLabel {
    private static final int MIN_X = 0;
    private static final int MAX_X = 800;
    private static final int MIN_Y= 0;
    private static final int MAX_Y = 600;

    public WordLabel(String text) {
        super(text);
        setFont(new Font("맑은 고딕", Font.BOLD, 16));
        int width = getFont().getSize() * text.length();
        int height = getFont().getSize() * 2;
        setSize(width, height);
        Random random = new Random();
        int x = random.nextInt(MAX_X + 1 - width) + MIN_X;
        int y = random.nextInt(MAX_Y + 1 - height) + MIN_Y;
        setLocation(x, y);
    }
}
