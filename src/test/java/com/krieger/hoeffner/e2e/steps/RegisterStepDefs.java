package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.HomePage;
import com.krieger.hoeffner.e2e.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class RegisterStepDefs {

    private final RegisterPage registerPage;
    private final HomePage homePage;

    @Given("I load the registration page")
    public void iLoadTheRegistrationPage() {
        registerPage.load();
    }

    @When("I submit form with valid data")
    public void iSubmitFormWithValidData(){
        registerPage.enterValidData();
        registerPage.submitRegistrationForm();
        homePage.waitForLoggedUser();
    }
}
