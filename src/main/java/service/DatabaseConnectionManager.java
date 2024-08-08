package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnectionManager {
    private final String url;

    public DatabaseConnectionManager() throws IOException {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("configdb.properties")) {
            if (input == null) {
                throw new IOException("Unable to find configdb.properties");
            }
            props.load(input);
        }

        String databaseName = props.getProperty("database.name");
        String username = props.getProperty("database.username");
        String password = props.getProperty("database.password");

        this.url = "jdbc:sqlserver://localhost:1433;database=" + databaseName
                + ";user=" + username
                + ";password=" + password
                + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
    }

    public Connection getConnection() throws SQLException {
        System.out.println("Connecting to database with URL: " + this.url);
        return DriverManager.getConnection(this.url);
    }
}

