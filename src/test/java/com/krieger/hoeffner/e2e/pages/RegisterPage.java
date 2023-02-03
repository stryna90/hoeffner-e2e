package com.krieger.hoeffner.e2e.pages;

import com.google.inject.Inject;
import com.krieger.hoeffner.e2e.support.TestConfig;
import com.krieger.hoeffner.e2e.support.WebDriverSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class RegisterPage {
    public static final String REGISTER_PATH = "/registrierung";

    private final TestConfig config;
    private final WebDriverSupport support;

    public void load() {
        support.getWebDriver().get(config.getUrl(REGISTER_PATH));
    }
}
