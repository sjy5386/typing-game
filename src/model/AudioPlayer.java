package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private Clip clip;

    public AudioPlayer() {
        init();
    }

    public AudioPlayer(String filename) {
        init();
        load(filename);
    }

    private void init() {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public boolean load(String filename) {
        if (clip.isOpen())
            clip.close();

        try {
            File file = new File(filename);
            AudioInputStream in = AudioSystem.getAudioInputStream(file);
            clip.open(in);
            return true;
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void play() {
        if (!clip.isOpen())
            return;

        clip.start();
    }

    public void pause() {
        if (!clip.isOpen())
            return;

        clip.stop();
    }

    public void stop() {
        if (!clip.isOpen())
            return;

        clip.stop();
        clip.setFramePosition(0);
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }

    public int getPosition() {
        return clip.getFramePosition();
    }

    public void setPosition(int position) {
        if (!clip.isOpen())
            return;

        clip.setFramePosition(position);
    }

    public int getLength() {
        return clip.getFrameLength();
    }

    public void setLoop(int count) {
        if (!clip.isOpen())
            return;

        clip.loop(count);
    }
}
