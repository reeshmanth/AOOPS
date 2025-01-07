package TASK2;

public class AdvancedMusicPlayer implements MusicPlayer {
    private MusicSource musicSource;

    public AdvancedMusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    @Override
    public void playMusic(String sourceDetails) {
        System.out.println("Playing music from: " + musicSource.getSourceName());
        System.out.println("Details: " + sourceDetails);
    }
}