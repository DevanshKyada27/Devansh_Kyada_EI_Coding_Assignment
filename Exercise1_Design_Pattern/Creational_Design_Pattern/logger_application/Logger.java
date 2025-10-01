import java.util.ArrayList;
import java.util.List;

public class Logger {
    //a constructor is invoked when we create an object but here we need to call the object only once

    private static Logger logger;
    private List<String> logs;

    private Logger() {
        logs = new ArrayList<>();
        System.out.println("Logger initialized...");
    }

    public static Logger getLogger() {
        //object of this class
        if(logger == null) {
            //here we will perform block synchronization for multi threading process
            synchronized(Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    // logging methods
    public void logInfo(String message) {
        String log = "[INFO] " + message;
        logs.add(log);
        System.out.println(log);
    }

    public void logError(String message) {
        String log = "[ERROR] " + message;
        logs.add(log);
        System.out.println(log);
    }

    // display all stored logs
    public void showLogs() {
        if (logs.isEmpty()) {
            System.out.println("No logs available. :(");
            return;
        }
        System.out.println("\n--- All Logs ---");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("----------------\n");
    }
}
