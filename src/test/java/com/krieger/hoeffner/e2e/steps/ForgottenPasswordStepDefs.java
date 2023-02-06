package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.ForgottenPasswordPage;
import com.krieger.hoeffner.e2e.support.TestConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ForgottenPasswordStepDefs {
    private final ForgottenPasswordPage forgottenPasswordPage;
    private final TestConfig config;

    @And("I enter my email in forgotten password form")
    public void iEnterMyEmailInForgottenPasswordForm() {
    }

    @And("I click on the Send Email button")
    public void iClickOnTheSendEmailButton() {
    }

    @Then("I can see a confirmation that email with further instructions was sent")
    public void iCanSeeAConfirmationThatEmailWithFurtherInstructionsWasSent() {
    }
}
