/*
 * Enumeration representing different log levels.
 */
package com.algonquin.cst8288.assignment2.logger;

public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    final int level;

    /**
     * Constructor to set the log level.
     * 
     * @param level The log level.
     */
    LogLevel(int level) {
        this.level = level;
    }
}
