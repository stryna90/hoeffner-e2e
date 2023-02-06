package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.ForgottenPasswordPage;
import com.krieger.hoeffner.e2e.support.TestConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.krieger.hoeffner.e2e.pages.ForgottenPasswordPage.FORGOTTEN_PASSWORD_PATH;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ForgottenPasswordStepDefs {
    private final ForgottenPasswordPage forgottenPasswordPage;
    private final TestConfig config;

    @And("I land on a forgotten password page")
    public void iLandOnAForgottenPasswordPage() {
        assertThat(forgottenPasswordPage.getCurrentUrl(), containsString(FORGOTTEN_PASSWORD_PATH));
    }

    @And("I enter email for {string} in forgotten password input field")
    public void iEnterEmailForInForgottenPasswordInputField(String userId) {
        forgottenPasswordPage.enterEmail(config.email(userId));
    }

    @And("I click on the Send Email button")
    public void iClickOnTheSendEmailButton() {
        forgottenPasswordPage.clickSendButton();
    }

    @Then("I can see a confirmation that email with further instructions was sent")
    public void iCanSeeAConfirmationThatEmailWithFurtherInstructionsWasSent() {
        assertThat(forgottenPasswordPage.getCheckMailboxHeadline().getText(), equalTo("Postfach überprüfen"));
        assertThat(forgottenPasswordPage.getCheckMailboxText().getText(), equalTo("Eine E-Mail mit den Anweisungen, um Ihr Passwort zurückzusetzen wurde an Sie verschickt. Bitte überprüfen Sie Ihr Postfach"));
    }
}
