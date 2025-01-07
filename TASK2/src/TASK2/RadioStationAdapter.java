package TASK2;

public class RadioStationAdapter implements MusicSource {
    private String stationUrl;

    public RadioStationAdapter(String stationUrl) {
        this.stationUrl = stationUrl;
    }

    @Override
    public String getSourceName() {
        return "Radio Station: " + stationUrl;
    }

    @Override
    public String getSourceDetails() {
        return stationUrl;
    }
}