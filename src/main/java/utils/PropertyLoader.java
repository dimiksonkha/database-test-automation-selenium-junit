package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private Properties properties;
    private String driverClassName;
    private String dbUser;
    private String dbPassword;
    private String dbUrl;


    public PropertyLoader() {

    }
    public void loadProperty() throws IOException {
        // create file input stream object for the properties file
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/resources/database.properties");
        // create Properties class object to access properties file
        properties = new Properties();
        // load the properties file
        properties.load(fis);

    }


    public String getDriverClassName(){

        return properties.getProperty("db.class.name");
    }

    public String getDbUrl(){
        return properties.getProperty("db.url");
    }
    public String getDbUser(){
        return properties.getProperty("db.user");
    }
    public String getDbPassword(){
        return properties.getProperty("db.password");
    }


}

