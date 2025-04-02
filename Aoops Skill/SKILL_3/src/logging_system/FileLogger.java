package logging_system;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {
    public FileLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            writer.write("[FILE] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
