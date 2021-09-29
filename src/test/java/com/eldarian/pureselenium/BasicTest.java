package com.eldarian.pureselenium;

import com.eldarian.pureselenium.pages.HomePage;
import org.apache.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class BasicTest extends AbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(BasicTest.class);

    @Test
    public void testElementsCardClickable() {
        getDriver().get(Configs.BASE_URL.getValue());
        HomePage homePage = new HomePage(getDriver());
        homePage.removeAds();
        homePage.clickElementsCard();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
    }

    @Test
    public void testElementsCardClickableViaJsScroll() {
        getDriver().get(Configs.BASE_URL.getValue());
        HomePage homePage = new HomePage(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scroll(0, 100);");
        homePage.clickElementsCard();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
    }

    @Test
    public void testElementsCardClickableViaJsClick() {
        getDriver().get(Configs.BASE_URL.getValue());
        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsCardViaJS();
        Assert.assertEquals(homePage.getPageHeader(), "Elements");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void testTabsFunctionality() {
        getDriver().get(Configs.BASE_URL.getValue());
        HomePage homePage = new HomePage(getDriver());
        homePage.openNewTab();
        homePage.openNewTab();
        homePage.openNewTab();
        LOGGER.warn("TOO MANY TABS!");
        LOGGER.warn("AGAIN");
        ArrayList<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(handles.get(1));
        getDriver().get("https://demoqa.com/elements");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void refreshTest() {
        getDriver().get(Configs.BASE_URL.getValue());
        HomePage homePage = new HomePage(getDriver());
        homePage.refresh();
        homePage.refresh();
        homePage.removeAds();
        homePage.clickElementsCard();
        homePage.getPageHeader();
    }
}
