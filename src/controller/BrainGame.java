package controller;

import model.MyAudio;
import view.BrainWordLabel;
import view.GamePanel;
import view.WordLabel;

import java.awt.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BrainGame extends Game {
    private List<BrainWordLabel> wordLabels = Collections.synchronizedList(new LinkedList<>());

    public BrainGame(GamePanel view) {
        super(view);
    }

    @Override
    protected void addWordLabel() {
        BrainWordLabel wordLabel = new BrainWordLabel(wordManager.getRandomWord());
        wordLabels.add(wordLabel);
        view.getGameGroundPanel().add(wordLabel);
        Thread th = new Thread(wordLabel);
        th.start();
    }

    @Override
    protected WordLabel searchTarget(String word) {
        Iterator<BrainWordLabel> it = wordLabels.iterator();
        while (it.hasNext()) {
            WordLabel w = it.next();
            if (word.equals(w.getText()))
                return w;
        }
        return null;
    }

    @Override
    protected void hit(WordLabel target) {
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

    @Override
    protected synchronized void gc() { // Garbage Collection
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
    public void run() {
        try {
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
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            return;
        }
        stop();
    }
}
