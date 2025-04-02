package TASK2;

public class EqualizerDecorator implements MusicPlayer {
    private MusicPlayer musicPlayer;

    public EqualizerDecorator(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void playMusic(String sourceDetails) {
        musicPlayer.playMusic(sourceDetails);
        applyEqualizer();
    }

    private void applyEqualizer() {
        System.out.println("Applying equalizer settings...");
    }
}
