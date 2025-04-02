package music_streaming;

public class LocalPlayer implements MusicPlayer {
    public void play(String song) {
        System.out.println("Playing local file: " + song);
    }
}
