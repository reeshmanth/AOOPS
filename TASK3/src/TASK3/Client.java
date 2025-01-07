package TASK3;

public class Client {
    public static void main(String[] args) {
        LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);
        Logger logger = new Logger();
        System.out.println("Processing INFO level messages:");
        logger.addCommand(new LogCommand(infoHandler));
        logger.processCommands();
        System.	out.println("\nProcessing DEBUG level messages:");
        logger.addCommand(new LogCommand(debugHandler));
        logger.processCommands();
        System.out.println("\nProcessing ERROR level messages:");
        logger.addCommand(new LogCommand(errorHandler));
        logger.processCommands();
    }
}

