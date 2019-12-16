package model;

public class Settings {
    private static boolean soundEffectEnabled = true;
    private static int soundEffectVolume = 100;
    private static boolean backgroundMusicEnabled = true;
    private static int backgroundMusicVolume = 60;

    public static boolean isSoundEffectEnabled() {
        return soundEffectEnabled;
    }

    public static void setSoundEffectEnabled(boolean enabled) {
        soundEffectEnabled = enabled;
    }

    public static int getSoundEffectVolume() {
        return soundEffectVolume;
    }

    public static void setSoundEffectVolume(int volume) {
        soundEffectVolume = volume;
    }

    public static boolean isBackgroundMusicEnabled() {
        return backgroundMusicEnabled;
    }

    public static void setBackgroundMusicEnabled(boolean enabled) {
        backgroundMusicEnabled = enabled;
    }

    public static int getBackgroundMusicVolume() {
        return backgroundMusicVolume;
    }

    public static void setBackgroundMusicVolume(int volume) {
        backgroundMusicVolume = volume;
    }
}
