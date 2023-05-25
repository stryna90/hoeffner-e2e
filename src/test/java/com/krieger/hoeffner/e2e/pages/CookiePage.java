package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.TestConfig;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class CookiePage {

    private final By byAcceptCookieButton = By.cssSelector(".consentForm__acceptButton");

    private final WebDriverSupport support;

    public void clickAcceptCookieButton() {
        support.getWebDriver().findElement(byAcceptCookieButton).click();
    }
}
