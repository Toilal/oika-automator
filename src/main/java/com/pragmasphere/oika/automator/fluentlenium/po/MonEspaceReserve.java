package com.pragmasphere.oika.automator.fluentlenium.po;

import com.pragmasphere.oika.automator.commands.auth.Auth;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@PageUrl("http://www.oikaoika.fr/mon-espace-reserve")
public class MonEspaceReserve extends FluentPage {
    @FindBy(css = "#espace-reserve input#Login")
    private FluentWebElement login;

    @FindBy(css = "#espace-reserve input#Pass")
    private FluentWebElement password;

    @FindBy(css = "#espace-reserve input[type='submit']")
    private FluentWebElement submit;

    @FindBy(css = "#qLbar_wrap")
    private FluentWebElement loader;

    public void login(final Auth auth) {
        await().atMost(15, TimeUnit.SECONDS).until(loader).not().present();
        login.write(auth.getLogin());
        password.write(auth.getPassword());
        // A Corriger dans fluentlenium ?
        // await().atMost(15, TimeUnit.SECONDS).until(submit).clickable();
        submit.click();
    }
}
