package be.masqueou.punishmaster.spigot.database.mysql.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private final String urlBase;
    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;
    private Connection connection;

    public MySQL(String urlBase, String host, String port, String database, String username, String password) {
        this.urlBase = urlBase;
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public void connection() {
        try {
            this.connection = DriverManager.getConnection(this.urlBase + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
        } catch (SQLException sqlException) {
            System.out.println("SQL Connection Error: "+sqlException.getErrorCode());
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                this.connection.close();
            } catch (SQLException sqlException) {
                System.out.println("SQL Disconnection Error: "+sqlException.getErrorCode());
            }
        }
    }

    public boolean isConnected() {
        try {
            return (this.connection != null) && (!this.connection.isClosed()) && (!this.connection.isValid(5));
        } catch (SQLException sqlException) {
            System.out.println("SQL Error: "+sqlException.getErrorCode());
        }
        return false;
    }

    public Connection getConnection() {
        return connection;
    }
}

