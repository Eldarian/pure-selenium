package com.eldarian.pureselenium;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.ConcurrentHashMap;

public class DriverPool {
    private static final Logger LOGGER = LogManager.getLogger(DriverPool.class);
    private static ConcurrentHashMap<String, WebDriver> drivers = new ConcurrentHashMap<>();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver getDriver() {
        String threadName = Thread.currentThread().getName();
        LOGGER.debug(threadName);
        WebDriver driver = drivers.get(threadName);
        LOGGER.debug(threadName + " " + driver);
        if (driver == null) {
            capabilities.setBrowserName(Configs.BROWSER.getValue());
            //driver = new RemoteWebDriver(capabilities);
            driver = new RemoteWebDriver(new DesiredCapabilities(
                    Configs.BROWSER.getValue(),
                    Configs.VERSION.getValue(),
                    Platform.valueOf(Configs.PLATFORM.getValue())));
            drivers.put(threadName, driver);
        }
        return driver;
    }

    public static void closeAll() {
        drivers.forEach((name, driver) -> driver.quit());
        drivers.clear();
    }

    public static void closeDriver() {
        String threadName = Thread.currentThread().getName();
        WebDriver driver = drivers.get(threadName);
        if (driver != null) {
            drivers.remove(threadName);
            driver.quit();
        }
    }
}
