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
        c.setBackground(MyColor.BASE);
        list.setBackground(MyColor.LIGHT);
        scrollPane.setPreferredSize(new Dimension(350, 320));
        textField.setBackground(MyColor.LIGHT);
        addButton.setBackground(MyColor.DARK);
        c.add(scrollPane);
        c.add(textField);
        c.add(addButton);
        setVisible(true);
    }

    public static void main(String [] args) { // for testing
        WordFrame wordFrame = new WordFrame();
    }
}
