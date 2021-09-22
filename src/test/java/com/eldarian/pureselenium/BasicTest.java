package com.eldarian.pureselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class BasicTest {

    private static final Logger LOGGER = Logger.getLogger(BasicTest.class);
    WebDriver driver;

    @BeforeClass
    public void configureLogger() {
        //PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

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
        Assert.assertEquals(driver.findElement(By.className("main-header")).getText(), "Elements");
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
