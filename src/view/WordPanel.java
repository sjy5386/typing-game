package view;

import controller.WordPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class WordPanel extends JPanel {
    private WordPanelListener controller = new WordPanelListener(this);

    private JLabel sizeTextLabel = new JLabel("단어: ");
    private JLabel sizeLabel = new JLabel("0");
    private JList<String> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane(list);
    private JTextField textField = new JTextField(20);
    private JButton addButton = new JButton("추가");
    private JButton removeButton = new JButton("삭제");
    private JButton loadButton = new JButton("열기");
    private JButton saveButton = new JButton("저장");

    public WordPanel() {
        setBackground(MyColor.BASE);

        list.setBackground(MyColor.LIGHT);
        scrollPane.setPreferredSize(new Dimension(350, 320));
        textField.setBackground(MyColor.LIGHT);
        addButton.setBackground(MyColor.DARK);
        removeButton.setBackground(MyColor.DARK);
        loadButton.setBackground(MyColor.DARK);
        saveButton.setBackground(MyColor.DARK);

        list.addListSelectionListener(controller);
        textField.addActionListener(e -> addButton.doClick());
        addButton.addActionListener(controller);
        removeButton.addActionListener(controller);
        loadButton.addActionListener(controller);
        saveButton.addActionListener(controller);

        loadButton.doClick();

        setLayout(new FlowLayout());
        add(sizeTextLabel);
        add(sizeLabel);
        add(scrollPane);
        add(textField);
        add(addButton);
        add(removeButton);
        add(loadButton);
        add(saveButton);
        setVisible(true);
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public void setSize(int size) {
        sizeLabel.setText(String.valueOf(size));
    }

    public void setListData(Vector<String> listData) {
        list.setListData(listData);
    }
}
