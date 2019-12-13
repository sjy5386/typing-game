package controller;

import model.Settings;
import view.AudioPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioPanelListener implements ActionListener, ChangeListener {
    AudioPanel view;

    public AudioPanelListener(AudioPanel view) {
        this.view = view;
        view.getEffectCheckBox().setSelected(Settings.isSoundEffectEnabled());
        view.getEffectSlider().setValue(Settings.getSoundEffectVolume());
        view.getBackgroundCheckBox().setSelected(Settings.isBackgroundMusicEnabled());
        view.getBackgroundSlider().setValue(Settings.getBackgroundMusicVolume());
    }

    private void onEffectCheckBoxClicked() {
        Settings.setSoundEffectEnabled(view.getEffectCheckBox().isSelected());
    }

    private void onEffectSliderChanged() {
        Settings.setSoundEffectVolume(view.getEffectSlider().getValue());
    }

    private void onBackgroundCheckBoxClicked() {
        Settings.setBackgroundMusicEnabled(view.getBackgroundCheckBox().isSelected());
    }

    private void onBackgroundSliderChanged() {
        Settings.setBackgroundMusicVolume(view.getBackgroundSlider().getValue());
    }

    private void onOkButtonClicked() {
        view.getOwner().setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "효과음":
                onEffectCheckBoxClicked();
                break;
            case "배경음":
                onBackgroundCheckBoxClicked();
                ;
                break;
            case "확인":
                onOkButtonClicked();
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if (slider == view.getEffectSlider())
            onEffectSliderChanged();
        else if (slider == view.getBackgroundSlider())
            onBackgroundSliderChanged();
    }
}
