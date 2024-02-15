package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBOperations {
    
    private static Connection connection;
    public static LMSLogger l = LMSLogger.getInstance();
    
    public static void setConnection(Connection c){
        DBOperations.connection = c;
    }
    
    public static String takeQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSQL> ");
        String input = scanner.nextLine();
        return input;
    }

    public static int parse(String query) {
        String[] words = query.trim().split("\\s+"); // Split the query into words

        // Check if the first word (if any) is "SELECT" (case-insensitive)
        if (words.length > 0 && "SELECT".equalsIgnoreCase(words[0])) {
            return 1; // Return 1 if the first word is "SELECT"
        } else {
            return 0; // Return 0 otherwise
        }
    }

    public static void executeUpdate(String query) {
        if (connection == null){connection = DBConnection.getInstance().getConnection();}
        try (Statement s = connection.createStatement();) {
            int r = s.executeUpdate(query);
            String msg = r == 1 ?  " row affected" : " rows affected"; // grammar
            l.log("QUERY: " + query + "\n" + r + msg);
        }
        catch (SQLException ex) {
            l.log(LogLevel.ERROR, ex.getMessage());
        }
        catch (Exception e) {
            l.log(LogLevel.ERROR, "ERROR!");
        }
    }

    public static void executeQuery(String query) {
        if (connection == null){connection = DBConnection.getInstance().getConnection();}
        try ( // try-with-ressources for auto-closing
                Statement s = connection.createStatement(); // NEXT TIME REPLACE WITH PREPAREDSTATEMENT
                ResultSet r = s.executeQuery(query);
                )
            {
                ResultSetMetaData m = r.getMetaData();

                while(r.next()){
                    for (int i = 1; i <= m.getColumnCount() ; i++) {
                        System.out.println(
                                m.getColumnName(i) + ": " +
                                r.getObject(i));
                    }
                    System.out.println("-------------");
                }
        } catch (SQLException ex) {
            l.log(LogLevel.ERROR, ex.getMessage());
        } catch (Exception e) {
            l.log(LogLevel.ERROR, "ERROR!");
        }
    }
}
