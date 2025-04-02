package logging_system;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("[CONSOLE] " + message);
    }
}
