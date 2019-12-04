package controller;

import model.AudioPlayer;
import model.MyAudio;
import model.WordManager;
import view.GamePanel;
import view.WordLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game implements ActionListener, Runnable {
    private GamePanel view;
    private WordManager wordManager = new WordManager();
    private List<WordLabel> wordLabels = Collections.synchronizedList(new LinkedList<>());
    private int score = 0;
    private int level = 1;

    public Game(GamePanel view) {
        this.view = view;
        view.getScorePanel().setScore(0);
        view.getScorePanel().setLevel(1);
        addWordLabel();
    }

    private void addWordLabel() {
        WordLabel wordLabel = new WordLabel(wordManager.getRandomWord());
        wordLabels.add(wordLabel);
        view.getGameGroundPanel().add(wordLabel);
        Thread th = new Thread(wordLabel);
        th.start();
    }

    private void playSoundEffect(String audio) {
        AudioPlayer audioPlayer = new AudioPlayer(audio);
        audioPlayer.play();
    }

    private synchronized void gc() { // Garbage Collection
        wordLabels.removeIf(item -> !item.isVisible());
        Component[] components = view.getGameGroundPanel().getComponents();
        for (Component c : components) {
            if (c instanceof WordLabel) {
                WordLabel w = (WordLabel) c;
                if (!w.isVisible())
                    view.getGameGroundPanel().remove(w);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String myWord = ((JTextField) e.getSource()).getText();
        view.getInputPanel().getInputText().setText("");
        Iterator<WordLabel> it = wordLabels.iterator();
        WordLabel wordLabel = null;
        while (it.hasNext()) {
            WordLabel w = it.next();
            if (myWord.equals(w.getText())) {
                wordLabel = w;
                break;
            }
        }
        if (wordLabel != null) {
            wordLabel.setVisible(false);
            wordLabels.remove(wordLabel);
            playSoundEffect(MyAudio.SHOT);
            score += myWord.length();
            level = score / 100 + 1;
            view.getScorePanel().setScore(score);
            view.getScorePanel().setLevel(level);
        } else {
            playSoundEffect(MyAudio.DRY);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (wordLabels.size() < level + 2)
                addWordLabel();
            gc();
        }
    }
}
