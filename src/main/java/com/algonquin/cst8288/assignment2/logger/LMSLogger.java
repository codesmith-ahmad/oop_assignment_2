/*
 * Logger class for logging messages with different log levels.
 */
package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LMSLogger {
    
    private static LMSLogger instance = null;
    private final String logFilePath = "logs.txt"; // Path is src\..
    private boolean cleared = false; // Flag to indicate FileWriter to clear the file the first time log is called
    
    private LMSLogger(){}

    /**
     * Get the singleton instance of LMSLogger.
     * 
     * @return The instance of LMSLogger.
     */
    public static LMSLogger getInstance() {
        if (instance == null){
            instance = new LMSLogger();
        }
        return instance;
    }
    
    /**
     * Log a message with the default log level (INFO).
     * 
     * @param message The message to be logged.
     */
    public void log(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Log a message with the specified log level.
     * 
     * @param level The log level.
     * @param message The message to be logged.
     */
    public void log(LogLevel level, String message) {
        try (var writer = new PrintWriter(new FileWriter(logFilePath, cleared))) {
            if (!cleared) {
                cleared = true;
            }
            
            // Get current timestamp
            LocalDateTime timestamp = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format log message
            String logMessage = String.format("\n[%s] %s - %s: %s", formatter.format(timestamp), logFilePath, level.name(), message);

            // Print or store the log message as needed
            System.out.println(logMessage);
            writer.println(logMessage);
        }
        catch (IOException e) {
            // Handle the exception (e.g., print to console)
            e.printStackTrace();
        }
    }
}
