package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ForgottenPasswordPage {

    public static final String FORGOTTEN_PASSWORD_PATH = "/passwort/vergessen/login";
    private final WebDriverSupport support;

    private final By byEmailInput = By.cssSelector("#passwordForgottenEmail");
    private final By bySendEmailButton = By.cssSelector("#passwordForgottenSubmitId");
    private final By byCheckMailBoxHeadline = By.cssSelector(".checkMailbox__headline");
    private final By byCheckMailBoxText = By.cssSelector(".checkMailbox__text");

    public String getCurrentUrl() {
        return support.getWebDriver().getCurrentUrl();
    }

    public void enterEmail(String email) {
        WebElement emailInput = support.getWebDriver().findElement(byEmailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickSendButton() {
        WebElement sendEmailButton = support.getWebDriver().findElement(bySendEmailButton);
        sendEmailButton.click();
        new WebDriverWait(support.getWebDriver(), 3).until(ExpectedConditions.invisibilityOf(sendEmailButton));
    }

    public WebElement getCheckMailboxHeadline() {
        return support.getWebDriver().findElement(byCheckMailBoxHeadline);
    }

    public WebElement getCheckMailboxText() {
        return support.getWebDriver().findElement(byCheckMailBoxText);
    }
}
