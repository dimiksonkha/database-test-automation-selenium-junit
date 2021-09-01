package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By activityPageLink = By.cssSelector("a[href=\"/DailyActivityManager/activities\"]");
    private By activityTypePageLink = By.cssSelector("a[href=\"/DailyActivityManager/activities\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public ActivityPage clickActivityPage(){
        driver.findElement(activityPageLink).click();
        return new ActivityPage(driver);
    }
}
