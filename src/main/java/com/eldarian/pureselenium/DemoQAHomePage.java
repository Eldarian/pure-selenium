package com.eldarian.pureselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']/../../..")
    private WebElement elementsCard;

    public void clickElementsCard() {
        elementsCard.click();
    }

    public DemoQAHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //elementsCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']/h5[text()='Elements']/../../..")));

    }
}
