package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WordLabel extends JLabel implements Runnable {
    private static final int MIN_X = 0;
    private static final int MAX_X = 800;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 400;

    private static final int MIN_FONT_SIZE = 0;
    private static final int MAX_FONT_SIZE = 32;
    private static final int DELTA = 1;
    private static final int INTERVAL = 200;

    private boolean hit = false;

    public WordLabel(String text) {
        super(text);
        setFont(new Font(MyFont.DEFAULT.getFontName(), Font.BOLD, MIN_FONT_SIZE));
        int width = MAX_FONT_SIZE * text.length();
        int height = MAX_FONT_SIZE * 2;
        setSize(width, height);
        Random random = new Random();
        int x = random.nextInt(MAX_X + 1 - MIN_X - width) + MIN_X;
        int y = random.nextInt(MAX_Y + 1 - MIN_Y - height) + MIN_Y;
        setLocation(x, y);
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public void run() {
        try {
            if (hit)
                return;
            if (!isVisible())
                setVisible(true);
            boolean peak = false;
            while (true) {
                Font font = getFont();
                String fontName = font.getFontName();
                int fontStyle = font.getStyle();
                int fontSize = font.getSize();
                int x = getX();
                int y = getY();

                if (!peak) { // increase
                    fontSize += DELTA;
                    x -= DELTA * 2;
                    if (x < MIN_X)
                        x = MIN_X;
                } else { // decrease
                    fontSize -= DELTA;
                    x += DELTA * 2;
                    if (x > MAX_X - MIN_X - getWidth())
                        x = MAX_X - MIN_X - getWidth();
                }
                setFont(new Font(fontName, fontStyle, fontSize));
                setLocation(x, y);

                if (getFont().getSize() >= MAX_FONT_SIZE)
                    peak = true;
                else if (getFont().getSize() <= MIN_FONT_SIZE && peak)
                    break;
                Thread.sleep(INTERVAL);
            }
            setVisible(false);
        } catch (InterruptedException e) {
            return;
        }
    }
}
