package org.bada.hw2.dao;

import org.bada.hw2.eccezioni.ErroreLetturaPassword;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static Connection connection;

    private ConnectionDB() throws IOException, SQLException{
        connect();
    }

    public static void connect() throws IOException, SQLException{

        InputStream input = new FileInputStream("src/resources/db.properties") ;
            Properties properties = new Properties();
            properties.load(input);

            String connectionUrl = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty("LOGIN_USER");
            String pass = properties.getProperty("LOGIN_PASS");

            connection = DriverManager.getConnection(connectionUrl, user, pass);

    }

    public static Connection getConnection() throws SQLException, ErroreLetturaPassword {
        try {
            if(connection == null){
               new ConnectionDB();
            }

        }catch (SQLException e){
        throw new SQLException("impossibile connettersi al database\nriprova più tardi");
        } catch (IOException e) {
        throw new ErroreLetturaPassword("impossibile estrarre la password\ndi connessione al db");
    }
        return connection;

    }
}
