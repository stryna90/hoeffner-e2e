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

    //Registration form error messages
    private final static String SALUTATION_ERR_MSG = "Bitte geben Sie eine Anrede ein";
    private final static String EMPTY_FIRST_NAME_ERR_MSG = "Bitte geben Sie Ihren Vornamen ein";
    private final static String EMPTY_LAST_NAME_ERR_MSG = "Bitte geben Sie Ihren Nachnamen ein";
    private final static String FIRST_LAST_NAME_ERR_MSG = "Bitte verwenden Sie nur die Zeichen a-z oder A-Z und nicht mehr als 30 Zeichen";
    private final static String EMPTY_EMAIL_ERR_MSG = "Bitte geben Sie Ihre E-Mail-Adresse ein";
    private final static String EMAIL_ERR_MSG = "Bitte geben Sie eine gültige E-Mail-Adresse ein";
    private final static String EXISTING_EMAIL_ERR_MSG = "Dieser Nutzer ist bereits vorhanden.";
    private final static String PASSWORD_ERR_MSG = "Bitte verwenden Sie ein Passwort von mindestes 8 Zeichen mit mindestens einem Kleinbuchstaben, einem Großbuchstaben, einer Zahl und einem Sonderzeichen.";
    private final static String PASSWORD2_ERR_MSG = "Die Passwörter stimmen nicht überein";
    private final static String EMPTY_PASSWORD2_ERR_MSG = "Bitte wiederholen Sie die Eingabe des Passworts";
    private final static String TERMS_CONDITION_ERR_MSG = "Bitte akzeptieren Sie die AGB und die Datenschutzbestimmungen";

    //Clauses titles
    private final static String NEWSLETTER_TITLE = "Informationen zum Newsletterversand";
    private final static String TERMS_CONDITION_TITLE = "Allgemeine Geschäftsbedingungen (AGB) für Bestellungen auf www.hoeffner.de";
    private final static String DATA_USAGE_TITLE = "Datenschutz";

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

    //Register form clauses link
    private final By byNewsLetterLink = By.className("newsletter");
    private final By byTermsAndConditionsLink = By.className("agb");
    private final By byDataUsageLink = By.className("data-usage");

    //Register form clauses title
    private final By byNewsLetterTitle = By.cssSelector("div.fancybox-content > div");
    private final By byTermsAndConditionsTitle = By.cssSelector("div.fancybox-content center");
    private final By byDataUsageTitle = By.cssSelector("div.fancybox-content h1");

    //Register form warning messages
    private final By bySalutationErrorMessage = By.id("salutation-error");
    private final By byFirstNameErrorMessage = By.id("firstName-error");
    private final By byLastNameErrorMessage = By.id("lastName-error");
    private final By byEmailErrorMessage = By.id("email-error");
    private final By byPasswordErrorMessage = By.id("password-error");
    private final By byPassword2ErrorMessage = By.id("password2-error");
    private final By byTermsAndConditionsErrorMessage = By.id("accountNew__agbBoxErrorId");

    public void load() {
        support.getWebDriver().get(config.getUrl(REGISTER_PATH));
    }

    public void enterValidData() {
        selectElement(bySalutationSelect, "male");
        enterValidDataWitoutSalutation();
    }

    public void enterValidDataWitoutSalutation() {
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

    public void clickTermsAndConditionsCheckbox() {
        clickElement(byTermsAndConditionsCheckbox);
    }

    public void enterDataFor(String value, String fieldName) {
        switch (fieldName) {
            case "first name":
                sendKeysForElement(byFirstNameInput, value);
                break;

            case "last name":
                sendKeysForElement(byLastNameInput, value);
                break;

            case "email":
                sendKeysForElement(byEmailInput, value);
                break;

            case "password":
                sendKeysForElement(byPasswordInput, value);
                break;

            case "repeat password":
                sendKeysForElement(byPassword2Input, value);
                break;

            default:
                log.error("Field name is incorrect");
                break;
        }
    }

    public String getErrorMessageFor(String errorField) {
        switch (errorField) {
            case "salutation":
                return getTextFromElement(bySalutationErrorMessage);

            case "first name":
            case "empty first name":
                return getTextFromElement(byFirstNameErrorMessage);

            case "last name":
            case "empty last name":
                return getTextFromElement(byLastNameErrorMessage);

            case "email":
            case "existing email":
            case "empty email":
                return getTextFromElement(byEmailErrorMessage);

            case "password":
                return getTextFromElement(byPasswordErrorMessage);

            case "repeat password":
            case "empty repeat password":
                return getTextFromElement(byPassword2ErrorMessage);

            case "terms and conditions":
                return getTextFromElement(byTermsAndConditionsErrorMessage);

            default:
                log.error("Field name is incorrect");
                return "Field name is incorrect";
        }
    }

    public String getCorrectErrorMessageFor(String errorField) {
        switch (errorField) {
            case "salutation":
                return SALUTATION_ERR_MSG;

            case "first name":

            case "last name":
                return FIRST_LAST_NAME_ERR_MSG;

            case "empty first name":
                return EMPTY_FIRST_NAME_ERR_MSG;

            case "empty last name":
                return EMPTY_LAST_NAME_ERR_MSG;

            case "email":
                return EMAIL_ERR_MSG;

            case "existing email":
                return EXISTING_EMAIL_ERR_MSG;

            case "empty email":
                return EMPTY_EMAIL_ERR_MSG;

            case "password":
                return PASSWORD_ERR_MSG;

            case "repeat password":
                return PASSWORD2_ERR_MSG;

            case "empty repeat password":
                return EMPTY_PASSWORD2_ERR_MSG;

            case "terms and conditions":
                return TERMS_CONDITION_ERR_MSG;

            default:
                log.error("Non existing error field name");
                return "Non existing error field name";
        }
    }


    public void openClause(String clause) {
        switch (clause) {
            case "newsletter":
                clickElement(byNewsLetterLink);
                break;

            case "terms and condition":
                clickElement(byTermsAndConditionsLink);
                break;

            case "data usage":
                clickElement(byDataUsageLink);
                break;

            default:
                log.error("Non existing clause name");
        }
    }

    public String getClauseTitle(String clause) {
        switch (clause) {

            case "newsletter title":
                return NEWSLETTER_TITLE;

            case "terms and condition title":
                return TERMS_CONDITION_TITLE;

            case "data usage title":
                return DATA_USAGE_TITLE;

            default:
                log.error("Non existing clause type");
                return "Non existing clause type";
        }
    }

    public String getCorrectClauseTitle(String clause) {
        switch (clause) {

            case "newsletter title":
                return getTextFromElement(byNewsLetterTitle);

            case "terms and condition title":
                return getTextFromElement(byTermsAndConditionsTitle);

            case "data usage title":
                return getTextFromElement(byDataUsageTitle);

            default:
                log.error("Non existing correct clause type");
                return "Non existing correct clause type";
        }
    }

    //Emails can be random, because there is no email validation
    private String randomEmailGenerator() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        return "test+" + sb + "@hoeffner.com";
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
    public String getTextFromElement(By by) {
        WebElement element = support.getWebDriver().findElement(by);
        return element.getText();
    }

    //This method should be extracted
    public void selectElement(By by, String value) {
        Select select = new Select(support.getWebDriver().findElement(by));
        select.selectByValue(value);
    }

    public void elementIsVisible(By by) {

    }

}