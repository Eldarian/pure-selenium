package com.eldarian.pureselenium;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {
    String url;

    protected WebDriver getDriver() {
        return DriverPool.getDriver();
    }

    @BeforeClass
    public void configureLogger() {
        BasicConfigurator.configure();
    }

    @AfterMethod
    public void closeDriver() {
        DriverPool.closeDriver();
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
