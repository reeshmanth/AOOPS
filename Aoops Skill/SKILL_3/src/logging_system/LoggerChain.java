package logging_system;

public class LoggerChain {
    public static Logger getLoggerChain() {
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);
        Logger fileLogger = new FileLogger(LogLevel.DEBUG);
        Logger consoleLogger = new ConsoleLogger(LogLevel.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}
