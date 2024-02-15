package com.algonquin.cst8288.assignment2.logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LMSLogger {
    
    private static LMSLogger instance = null;
    private final String logFilePath = "logs.txt"; // Path is src\..
    
    private LMSLogger() throws FileNotFoundException {new PrintWriter(logFilePath).close();}

    public static LMSLogger getInstance() {
        try {
            if (instance == null){return new LMSLogger();}
            else {return instance;} 
        }
        catch (FileNotFoundException e) {return null;}
    }
    
    public void log(String s){log(LogLevel.INFO,s);}

    public void log(LogLevel lvl, String s) {
        
        try (var writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            // Get current timestamp
            LocalDateTime timestamp = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format log message
            String logMessage = String.format("\n[%s] %s - %s: %s", formatter.format(timestamp), this.logFilePath, lvl.name(), s);

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
