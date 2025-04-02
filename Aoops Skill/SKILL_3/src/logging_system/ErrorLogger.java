package logging_system;

public class ErrorLogger extends Logger {
    public ErrorLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.err.println("[ERROR] " + message);
    }
}
