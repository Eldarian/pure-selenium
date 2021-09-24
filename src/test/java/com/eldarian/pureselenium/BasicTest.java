package com.eldarian.pureselenium;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Set;

public class BasicTest {

    private static final Logger LOGGER = LogManager.getLogger(BasicTest.class);
    WebDriver driver;

    @BeforeClass
    public void configureLogger() {
        //PropertyConfigurator.configure("src/main/resources/log4j.properties");
        BasicConfigurator.configure();
    }

    @BeforeMethod
    public void initDriver() {
        driver = new RemoteWebDriver(DesiredCapabilities.chrome());
    }

    @Test
    public void testElementsCardClickable() {
        driver.get("https://demoqa.com/");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        homePage.removeAds();
        homePage.clickElementsCard();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
    }

    @Test
    public void testElementsCardClickableViaJsScroll() {
        driver.get("https://demoqa.com/");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 100);");
        homePage.clickElementsCard();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
    }

    @Test
    public void testElementsCardClickableViaJsClick() {
        driver.get("https://demoqa.com/");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        homePage.clickElementsCardViaJS();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void testTabsFunctionality() {
        driver.get("https://demoqa.com");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        homePage.openNewTab();
        homePage.openNewTab();
        homePage.openNewTab();
        LOGGER.warn("TOO MANY TABS!");
        LOGGER.warn("AGAIN");
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.get("https://demoqa.com/elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void refreshTest() {
        driver.get("https://demoqa.com");
        DemoQAHomePage homePage = new DemoQAHomePage(driver);
        homePage.refresh();
        homePage.refresh();
        homePage.removeAds();
        homePage.clickElementsCard();
        homePage.getPageHeader();
    }


    @Test
    public void waitTest() {
        driver.get("https://demoqa.com/alerts");
        AlertsPage alertsPage = new AlertsPage(driver);
        Alert alert = alertsPage.clickTimedAlert();
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
