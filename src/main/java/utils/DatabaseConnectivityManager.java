package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnectivityManager  {
    protected static PropertyLoader propertyLoader = new PropertyLoader();
    private static void loadDBProperty() throws IOException {
        propertyLoader.loadProperty();
    }
    static {
        try {
            loadDBProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Connection object
    private static Connection connection = null;
    // Statement object
    private static Statement statement;
    // Constant for Database URL
    private static String DB_URL = propertyLoader.getDbUrl();
    // Constant for Database Username
    private static String DB_USER = propertyLoader.getDbUser();

    // Constant for Database Password
    private static String DB_PASSWORD = propertyLoader.getDbPassword();

    public DatabaseConnectivityManager() throws IOException {
        loadDBProperty();
    }

    public Statement getStatement(){
        return statement;
    }
    public void setUpDatabase() throws Exception {
        try{
            // Make the database connection
            String dbClass = propertyLoader.getDriverClassName();
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            statement = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void closeDatabase() throws SQLException {
        // Close DB connection
        if (connection != null) {
            connection.close();
        }
    }



}