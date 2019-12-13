package controller;

import model.*;
import view.GamePanel;
import view.WordLabel;

import javax.sound.sampled.Clip;
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
    private AudioPlayer bgmPlayer = new AudioPlayer();
    private LeaderBoardManager leaderBoardManager = new LeaderBoardManager();
    private int score = 0;
    private int level = 1;
    private int life = 5;

    private boolean flag = true;

    public Game(GamePanel view) {
        this.view = view;
        view.getScorePanel().setScore(score);
        view.getScorePanel().setLevel(level);
        view.getScorePanel().setLife(life);
        view.getGameGroundPanel().removeAll();
        view.getGameGroundPanel().revalidate();
        view.getGameGroundPanel().repaint();
        bgmPlayer.load(MyAudio.BACKGROUND);
        bgmPlayer.setLoop(Clip.LOOP_CONTINUOUSLY);
        bgmPlayer.play();
    }

    private void addWordLabel() {
        WordLabel wordLabel = new WordLabel(wordManager.getRandomWord());
        wordLabels.add(wordLabel);
        view.getGameGroundPanel().add(wordLabel);
        Thread th = new Thread(wordLabel);
        th.start();
    }

    private void playSoundEffect(String audio) {
        if (!Settings.isSoundEffectEnabled())
            return;
        AudioPlayer audioPlayer = new AudioPlayer(audio);
        audioPlayer.setVolume(Settings.getSoundEffectVolume());
        audioPlayer.play();
    }

    private WordLabel searchTarget(String word) {
        Iterator<WordLabel> it = wordLabels.iterator();
        while (it.hasNext()) {
            WordLabel w = it.next();
            if (word.equals(w.getText()))
                return w;
        }
        return null;
    }

    private void hit(WordLabel target) {
        String word = target.getText();
        target.setHit(true);
        target.setVisible(false);
        wordLabels.remove(target);
        playSoundEffect(MyAudio.SHOT);
        score += word.length();
        int prevLevel = level;
        level = score / 100 + 1;
        if (prevLevel < level) {
            life = 5;
            view.getScorePanel().setLife(life);
        }
        view.getScorePanel().setScore(score);
        view.getScorePanel().setLevel(level);
        view.getGameGroundPanel().revalidate();
        view.getGameGroundPanel().repaint();
    }

    public void stop() {
        bgmPlayer.stop();
        life = 0;
    }

    private void gameOver() {
        String name = JOptionPane.showInputDialog(view, "이름을 입력하세요.", "Game Over!", 3);
        Player player = new Player(name);
        leaderBoardManager.add(player);
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private synchronized void gc() { // Garbage Collection
        wordLabels.removeIf(item -> !item.isVisible());
        Component[] components = view.getGameGroundPanel().getComponents();
        for (Component c : components) {
            if (c instanceof WordLabel) {
                WordLabel w = (WordLabel) c;
                if (!w.isVisible()) {
                    view.getGameGroundPanel().remove(w);
                    if (!w.isHit()) {
                        life--;
                        view.getScorePanel().setLife(life);
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String myWord = ((JTextField) e.getSource()).getText();
        view.getInputPanel().getInputText().setText("");
        WordLabel target = searchTarget(myWord);
        if (target != null)
            hit(target);
        else
            playSoundEffect(MyAudio.DRY);
    }

    @Override
    public void run() {
        while (true) {
            if (!flag)
                break;
            if (wordLabels.size() < level + 2)
                addWordLabel();
            gc();
            if (life <= 0) {
                gameOver();
                break;
            }
            if (Settings.isBackgroundMusicEnabled() && !bgmPlayer.isPlaying())
                bgmPlayer.play();
            else if (!Settings.isBackgroundMusicEnabled() && bgmPlayer.isPlaying())
                bgmPlayer.pause();
            bgmPlayer.setVolume(Settings.getBackgroundMusicVolume());
        }
        stop();
    }
}
