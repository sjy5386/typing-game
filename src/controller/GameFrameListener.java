package controller;

import view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrameListener implements ActionListener {
    private GameFrame view;
    private Game game;
    private BrainGame brainGame;

    public GameFrameListener(GameFrame view) {
        this.view = view;
    }

    private boolean isGameRunning() {
        return game != null || brainGame != null;
    }

    private void stopGame() {
        if (game != null && game.getFlag())
            game.stop();
        if (brainGame != null && brainGame.getFlag())
            brainGame.stop();
        game = null;
        brainGame = null;
    }

    private void onNewGameMenuItemClicked() {
        if (isGameRunning()) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 2)
                return;
            stopGame();
        }
        game = new Game(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(game);
        Thread th = new Thread(game);
        th.start();
    }

    private void onNewGameBrainMenuItemClicked() {
        if (isGameRunning()) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 2)
                return;
            stopGame();
        }
        brainGame = new BrainGame(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(brainGame);
        Thread th = new Thread(brainGame);
        th.start();
    }

    private void onLeaderBoardMenuItemClicked() {
        if (!view.getLeaderBoardDialog().isVisible())
            view.getLeaderBoardDialog().setVisible(true);
        else
            view.getLeaderBoardDialog().requestFocus();
    }

    private void onExitMenuItemClicked() {
        if (JOptionPane.showConfirmDialog(view, "정말로 종료할까요?", view.getTitle(), 0) == 0)
            System.exit(0);
    }

    private void onWordListMenuItemClicked() {
        if (!view.getWordDialog().isVisible())
            view.getWordDialog().setVisible(true);
        else
            view.getWordDialog().requestFocus();
    }

    private void onSoundSettingsMenuItemClicked() {
        if (!view.getAudioDialog().isVisible())
            view.getAudioDialog().setVisible(true);
        else
            view.getAudioDialog().requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "새 클래식 게임":
                onNewGameMenuItemClicked();
                break;
            case "새 브레인 게임":
                onNewGameBrainMenuItemClicked();
                break;
            case "리더보드":
                onLeaderBoardMenuItemClicked();
                break;
            case "끝내기":
                onExitMenuItemClicked();
                break;
            case "단어 목록":
                onWordListMenuItemClicked();
                break;
            case "소리 설정":
                onSoundSettingsMenuItemClicked();
                break;
        }
    }
}
