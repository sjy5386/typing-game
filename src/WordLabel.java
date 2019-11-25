import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WordLabel extends JLabel {
    private static final int MIN_X = 0;
    private static final int MAX_X = 700;
    private static final int MIN_Y= 0;
    private static final int MAX_Y = 500;

    public WordLabel(String text) {
        super(text);
        Random random = new Random();
        int x = random.nextInt(MAX_X + 1) + MIN_X;
        int y = random.nextInt(MAX_Y + 1) + MIN_Y;
        setLocation(x, y);
        setSize(text.length() * 16, 16);
        setFont(new Font("맑은 고딕", Font.PLAIN, 16));
    }
}
