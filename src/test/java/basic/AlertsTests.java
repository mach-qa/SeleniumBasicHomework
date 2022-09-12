package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTests extends TestSetup {

    @Test
    @DisplayName("Simple Alert pop-up")
    @Tag("Alert")
    void verifySimpleAlertPopUp() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("simple-alert")).click();
        getDriver().switchTo().alert().accept();
        String alertLabel = getDriver().findElement(By.id("simple-alert-label")).getText();

        assertThat(alertLabel).isEqualTo("OK button pressed");
    }

    @Test
    @DisplayName("Prompt Alert box")
    @Tag("Alert")
    void verifyPromptAlertBox() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        String promptAlertInput = "Darth Vader";

        getDriver().findElement(By.id("prompt-alert")).click();
        getDriver().switchTo().alert().sendKeys("Darth Vader");
        getDriver().switchTo().alert().accept();
        String promptLabel = getDriver().findElement(By.id("prompt-label")).getText();

        assertThat(promptLabel).isEqualTo("Hello " + promptAlertInput +"! How are you today?");
    }

    @Test
    @DisplayName("Confirm Alert box")
    @Tag("Alert")
    void verifyConfirmAlertBox() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().accept();
        String confirmLabel = getDriver().findElement(By.id("confirm-label")).getText();
        assertThat(confirmLabel).isEqualTo("You pressed OK!");

        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().dismiss();
        String declineLabel = getDriver().findElement(By.id("confirm-label")).getText();
        assertThat(declineLabel).isEqualTo("You pressed Cancel!");
    }

    @Test
    @DisplayName("Delayed Alert")
    @Tag("Alert")
    void verifyDelayedAlert() throws InterruptedException {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("delayed-alert")).click();
        Thread.sleep (5500);
        getDriver().switchTo().alert().accept();
        String delayedLabel = getDriver().findElement(By.id("delayed-alert-label")).getText();
        assertThat(delayedLabel).isEqualTo("OK button pressed");
    }
}
