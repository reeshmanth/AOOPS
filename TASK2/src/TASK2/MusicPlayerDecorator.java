package TASK2;

public abstract class MusicPlayerDecorator implements MusicPlayer {
    protected MusicPlayer decoratedMusicPlayer;

    public MusicPlayerDecorator(MusicPlayer decoratedMusicPlayer) {
        this.decoratedMusicPlayer = decoratedMusicPlayer;
    }

    @Override
    public void playMusic(String sourceDetails) {
        decoratedMusicPlayer.playMusic(sourceDetails);
    }
}
