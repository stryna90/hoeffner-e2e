package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.HomePage;
import com.krieger.hoeffner.e2e.pages.RegisterPage;
import com.krieger.hoeffner.e2e.support.TestConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class RegisterStepDefs {

    private final RegisterPage registerPage;
    private final HomePage homePage;
    private final TestConfig config;

    @Given("I load the registration page")
    public void iLoadTheRegistrationPage() {
        registerPage.load();
    }

    @When("I submit the form with valid data")
    public void iSubmitFormWithValidData() {
        registerPage.enterValidData();
        registerPage.submitRegistrationForm();
        homePage.clickClientAccountButton();
    }

    @When("I fill out the registration form")
    public void iFillOutRegistrationForm() {
        registerPage.enterValidData();
    }

    @When("I submit the form with invalid value {string} for {string}")
    public void iSubmitFormWithInvalidValue(String value, String fieldName) {
        registerPage.enterDataFor(value, fieldName);
        registerPage.submitRegistrationForm();
    }

    @Then("I see a error message for {string}")
    public void iSeeAErrorMessageFor(String errorField) {
        assertThat(registerPage.getErrorMessageFor(errorField), equalTo(registerPage.getCorrectErrorMessageFor(errorField)));
    }

    @When("I submit the registration form without salutation")
    public void iFillOutTheRegistrationFormWithoutSalutation() {
        registerPage.enterValidDataWitoutSalutation();
        registerPage.submitRegistrationForm();
    }

    @When("I submit the registration form without terms and conditions")
    public void iSubmitTheRegistrationFormWithoutTermsAndConditions() {
        registerPage.clickTermsAndConditionsCheckbox();
        registerPage.submitRegistrationForm();
    }

    @When("I open register form clause for {string}")
    public void iOpenRegisterFormClauseFor(String clause) {
        registerPage.openClause(clause);
    }

    @Then("I can read register form clause for {string}")
    public void iCanReadRegisterFormClauseFor(String clause) {
        assertThat(registerPage.getClauseTitle(clause), equalTo(registerPage.getCorrectClauseTitle(clause)));
    }


}
