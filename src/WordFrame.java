import javax.swing.*;
import java.awt.*;

public class WordFrame extends JFrame {
    private JList<String> list = new JList<String>();
    private JScrollPane scrollPane = new JScrollPane(list);
    private JTextField textField = new JTextField(25);
    private JButton addButton = new JButton("추가");

    public WordFrame() {
        super("단어");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(255, 224, 178));
        list.setBackground(new Color(255, 255, 228));
        scrollPane.setPreferredSize(new Dimension(350, 320));
        textField.setBackground(new Color(255, 255, 228));
        addButton.setBackground(new Color(203, 174, 130));
        c.add(scrollPane);
        c.add(textField);
        c.add(addButton);
        setVisible(true);
    }

    public static void main(String [] args) { // for testing
        WordFrame wordFrame = new WordFrame();
    }
}
