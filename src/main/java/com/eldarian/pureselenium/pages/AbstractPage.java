package com.eldarian.pureselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String string, long timeout) {
        pause(timeout);
        element.clear();
        element.sendKeys(string);
    }

    public void type(WebElement element, String string) {
        type(element, string, 0L);
    }

    public void pause(Number timeout) {
        try {
            Float timeoutFloat = timeout.floatValue();
            long timeoutLong = timeoutFloat.longValue();
            Thread.sleep(timeoutLong * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
