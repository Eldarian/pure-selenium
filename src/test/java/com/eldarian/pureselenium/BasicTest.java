package com.eldarian.pureselenium;

import com.eldarian.pureselenium.pages.HomePage;
import com.eldarian.pureselenium.pages.SelectPage;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BasicTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicTest.class);

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

    @Test
    public void testSelector() {
        getDriver().get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        SelectPage selectPage = new SelectPage(getDriver());
        selectPage.select(6);
        selectPage = new SelectPage(getDriver());
        Assert.assertEquals(selectPage.getSelectedDay(), "Friday");
    }

    @Test
    public void testMultiSelect() {
        getDriver().get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        SelectPage selectPage = new SelectPage(getDriver());
        selectPage.selectMultiple(4, 1, 0);
        Assert.assertEquals(selectPage.getFirstSelected(), "First selected option is : California");
    }
}
