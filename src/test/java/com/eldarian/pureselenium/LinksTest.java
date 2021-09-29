package com.eldarian.pureselenium;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTest extends AbstractTest{
    private static final Logger LOGGER = LogManager.getLogger(LinksTest.class);

    @Test
    public void testCreateLink() {
        getDriver().get("https://demoqa.com/links");
    }
}
