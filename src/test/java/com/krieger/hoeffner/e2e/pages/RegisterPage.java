package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.TestConfig;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class RegisterPage {
    public static final String REGISTER_PATH = "/registrierung";

    private final TestConfig config;
    private final WebDriverSupport support;

    //Register form input fields
    private final By bySalutationSelect = By.id("salutation");
    private final By byFirstNameInput = By.id("firstName");
    private final By byLastNameInput = By.id("lastName");
    private final By byEmailInput = By.id("email");
    private final By byPasswordInput = By.id("password");
    private final By byPassword2Input = By.id("password2");

    //Register form buttons
    private final By byRegisterSubmitButton = By.id("register-submit");

    //Register form checkboxes
    private final By byDiscountCheckbox = By.cssSelector("div.accountNew__newsletterCheckbox span.checkbox__checkbox");
    private final By byTermsAndConditionsCheckbox = By.cssSelector("div.accountNew__agbCheckbox span.checkbox__checkbox");

    //Register form clauses
    private final By byNewsLetterLink = By.className("newsletter");
    private final By byTermsAndConditionsLink = By.className("agb");
    private final By byDataUsageLink = By.className("data-usage");

    //Register form warning messages
    private final By bySalutationErrorMessage = By.id("salutation-error");
    private final By byFirstNameErrorMessage = By.id("firstName-error");
    private final By byLastNameErrorMessage = By.id("lastName-error");
    private final By byEmailErrorMessage = By.id("email-error");
    private final By byExistingEmailErrorMessage = By.id(""); //TC
    private final By byPasswordErrorMessage = By.id("password-error");
    private final By byPassword2ErrorMessage = By.id("password2-error");
    private final By byIncorrectPassword2ErrorMessage = By.id(""); //TC
    private final By byTermsAndConditionsErrorMessage = By.id("accountNew__agbBoxErrorId");

    public void load() {
        support.getWebDriver().get(config.getUrl(REGISTER_PATH));
    }

    public void enterValidData() {
        selectElement(bySalutationSelect, "male");
        sendKeysForElement(byFirstNameInput, "FirstNameTest");
        sendKeysForElement(byLastNameInput, "LastNameTest");
        sendKeysForElement(byEmailInput, randomEmailGenerator());
        sendKeysForElement(byPasswordInput, "Password!2");
        sendKeysForElement(byPassword2Input, "Password!2");
        clickElement(byDiscountCheckbox);
        clickElement(byTermsAndConditionsCheckbox);
    }

    public void submitRegistrationForm() {
        clickElement(byRegisterSubmitButton);
    }

    //Pseudo random mail generator should be in utils or external library should be used
    //Emails can be random, because there is no email validation
    private String randomEmailGenerator() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        return "test+" + sb.toString() + "@hoeffner.com";
    }

    //This method should be extracted
    public void sendKeysForElement(By by, String input) {
        WebElement element = support.getWebDriver().findElement(by);
        element.clear();
        element.sendKeys(input);
    }

    //This method should be extracted
    public void clickElement(By by) {
        WebElement element = support.getWebDriver().findElement(by);
        element.click();
    }

    //This method should be extracted
    public void selectElement(By by, String value) {
        Select select = new Select(support.getWebDriver().findElement(by));
        select.selectByValue(value);
    }
}
