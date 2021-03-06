package com.eldarian.pureselenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends AbstractPage {
    WebDriver driver;

    @FindBy(id = "timerAlertButton")
    private WebElement timeAlertButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public Alert clickTimedAlert() {
        timeAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.alertIsPresent());
    }


}
