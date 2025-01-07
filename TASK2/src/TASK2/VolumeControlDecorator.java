package TASK2;

public class VolumeControlDecorator implements MusicPlayer {
    private MusicPlayer musicPlayer;

    public VolumeControlDecorator(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void playMusic(String sourceDetails) {
        musicPlayer.playMusic(sourceDetails);
        adjustVolume();
    }

    private void adjustVolume() {
        System.out.println("Adjusting volume settings...");
    }
}
