package com.eldarian.pureselenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LinksTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinksTest.class);

    @Test
    public void testCreateLink() {
        getDriver().get("https://demoqa.com/links");
    }
}
