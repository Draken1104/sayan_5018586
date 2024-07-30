//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// SingletonPatternExample.java

// Step 2: Define a Singleton Class
class Logger {

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize any resources here if needed
    }

    private static final class InstanceHolder {
        // Private static instance of Logger
        private static final Logger instance = new Logger();
    }

    // Public static method to get the single instance of Logger
    public static Logger getInstance() {
        return InstanceHolder.instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

// Step 4: Test the Singleton Implementation
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using the logger instance
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that both references point to the same instance
        System.out.println("Both logger1 and logger2 refer to the same instance.");
    }
}
