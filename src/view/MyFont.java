package view;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class MyFont {
    public static final Font DEFAULT = new Font("맑은 고딕", Font.PLAIN, 12);

    public static void setDefaultFont(Font font) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, font);
        }
    } // https://stackoverflow.com/questions/7434845/setting-the-default-font-of-swing-program
}