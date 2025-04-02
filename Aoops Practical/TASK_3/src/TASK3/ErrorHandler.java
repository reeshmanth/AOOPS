package TASK3;

public class ErrorHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }
    @Override
    protected void log(String message) {
        System.err.println("ERROR: " + message);
    }
}
