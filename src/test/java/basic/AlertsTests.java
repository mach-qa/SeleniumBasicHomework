package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTests extends TestSetup {

    @Test
    @DisplayName("Simple Alert pop-up")
    @Tag("Alert")
    @Tag("Basic")
    void verifySimpleAlertPopUp() {
        getDriver().get("http://51.75.61.161:9102/alerts.php");

        setElementCssPath("#simple-alert").click();
        getDriver().switchTo().alert().accept();
        String alertLabel = setElementCssPath("#simple-alert-label").getText();

        assertThat(alertLabel).isEqualTo("OK button pressed");
    }

    @Test
    @DisplayName("Prompt Alert box")
    @Tag("Alert")
    @Tag("Basic")
    void verifyPromptAlertBox() {
        getDriver().get("http://51.75.61.161:9102/alerts.php");

        String promptAlertInput = "Darth Vader";

        setElementCssPath("#prompt-alert").click();
        getDriver().switchTo().alert().sendKeys("Darth Vader");
        getDriver().switchTo().alert().accept();
        String promptLabel = setElementCssPath("#prompt-label").getText();

        assertThat(promptLabel).isEqualTo("Hello " + promptAlertInput +"! How are you today?");
    }

    @Test
    @DisplayName("Confirm Alert box")
    @Tag("Alert")
    @Tag("Basic")
    void verifyConfirmAlertBox() {
        getDriver().get("http://51.75.61.161:9102/alerts.php");

        setElementCssPath("#confirm-alert").click();
        getDriver().switchTo().alert().accept();
        String confirmLabel = setElementCssPath("#confirm-label").getText();
        assertThat(confirmLabel).isEqualTo("You pressed OK!");

        setElementCssPath("#confirm-alert").click();
        getDriver().switchTo().alert().dismiss();
        String declineLabel = setElementCssPath("#confirm-label").getText();
        assertThat(declineLabel).isEqualTo("You pressed Cancel!");
    }

    @Test
    @DisplayName("Delayed Alert")
    @Tag("Alert")
    @Tag("Basic")
    void verifyDelayedAlert() {
        getDriver().get("http://51.75.61.161:9102/alerts.php");

        setElementCssPath("#delayed-alert").click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        getDriver().switchTo().alert().accept();
        String delayedLabel = setElementCssPath("#delayed-alert-label").getText();
        assertThat(delayedLabel).isEqualTo("OK button pressed");
    }
}
