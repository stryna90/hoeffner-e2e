package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.ClientAccountPage;
import com.krieger.hoeffner.e2e.pages.HomePage;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ClientAccountStepDefs {

    private final ClientAccountPage clientAccountPage;

    @Then("My account is registered")
    public void myAccountIsRegistered() {
        clientAccountPage.load();
        clientAccountPage.getClientName();
    }
}
