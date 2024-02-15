package com.algonquin.cst8288.assignment2.logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LMSLogger {
    
    private static LMSLogger instance = null;
    private final String logFilePath = "logs.txt"; // Path is src\.. 
    private boolean cleared = false; // flag to indicate FileWriter to clear file the first time log is called
    
    private LMSLogger(){}

    public static LMSLogger getInstance() {
        if (instance == null){
            instance = new LMSLogger();
        }
        return instance;
    }
    
    public void log(String s){log(LogLevel.INFO,s);}

    public void log(LogLevel lvl, String s) {
        
        try (var writer = new PrintWriter(new FileWriter(logFilePath, cleared))) {
            if (!cleared){cleared = true;}
            
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
