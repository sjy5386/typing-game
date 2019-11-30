package controller;

import model.WordManager;
import view.WordPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordPanelListener implements ActionListener, ListSelectionListener {
    private WordPanel view;
    private WordManager wordManager = new WordManager();

    public WordPanelListener(WordPanel view) {
        this.view = view;
    }

    private void onAddButtonClicked() {
        wordManager.add(view.getText());
        view.setText("");
        refresh();
    }

    private void onRemoveButtonClicked() {
        wordManager.remove(view.getText());
        view.setText("");
        refresh();
    }

    private void onSaveButtonClicked() {
        if (wordManager.save())
            JOptionPane.showMessageDialog(view, "저장되었습니다.", "단어", 1);
    }

    private void onLoadButtonClicked() {
        if (wordManager.load())
            refresh();
    }

    private void refresh() {
        view.setSize(wordManager.getSize());
        view.setListData(wordManager.getAllWords());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "추가":
                onAddButtonClicked();
                break;
            case "삭제":
                onRemoveButtonClicked();
                break;
            case "열기":
                onLoadButtonClicked();
                break;
            case "저장":
                onSaveButtonClicked();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>)e.getSource();
        view.setText(list.getSelectedValue());
    }
}
