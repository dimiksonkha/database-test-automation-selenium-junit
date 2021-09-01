package activities;

import base.BaseTests;
import pages.ActivityPage;
import pages.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.DatabaseConnectivityManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActivityTests extends BaseTests {
    private DatabaseConnectivityManager databaseConnectivityManager = new DatabaseConnectivityManager();
    private Statement statement = databaseConnectivityManager.getStatement();
    private static final String HOME_PAGE = "http://localhost:5000/DailyActivityManager/";

    public ActivityTests() throws IOException {
    }

    @BeforeAll
    public static void launchApp() {
        driver.get(HOME_PAGE);

    }

    @Test
    public void testAddActivity() throws InterruptedException {

        String activityName = "Gym";
        String activityType = "Exercise";
        String activityDescription = "Running 5 km in this morning!!!";
        HomePage homePage = new HomePage(driver);
        ActivityPage activityPage = homePage.clickActivityPage();
        activityPage.setActivityName(activityName);
        activityPage.selectActivityType(activityType);
        activityPage.setActivityDescription(activityDescription);
        activityPage.clickIsActiveCheckbox();
        activityPage.clickAddActivityButton();
        String expectedActivityName = getExpectedName();


        assertEquals(expectedActivityName, activityName, "Invalid Activity Name!!!");

    }


    private String getExpectedName() {
        try{
            String query = "select * from ACTIVITY order by id desc limit 1";
            // Get the contents of activity table from DB
            ResultSet res = statement.executeQuery(query);
            // res.next() returns true if there is any next record else returns fals
            if(res.next()){

                return res.getString(2);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}




