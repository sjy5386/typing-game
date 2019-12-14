package controller;

import model.Settings;
import view.AudioPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AudioPanelListener implements ActionListener, ChangeListener, ItemListener {
    AudioPanel view;

    public AudioPanelListener(AudioPanel view) {
        this.view = view;
        view.getEffectCheckBox().setSelected(Settings.isSoundEffectEnabled());
        view.getEffectSlider().setValue(Settings.getSoundEffectVolume());
        view.getBackgroundCheckBox().setSelected(Settings.isBackgroundMusicEnabled());
        view.getBackgroundSlider().setValue(Settings.getBackgroundMusicVolume());
    }

    private void onEffectCheckBoxItemStateChanged() {
        boolean selected = view.getEffectCheckBox().isSelected();
        Settings.setSoundEffectEnabled(selected);
        view.getEffectSlider().setEnabled(selected);
    }

    private void onEffectSliderChanged() {
        Settings.setSoundEffectVolume(view.getEffectSlider().getValue());
    }

    private void onBackgroundCheckBoxItemStateChanged() {
        boolean selected = view.getBackgroundCheckBox().isSelected();
        Settings.setBackgroundMusicEnabled(selected);
        view.getBackgroundSlider().setEnabled(selected);
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
            case "확인":
                onOkButtonClicked();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getSource();
        if (checkBox == view.getEffectCheckBox())
            onEffectCheckBoxItemStateChanged();
        else if (checkBox == view.getBackgroundCheckBox())
            onBackgroundCheckBoxItemStateChanged();
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
