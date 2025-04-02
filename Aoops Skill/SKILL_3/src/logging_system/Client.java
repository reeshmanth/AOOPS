package logging_system;

public class Client {
    public static void main(String[] args) {
        Logger loggerChain = LoggerChain.getLoggerChain();


        loggerChain.logMessage(LogLevel.INFO, "This is an INFO message.");
        loggerChain.logMessage(LogLevel.DEBUG, "This is a DEBUG message.");
        loggerChain.logMessage(LogLevel.ERROR, "This is an ERROR message.");
    }
}
