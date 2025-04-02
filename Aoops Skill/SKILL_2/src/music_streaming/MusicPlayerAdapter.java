package music_streaming;

public class MusicPlayerAdapter implements MusicPlayer {
    private OnlineStreaming onlineStreaming;
    private RadioPlayer radioPlayer;

    public MusicPlayerAdapter(String type) {
        if (type.equalsIgnoreCase("online")) {
            onlineStreaming = new OnlineStreaming();
        } else if (type.equalsIgnoreCase("radio")) {
            radioPlayer = new RadioPlayer();
        }
    }

    public void play(String song) {
        if (onlineStreaming != null) {
            onlineStreaming.stream(song);
        } else if (radioPlayer != null) {
            radioPlayer.tune(song);
        }
    }
}
