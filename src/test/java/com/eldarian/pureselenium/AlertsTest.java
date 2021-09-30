package com.eldarian.pureselenium;

import com.eldarian.pureselenium.pages.AlertsPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends AbstractTest {

    @Test
    public void waitTest() {
        getDriver().get("https://demoqa.com/alerts");
        AlertsPage alertsPage = new AlertsPage(getDriver());
        Alert alert = alertsPage.clickTimedAlert();
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds");
    }


}
