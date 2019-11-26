package view;

import model.WordManager;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel {
    private JList<String> list = new JList<String>();
    private JScrollPane scrollPane = new JScrollPane(list);
    private JTextField textField = new JTextField(20);
    private JButton addButton = new JButton("추가");
    private JButton removeButton = new JButton("삭제");
    private JButton loadButton = new JButton("열기");
    private JButton saveButton = new JButton("저장");
    private WordManager wordManager = new WordManager();

    public WordPanel() {
        setLayout(new FlowLayout());
        setBackground(MyColor.BASE);
        list.setBackground(MyColor.LIGHT);
        list.setListData(wordManager.getAllWords());
        list.addListSelectionListener(e -> {
            JList<String> list = (JList<String>)e.getSource();
            textField.setText(list.getSelectedValue());
        });
        scrollPane.setPreferredSize(new Dimension(350, 320));
        textField.setBackground(MyColor.LIGHT);
        textField.addActionListener(e -> addButton.doClick());
        addButton.setBackground(MyColor.DARK);
        addButton.addActionListener(e -> {
            wordManager.add(textField.getText());
            textField.setText("");
            list.setListData(wordManager.getAllWords());
            textField.setFocusable(true);
            textField.requestFocus(true);
        });
        removeButton.setBackground(MyColor.DARK);
        removeButton.addActionListener(e -> {
            wordManager.remove(textField.getText());
            textField.setText("");
            list.setListData(wordManager.getAllWords());
        });
        loadButton.setBackground(MyColor.DARK);
        loadButton.addActionListener(e -> {
            if (wordManager.load())
                list.setListData(wordManager.getAllWords());
        });
        saveButton.setBackground(MyColor.DARK);
        saveButton.addActionListener(e -> {
            if (wordManager.save())
                JOptionPane.showMessageDialog(this, "저장되었습니다.");
        });
        add(scrollPane);
        add(textField);
        add(addButton);
        add(removeButton);
        add(loadButton);
        add(saveButton);
        setVisible(true);
    }
}
