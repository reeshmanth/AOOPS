package TASK2;

public class LocalFileAdapter implements MusicSource {
    private String filePath;

    public LocalFileAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getSourceName() {
        return "Local File: " + filePath;
    }

    @Override
    public String getSourceDetails() {
        return filePath;
    }
}
