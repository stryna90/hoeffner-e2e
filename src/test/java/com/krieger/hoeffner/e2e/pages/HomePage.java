package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.TestConfig;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class HomePage {
    public static final String HOME_PATH = "/";

    private final TestConfig config;
    private final WebDriverSupport support;

    //XPath should be created dynamically depends on user name
    private final By byLoginIcon = By.xpath("//span[contains(text(), 'FirstNameTest')]");

    public void load() {
        support.getWebDriver().get(config.getUrl(HOME_PATH));
    }

    public void waitForLoggedUser() {
        new WebDriverWait(support.getWebDriver(), 5).until(ExpectedConditions.elementToBeClickable(support.getWebDriver().findElement(byLoginIcon)));
    }
}
