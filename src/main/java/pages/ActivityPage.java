package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivityPage {
    private WebDriver driver;
    private By activityNameField = By.id("activityName");
    private By activityTypeDropdown = By.id("activityType.activityTypeId");
    private By activityDescriptionField = By.id("activityDescription");
    private By isActiveCheckbox = By.id("isActive1");
    private By addActivityButton = By.id("addActivity");


    public ActivityPage(WebDriver driver) {
     this.driver = driver;
    }

    public void setActivityName(String activityName) {
        driver.findElement(activityNameField).sendKeys(activityName);
    }

    public void selectActivityType(String option){
        findDropdownElement(activityTypeDropdown).selectByVisibleText(option);
    }
    public void setActivityDescription(String activityDescription){
        driver.findElement(activityDescriptionField).sendKeys(activityDescription);
    }
    public void clickAddActivityButton(){
        driver.findElement(addActivityButton).click();
    }
    public void clickIsActiveCheckbox(){
        driver.findElement(isActiveCheckbox).click();
    }

    private Select findDropdownElement(By locator){
        return new Select(driver.findElement(locator));
    }
}
