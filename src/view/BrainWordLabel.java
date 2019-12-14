package view;

import java.awt.*;

public class BrainWordLabel extends WordLabel {
    private static final int INTERVAL = 250;

    public BrainWordLabel(String text) {
        super(text);
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
                    if(fontSize == 22)
                        setForeground(new Color(0x00000000, true));
                    else if(fontSize == 28)
                        setForeground(new Color(0xFF000000, true));
                } else { // decrease
                    fontSize -= DELTA;
                    x += DELTA * 2;
                    if (x > MAX_X - MIN_X - getWidth())
                        x = MAX_X - MIN_X - getWidth();
                    if(fontSize == 25)
                        setForeground(new Color(0x00000000, true));
                    else if(fontSize == 20)
                        setForeground(new Color(0xFF000000, true));
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
