/**
 * Class handling various database operations, including executing SQL queries and updates.
 */
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
    
    /**
     * Sets the current database connection.
     *
     * @param c The new database connection.
     */
    public static void setConnection(Connection c){
        DBOperations.connection = c;
    }
    
    /**
     * Reads a SQL query from the user.
     *
     * @return The SQL query entered by the user.
     */
    public static String takeQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSQL> ");
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Parses the SQL query to determine whether it is a SELECT query or an update query.
     *
     * @param query The SQL query to parse.
     * @return 1 if it is a SELECT query, 0 if it is an update query.
     */
    public static int parse(String query) {
        String[] words = query.trim().split("\\s+"); // Split the query into words

        // Check if the first word (if any) is "SELECT" (case-insensitive)
        if (words.length > 0 && "SELECT".equalsIgnoreCase(words[0])) {
            return 1; // Return 1 if the first word is "SELECT"
        } else {
            return 0; // Return 0 otherwise
        }
    }

    /**
     * Executes an SQL update query.
     *
     * @param query The SQL update query to execute.
     */
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

    /**
     * Executes an SQL SELECT query and prints the result set to the console.
     *
     * @param query The SQL SELECT query to execute.
     */
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
