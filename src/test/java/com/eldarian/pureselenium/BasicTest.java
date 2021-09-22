package com.eldarian.pureselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = new RemoteWebDriver(DesiredCapabilities.firefox());
    }

    @Test
    public void testElementsCardClickable() {
        driver.get("https://demoqa.com/");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        driver.manage().window().maximize();
        homePage.clickElementsCard();
        driver.getTitle();
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
