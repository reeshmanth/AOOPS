package music_streaming;

public class MusicPlayerDecorator implements MusicPlayer {
    protected MusicPlayer player;

    public MusicPlayerDecorator(MusicPlayer player) {
        this.player = player;
    }

    public void play(String song) {
        player.play(song);
    }
}
