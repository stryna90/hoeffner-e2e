package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.TestConfig;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ClientAccountPage {
    public static final String ACCOUNT_PATH = "//kundenkonto";

    private final TestConfig config;
    private final WebDriverSupport support;

    private final By byClientNameLabel = By.className("titleHeadline");


    public void load() {
        support.getWebDriver().get(config.getUrl(ACCOUNT_PATH));
    }

    public String getClientName(){
        WebElement element = support.getWebDriver().findElement(byClientNameLabel);
        String[] clientName = element.getText().split(",");
        System.out.println(clientName[1]);
        return clientName[1];
    }
}
