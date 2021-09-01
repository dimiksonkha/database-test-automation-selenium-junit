package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DatabaseConnectivityManager;

import java.io.IOException;
import java.sql.SQLException;

public class BaseTests {

    protected static WebDriver driver;
    private static DatabaseConnectivityManager databaseConnectivityManager;

    static {
        try {
            databaseConnectivityManager = new DatabaseConnectivityManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp () throws Exception{
        databaseConnectivityManager.setUpDatabase();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        databaseConnectivityManager.closeDatabase();
        driver.quit();
    }
}