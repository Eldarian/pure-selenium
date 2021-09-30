package com.eldarian.pureselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']/../../..")
    private WebElement elementsCard;

    @FindBy(id = "adplus-anchor")
    private WebElement ad;

    public void clickElementsCard() {
        elementsCard.click();
    }

    public void clickElementsCardViaJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementsCard);

    }

    public String getPageHeader() {
        return driver.findElement(By.className("main-header")).getText();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public void removeAds() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", ad);

    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
