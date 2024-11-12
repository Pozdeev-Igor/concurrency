package org.example.b2_connection_dispenser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Use class ThreadLocal for ogranichenie with one thread
 */
public class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private final ThreadLocal<Connection> connectionHolder =
            ThreadLocal.withInitial(ConnectionDispenser::getDBConnection);

    private static Connection getDBConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to acquire Connection, e");
        }
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
