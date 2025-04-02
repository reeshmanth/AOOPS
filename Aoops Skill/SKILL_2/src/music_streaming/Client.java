package music_streaming;

public class Client {
    public static void main(String[] args) {
        MusicPlayer localPlayer = new LocalPlayer();
        localPlayer.play("Song.mp3");

        MusicPlayer onlineAdapter = new MusicPlayerAdapter("online");
        onlineAdapter.play("OnlineSong.mp3");

        MusicPlayer radioAdapter = new MusicPlayerAdapter("radio");
        radioAdapter.play("Radio FM 101");

        MusicPlayer enhancedPlayer = new EqualizerDecorator(new LocalPlayer());
        enhancedPlayer.play("SongWithEqualizer.mp3");
    }
}
