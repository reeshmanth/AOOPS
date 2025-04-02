package TASK2;

public class OnlineStreamingAdapter implements MusicSource {
    private String streamingUrl;

    public OnlineStreamingAdapter(String streamingUrl) {
        this.streamingUrl = streamingUrl;
    }

    @Override
    public String getSourceName() {
        return "Online Streaming: " + streamingUrl;
    }

    @Override
    public String getSourceDetails() {
        return streamingUrl;
    }
}
