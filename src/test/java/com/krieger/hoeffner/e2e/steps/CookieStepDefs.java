package com.krieger.hoeffner.e2e.steps;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.pages.CookiePage;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class CookieStepDefs {

    private final CookiePage cookiePage;

    @And("I accept the cookies")
    public void iAcceptTheCookies() {
        cookiePage.clickAcceptCookieButton();
    }
}
