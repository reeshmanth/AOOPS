package logging_system;

public abstract class Logger {
    protected LogLevel level;
    protected Logger nextLogger;

    public Logger(LogLevel level) {
        this.level = level;
    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}
