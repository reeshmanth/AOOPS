package music_streaming;

public class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer player) {
        super(player);
    }

    public void play(String song) {
        super.play(song);
        System.out.println("Applying equalizer settings...");
    }
}
