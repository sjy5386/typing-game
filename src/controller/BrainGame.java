package controller;

import view.BrainWordLabel;
import view.GamePanel;

public class BrainGame extends Game {
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
}
